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
        serviceA.fetch(0);
    }

    static class ServiceA {
        private final DBRepository _repository;

        public ServiceA(DBRepository dRepository) {
            _repository = dRepository;
        }

        public RepositoryObject fetch(int useCache) {
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
                add(new CacheAnswer(0, "Answer"));
                add(new CacheAnswer(1, "Answer1"));
                add(new CacheAnswer(2, "Answer2"));
                add(new CacheAnswer(3, "Answer3"));
            }
        };
    }

    // Cache object duplicates data that is the same across the enumerable.
    static class CacheAnswer {
        private int _valOne = 1;
        private String _valTwo = "Two";
        private int _id;
        private String _answer;

        public CacheAnswer(int ID, String answer) {
            _id = ID;
            _answer = answer;
        }
    }

    // interface IRepositoryObject {
    //     int getValOne();
    //     String getValTwo();
    //     List<IAnswer> getAnswers();
    // }

    // interface RepositoryFacade
}
