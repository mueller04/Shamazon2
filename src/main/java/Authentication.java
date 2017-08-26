import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Authentication {

    HashMap<String, String> users = new HashMap();
    Scanner sc = new Scanner(System.in);

    public Authentication() {
        users.put("Mike", "password");
        users.put("Court", "Germany12");
    }

    public boolean login() {

        if (checkUserName()) {
            return checkPassword();
        }
        return false;
    }

    private boolean checkUserName() {
        System.out.println("Enter your username");
        String userName = sc.nextLine();
        for (Map.Entry<String, String> user : users.entrySet()) {
            if (userName.equals(user.getKey())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPassword() {
        System.out.println("Enter your password");
        String password = sc.nextLine();
        for (Map.Entry<String, String> user : users.entrySet()) {
            if (password.equals(user.getValue())) {
                return true;
            }
        }
        return false;
    }
}
