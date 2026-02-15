package uvg.edu.gt.stack;

import uvg.edu.gt.list.ListADT;

public class StackList<T> extends AbstractStack<T> {

    private ListADT<T> list;

    public StackList(ListADT<T> list) {
        this.list = list;
    }

    @Override
    public void push(T item) {
        list.addLast(item);
    }

    @Override
    public T pop() {
        return list.removeLast();
    }

    @Override
    public T peek() {
        return list.getLast();
    }

    @Override
    protected int size() {
        return list.size();
    }
}
