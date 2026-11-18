package creational.singleton.nonlazy.usingenum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class SingletonTest {

    @Test
    public void shouldHaveSingleEnumInstance() {
        // An enum guarantees a single constant instance, even after deserialization
        assertEquals(1, Singleton.values().length);
        assertNotNull(Singleton.INSTANCE);
        assertSame(Singleton.INSTANCE, Singleton.valueOf("INSTANCE"));
    }
}
