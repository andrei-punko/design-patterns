package behavioral.iterator;

public class IteratorImpl<T> implements Iterator {

    private final T[] arr;
    private int index = 0;

    public IteratorImpl(T[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        if (index < arr.length) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return arr[index++];
        }
        return null;
    }
}
