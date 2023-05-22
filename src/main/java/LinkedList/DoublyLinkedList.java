package LinkedList;

public class DoublyLinkedList<T> implements LinkedList<T> {
    class Node {
        T value;

        Node next;

        Node previous;

        Node(T value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }

        boolean hasNext() {
            return this.next != null;
        }

        boolean hasPrevious() {
            return this.next != null;
        }
    }

    Node head;
    Node tail;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addTail(T value){
        size++;

        if (head == null && tail == null) {
            head = new Node(value);
            tail = head;
            return;
        }

        Node nNode = new Node(value);
        nNode.previous = tail;
        tail.next = nNode;
        tail = nNode;
    }

    @Override
    public void addHead(T value) {
        size++;

        if (head == null && tail == null) {
            head = new Node(value);
            tail = head;
            return;
        }

        Node nNode = new Node(value);
        nNode.next = head;
        head.previous = nNode;
        head = nNode;
    }

    @Override
    public void addBefore(int position, T value){
        if (position >= size) return;
        size++;

        if (head == null) {
            head = new Node(value);
        }

        int cur = 0;
        Node next = head;
        Node before = head;
        while (next.hasNext() && cur != position){
            cur++;
            before = next;
            next = next.next;
        }

        Node nNode = new Node(value);
        before.next = nNode;
        nNode.previous = before;
        nNode.next = next;
        next.previous = nNode;
    }

    @Override
    public void addAfter(int position, T value){
        if (position >= size) return;
        size++;

        if (head == null) {
            head = new Node(value);
            return;
        }

        Node next = head;
        int cur = 0;
        while (next.hasNext() && cur != position){
            next = next.next;
            cur++;
        }

        Node nNode = new Node(value);
        nNode.next = next.next;
        nNode.previous = next;
        next.next.next.previous = nNode;
        next.next = nNode;
    }

    @Override
    public T get(int position){
        if (position >= size) return null;

        Node next = head;
        int cur = 0;
        while (next.hasNext() && cur != position){
            next = next.next;
        }

        return next.value;
    }

    @Override
    public void delete(int position){
        if (position >= size) return;
        size--;

        Node next = head;
        Node before = head;
        int cur = 0;
        while (next.hasNext() && cur != position){
            before = next;
            next = next.next;
        }
        next.next.previous = before;
        before.next = next.next;

    }

    @Override
    public void deleteHead() {
        if (head == null) return;
        Node nHead = head.next;
        nHead.previous = null;
        head.next = null;
        head = nHead;
        size--;
    }

    @Override
    public void deleteTail() {
        if (tail == null) return;
        Node nTail = tail.previous;
        nTail.next = null;
        tail.previous = null;
        tail = nTail;
        size--;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("DoublyLinkedList [");
        if (head != null) {
            Node next = head;
            while (true) {
                result.append(next.value.toString());
                if (next.hasNext()) {
                    result.append(",");
                }
                else {
                    break;
                }
                next = next.next;
            }
        }
        return result.append("]").toString();
    }
}
