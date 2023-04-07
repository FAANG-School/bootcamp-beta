package ru.faang.school.hashmap.task_5.Solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple class for indexing pages(associating pages by (key -> page))
 */
public class Indexing {
    /**
     * key - URL
     * value - content of that page
     */
    private final Map<String, WebPage> index = new HashMap<>();

    public void add(WebPage page){
        index.put(page.getURL(), page);
    }

    /**
     *
     * @param URL of page to Delete
     * @return false if page was not found
     */
    public boolean remove(String URL){
        return index.remove(URL) != null;
    }

    public List<String> contentByURL(String URL){
        return index.get(URL).getContent();
    }

    public WebPage pageByURL(String URL){
        if(!index.containsKey(URL)){
            return null;
        }
        return index.get(URL);
    }

    public boolean containsURL(String URL){
        return index.containsKey(URL);
    }
}
