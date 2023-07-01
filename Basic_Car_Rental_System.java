import java.util.Scanner;
import java.lang.Math;

public class Basic_Car_Rental_System {
    public static void main(String[] args) {
        int max = 50;
        int min = 10;
        int total = 60;

        System.out.println("Welcome to BCR");
        System.out.println("Per Day 50$ + 10$ deposite");
        Scanner input = new Scanner(System.in);
        System.out.println("DO YOU WANT TO RENT A CAR [Y or N]");
        String response = input.next().toUpperCase();
        if (response.equals("N")) {
            System.out.println("You Selected No");
        } else if (response.equals("Y")) {
            System.out.println("PLEASE SELECT TYPE OF CAR ELECTRIC(E) or PETROL(P) ");
            response = input.next().toUpperCase();
            if (response.equals("E") || response.equals("P")) {
                System.out.println("DO YOU HAVE ANY COUPAN [Y or N]");
                response = input.next().toUpperCase();
                if (response.equals("Y")) {
                    int per = (int) (Math.random() * (max - min + 1) + min);
                    System.out.println("Whoooo You got " + per + "%" + " " + "off from your order");
                    Double discount = (per * 0.01);
                    System.out.println("The Price is " + Math.abs(total * discount) + "$ Per day");
                } else {
                    System.out.println("Your Price is " + total + "$ Per day");
                }
            }

            input.close();
        }
    }

}
