package linearandbinary;

import java.io.*;

public class WordCountInFile {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String targetWord = "example";
        int count = 0;
        
        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            
            System.out.println("The word '" + targetWord + "' appears " + count + " times.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
