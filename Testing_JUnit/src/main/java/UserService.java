import java.util.List;
import java.util.ArrayList;

public class UserService {

    private final List<String> users = new ArrayList<>();

    public boolean registerUser(String username) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        //if user alseady exists!
        if (users.contains(username)) {
            return false;
        }
        // add new username
        users.add(username);
        return true;
    }

    // check if user is registered
    public boolean isUserRegistered(String username) {
        return users.contains(username);
    }

    // clears the user list
    public void clearUsers() {
        users.clear();
    }
}
