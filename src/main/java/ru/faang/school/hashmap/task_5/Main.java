package ru.faang.school.hashmap.task_5;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final Map<String, List<WebPage>> index = new HashMap<>();

    public void processWebPage(WebPage webPage) {
        String[] content = webPage.getContext().split("\\W+");
        Arrays.stream(content).sorted().distinct().forEach(word -> {
            if(!index.containsKey(word)) {
                index.put(word, new ArrayList<>());
                index.get(word).add(webPage);
            } else  {
                index.get(word).add(webPage);
            }
        });
    }

    public List<String> getPagesByKeyword(String keyword) {
        return index.get(keyword).stream().map(WebPage::toString).collect(Collectors.toList());
    }

    public void deletePageByUrl(URL url) {
        Set<WebPage> webPageSet = new HashSet<>();
        index.values().stream().forEach(webPages -> {
            webPages.stream().filter(webPage -> webPage.getUrl().equals(url)).forEach(webPageSet::add);
        });
        for (var value : index.values()) {
            value.removeAll(webPageSet);
        }
    }

}
