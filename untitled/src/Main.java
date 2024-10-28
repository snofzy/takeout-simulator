//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String customerName;
        int money = 0;

        System.out.print("Enter your customer name: ");
        customerName = input.nextLine();


        while (true) {
            System.out.print("Enter your starting money: ");
            try {
                money = input.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for money.");
                input.next();
            }
        }

        Customer customer = new Customer(customerName, money);
        TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer, new FoodMenu());

        takeOutSimulator.startTakeOutSimulator();
    }
}
