package curriculum.project1.problem;

public class Repository {
    private final Publisher _publisher;

    public Repository(Publisher publisher) {
        this._publisher = publisher;
    }

    public boolean update(int val) {
        _publisher.publish(val);
        return true;
    }
}
