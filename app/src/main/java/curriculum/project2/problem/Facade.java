package curriculum.project2.problem;

import java.util.ArrayList;
import java.util.List;

/*
* Project 1: Refactor this application. 
* ServiceA calls for data from the repo, but it now needs the option to call from the cache.
* The cache stores the data in a different structure, but the reponse from the service requires the same structure.
 */
public class Facade {
    public static void main(String[] args) throws Exception {
        run();
    }

    private static void run() {
        Service service = new Service(new DBRepository());
        service.fetch();
    }

    public static class Service {
        private final DBRepository _repository;

        public Service(DBRepository dRepository) {
            _repository = dRepository;
        }

        public RepositoryObject fetch() {
            return _repository.fetch();
        }
    }

    public static class DBRepository {
        public DBRepository() {}

        public RepositoryObject fetch() {
            return new RepositoryObject();
        }
    }

    public static class RepositoryObject {
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

    public static class Answer {
        private int _id;
        private String _answer;

        public Answer(int ID, String answer) {
            _id = ID;
            _answer = answer;
        }
    }

    public static class Cache {
        public Cache() {}

        public CacheObject get() {
            return new CacheObject();
        }
    }

    public static class CacheObject {
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
    public static class CacheAnswer {
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
