package behavioral.iterator;

public interface Container<T> {

    CustomIterator<T> getIterator();
}
