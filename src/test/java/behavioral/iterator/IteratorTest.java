package behavioral.iterator;

import org.junit.Before;
import org.junit.Test;

/**
 * Представляет собой объект, позволяющий получить последовательный доступ к элементам объекта-агрегата без
 * использования описаний каждого из агрегированных объектов.
 */
public class IteratorTest {

    private Iterator iterator;

    @Before
    public void setUp() {
        final String[] names = {"Robert", "John", "Julie", "Lora"};
        iterator = new IteratorImpl<>(names);
    }

    @Test
    public void test() {
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            System.out.println("Name : " + name);
        }
    }
}
