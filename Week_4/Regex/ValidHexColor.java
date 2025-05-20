import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidHexColor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Hexcode: ");
        String input = sc.nextLine();

        String regex = "^[#][0-9a-zA-Z]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
         if (matcher.matches()) {
            System.out.println("Valid Hexcode");
        } else {
            System.out.println("Invalid Hexcode");
        }
        sc.close();
    }
}
