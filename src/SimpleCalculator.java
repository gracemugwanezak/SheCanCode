import java.util.Scanner;

public class SimpleCalculator {


    public static double add(double a, double b) {
        return a + b;
    }


    public static double subtract(double a, double b) {
        return a - b;
    }


    public static double multiply(double a, double b) {
        return a * b;
    }


    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalc = true;

        System.out.println("=== Welcome to Simple Calculator ===");

        while (continueCalc) {
            // Input numbers
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();


            System.out.println(num1 + " + " + num2 + " = " + add(num1, num2));
            System.out.println(num1 + " - " + num2 + " = " + subtract(num1, num2));
            System.out.println(num1 + " * " + num2 + " = " + multiply(num1, num2));
            System.out.println(num1 + " / " + num2 + " = " + divide(num1, num2));


            System.out.print("Do you want to perform another calculation? (y/n): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("y")) {
                continueCalc = false;
            }
            System.out.println();
        }

        System.out.println("Thank you for using Simple Calculator!");
        scanner.close();
    }
}
