import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LisencePlateValiadation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a License Number: ");
        String input = sc.nextLine();

        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
         if (matcher.matches()) {
            System.out.println("Valid License Number");
        } else {
            System.out.println("Invalid License Number");
        }
        sc.close();
    }
}
