import java.util.Scanner;

public class ReplaceWhiteSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String input = sc.nextLine();

        String res = input.replaceAll("\\s+"," ");
        System.out.println("Result: "+res);
        sc.close();
    }
}
