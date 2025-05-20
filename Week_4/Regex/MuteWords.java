import java.util.ArrayList;
import java.util.Scanner;

 class MuteWords {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("damn");
        words.add("stupid");
        Scanner sc = new Scanner(System.in);
         System.out.println("Enter a sentence: ");
         String input = sc.nextLine();
        for(String word:words){
            input = input.replaceAll(word,"****");
        }
        System.out.println(input);
        sc.close();
    }
}
