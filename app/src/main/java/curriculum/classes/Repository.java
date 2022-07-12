package curriculum;
class Repository {
    private final Publisher _publisher;

    public Repository(Publisher publisher) {
        this._publisher = publisher;
    }

    public boolean update(int val) {
        _publisher.publish(val);
        return true;
    }
}

// class Repository implements IRepository {
//     public Repository() {
//     }

//     public boolean update(int val) {
//         return true;
//     }
// }