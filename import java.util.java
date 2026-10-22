import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 10000.0;

        System.out.println("Welcome to Kiran Bank");
        System.out.println("Opening Balance: ₹" + (int)balance);

        while (true) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + (int)balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.println("Deposit successful.");
                        System.out.println("Updated Balance: ₹" + (int)balance);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid withdrawal amount.");
                    } else if (withdrawAmount > balance) {
                        System.out.println("Transaction failed: Insufficient balance.");
                        System.out.println("Current Balance: ₹" + (int)balance);
                    } else {
                        balance -= withdrawAmount;
                        System.out.println("Withdrawal successful.");
                        System.out.println("Updated Balance: ₹" + (int)balance);
                    }
                    break;

                case 4:
                    System.out.println("Thank you for banking with us. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
}