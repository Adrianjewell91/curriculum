package curriculum;

class ServiceB implements IService {
    private final Repository _repository;

    public ServiceB(Repository repository) {
        this._repository = repository;
    }

    public boolean call(int val) {
        return _repository.update(val);
    }
}

// class ServiceB implements IService {
//     private final IRepository _repository;

//     public ServiceB(IRepository repository) {
//         this._repository = repository;
//     }

//     public boolean call(int val) {
//         return _repository.update(val);
//     }
// }