import java.io.*;
import java.util.Scanner;

public class StudentReportSystem {

    private static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            // Input student details
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter roll number: ");
            String rollNumber = scanner.nextLine();

            System.out.print("Enter marks: ");
            int marks = Integer.parseInt(scanner.nextLine()); // may throw NumberFormatException

            // Save details to file
            saveStudentDetails(name, rollNumber, marks);

            // Read and display student details
            System.out.println("\n Student Report");
            readStudentDetails();

        } catch (NumberFormatException e) {
            System.out.println(" Please enter numeric values.");
        } catch (IOException e) {
            System.out.println("File error occurred: " + e.getMessage());
        }
    }

    // Save details using BufferedWriter
    private static void saveStudentDetails(String name, String rollNumber, int marks) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write("Name: " + name + ", Roll No: " + rollNumber + ", Marks: " + marks);
            writer.newLine();
        }
    }

    // Read details using BufferedReader
    private static void readStudentDetails() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
