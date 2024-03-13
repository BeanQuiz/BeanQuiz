package za.co.bbd.beanquizcli.userservice;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    private Map<String, String> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        /**API: IMPLEMENT POST TO DB**/
        users.put(username, password);
    }

    public boolean authenticateUser(String username, String password) {
        /**TO DO: IMPLEMENT AUTHENTICATION**/
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            return true; // Admin login
        }
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

