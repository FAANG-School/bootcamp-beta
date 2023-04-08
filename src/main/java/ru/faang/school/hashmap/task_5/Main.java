package ru.faang.school.hashmap.task_5;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Main {
    static Map<String, List<WebPage>> mainIndexMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        System.out.println("***************TEST START***********************");
        List<String> pagesToIndex = List.of(
                "https://www.cs.usfca.edu/~galles/cs411/",
                "https://www.cs.usfca.edu/~galles/",
                "https://www.cs.usfca.edu/~galles/cs411/cs411MT2ReviewF15.html",
                "https://www.cs.usfca.edu/~galles/compilerdesign/",
                "http://pr0git.blogspot.com/2015/02/git_13.html"
        );
        for (String urlString : pagesToIndex) {
            WebPage webPage = WebPageReader.readPage(urlString);
            indexPage(webPage);
        }
        System.out.println(search("411"));

        removePageFromIndex(new URL("https://www.cs.usfca.edu/~galles/cs411/"));
        System.out.println(search("411"));

        System.out.println("****************TEST END************************");
    }

    public static void indexPage(WebPage webPage) {
        String[] words = webPage.getContent().toLowerCase(Locale.ROOT)
                .replaceAll("\\W", " ").split(" ");
        for (String word : words) {
            if (mainIndexMap.containsKey(word)) {
                if (!mainIndexMap.get(word).contains(webPage)) {
                    mainIndexMap.get(word).add(webPage);
                }
            } else {
                List<WebPage> webPages = new ArrayList<>();
                webPages.add(webPage);
                mainIndexMap.put(word, webPages);
            }
        }
    }

    public static List<WebPage> search(String keyword) {
        return mainIndexMap.get(keyword.toLowerCase(Locale.ROOT));
    }

    public static void removePageFromIndex(URL url){
        for (List<WebPage> pagesList : mainIndexMap.values()) {
            pagesList.removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
