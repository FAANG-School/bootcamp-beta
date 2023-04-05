package ru.faang.school.hashmap.task_5;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
    private static Map<String, List<WebPage>> allPages=new HashMap<>();

    public static void main(String[] args)
    {
        indexNewWebPage(new WebPage("urli", "Cooking", "Recipe of french fries"));
        indexNewWebPage(new WebPage("ur", "Delivery", "Get french fries"));
        indexNewWebPage(new WebPage("uri", "Dictionary", "яблоко-apple"));
        indexNewWebPage(new WebPage("u", "Vegan food", "why apple aren't healthy?"));
        int i=1;
        for(String targetWord:allPages.keySet()){
            System.out.println("Group"+i+":");
            for(WebPage currentWebPage:allPages.get(targetWord)){
                System.out.println(currentWebPage.getUrl()+" "+currentWebPage.getTitle()+" "+currentWebPage.getContent());
            }
            i++;
        }
    }
    public static void indexNewWebPage(WebPage webPage){
        String [] allWords=webPage.getContent().split(" ");
        for (int i = 0; i < allWords.length; i++)
        {
            if (allPages.containsKey(allWords[i])){
                List<WebPage> subList=allPages.get(allWords[i]);
                subList.add(webPage);
                allPages.put(allWords[i], subList);
            }else{
                List<WebPage> newList=new ArrayList<>();
                newList.add(webPage);
                allPages.put(allWords[i], newList);
            }
        }
    }
    public static List<WebPage> findWebPagesByTargetWord(String targetWord)
    {
        return allPages.get(targetWord);
    }
    public static void deleteWebPage(String url){
        for(String targetWord:allPages.keySet()){
            for(WebPage currentWebPage:allPages.get(targetWord)){
                if (currentWebPage.getUrl().equals(url)) allPages.get(targetWord).remove(currentWebPage);
            }
        }
    }

}
