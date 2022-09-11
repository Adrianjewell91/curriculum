package curriculum.project1.solution;

public class ServiceB implements IService {
    private final IRepository _repository;

    public ServiceB(IRepository repository) {
        this._repository = repository;
    }

    public boolean call(int val) {
        return _repository.update(val);
    }
}