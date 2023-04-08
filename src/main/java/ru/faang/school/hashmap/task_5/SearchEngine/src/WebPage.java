import java.util.*;
import java.util.stream.Collectors;

public record WebPage(String url, String title, Content content) {
    public static void indexing(WebPage webPage) {
        Set<String> keyWords = Arrays.stream(webPage.content().content.split("[^a-zA-Z]+"))
                .collect(Collectors.toSet());
        Map<String, List<WebPage>> tempWebPages = Main.webPages;
        for (String key : keyWords) {
            String keyIgnoreCase = key.toLowerCase();
            if (tempWebPages.containsKey(keyIgnoreCase)) {
                tempWebPages.get(keyIgnoreCase).add(webPage);
                continue;
            }
            List<WebPage> webPageList = new ArrayList<>();
            webPageList.add(webPage);
            tempWebPages.put(keyIgnoreCase, webPageList);
        }
    }

    public static List<WebPage> getByKeyWord(String keyWord) {
        return Main.webPages.get(keyWord.toLowerCase());
    }

    public static void delete(String url) {
        Main.webPages.values().forEach(list -> list.removeIf(page -> page.url().equals(url)));
    }

    public static void printAll() {
        Main.webPages.forEach((k, v) -> System.out.println(k + " --> " + v.size() + " " + v));
    }
}
