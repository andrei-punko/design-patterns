package creational.singleton.lazy.synchronizedaccessor;

/**
 * Этот вариант блокирует метод getInstance() вне зависимости от того, создали ли мы единственный экземпляр или нет.
 * Это замедляет работу программы, если требуется часто получать объект Singleton из разных потоков.
 * <pre>
 * + Ленивая инициализация
 * - Низкая производительность (критическая секция) в наиболее типичном доступе
 * </pre>
 */
public class Singleton {

    // volatile не нужен: все обращения к instance идут через synchronized-метод,
    // который даёт взаимное исключение и гарантирует видимость изменений (happens-before)
    // между потоками.
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
