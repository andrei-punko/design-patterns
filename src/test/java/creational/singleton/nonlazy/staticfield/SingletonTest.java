package creational.singleton.nonlazy.staticfield;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SingletonTest {

    @Test
    public void shouldInitializeInstanceEagerly() {
        assertNotNull("Instance must be initialized eagerly", Singleton.INSTANCE);
    }
}
