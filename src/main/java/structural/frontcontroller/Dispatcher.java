package structural.frontcontroller;

public class Dispatcher {

    private final View studentView;
    private final View homeView;

    public Dispatcher() {
        studentView = new StudentView();
        homeView = new HomeView();
    }

    public void dispatch(String request) {
        if ("STUDENT".equalsIgnoreCase(request)) {
            studentView.show();
        } else if ("HOME".equalsIgnoreCase(request)) {
            homeView.show();
        } else {
            throw new IllegalArgumentException("Unknown request: " + request);
        }
    }
}
