package behavioral.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * По типу клиента (или по типу обрабатываемых данных) выбрать подходящий алгоритм, который следует применить. Если
 * используется правило, которое не подвержено изменениям, нет необходимости обращаться к шаблону «стратегия».
 */
public class StrategyTest {

    @Test
    public void shouldApplySelectedStrategy() {
        assertEquals(15, new Context(new OperationAdd()).executeStrategy(10, 5));
        assertEquals(5, new Context(new OperationSubtract()).executeStrategy(10, 5));
        assertEquals(50, new Context(new OperationMultiply()).executeStrategy(10, 5));
    }
}
