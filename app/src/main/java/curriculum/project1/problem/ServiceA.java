package curriculum.project1.problem;
public class ServiceA implements IService {
    private final Repository _repository;

    public ServiceA(Repository repository) {
        this._repository = repository;
    }

    public boolean call(int val) {
        return _repository.update(val);
    }
}

