package curriculum.project1.solution;

/*
 * Project 1: Refactor this application.
 * ServiceB cannot use the publishing logic, but ServiceA should use it.
 */
public class App {
    public static void main(String[] args) throws Exception {
        run();
    }

    private static void run() {
        IService serviceWithPublish = new ServiceA(new Decorator(new Publisher(), new Repository()));
        IService serviceWithOutPublish = new ServiceB(new Repository());

        serviceWithPublish.call(1);
        serviceWithOutPublish.call(2);
    }
}



