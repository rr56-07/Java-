import java.util.*;

public class RepeatedWord {
    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";

        sentence = sentence.toLowerCase().replaceAll("[^a-z\\s]", "");

        String[] words = sentence.split("\\s+");
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new LinkedHashSet<>();

        for (String word : words) {
            if (!seen.add(word)) {
                repeated.add(word);
            }
        }

        System.out.println(String.join(", ", repeated));
    }
}
