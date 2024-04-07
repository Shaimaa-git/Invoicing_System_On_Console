import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Integer> menuSelections = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop("My Grocery Shop");

        while (true) {
            try {
                Menu.show();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                menuSelections.put(choice, menuSelections.getOrDefault(choice, 0) + 1);
                switch (choice) {
                    case 1:
                        System.out.println("Shop Settings Menu:");
                        System.out.println("1- Set Shop Name");
                        System.out.println("2- Set Invoice Header");
                        System.out.println("3- Go Back");

                        System.out.print("Enter your choice: ");
                        int settingChoice = scanner.nextInt();
                        switch (settingChoice) {
                            case 1:
                                System.out.print("Enter new shop name: ");
                                scanner.nextLine(); // Clear the input buffer
                                String newShopName = scanner.nextLine();
                                shop.setShopName(newShopName);
                                System.out.println("Shop name set to: " + newShopName);
                                break;
                            case 2:
                                System.out.println("Enter Invoice Header Information:");
                                System.out.print("Telephone: ");
                                String tel = scanner.next();
                                System.out.print("Fax: ");
                                String fax = scanner.next();
                                System.out.print("Email: ");
                                String email = scanner.next();
                                System.out.print("Website: ");
                                String website = scanner.next();
                                shop.setInvoiceHeader(tel, fax, email, website);
                                System.out.println("Invoice header information set successfully.");
                                break;
                            case 3:
                                // Go back to main menu
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Manage Shop Items Menu:");
                        System.out.println("1- Add Item");
                        System.out.println("2- Delete Item");
                        System.out.println("3- Change Item Price");
                        System.out.println("4- Report All Items");
                        System.out.println("5- Go Back");

                        System.out.print("Enter your choice: ");
                        int itemChoice = scanner.nextInt();
                        switch (itemChoice) {
                            case 1:
                                System.out.print("Enter Item ID: ");
                                int itemId = scanner.nextInt();
                                System.out.print("Enter Item Name: ");
                                String itemName = scanner.next();
                                System.out.print("Enter Unit Price: ");
                                double unitPrice = scanner.nextDouble();
                                Item newItem = new Item(itemId, itemName, unitPrice);
                                shop.addItem(newItem);
                                System.out.println("Item added successfully.");
                                break;
                            case 2:
                                System.out.print("Enter Item ID to delete: ");
                                int deleteItemId = scanner.nextInt();
                                shop.deleteItem(deleteItemId);
                                break;
                            case 3:
                                System.out.print("Enter Item ID to change price: ");
                                int changeItemId = scanner.nextInt();
                                System.out.print("Enter new price: ");
                                double newPrice = scanner.nextDouble();
                                shop.changeItemPrice(changeItemId, newPrice);
                                break;
                            case 4:
                                shop.reportAllItems();
                                break;
                            case 5:
                                // Go back to main menu
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Create New Invoice Menu:");

                        // Collect invoice information
                        System.out.print("Enter customer full name: ");
                        scanner.nextLine(); // Clear the input buffer
                        String customerName = scanner.nextLine();
                        System.out.print("Enter phone number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Enter invoice date: ");
                        String invoiceDate = scanner.nextLine();

                        // Create new invoice object
                        Invoice newInvoice = new Invoice(customerName, phoneNumber, invoiceDate);

                        // Add items to the invoice
                        while (true) {
                            System.out.print("Enter item ID (or -1 to finish adding items): ");
                            int itemId = scanner.nextInt();
                            if (itemId == -1) {
                                break;
                            }
                            // Search for item by ID and add to the invoice
                            boolean found = false;
                            for (Item item : shop.getItems()) {
                                if (item.getItemId() == itemId) {
                                    found = true;
                                    System.out.print("Enter quantity for item " + item.getItemName() + ": ");
                                    int quantity = scanner.nextInt();
                                    newInvoice.addItem(item, quantity);
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Item with ID " + itemId + " not found.");
                            }
                        }

                        // Add invoice to shop or perform any further actions as needed
                        System.out.println("Invoice created successfully.");
                        break;

                    case 4:
                        System.out.println("Report: Statistics Menu:");
                        int totalItems = 0;
                        int totalInvoices = shop.getInvoices().size();
                        double totalSales = 0;

                        // Calculate total number of items and total sales from all invoices
                        for (Invoice invoice : shop.getInvoices()) {
                            totalItems += invoice.getItems().size();
                            totalSales += invoice.getTotalAmount();
                        }

                        // Print statistics
                        System.out.println("Total number of items sold: " + totalItems);
                        System.out.println("Total number of invoices: " + totalInvoices);
                        System.out.println("Total sales: $" + totalSales);
                        break;

                    case 5:
                        System.out.println("Report: All Invoices Menu:");
                        List<Invoice> allInvoices = shop.getInvoices();
                        if (allInvoices.isEmpty()) {
                            System.out.println("No invoices found.");
                        } else {
                            System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Invoice No", "Invoice Date", "Customer Name", "No of Items", "Total");
                            for (int i = 0; i < allInvoices.size(); i++) {
                                Invoice invoice = allInvoices.get(i);
                                System.out.printf("%-15d %-15s %-15s %-15d $%.2f\n", i + 1, invoice.getInvoiceDate(), invoice.getCustomerName(), invoice.getItems().size(), invoice.getTotalAmount());
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Search Invoices Menu:");
                        System.out.print("Enter Invoice Number: ");
                        int searchInvoiceNumber = scanner.nextInt();
                        boolean found = false;

                        for (Invoice invoice : shop.getInvoices()) {
                            if (invoice.getInvoiceNumber() == searchInvoiceNumber) {
                                found = true;
                                System.out.println("Invoice Details:");
                                System.out.println("Invoice Number: " + invoice.getInvoiceNumber());
                                System.out.println("Invoice Date: " + invoice.getInvoiceDate());
                                System.out.println("Customer Name: " + invoice.getCustomerName());
                                System.out.println("Phone Number: " + invoice.getPhoneNumber());
                                System.out.println("Total Amount: $" + invoice.getTotalAmount());
                                System.out.println("Paid Amount: $" + invoice.getPaidAmount());
                                System.out.println("Balance: $" + invoice.getBalance());

                                System.out.println("Items:");
                                for (Item item : invoice.getItems()) {
                                    System.out.println("Item ID: " + item.getItemId());
                                    System.out.println("Item Name: " + item.getItemName());
                                    System.out.println("Unit Price: $" + item.getUnitPrice());
                                    System.out.println("Quantity: " + invoice.getQuantityForItem(item));
                                    System.out.println("Item Amount: $" + invoice.getItemAmount(item));
                                }
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Invoice with number " + searchInvoiceNumber + " not found.");
                        }
                        break;

                    case 7:
                        System.out.println("Program Statistics Menu:");
                        printMenuSelections();
                        break;
                    case 8:
                        System.out.print("Are you sure you want to exit? (y/n): ");
                        String confirm = scanner.next();
                        if (confirm.equalsIgnoreCase("y")) {
                            System.out.println("Exiting program.");
                            System.exit(0);
                        } else if (confirm.equalsIgnoreCase("n")) {
                            continue;
                        } else {
                            System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a number between 1 and 8.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    private static void printMenuSelections() {
        System.out.println("Program Statistics Menu:");
        for (Map.Entry<Integer, Integer> entry : menuSelections.entrySet()) {
            System.out.println("Menu Option " + entry.getKey() + ": " + entry.getValue() + " times selected");
        }
    }
}

