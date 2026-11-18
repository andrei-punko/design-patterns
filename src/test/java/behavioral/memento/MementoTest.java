package behavioral.memento;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Memento (хранитель) - шаблон, позволяющий, не нарушая инкапсуляцию, зафиксировать и сохранить внутреннее состояние
 * объекта так, чтобы позднее восстановить его в это состояние.
 */
public class MementoTest {

    @Test
    public void shouldRestoreSavedStates() {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        assertEquals("State #4", originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        assertEquals("State #2", originator.getState());

        originator.getStateFromMemento(careTaker.get(1));
        assertEquals("State #3", originator.getState());
    }
}
