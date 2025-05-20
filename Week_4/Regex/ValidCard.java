import java.util.Scanner;

public class ValidCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your credit card number: ");
        String cardNumber = scanner.nextLine();

        if (isValidVisa(cardNumber)) {
            System.out.println("Valid Visa card number.");
        } else if (isValidMasterCard(cardNumber)) {
            System.out.println("Valid MasterCard number.");
        } else {
            System.out.println("Invalid credit card number.");
        }

        scanner.close();
    }

    public static boolean isValidVisa(String card) {
        return card.matches("^4\\d{15}$"); 
    }

    public static boolean isValidMasterCard(String card) {
        return card.matches("^5\\d{15}$"); 
    }

}
