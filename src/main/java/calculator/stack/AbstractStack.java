package calculator.stack;

public abstract class AbstractStack<T> implements Stack<T> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    protected abstract int size();
}
