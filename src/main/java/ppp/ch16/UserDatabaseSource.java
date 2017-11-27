package ppp.ch16;

/**
 * Java의 초기화 기능을 이용한 싱글턴 패턴
 */
public class UserDatabaseSource implements UserDatabase {
    private static UserDatabase theInstance = new UserDatabaseSource();

    public static UserDatabase instance() {
        return theInstance;
    }

    private UserDatabaseSource() {
    }

    @Override
    public User readUser(String userName) {
        // do something
        return null;
    }

    @Override
    public void writeUser(User user) {
        // do something
    }
}
