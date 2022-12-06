import User.UserHandler;

public class MovieBookingSystem {

    private static UserHandler uh = UserHandler.getInstance();
    public static void main(String[] args) {
        uh.create("test", "test", "123", "adff", "fasdf", false);
        System.out.println(uh.getUser().getName());
    }

}
