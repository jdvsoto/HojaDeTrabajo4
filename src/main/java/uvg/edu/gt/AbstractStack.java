package uvg.edu.gt;

/**
 * Clase abstracta que implementa los métodos comunes de Stack.
 * @param <T> tipo de elementos en la pila
 */
public abstract class AbstractStack<T> implements Stack<T> {

    protected int size;

    public AbstractStack() {
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
