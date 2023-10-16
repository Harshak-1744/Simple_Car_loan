import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Simple_Car_Loan {

    private static Scanner sc = new Scanner(System.in);

    private static double getInputDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }
    }

    private static int getInputInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();
            }
        }
    }

    private static boolean checkEligibility() {
        System.out.println("\n--- Checking Loan Eligibility ---");

        int age = getInputInt("Enter your age: ");
        int income = getInputInt("Enter your income: ");
        int creditScore = getInputInt("Enter your credit score: ");

        return age >= 21 && age <= 60 && income >= 25000 && creditScore >= 700;
    }

    private static void calculateAndDisplayEMI() {
        System.out.println("\n--- EMI Calculator ---");

        double principal = getInputDouble("Enter Amount: ");
        double interestRate = getInputDouble("Enter interest rate (in percentage): ");
        int loanTerm = getInputInt("Enter number of years: ");

        double emi = calculateCarLoanEMI(principal, interestRate, loanTerm);
        double roundedEMI = Math.round(emi * 100) / 100.0;

        System.out.println("Your monthly EMI: " + new DecimalFormat("#,##0.00").format(roundedEMI));
    }

    private static double calculateCarLoanEMI(double principal, double interestRate, int loanTerm) {
        double r = interestRate / 12 / 100;
        int n = loanTerm * 12;
        return (principal * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
    }

    public static void main(String[] args) {
        if (checkEligibility()) {
            System.out.println("Congratulations! You are eligible for a loan.");
            calculateAndDisplayEMI();
        } else {
            System.out.println("Sorry, you are not eligible for a loan.");
        }
        
        System.out.println("Thank you for using Car Loan Assistant. Goodbye!");
        sc.close();
    }
}
