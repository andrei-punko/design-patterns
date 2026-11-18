package creational.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Отделяет конструирование сложного объекта от его представления, так что в результате одного и того же процесса
 * конструирования могут получаться разные представления.
 */
public class BuilderExampleTest {

    @Test
    public void shouldBuildHawaiianPizza() {
        Waiter waiter = new Waiter();
        waiter.setPizzaBuilder(new HawaiianPizzaBuilder());
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();

        assertEquals("cross", pizza.getDough());
        assertEquals("mild", pizza.getSauce());
        assertEquals("ham+pineapple", pizza.getTopping());
    }

    @Test
    public void shouldBuildSpicyPizzaWithSameProcess() {
        Waiter waiter = new Waiter();
        waiter.setPizzaBuilder(new SpicyPizzaBuilder());
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();

        assertEquals("pan baked", pizza.getDough());
        assertEquals("hot", pizza.getSauce());
        assertEquals("pepperoni+salami", pizza.getTopping());
    }
}
