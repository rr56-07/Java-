import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = sc.nextLine();

        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);

        if (matcher.matches()) {
            System.out.println("Valid username");
        } else {
            System.out.println("Invalid username");
        }
        sc.close();
    }
}
