import java.util.Scanner;

class LabAct1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] food = {"Burger", "Fries", "Pizza", "Hotdog", "Coke"};
        double[] price = {50, 30, 80, 40, 20};

        int choice;
        int quantity;
        int totalQuantity = 0;

        double total = 0;
        double discount = 0;
        double finalAmount;

        char student;
        char again;

        // Display Menu
        System.out.println("===== CANTEEN MENU =====");

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + food[i] + " - " + price[i]);
        }

        // Ordering
        do {

            System.out.print("\nChoose food (1-5): ");
            choice = scanner.nextInt();

            // Validate choice
            while (choice < 1 || choice > 5) {
                System.out.println("Invalid choice!");
                System.out.print("Choose again (1-5): ");
                choice = scanner.nextInt();
            }

            // Switch
            switch (choice) {
                case 1:
                    System.out.println("You chose Burger");
                    break;
                case 2:
                    System.out.println("You chose Fries");
                    break;
                case 3:
                    System.out.println("You chose Pizza");
                    break;
                case 4:
                    System.out.println("You chose Hotdog");
                    break;
                case 5:
                    System.out.println("You chose Coke");
                    break;
            }

            // Quantity
            System.out.print("Enter quantity (1-10): ");
            quantity = scanner.nextInt();

            if (quantity < 1 || quantity > 10) {
                System.out.println("Invalid quantity!");
                continue;
            }

            // Compute order
            total = total + (price[choice - 1] * quantity);
            totalQuantity = totalQuantity + quantity;

            // Student
            System.out.print("Are you a student? (Y/N): ");
            student = scanner.next().charAt(0);

            // Discount
            if ((student == 'Y' || student == 'y') && total >= 500) {
                discount = total * 0.15;
            }
            else if (student == 'Y' || student == 'y') {
                discount = total * 0.10;
            }
            else if (total >= 500) {
                discount = total * 0.05;
            }
            else {
                discount = 0;
            }

            System.out.print("Do you want to order again? (Y/N): ");
            again = scanner.next().charAt(0);

        } while (again == 'Y' || again == 'y');

        // Final amount
        finalAmount = total - discount;

        // Order Summary
        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total Quantity: " + totalQuantity);
        System.out.println("Total Before Discount: " + total);
        System.out.println("Total Discount: " + discount);
        System.out.println("Final Amount: " + finalAmount);

        scanner.close();
    }
}