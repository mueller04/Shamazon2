import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Authentication auth = new Authentication();
        Application app = new Application();
        boolean keepRunning = true;
        Scanner sc = new Scanner(System.in);

        do {

            if (auth.login()) {
                app.start();
                keepRunning = false;
            } else {
                keepRunning = loginMenu(keepRunning, sc);
            }

        } while (keepRunning);
    }

    private static boolean loginMenu(boolean keepRunning, Scanner sc) {
        System.out.print("\nIncorrect Credentials.  Try again.");
        System.out.print("\n1 - try again" +
                "\n2 - exit\n");

        int selection = sc.nextInt();

        if (selection == 2) {
            keepRunning = false;
        }
        return keepRunning;
    }
}
