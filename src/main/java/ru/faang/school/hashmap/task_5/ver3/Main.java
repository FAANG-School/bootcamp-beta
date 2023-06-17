package ru.faang.school.hashmap.task_5.ver3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<String, ListNode> index = new HashMap<>();
    private Map<String, List<ListNode.Node>> indexUrl = new HashMap<>();

    public void splittingIntoKeywords(WebPage webPage) {
        String[] s = webPage.getContent().split(" ");
        for (int i = 0; i < s.length; i++) {
            String keyWords = s[i];
            ListNode.Node lastAddedNode;
            if (index.containsKey(keyWords)) {
                index.get(keyWords).add(webPage);
                lastAddedNode = index.get(keyWords).getLast();
            } else {
                ListNode listNode = new ListNode();
                listNode.add(webPage);
                lastAddedNode = listNode.getLast();
                index.put(keyWords, listNode);
            }

            if (indexUrl.containsKey(webPage.getUrl())) {
                indexUrl.get(webPage.getUrl()).add(lastAddedNode);
            } else {
                List<ListNode.Node> list = new ArrayList<>();
                list.add(lastAddedNode);
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
//        List<ListNode.Node> list = indexUrl.get(url);
//        for (ListNode.Node node : list) {
//            if (node.getNext() == null && node.getPrev() == null) { //значит в списке одна нода и нужно удалить список
//
//            }
//            if (node.getNext() == null) { //значит это последняя нода
//                node.getPrev().setNext(null);
//                last = node.prev;
//                node.prev = null;
//                size--;
//            }
//            node.prev.next = node.next;
//            node.next.prev = node.prev;
//            size--;
//        }
//        indexUrl.remove(url);
    }

    class Node {
        Node last;
        Node prev;
        Node next;
        WebPage content;

        String key;
    }
}
