package calculator.stack;

import java.util.ArrayList;

public class StackArrayList<T> extends AbstractStack<T> {

    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public T pop() {
        return list.remove(list.size() - 1);
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
    }

    @Override
    protected int size() {
        return list.size();
    }
}
