package creational.singleton.nonlazy.staticfield;

/**
 * <pre>
 * + Простая и прозрачная реализация
 * + Потокобезопасность
 * - Не ленивая инициализация
 * </pre>
 */
public class Singleton {

    public static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }
}
