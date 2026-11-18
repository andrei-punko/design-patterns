package creational.prototype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Задаёт виды создаваемых объектов с помощью экземпляра-прототипа и создаёт новые объекты путём копирования этого прототипа.
 * Позволяет уйти от реализации и следовать принципу «программирование через интерфейсы».
 * В качестве возвращающего типа указывается интерфейс/абстрактный класс на вершине иерархии, а классы-наследники могут
 * подставить туда наследника, реализующего этот тип.
 * <p>
 * Проще говоря, это паттерн создания объекта через клонирование другого объекта вместо создания через конструктор.
 */
public class PrototypeTest {

    @Test
    public void shouldCreateIndependentCopyOfPrototype() throws CloneNotSupportedException {
        Cookie prototype = new CoconutCookie();
        prototype.weight = 150;
        CookieMachine machine = new CookieMachine(prototype);

        Cookie copy = machine.makeCookie();

        assertNotSame("Clone must be a new object", prototype, copy);
        assertEquals(prototype.weight, copy.weight);
        assertTrue("Clone must keep the concrete prototype type", copy instanceof CoconutCookie);
    }
}
