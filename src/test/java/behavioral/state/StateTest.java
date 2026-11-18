package behavioral.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Используется в тех случаях, когда во время выполнения программы объект должен менять своё поведение в зависимости от
 * своего состояния.
 */
public class StateTest {

    @Test
    public void shouldChangeStateWhenActionApplied() {
        Context context = new Context();
        assertTrue("Context must start in the initial state", context.getState() instanceof StartState);
        assertEquals("Start State", context.getState().toString());

        StartState startState = new StartState();
        startState.doAction(context);
        assertTrue("Start action must keep the start state", context.getState() instanceof StartState);
        assertEquals("Start State", context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);
        assertTrue("Stop action must replace the state", context.getState() instanceof StopState);
        assertEquals("Stop State", context.getState().toString());
    }
}
