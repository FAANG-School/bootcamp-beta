package ru.faang.school.hashmap.task_5.solution;

import java.util.*;

public class WebIndexes extends HashMap<String, List<WebPage>> {

    public void index(List<WebPage> webPages){
        for (WebPage webPage : webPages){
            addToIndex(webPage);
        }
    }

    public void addToIndex(WebPage webPage){
        Iterator<String> wordsIterator = webPage.getKeyWords().iterator();
        while (wordsIterator.hasNext()){
            String keyWord = wordsIterator.next();

            if(containsKey(keyWord)){
                if(!get(keyWord).contains(webPage))
                    get(keyWord).add(webPage);
            }else {
                List<WebPage> newWebPages = new ArrayList<>();
                newWebPages.add(webPage);

                put(keyWord, newWebPages);
            }
        }
    }

    public List<WebPage> getWebPagesByKeyWord(String keyWord){
        List<WebPage> webPages = new ArrayList<>();

        if(containsKey(keyWord))
            webPages.addAll(get(keyWord));

        return webPages;
    }

    public void deleteWebPageByUrl(String url){
        WebPage urlPage = null;
        for(Map.Entry<String, List<WebPage>> index : entrySet()){
            for(WebPage webPage : index.getValue()){
                if(webPage.getUrl().equals(url))
                    urlPage = webPage;
            }
            if(urlPage != null){
                if(index.getValue().contains(urlPage))
                    index.getValue().remove(urlPage);
            }
        }
    }

    public void printIndexes(){
        for(Map.Entry<String, List<WebPage>> index : entrySet()){
            System.out.println(index);
        }

        System.out.println();
    }
}
