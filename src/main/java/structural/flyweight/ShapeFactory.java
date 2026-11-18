package structural.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShapeFactory {

    private static final Map<String, Circle> circleMap = new ConcurrentHashMap<>();

    private ShapeFactory() {
    }

    public static Shape getCircle(String color) {
        return circleMap.computeIfAbsent(color, ShapeFactory::createCircle);
    }

    private static Circle createCircle(String color) {
        System.out.println("Creating circle of color : " + color);
        return new Circle(color);
    }
}
