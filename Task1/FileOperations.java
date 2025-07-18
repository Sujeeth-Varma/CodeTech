import java.io.*;

public class FileOperations {

    public static void readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("\nReading file: " + filePath);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("\nSuccessfully wrote to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public static void modifyFile(String filePath, String oldString, String newString) {
        StringBuilder content = new StringBuilder();

        // Read existing content
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line.replace(oldString, newString)).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error during modification read: " + e.getMessage());
            return;
        }

        // Write updated content
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content.toString());
            System.out.println("\nSuccessfully modified: " + filePath);
            System.out.println("Replaced '" + oldString + "' with '" + newString + "'");
        } catch (IOException e) {
            System.err.println("Error during modification write: " + e.getMessage());
        }
    }
}