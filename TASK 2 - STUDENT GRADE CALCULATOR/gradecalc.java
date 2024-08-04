import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

class GradeCalc {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        double[] marks = new double[6];
        boolean validInput = false;

        while (!validInput) {
            try {
                for (int i = 0; i < marks.length; i++) {
                    marks[i] = readMark(in, "Enter marks of subject " + (i + 1) + ":");
                }
                validInput = true; // Input is valid, exit loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                in.next(); // Clear the invalid input
            }
        }

        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }

        double avg = sum / marks.length;

        // Formatting the average to 2 decimal places
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Sum of marks = " + sum);
        System.out.println("Average percentage = " + df.format(avg));

        // Grade determination
        if (avg >= 80) {
            System.out.println("Grade is A");
        } else if (avg >= 60) {
            System.out.println("Grade is B");
        } else {
            System.out.println("Grade is C");
        }
    }

    private static double readMark(Scanner in, String prompt) {
        double mark = -1;
        while (mark < 0 || mark > 100) {
            System.out.println(prompt);
            try {
                mark = in.nextDouble();
                if (mark < 0 || mark > 100) {
                    System.out.println("Marks must be between 0 and 100. Please enter again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values.");
                in.next(); // Clear the invalid input
            }
        }
        return mark;
    }
}
