package ru.faang.school.hashmap.task_5;

import java.util.*;

public class Main {

    public static Map<String, List<WebPage>> map = new HashMap<>();

    public static void main(String[] args) {
        WebPage webPage1 = new WebPage("url1", "title1", "some content here 1");
        WebPage webPage2 = new WebPage("url2", "title2", "some content here 2");

        Main main = new Main();
        main.createIndex(webPage1);
        System.out.println(map);

        System.out.println("***************************");
        main.createIndex(webPage2);
        System.out.println(map);

        System.out.println("***************************");
        System.out.println(main.findWebPage("here"));

        System.out.println("***************************");
        main.removedByUrl("url2");
        System.out.println(map);
    }

    public void createIndex(WebPage webPage) {
        String[] contents = webPage.getContent().split(" ");
        for (String content : contents) {
            if (map.get(content) == null) {
                List<WebPage> webPageList = new ArrayList<>();
                webPageList.add(webPage);
                map.put(content, webPageList);
            } else {
                List<WebPage> webPages = map.get(content);
                webPages.add(webPage);
            }
        }
    }

    public void removedByUrl(String url) {
        for (Map.Entry<String, List<WebPage>> entry : map.entrySet()) {
            List<WebPage> values = entry.getValue();
            values.removeIf(next -> next.getUrl().equals(url));
        }
    }

    public List<WebPage> findWebPage(String keyWord) {
        return map.get(keyWord);
    }

}
