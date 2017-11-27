package ppp.ch16;

public interface UserDatabase {
    User readUser(String userName);
    void writeUser(User user);
}
