package ru.faang.school.hashmap.task_5.ver2_with_node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<String, Node> index = new HashMap<>();
    private Map<String, List<Node>> indexUrl = new HashMap<>();

    public void splittingIntoKeywords(WebPage webPage) {
        String[] s = webPage.getContent().split(" ");
        for (int i = 0; i < s.length; i++) {
            String keyWords = s[i];
            Node node = new Node();
            node.content = webPage;
            node.key = keyWords;
            if (index.containsKey(keyWords)) {
                Node nodeEmpty = index.get(keyWords); //самая верхняя нода
                nodeEmpty.last.next = node;
                nodeEmpty.last = node;
                node.prev = index.get(keyWords);
            } else {
                Node nodeEmpty = new Node();
                nodeEmpty.next = node;
                node.prev = nodeEmpty;
                nodeEmpty.last = node;
                index.put(keyWords, nodeEmpty);
            }

            if (indexUrl.containsKey(webPage.getUrl())) {
                indexUrl.get(webPage.getUrl()).add(node);
            } else {
                List<Node> list = new ArrayList<>();
                list.add(node);
                indexUrl.put(webPage.getUrl(), list);
            }
        }


    }

//    public List<WebPage> searchWepPages(String keyWords) {
//        if (index.get(keyWords) != null) {
//            List<WebPage> webPages = index.get(keyWords);
//            return webPages;
//        } else {
//            throw new IllegalArgumentException("По ключевому слову " + keyWords + " страниц не найдено");
//        }
//    }

    public void removePage(String url) {
        List<Node> list = indexUrl.get(url);
        for (Node node : list) {
            Node prev = node.prev;
            Node next = node.next;
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            } else {
                index.remove(node.key);
            }
        }
        indexUrl.remove(url);
    }

    class Node {
        Node last;
        Node prev;
        Node next;
        WebPage content;

        String key;
    }
}
