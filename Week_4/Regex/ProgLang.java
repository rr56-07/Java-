import java.util.ArrayList;
import java.util.Scanner;

 class ProgLang {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Python");
        words.add("Java");
        words.add("JavaScript");
        words.add("Go");
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter a sentence: ");
         String input = sc.nextLine();
         for (String word : words) {
            if (input.contains(word)) {
                System.out.println(word);
            }
        }
        sc.close();
    }
}
