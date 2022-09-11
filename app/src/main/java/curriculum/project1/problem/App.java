package curriculum.project1.problem;

/*
 * Project 1: Refactor the application.
 * ServiceB cannot use the publishing logic, but ServiceA should use it.
 */
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



