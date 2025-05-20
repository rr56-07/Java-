package map;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequencies(String filename) throws IOException {
        Map<String, Integer> frequencyMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        reader.close();
        return frequencyMap;
    }

    public static void main(String[] args) throws IOException {
        String filename = "input.txt"; // Make sure this file exists
        Map<String, Integer> frequencies = countWordFrequencies(filename);
        System.out.println(frequencies);
    }
}
