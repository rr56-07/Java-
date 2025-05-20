import java.util.Scanner;

public class SSN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your SSN: ");
        String ssn = scanner.nextLine();

        if (ssn.matches("^\\d{3}-\\d{2}-\\d{4}$")) {
            System.out.println( ssn + " is valid");
        } else {
            System.out.println( ssn + " is invalid");
        }

        scanner.close();
    }
}
