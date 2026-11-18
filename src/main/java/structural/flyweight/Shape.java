package structural.flyweight;

public interface Shape {

    /**
     * Extrinsic state (position and size) is provided by the client on every call,
     * so it is not stored inside the shared flyweight object.
     */
    void draw(int x, int y, int radius);
}
