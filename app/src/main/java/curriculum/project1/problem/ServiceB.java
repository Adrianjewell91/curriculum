package curriculum.project1.problem;

public class ServiceB implements IService {
    private final Repository _repository;

    public ServiceB(Repository repository) {
        this._repository = repository;
    }

    public boolean call(int val) {
        return _repository.update(val);
    }
}
