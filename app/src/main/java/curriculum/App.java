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
        System.out.println("Running Services");
        try {
            curriculum.project1.solution.App.main(null);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
}



