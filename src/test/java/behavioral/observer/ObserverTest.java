package behavioral.observer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Определяет зависимость типа «один ко многим» между объектами таким образом, что при изменении состояния одного
 * объекта все зависящие от него оповещаются об этом событии.
 */
public class ObserverTest {

    @Test
    public void test() {
        Subject subject = new Subject();

        // Observers are registered explicitly: passing `this` out of a constructor
        // would let a partially initialized object escape.
        subject.attach(new HexObserver(subject));
        subject.attach(new OctalObserver(subject));
        subject.attach(new BinaryObserver(subject));

        System.out.println("First state change: 15");
        subject.setState(15);
        assertEquals(15, subject.getState());

        System.out.println("Second state change: 10");
        subject.setState(10);
        assertEquals(10, subject.getState());
    }
}
