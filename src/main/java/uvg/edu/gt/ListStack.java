package uvg.edu.gt;

/**
 * Implementación de Stack usando una Lista (simplemente o doblemente encadenada).
 * @param <T> tipo de elementos en la pila
 */
public class ListStack<T> extends AbstractStack<T> {

    private List<T> list;

    public ListStack(List<T> list) {
        this.list = list;
    }

    @Override
    public void push(T item) {
        list.addFirst(item);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T item = list.removeFirst();
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.getFirst();
    }
}
