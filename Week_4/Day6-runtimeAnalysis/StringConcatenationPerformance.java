package runtimeAnalysis;

public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        
        for (int size : datasetSizes) {
            // Using String
            long stringStartTime = System.nanoTime();
            String concatenatedString = concatenateWithString(size);
            long stringEndTime = System.nanoTime();
            long stringTime = stringEndTime - stringStartTime;

            // Using StringBuilder
            long stringBuilderStartTime = System.nanoTime();
            String concatenatedStringBuilder = concatenateWithStringBuilder(size);
            long stringBuilderEndTime = System.nanoTime();
            long stringBuilderTime = stringBuilderEndTime - stringBuilderStartTime;

            // Using StringBuffer
            long stringBufferStartTime = System.nanoTime();
            String concatenatedStringBuffer = concatenateWithStringBuffer(size);
            long stringBufferEndTime = System.nanoTime();
            long stringBufferTime = stringBufferEndTime - stringBufferStartTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("String Concatenation Time: " + stringTime / 1000000.0 + " ms");
            System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime / 1000000.0 + " ms");
            System.out.println("StringBuffer Concatenation Time: " + stringBufferTime / 1000000.0 + " ms");
            System.out.println();
        }
    }

    // Concatenating using String
    public static String concatenateWithString(int size) {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += "string"; // Inefficient string concatenation
        }
        return result;
    }

    // Concatenating using StringBuilder
    public static String concatenateWithStringBuilder(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("string");
        }
        return sb.toString();
    }

    // Concatenating using StringBuffer
    public static String concatenateWithStringBuffer(int size) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append("string");
        }
        return sb.toString();
    }
}
