package ru.faang.school.hashmap.task_5;



import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, List<WebPage>> map = new HashMap<>();
        WebPage page1 = new WebPage("https://www.example.com/page1", "Title", "Content of page 1");
        WebPage page2 = new WebPage("https://www.example.com/page2", "Title2", "Content of page 2");
        indexPage(page2, map);

        WebPage page3 = new WebPage("https://www.example.com/page3", "Title3", "Content of page 3");
        indexPage(page3, map);

        indexPage(page1, map);
        deletePage("https://www.example.com/page1", map);
        System.out.println(search("Content", map));

    }

    public static void deletePage(String url, Map<String, List<WebPage>> map){
        for(String word: map.keySet()){
            List<WebPage> pages = map.get(word);
            Iterator<WebPage> iterator = pages.iterator();
            while (iterator.hasNext()){
                WebPage webPage = iterator.next();
                if(webPage.getUrl().equals(url)){
                    iterator.remove();
                }
            }
        }
    }

    public static void indexPage(WebPage page, Map<String, List<WebPage>> index){
        String[] words = page.getContent().split(" ");
        for(String word: words){
           if(!index.containsKey(word)){
               index.put(word, new ArrayList<>());
           }
           index.get(word).add(page);
        }
    }

    public static List<WebPage> search(String word, Map<String, List<WebPage>> index){
        List<WebPage> pages = new ArrayList<>();
        if(index.containsKey(word)){
            pages = index.get(word);
        }
        return pages;
    }


}
