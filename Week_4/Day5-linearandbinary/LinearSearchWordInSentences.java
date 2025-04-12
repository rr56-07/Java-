package linearandbinary;

public class LinearSearchWordInSentences {
    public static void main(String[] args) {
        String[] sentences = {
            "The sky is blue.",
            "I love programming.",
            "Java is powerful.",
            "I enjoy learning new things."
        };

        String word = "Java";
        String result = findSentenceWithWord(sentences, word);

        System.out.println(result);
    }

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}
