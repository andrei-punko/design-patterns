package structural.flyweight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * Оптимизация работы с памятью путём предотвращения создания экземпляров элементов, имеющих общую сущность.
 */
public class FlyWeightTest {

    private static final String[] COLORS = {"Red", "Green", "Blue", "White", "Black"};

    @Test
    public void shouldDrawCirclesWithDifferentExtrinsicState() {
        for (int i = 0; i < 20; ++i) {
            Shape circle = ShapeFactory.getCircle(COLORS[i % COLORS.length]);
            circle.draw(i, i * 2, 100 + i);
        }
    }

    @Test
    public void shouldReuseFlyweightForSameColor() {
        Shape first = ShapeFactory.getCircle("Red");
        Shape second = ShapeFactory.getCircle("Red");

        assertNotNull(first);
        assertSame("Flyweight should be reused for the same color", first, second);
    }

    @Test
    public void shouldCreateSingleFlyweightPerColor() {
        Set<Shape> circles = new HashSet<>();
        for (String color : COLORS) {
            circles.add(ShapeFactory.getCircle(color));
        }

        assertEquals(COLORS.length, circles.size());
        assertNotSame(
                "Different colors must use different flyweights",
                ShapeFactory.getCircle("Red"),
                ShapeFactory.getCircle("Blue"));
    }
}
