package User;

import java.util.HashMap;
import java.util.Map;

public class UserHandler {
    public Map<String, User> users = new HashMap<>(); // email - user
    private User user;
    private static UserHandler instance;

    public static UserHandler getInstance() {
        if (instance == null) {
            Class var0 = UserHandler.class;
            synchronized (var0) {
                if (instance == null) {
                    instance = new UserHandler();
                }
            }
        }
        return instance;
    }

    public boolean create(String name, String email, String phoneNumber, String homeAddress, String password, boolean admin) {
        if (users.containsKey(email)) {
            return false;
        }
        User user = new AdminUser(name, email, phoneNumber, homeAddress, password);
        if (admin) {
            AdminUser adminUser = (AdminUser) user;
            users.putIfAbsent(email, adminUser);
        } else {
            BasicUser basicUser = (BasicUser) user;
            users.putIfAbsent(email, basicUser);
        }
        return true;
    }

    public boolean login(String email, String password) {
        if (!users.containsKey(email)) {
            return false;
        }
        if (!users.get(email).getPassword().equals(password)) {
            return false;
        }
        this.user = users.get(email);
        return true;
    }

    public boolean logout() {
        if (this.user != null) {
            this.user = null;
            return true;
        }
        return false;
    }

    public User getUser() {
        return this.user;
    }

}
