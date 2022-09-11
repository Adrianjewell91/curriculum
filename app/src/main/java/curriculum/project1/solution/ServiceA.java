package curriculum.project1.solution;

public class ServiceA implements IService {
    private final IRepository _decRepository;

    public ServiceA(IRepository decRepository) {
        this._decRepository = decRepository;
    }

    public boolean call(int val) {
        return _decRepository.update(val);
    }
}