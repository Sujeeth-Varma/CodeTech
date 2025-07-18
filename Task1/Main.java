import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String FILE_PATH = "demo.txt";
        Scanner scanner = new Scanner(System.in);

        // Initial file creation
        FileOperations.writeFile(FILE_PATH, "Hello World!\nWelcome to Java File Operations.\n");

        // Demonstrate reading
        FileOperations.readFile(FILE_PATH);

        // Demonstrate modification
        System.out.print("\nEnter text to replace: ");
        String oldText = scanner.nextLine();
        System.out.print("Enter new text: ");
        String newText = scanner.nextLine();

        FileOperations.modifyFile(FILE_PATH, oldText, newText);
        FileOperations.readFile(FILE_PATH);

        scanner.close();
    }

}
