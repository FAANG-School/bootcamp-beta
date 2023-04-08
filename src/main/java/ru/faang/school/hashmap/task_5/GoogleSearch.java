package ru.faang.school.hashmap.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleSearch {
    private Map<String, WebPage> urlMap = new HashMap<>();
    private Map<String, List<WebPage>> keyWordMap = new HashMap<>();

    public Map<String, List<WebPage>> addWebPage(WebPage webPage) {
        if (urlMap.containsKey(webPage.getUrl())) {
            urlMap.put(webPage.getUrl(), webPage);
            return create();
        } else {
            urlMap.put(webPage.getUrl(), webPage);
            addKeyWord(webPage.getContent(), webPage, keyWordMap);
            return keyWordMap;
        }

    }

    public List<WebPage> findByKeyWord(String keyWord) {
        return keyWordMap.get(keyWord);
    }

    public Map<String, List<WebPage>> remove(WebPage webPage) {
        if (urlMap.containsKey(webPage.getUrl())) {
            urlMap.remove(webPage.getUrl());
            return create();
        } else {
            return keyWordMap;
        }
    }

    private Map<String, List<WebPage>> create() {
        keyWordMap = new HashMap<>();
        for (Map.Entry<String, WebPage> entry : urlMap.entrySet()) {
            addKeyWord(entry.getValue().getContent(), entry.getValue(), keyWordMap);
        }
        return keyWordMap;
    }

    private void addKeyWord(String string, WebPage webPage, Map<String, List<WebPage>> keyWordMap) {
        for (String keyword : string.split(" ")) {
            List<WebPage> webPageList = keyWordMap.getOrDefault(keyword, new ArrayList<>());
            webPageList.add(webPage);
            keyWordMap.put(keyword, webPageList);
        }
    }
}



