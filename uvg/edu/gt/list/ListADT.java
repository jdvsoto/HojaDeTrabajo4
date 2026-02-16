package uvg.edu.gt.list;

public interface ListADT<T> {
    void addLast(T item);

    T removeLast();

    T getLast();

    int size();
}
