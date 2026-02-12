package uvg.edu.gt;

/**
 * Interfaz genérica para el ADT Stack.
 * @param <T> tipo de elementos en la pila
 */
public interface Stack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
