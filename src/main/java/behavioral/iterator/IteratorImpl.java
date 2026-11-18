package behavioral.iterator;

import java.util.NoSuchElementException;

public class IteratorImpl<T> implements Iterator<T> {

    private final T[] arr;
    private int index = 0;

    public IteratorImpl(T[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return index < arr.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return arr[index++];
    }
}
