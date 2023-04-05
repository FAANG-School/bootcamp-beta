import java.util.*;

public class Main {
    private static final Map<String, List<WebPage>> indexedMap = new HashMap<>();//key is keyWord, value is List of pages with keyWord
    private static final Map<String, List<String>> urlMap = new HashMap<>();//key is URL, value is List of keyWords to indexedMap

    public static void main(String[] args) {
        pageIndexing(new WebPage("yandex.by", "Yandex", "Great webSite for program developers from CIS region"));
        pageIndexing(new WebPage("google.com", "Google", "Great webSite for program developers"));
        pageIndexing(new WebPage("testPage.test", "TestPage", "Testing is very important part of program development"));

        System.out.println("Trying to delete page with unexciting URL:");
        deletePage("TST");

        System.out.println("\nPages before deleting TestPage");
        System.out.println("KeyWord: \"Great\", Value: " + findPages("Great"));
        System.out.println("KeyWord: \"program\", Value: " + findPages("program"));
        System.out.println("KeyWord: \"development\", Value: " + findPages("development"));

        deletePage("testPage.test");
        System.out.println("\nPages after deleting TestPage");
        System.out.println("KeyWord: \"Great\", Value: " + findPages("Great"));
        System.out.println("KeyWord: \"program\", Value: " + findPages("program"));
        System.out.println("KeyWord: \"development\", Value: " + findPages("development"));
    }

    public static void pageIndexing(WebPage page) {
        String[] words = page.getContent().split("\\W++");
        urlMap.put(page.getURL(), new ArrayList<>(Arrays.asList(words)));

        for (String word : words) {
            if (indexedMap.containsKey(word)) {
                indexedMap.get(word).add(page);
            } else {
                ArrayList<WebPage> pages = new ArrayList<>();
                pages.add(page);
                indexedMap.put(word, pages);
            }
        }
    }

    public static List<WebPage> findPages(String keyWord) {
        return indexedMap.get(keyWord);
    }

    public static void deletePage(String URL) {
        if (!urlMap.containsKey(URL)) {
            System.out.println("No such URL found");
            return;
        }
        WebPage pageToDelete = null;

        for (String keyWord : urlMap.get(URL)) {
            if (pageToDelete == null) {
                pageToDelete = indexedMap.get(keyWord).stream().reduce((endPage, currPage) ->
                        endPage = currPage.getURL().equals(URL) ? currPage : endPage).get();
            }
            indexedMap.get(keyWord).remove(pageToDelete);
        }
    }
}