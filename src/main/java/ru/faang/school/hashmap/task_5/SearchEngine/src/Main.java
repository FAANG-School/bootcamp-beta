import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<String, List<WebPage>> webPages = new HashMap<>();
    public static void main(String[] args) {
        WebPage webPage = new WebPage("https://simple-site1.com", "Simple Site1", Content.TEXT1);
        WebPage webPage2 = new WebPage("https://simple-site2.com", "Simple Site2", Content.TEXT2);
        WebPage webPage3 = new WebPage("https://simple-site3.com", "Simple Site3", Content.TEXT3);
        WebPage webPage4 = new WebPage("https://simple-site4.com", "Simple Site4", Content.TEXT4);
        WebPage webPage5 = new WebPage("https://simple-site5.com", "Simple Site5", Content.TEXT5);
        WebPage webPage6 = new WebPage("https://simple-site6.com", "Simple Site6", Content.TEXT6);

                                        // Indexing
        WebPage.indexing(webPage);
        WebPage.indexing(webPage2);
        WebPage.indexing(webPage3);
        WebPage.indexing(webPage4);
        WebPage.indexing(webPage5);
        WebPage.indexing(webPage6);

        // Print
        System.out.println();
        WebPage.printAll();
        System.out.println();

        // Get
        String get = "new";
        System.out.println("Get by keyWord " + '\'' + get + '\'');
        List<WebPage> kwPages = WebPage.getByKeyWord(get);
        System.out.println("---".repeat(100));
        System.out.println(kwPages.size() + " " + kwPages);
        System.out.println("---".repeat(100));

        // Delete
        System.out.println();
        String deletePage = "https://simple-site2.com";
        System.out.println("Delete " + deletePage);
        System.out.println("---".repeat(100));
        WebPage.delete(deletePage);
        WebPage.printAll();
        System.out.println("---".repeat(100));
    }
}
