package ru.faang.school.hashmap.task_5.ver3;

public class ListNode {
    private Node last;
    private Node first;
    private int size;

    public ListNode() {

    }

    public void add(WebPage webPage) {
        Node node = new Node();
        node.content = webPage;
        if (last == null && first == null) {
            first = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }


    public void remove(Node node) {
        if (node.next == null && node.prev == null) { //значит в списке одна нода и нужно удалить список

        }
        if (node.next == null) { //значит это последняя нода
            node.prev.next = null;
            last = node.prev;
            node.prev = null;
            size--;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    class Node {
        private Node prev;
        private Node next;
        private WebPage content;
        private String key;

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public WebPage getContent() {
            return content;
        }

        public void setContent(WebPage content) {
            this.content = content;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public int getSize() {
        return size;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
