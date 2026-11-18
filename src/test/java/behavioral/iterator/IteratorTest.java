package behavioral.iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

/**
 * Представляет собой объект, позволяющий получить последовательный доступ к элементам объекта-агрегата без
 * использования описаний каждого из агрегированных объектов.
 */
public class IteratorTest {

    private static final String[] NAMES = {"Robert", "John", "Julie", "Lora"};

    private Iterator<String> iterator;

    @Before
    public void setUp() {
        iterator = new IteratorImpl<>(NAMES);
    }

    @Test
    public void shouldIterateOverAllElementsInOrder() {
        for (String expectedName : NAMES) {
            assertEquals(expectedName, iterator.next());
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    public void shouldThrowWhenNoMoreElements() {
        while (iterator.hasNext()) {
            iterator.next();
        }

        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
