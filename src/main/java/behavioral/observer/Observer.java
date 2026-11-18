package behavioral.observer;

public abstract class Observer {

    protected final Subject subject;

    protected Observer(Subject subject) {
        this.subject = subject;
    }

    public abstract void update();
}
