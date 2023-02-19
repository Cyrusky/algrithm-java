package ComplexDataStructure.List;

public class LinkedList<T extends Number> {

    public Node list;
    private Node tail;

    public LinkedList() {
        this.list = new Node();
        this.list.value = null;
        this.list.next = null;
        this.tail = this.list;
    }

    public void add(T value) {
        this.tail.next = new Node(value);
        this.tail = this.tail.next;
    }


    public class Node {
        public T value;
        public Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public Node() {
            this.value = null;
            this.next = null;
        }
    }
}
