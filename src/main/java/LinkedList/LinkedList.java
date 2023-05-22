package LinkedList;

public interface LinkedList<T> {
    int size();
    void addTail(T value);
    void addHead(T value);
    void addBefore(int position, T value);
    void addAfter(int position, T value);
    T get(int position);
    void delete(int position);
    void deleteHead();
    void deleteTail();
}
