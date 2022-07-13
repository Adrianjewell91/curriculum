import java.util.ArrayList;
import java.util.List;

/*
* Project 1: Refactor this application to use the facade pattern.
* ServiceA calls for data from the repo, but it now needs the option to call from the cache.
* The cache stores the data in a different way, but the data returned to the client needs to match the status quo.
 */
public class Facade {
    public static void main(String[] args) throws Exception {
        run();
    }

    private static void run() {
        ServiceA serviceA = new ServiceA(new DBRepository());
        serviceA.fetch();
    }

    static class ServiceA {
        private final DBRepository _repository;

        public ServiceA(DBRepository dRepository) {
            _repository = dRepository;
        }

        public RepositoryObject fetch() {
            return _repository.fetch();
        }
    }

    static class DBRepository {
        public DBRepository() {}

        public RepositoryObject fetch() {
            return new RepositoryObject();
        }
    }

    static class RepositoryObject {
        private int _valOne = 1;
        private String _valTwo = "Two";
        private List<Answer> _answers = new ArrayList<Answer>()  {
            {
                add(new Answer(0, "Answer"));
                add(new Answer(1, "Answer1"));
                add(new Answer(2, "Answer2"));
                add(new Answer(3, "Answer3"));
            }
        };
    }

    static class Answer {
        private int _id;
        private String _answer;

        public Answer(int ID, String answer) {
            _id = ID;
            _answer = answer;
        }
    }

    static class Cache {
        public Cache() {}

        public CacheObject get() {
            return new CacheObject();
        }
    }

    static class CacheObject {
        private List<CacheAnswer> answers = new ArrayList<CacheAnswer>()
        {
            {
                add(new CacheAnswer(4, "Answer4"));
                add(new CacheAnswer(5, "Answer5"));
                add(new CacheAnswer(6, "Answer6"));
                add(new CacheAnswer(7, "Answer7"));
            }
        };
    }

    // Cache object duplicates data that is the same across the enumerable.
    static class CacheAnswer {
        private int _valOne = 4;
        private String _valTwo = "Five";
        private int _id;
        private String _answer;

        public CacheAnswer(int ID, String answer) {
            _id = ID;
            _answer = answer;
        }
    }

    // Solution Hints:
    // interface IRepository {
    // interface IRepositoryObject {
    // interface IAnswer {
}
