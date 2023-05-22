package LinkedList;

public class SinglyLinkedList<T> implements LinkedList<T> {
    class Node {
        T value;

        Node next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }

        boolean hasNext() {
            return this.next != null;
        }
    }
    Node head;
    int size = 0;

    public int size(){
        return size;
    }

    @Override
    public void addTail(T value){
        size++;

        if (head == null) {
            head = new Node(value);
            return;
        }

        Node next = head;
        while (next.hasNext()){
            next = next.next;
        }
        next.next = new Node(value);
    }

    @Override
    public void addHead(T value) {
        size++;

        if (head == null) {
            head = new Node(value);
            return;
        }

        Node nNode = new Node(value);
        nNode.next = head;
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
        nNode.next = next;
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

        before.next = next.next;

    }

    @Override
    public void deleteHead() {
        if (head == null) return;
        Node nHead = head.next;
        head.next = null;
        head = nHead;
        size--;
    }

    @Override
    public void deleteTail() {
        if (head == null) return;
        Node next = head;
        Node before = head;
        while (next.hasNext()) {
            before = next;
            next = next.next;
        }
        before.next = null;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("SingledLinkedList [");
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
