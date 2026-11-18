package behavioral.observer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Определяет зависимость типа «один ко многим» между объектами таким образом, что при изменении состояния одного
 * объекта все зависящие от него оповещаются об этом событии.
 */
public class ObserverTest {

    @Test
    public void shouldNotifyObserversOnStateChange() {
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

    @Test
    public void shouldStopNotifyingDetachedObserver() {
        Subject subject = new Subject();
        CountingObserver observer = new CountingObserver(subject);
        subject.attach(observer);

        subject.setState(1);
        assertEquals(1, observer.updates);

        subject.detach(observer);
        subject.setState(2);
        assertEquals("Detached observer must not be notified", 1, observer.updates);
    }

    @Test
    public void shouldIgnoreDuplicateAttachAndUnchangedState() {
        Subject subject = new Subject();
        CountingObserver observer = new CountingObserver(subject);
        subject.attach(observer);
        subject.attach(observer);

        subject.setState(1);
        assertEquals("Duplicate attach must not double-notify", 1, observer.updates);

        subject.setState(1);
        assertEquals("Unchanged state must not notify observers", 1, observer.updates);
    }

    @Test
    public void shouldNotFailWhenObserverDetachesDuringNotification() {
        Subject subject = new Subject();
        SelfDetachingObserver first = new SelfDetachingObserver(subject);
        SelfDetachingObserver second = new SelfDetachingObserver(subject);
        subject.attach(first);
        subject.attach(second);

        subject.setState(1);

        assertEquals(1, first.updates);
        assertEquals("Every observer from the snapshot must still be notified", 1, second.updates);
    }

    private static class CountingObserver extends Observer {

        private int updates;

        CountingObserver(Subject subject) {
            super(subject);
        }

        @Override
        public void update() {
            updates++;
        }
    }

    private static class SelfDetachingObserver extends Observer {

        private int updates;

        SelfDetachingObserver(Subject subject) {
            super(subject);
        }

        @Override
        public void update() {
            updates++;
            subject.detach(this);
        }
    }
}
