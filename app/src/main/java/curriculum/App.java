package curriculum;

/*
 * Project 1: Refactor this application to use the decorator pattern.
 * ServiceB cannot use the publishing logic, but ServiceA should use it.
 */
// Split classes.
// One App.
// Make the solution classes because you want those testable.
// Figure out how to test these.
public class App {
    public static void main(String[] args) throws Exception {
        run();
    }

    private static void run() {
        ServiceA serviceA = new ServiceA(new Repository(new Publisher()));
        serviceA.call(0);

        // IService serviceA = new ServiceA(new Decorator(new Publisher(), new Repository()));

        // IService serviceB = new ServiceB(new Repository());

        // serviceA.call(0);
        // serviceB.call(1);

        System.out.println("Ran Services");
    }
}



