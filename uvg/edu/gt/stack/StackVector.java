package uvg.edu.gt.stack;

import java.util.Vector;

public class StackVector<T> extends AbstractStack<T> {

    private Vector<T> vector = new Vector<>();

    @Override
    public void push(T item) {
        vector.add(item);
    }

    @Override
    public T pop() {
        return vector.remove(vector.size() - 1);
    }

    @Override
    public T peek() {
        return vector.get(vector.size() - 1);
    }

    @Override
    protected int size() {
        return vector.size();
    }
}
