import LinkedList.*;


public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new SinglyLinkedList<Integer>();
        System.out.println(list);
        list.addTail(1);
        list.addTail(4);
        list.addTail(3);
        System.out.println(list);
        list.addBefore(1, 2);
        System.out.println(list);
        list.addAfter(2, 5);
        System.out.println(list);
        list.delete(2);
        System.out.println(list);
    }
}
