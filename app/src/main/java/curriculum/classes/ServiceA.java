package curriculum;
class ServiceA implements IService {
    private final Repository _repository;

    public ServiceA(Repository repository) {
        this._repository = repository;
    }

    public boolean call(int val) {
        return _repository.update(val);
    }
}

// class ServiceA implements IService {
//     private final IRepository _decRepository;

//     public ServiceA(IRepository decRepository) {
//         this._decRepository = decRepository;
//     }

//     public boolean call(int val) {
//         return _decRepository.update(val);
//     }
// }