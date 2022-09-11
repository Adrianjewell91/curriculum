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
        ServiceB serviceB = new ServiceB(new Repository(new Publisher()));
        serviceB.call(1);
    }
}



