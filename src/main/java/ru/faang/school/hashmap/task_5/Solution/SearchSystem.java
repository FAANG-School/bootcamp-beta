package ru.faang.school.hashmap.task_5.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchSystem {
    private final Indexing index = new Indexing();

    /**
     * key - keyword
     * value - list of webpages containing such word
     */
    private final Map<String, List<WebPage>> pages = new HashMap<>();

    public void add(WebPage page){
        if(index.containsURL(page.getURL())){
            return;
        }
        index.add(page);
        for(String word : page.getContent()){
            pages.computeIfAbsent(word, p -> new ArrayList<>())
                    .add(page);
        }
    }

    /**
     *
     * @param URL of page to Delete
     * @return false if page was not found
     */
    public boolean remove(String URL){
        if(!index.containsURL(URL)){
            return false;
        }

        for(String word : index.contentByURL(URL)){
            pages.get(word).remove(index.pageByURL(URL));
            if(pages.get(word).size() == 0){
                pages.remove(word);
            }
        }
        index.remove(URL);
        return true;
    }

    public boolean remove(WebPage page){
        return remove(page.getURL());
    }

    public WebPage findByURL(String URL){
        return index.pageByURL(URL);
    }

    /**
     *
     * @param word - key word to search for
     * @return list of webpages containing such word
     */
    public List<WebPage> findPages(String word){
        return pages.get(word);
    }

    /**
     *
     * @param word - key to search
     * @return string, representing response containing titles of the pages
     */
    public String find(String word){
        if(!pages.containsKey(word)){
            return null;
        }
        StringBuilder response = new StringBuilder(
                "SearchQuery:" + word + "\nResponse:\n"
        );

        for(WebPage page : pages.get(word)){
            response.append(page.getTitle());
            response.append('\n');
        }

        return response.toString();
    }
}
