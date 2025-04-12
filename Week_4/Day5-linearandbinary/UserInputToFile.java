package linearandbinary;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String filePath = "user_input.txt";
        
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter writer = new BufferedWriter(fw)) {
            
            String input;
            System.out.println("Enter input (type 'exit' to stop):");
            
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                writer.write(input);
                writer.newLine();
            }
            
            System.out.println("Input has been written to the file.");
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
