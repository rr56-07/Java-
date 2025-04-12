package runtimeAnalysis;

import java.io.*;

public class LargeFileReadingEfficiency {

    public static void main(String[] args) {
        String filePath = "largefile.txt";  // Make sure to replace with the path of your large file
        
        // Reading with FileReader
        long fileReaderStartTime = System.nanoTime();
        readWithFileReader(filePath);
        long fileReaderEndTime = System.nanoTime();
        long fileReaderTime = fileReaderEndTime - fileReaderStartTime;

        // Reading with InputStreamReader
        long inputStreamReaderStartTime = System.nanoTime();
        readWithInputStreamReader(filePath);
        long inputStreamReaderEndTime = System.nanoTime();
        long inputStreamReaderTime = inputStreamReaderEndTime - inputStreamReaderStartTime;

        System.out.println("FileReader Time: " + fileReaderTime / 1000000.0 + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1000000.0 + " ms");
    }

    // Read with FileReader
    public static void readWithFileReader(String filePath) {
        try (FileReader fr = new FileReader(filePath)) {
            int i;
            while ((i = fr.read()) != -1) {
                // Do nothing, just reading the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read with InputStreamReader
    public static void readWithInputStreamReader(String filePath) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            int i;
            while ((i = isr.read()) != -1) {
                // Do nothing, just reading the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
