package curriculum.project1.solution;
    
    public class Decorator implements IRepository {
        private final Publisher _publisher;
        private final IRepository _repository;

        public Decorator(Publisher publisher, IRepository repository) {
            this._publisher = publisher;
            this._repository = repository;
        }

        public boolean update(int val) {
            boolean didUpdate = _repository.update(val);
            if(didUpdate) {
                _publisher.publish(val);
            }
            return didUpdate;
        }
    }