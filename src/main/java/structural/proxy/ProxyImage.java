package structural.proxy;

public class ProxyImage implements Image {

    private final String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Lazy initialization is synchronized so that concurrent calls cannot create two RealImage instances.
     */
    @Override
    public synchronized void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
