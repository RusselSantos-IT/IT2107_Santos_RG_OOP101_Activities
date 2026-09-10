
import java.util.Scanner;

class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n=== WELCOME TO TINDAHAN NI ALING TISING ===\n");

        // Menu Data
        String[] items = {"Pork Adobo", "Bicol Express", "Chicken Adobo", "Fried Chicken", "Tortang Talong"};
        double[] prices = {80.0, 80.0, 80.0, 50.0, 30.0};

        int totalitem = 0;
        double discount = 0.0;
        char orderAgain = 'Y';

        // Display Menu
        System.out.println("========== MENU ==========");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i] + " - P" + prices[i]);
        }
        System.out.println("==========================");

        // Main Ordering Loop
        do {
            System.out.print("\nEnter item number (1-5): ");
            int itemChoice = input.nextInt();

            // Validate item number first
            if (itemChoice < 1 || itemChoice > 5) {
                System.out.println("Invalid item number! Please enter only 1-5.");
                continue;
            }

            System.out.print("Enter quantity (1-10): ");
            int quantity = input.nextInt();

            // Validate quantity
            if (quantity < 1 || quantity > 10) {
                System.out.println("Invalid quantity! Please enter only 1-10.");

                System.out.print("Do you want to try ordering again? (Y/N): ");
                orderAgain = input.next().toUpperCase().charAt(0);
                continue;
            }

            double itemPrice = prices[itemChoice - 1];
            double orderSubtotal = itemPrice * quantity;

            totalitem += quantity;
            discount += orderSubtotal;

            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = input.next().toUpperCase().charAt(0);

        } while (orderAgain == 'Y');

        // Student Status for Discount
        System.out.print("\nAre you a student? (Y/N): ");
        char studentInput = input.next().toUpperCase().charAt(0);
        boolean isStudent = (studentInput == 'Y');

        // Deduction Calculation
        double deductionPercentage = 0.0;

        if (isStudent && discount >= 500) {
            deductionPercentage = 0.15;
        } else if (isStudent) {
            deductionPercentage = 0.10;
        } else if (discount >= 500) {
            deductionPercentage = 0.05;
        } else {
            deductionPercentage = 0.00;
        }

        double totalDeduction = discount * deductionPercentage;
        double finalAmountToPay = discount - totalDeduction;

        // Final Receipt
        System.out.println("\n==================================");
        System.out.println("          FINAL RECEIPT           ");
        System.out.println("==================================");
        System.out.println("Total quantity of items purchased: " + totalitem);
        System.out.printf("Total amount before Discount     : P%.2f\n", discount);
        System.out.printf("Total Discount                   : P%.2f\n", totalDeduction);
        System.out.printf("Final amount to pay              : P%.2f\n", finalAmountToPay);
        System.out.println("==================================");

        input.close();
    }
}
