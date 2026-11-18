package behavioral.nullobject;

import java.util.List;

public class CustomerFactory {

    private static final List<String> NAMES = List.of("Rob", "Joe", "Julie");

    private CustomerFactory() {
    }

    public static AbstractCustomer getCustomer(String name) {
        for (String candidate : NAMES) {
            if (candidate.equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
