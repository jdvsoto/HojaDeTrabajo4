package uvg.edu.gt;

/**
 * Interfaz genérica para el ADT Lista.
 * Solo los métodos necesarios para soportar la operación de una pila.
 * @param <T> tipo de elementos en la lista
 */
public interface List<T> {
    void addFirst(T item);
    T removeFirst();
    T getFirst();
    boolean isEmpty();
    int size();
}
