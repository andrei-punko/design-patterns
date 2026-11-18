package creational.singleton.lazy.doublecheckedlockingandvolatile;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class SingletonTest {

    @Test
    public void shouldReturnSameInstance() {
        Singleton first = Singleton.getInstance();
        Singleton second = Singleton.getInstance();

        assertNotNull(first);
        assertSame("Singleton must return the same instance", first, second);
    }
}
