package Stack;

import LinkedList.*;

public class Stack <T>{
    private LinkedList<T> list = new DoublyLinkedList<T>();

    public void push(T value){
        list.addTail(value);
    }
    public T peak() {
        return list.get(0);
    }

    public T pop() {
        T result = list.get(0);
        list.deleteTail();
        return result;
    }
}
