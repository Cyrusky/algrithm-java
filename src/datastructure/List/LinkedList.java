package datastructure.List;

public class LinkedList {

    public Node list;
    private Node tail;

    public LinkedList() {
        this.list = new Node();
        this.list.value = null;
        this.list.next = null;
        this.tail = this.list;
    }

    public void add(Integer value) {
        this.tail.next = new Node(value);
        this.tail = this.tail.next;
    }


    public static class Node {
        public Integer value;
        public Node next;

        public Node(Integer value) {
            this.value = value;
            this.next = null;
        }

        public Node() {
            this.value = null;
            this.next = null;
        }
    }
}
