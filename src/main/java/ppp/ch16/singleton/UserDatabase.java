package ppp.ch16.singleton;

public interface UserDatabase {
    User readUser(String userName);
    void writeUser(User user);
}
