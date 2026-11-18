package creational.builder;

public class Waiter {

    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public Pizza getPizza() {
        requireBuilder();
        return pizzaBuilder.getPizza();
    }

    public void constructPizza() {
        requireBuilder();
        pizzaBuilder.createNewPizzaProduct();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildSauce();
        pizzaBuilder.buildTopping();
    }

    private void requireBuilder() {
        if (pizzaBuilder == null) {
            throw new IllegalStateException("Pizza builder is not set");
        }
    }
}
