package ru.faang.school.hashmap.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final Map<String, List<WebPage>> webPagesMap = new HashMap<>();

    public Map<String, List<WebPage>> getWebPagesMap() {
        return webPagesMap;
    }

    public void indexWebPage(WebPage webPage) {
        if (webPage.getContent().isBlank() || webPage.getUrl().isBlank() || webPage.getTitle().isBlank())
            throw new IllegalArgumentException("Not valid web page");
        String webPageContent = webPage.getContent().replaceAll("\\W+", " ");
        if (!webPageContent.isBlank()) {
            for (String keyword : webPageContent.split(" ")) {
                if (!webPagesMap.containsKey(keyword)) {
                    webPagesMap.put(keyword, new ArrayList<>());
                    webPagesMap.get(keyword).add(webPage);
                } else {
                    webPagesMap.get(keyword).add(webPage);
                }
            }
        } else {
            throw new RuntimeException("Not valid web page content");
        }
    }

    public List<WebPage> getWebPageByKeyword(String keyword) {
        if (webPagesMap.containsKey(keyword)) {
            return webPagesMap.get(keyword).stream().toList();
        }
        throw new IllegalArgumentException("No such keyword found");
    }

    public void deleteWebPage(String url) {
        for (Map.Entry<String, List<WebPage>> entry : webPagesMap.entrySet()) {
            entry.getValue().removeIf(webPage -> webPage.getUrl().equals(url));
        }
    }
}
