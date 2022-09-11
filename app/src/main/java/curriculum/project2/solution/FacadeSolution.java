import java.util.ArrayList;
import java.util.List;

/*
* Project 1: Refactor this application. 
* ServiceA calls for data from the repo, but it now needs the option to call from the cache.
* The cache stores the data in a different structure, but the reponse from the service requires the same structure.
 */
public class FacadeSolution {
    public static void main(String[] args) throws Exception {
        run();
    }

    private static void run() {
        Service serviceDB = new Service(new CacheRepository());
        Service serviceCache = new Service(new DBRepository());
        serviceDB.fetch();
        serviceCache.fetch();
    }

    public interface IRepository {
        IRepositoryObject fetch();
    }

    public interface IRepositoryObject {
        int getValOne();
        String getValTwo();
        List<IAnswer> getAnswers();
    }

    public interface IAnswer {
        int getId();
        String getAnswer();
    }

    public static class Service {
        private final IRepository _repository;

        public Service(IRepository repository) {
            _repository = repository;
        }

        public IRepositoryObject fetch() {
            return _repository.fetch();
        }
    }

    public static class DBRepository implements IRepository {
        public DBRepository() {}

        public IRepositoryObject fetch() {
            return new RepositoryObject();
        }
    }

    public static class CacheRepository implements IRepository {
        private Cache _cache = new Cache();

        public CacheRepository() {}

        public IRepositoryObject fetch() {
            return new CacheObjectFacade(_cache.get());
        }
    }

    public static class Cache {
        public Cache() {}

        public CacheObject get() {
            return new CacheObject();
        }
    }

    public static class CacheObjectFacade implements IRepositoryObject {
        private final CacheObject _cacheObject;

        public CacheObjectFacade(CacheObject cacheObject) {
            _cacheObject = cacheObject;
        }

        public int getValOne() {
            return ((CacheAnswer) _cacheObject.getAnswers().get(0)).getValOne();
        }

        public String getValTwo() {
            return ((CacheAnswer) _cacheObject.getAnswers().get(0)).getValTwo();
        }

        public List<IAnswer> getAnswers() {
            return _cacheObject.getAnswers();
        }
    }

    public static class RepositoryObject implements IRepositoryObject {
        private int _valOne = 1;
        private String _valTwo = "Two";
        private List<IAnswer> _answers = new ArrayList<IAnswer>()  {
            {
                add(new Answer(0, "Answer"));
                add(new Answer(1, "Answer1"));
                add(new Answer(2, "Answer2"));
                add(new Answer(3, "Answer3"));
            }
        };

        public int getValOne() {
            return _valOne;
        }

        public String getValTwo() {
            return _valTwo;
        }

        public List<IAnswer> getAnswers() {
            return _answers;
        }
    }

    public static class Answer implements IAnswer {
        private int _id;
        private String _answer;

        public Answer(int ID, String answer) {
            _id = ID;
            _answer = answer;
        }

        public int getId() {
            return _id;
        }
        public String getAnswer() {
            return _answer;
        }
    }

    // From Business:
    // Cache object duplicates data that is the same across the enumerable.
    public static class CacheObject {
        private List<IAnswer> _answers = new ArrayList<IAnswer>()
        {
            {
                add(new CacheAnswer(4, "Answe4"));
                add(new CacheAnswer(5, "Answer5"));
                add(new CacheAnswer(6, "Answer6"));
                add(new CacheAnswer(7, "Answer7"));
            }
        };

        public List<IAnswer> getAnswers() {
            return _answers;
        }
    }

    public static class CacheAnswer implements IAnswer {
        private int _valOne = 4;
        private String _valTwo = "Five";
        private int _id;
        private String _answer;

        public CacheAnswer(int id, String answer) {
            _id = id;
            _answer = answer;
        }

        public int getId() {
            return _id;
        }

        public String getAnswer() {
            return _answer;
        }

        public int getValOne() {
            return _valOne;
        }

        public String getValTwo() {
            return _valTwo;
        }
    }
}
