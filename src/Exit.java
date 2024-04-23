import java.util.Scanner;

public class Exit {
    public static void exitSystem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you sure you want to exit? (y/n): ");
        String confirm = scanner.next();
        if (confirm.equalsIgnoreCase("y")) {
            System.out.println("Exiting program.");
            System.exit(0);
        } else if (confirm.equalsIgnoreCase("n")) {

        } else {
            System.out.println("Invalid choice. Please enter 'y' or 'n'.");
        }
    }
}
