package behavioral.command;

import org.junit.Test;

/**
 * Паттерн, представляющий действие. Объект команды заключает в себе само действие и его параметры.
 */
public class CommandTest {

    @Test
    public void shouldExecuteAllOrders() {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
