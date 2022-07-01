/*
 * Project 1: Refactor this application to use the decorator pattern.
 * ServiceA cannot use the publishing logic, but ServiceB should use it.
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Initializing the services");
        run();
    }

    private static void run() {
        ServiceA serviceA = new ServiceA();
        serviceA.update(0);
    }

    static class Repository {
        private final Publisher publisher = new Publisher();

        public Repository() {}

        public boolean update(int val) {
            System.out.println("Value Updated");
            System.out.println("Change Tracking Published: " + publisher.publish());
            return true;
        }
    }

    static class Publisher {
        public Publisher() {}

        public boolean publish() {
            return true;
        }
    }

    static class ServiceA {
        private final Repository repository = new Repository();

        public ServiceA() {}

        public boolean update(int val) {
            return repository.update(val);
        }
    }

    static class ServiceB {
        private final Repository repository = new Repository();

        public ServiceB() {}

        public boolean update(int val) {
            return repository.update(val);
        }
    }

    static class Test {
        public Test() {}

        // Test: Coding to interface.
        // Using decorator pattern
        // ServiceA uses the base
        // ServiceB uses the decorator
        // Classes have indended functionality and structures
        // Publisher has intended functionality
        // Repository has intended functionality
        //
    }
}
