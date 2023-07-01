import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Simple_Car_Loan {
    public static double calculateCarLoanEMI(double principal, double interestRate, int loanTerm) {
        double r = interestRate / 12 / 100;  // Convert annual interest rate to monthly rate
        int n = loanTerm * 12;  // Convert loan term from years to months

        double emi = (principal * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        return emi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age:");
        int age = sc.nextInt();
        if (age >= 21 && age <= 60) {
            System.out.println("Enter your income:");
            int income = sc.nextInt();
            if (income >= 25000) {
                System.out.println("Enter your credit score:");
                int creditScore = sc.nextInt();
                if (creditScore >= 700) {
                    System.out.println("You are eligible for a loan.");
                } else {
                    System.out.println("You are not eligible for a loan.");
                }
            } else {
                System.out.println("You are not eligible for a loan.");
            }
        } else {
            System.out.println("You are not eligible for a loan.");
        }

        System.out.println("EMI Calculator.....");

        System.out.println("Enter Amount: ");
        double principal = sc.nextDouble();
        System.out.println("Enter interest rate: ");
        double interestRate = sc.nextDouble();
        System.out.println("Enter number of years: ");
        int loanTerm = sc.nextInt();

        double emi = calculateCarLoanEMI(principal, interestRate, loanTerm);
        double roundedEMI = Math.round(emi * 100) / 100.0;

        NumberFormat formatter = new DecimalFormat("#,##0.00");
        String formattedEMI = formatter.format(roundedEMI);

        System.out.println("EMI: " + formattedEMI);

        sc.close();
    }
}
