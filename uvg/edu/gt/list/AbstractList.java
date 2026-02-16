package uvg.edu.gt.list;

public abstract class AbstractList<T> implements ListADT<T> {

    protected int size = 0;

    @Override
    public int size() {
        return size;
    }
}
