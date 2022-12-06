package User;

import java.util.HashMap;
import java.util.Map;

public class UserHandler {
    public Map<String, AUser> users = new HashMap<>(); // email - user
    private AUser AUser;
    public static UserHandler instance;

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

    public User.AUser create(String name, String email, String phoneNumber, String homeAddress, String password, boolean admin) {
        if (users.containsKey(email)) {
            return null;
        }
        AUser AUser = new BasicUser(name, email, phoneNumber, homeAddress, password);
        if (admin) {
            AdminUser adminUser = (AdminUser) AUser;
            users.putIfAbsent(email, adminUser);
        } else {
            BasicUser basicUser = (BasicUser) AUser;
            users.putIfAbsent(email, basicUser);
        }
        this.AUser = AUser;
        return AUser;
    }

    public boolean login(String email, String password) {
        if (!users.containsKey(email)) {
            return false;
        }
        if (!users.get(email).getPassword().equals(password)) {
            return false;
        }
        this.AUser = users.get(email);
        return true;
    }

    public boolean logout() {
        if (this.AUser != null) {
            this.AUser = null;
            return true;
        }
        return false;
    }

    public AUser getUser() {
        return this.AUser;
    }

}
