package structural.bridge;

public class LargeCircleDrawer implements Drawer {

    private static final int RADIUS_MULTIPLIER = 10;

    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Large circle center = " + x + "," + y + " radius = " + radius * RADIUS_MULTIPLIER);
    }
}
