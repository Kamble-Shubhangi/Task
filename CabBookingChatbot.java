import java.util.Random;
import java.util.Scanner;

public class CabBookingChatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] routes = {
            "Pune Station -> Shivajinagar",
            "Swargate -> Kothrud",
            "Hinjawadi -> Wakad"
        };
        int[] distances = {5, 8, 10};

        String[] cabTypes = {"Auto", "Sedan", "SUV"};
        int[] ratesPerKm = {12, 18, 25};

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter your choice (1 or 2): ");

            int mainChoice = -1;
            if (scanner.hasNextInt()) {
                mainChoice = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            if (mainChoice == 2) {
                System.out.println("Thank you for using Cab Booking Chatbot. Goodbye!");
                break;
            } else if (mainChoice != 1) {
                System.out.println("Invalid choice! Please select 1 or 2.");
                continue;
            }

            System.out.println("\n--- CHOOSE CAB TYPE ---");
            System.out.println("1. Auto (₹12/km)");
            System.out.println("2. Sedan (₹18/km)");
            System.out.println("3. SUV (₹25/km)");
            System.out.print("Enter cab choice (1-3): ");

            int cabChoice = -1;
            if (scanner.hasNextInt()) {
                cabChoice = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Returning to main menu.");
                scanner.next();
                continue;
            }

            if (cabChoice < 1 || cabChoice > 3) {
                System.out.println("Invalid cab choice! Returning to main menu.");
                continue;
            }

            String selectedCab = cabTypes[cabChoice - 1];
            int rate = ratesPerKm[cabChoice - 1];

            System.out.println("\n--- CHOOSE ROUTE ---");
            for (int i = 0; i < routes.length; i++) {
                System.out.println((i + 1) + ". " + routes[i] + " (" + distances[i] + " km)");
            }
            System.out.print("Enter route choice (1-3): ");

            int routeChoice = -1;
            if (scanner.hasNextInt()) {
                routeChoice = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Returning to main menu.");
                scanner.next();
                continue;
            }

            if (routeChoice < 1 || routeChoice > 3) {
                System.out.println("Invalid route choice! Returning to main menu.");
                continue;
            }

            String selectedRoute = routes[routeChoice - 1];
            int distance = distances[routeChoice - 1];

            int totalFare = rate * distance;

            System.out.println("\n--- RIDE SUMMARY ---");
            System.out.println("Cab Type  : " + selectedCab);
            System.out.println("Route     : " + selectedRoute);
            System.out.println("Distance  : " + distance + " km");
            System.out.println("Rate/km   : ₹" + rate);
            System.out.println("Total Fare: ₹" + totalFare);

            System.out.println("\n--- CONFIRMATION ---");
            System.out.println("1. Confirm & Share OTP");
            System.out.println("2. Cancel Ride");
            System.out.print("Enter your choice (1 or 2): ");

            int confirmChoice = -1;
            if (scanner.hasNextInt()) {
                confirmChoice = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Ride cancelled. Returning to main menu.");
                scanner.next();
                continue;
            }

            if (confirmChoice == 2) {
                System.out.println("Ride has been cancelled successfully. Returning to main menu.");
                continue;
            } else if (confirmChoice != 1) {
                System.out.println("Invalid choice! Ride cancelled. Returning to main menu.");
                continue;
            }

            int otp = 1000 + random.nextInt(9000);
            System.out.println("\n[SUCCESS] Booking Confirmed!");
            System.out.println("Your 4-digit OTP is: " + otp);
            System.out.println("Note: Once the OTP has been shared, the ride cannot be cancelled.");
            System.out.println("Returning to the main menu...");
        }

        scanner.close();
    }
}