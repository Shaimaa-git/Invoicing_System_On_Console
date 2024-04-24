import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Invoice {
    private static int nextInvoiceNumber = 1;
    private int invoiceNumber;
    private String customerName;
    private String phoneNumber;
    private String invoiceDate;
    private List<Item> items;
    private List<Integer> quantities;
    private double totalAmount;
    private double paidAmount;
    private double balance;

    public Invoice(String customerName, String phoneNumber, String invoiceDate) {
        this.invoiceNumber = nextInvoiceNumber++;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.invoiceDate = invoiceDate;
        this.items = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.totalAmount = 0;
        this.paidAmount = 0;
        this.balance = 0;
    }

    public void addItem(Item item, int quantity) {
        items.add(item);
        quantities.add(quantity);
        totalAmount += item.getUnitPrice() * quantity;
    }
    public static void getInvoiceHeaderSetting(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Invoice Header Information:");
        System.out.print("Telephone: ");
        String tel = scanner.next();
        System.out.print("Fax: ");
        String fax = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Website: ");
        String website = scanner.next();
        DataLoader.shop.setInvoiceHeader(tel, fax, email, website);
        System.out.println("Invoice header information set successfully.");
    }
    public static void getCreateNewInvoiceSetting(){
        Scanner scanner = new Scanner(System.in);
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
            if (itemId == -1) { //TODO: What if it is less than -1
                break;
            }
            else {
                System.out.println("Invalid Input. Enter a number greater then -1");
            }
                // Search for item by ID and add to the invoice
            boolean found = false;
            for (Item item : DataLoader.shop.getItems()) {
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
    }

    public static void getReportStatistics(){ //FIXME: Typo in the name
        System.out.println("Report: Statistics Menu:");
        int totalItems = 0;
        int totalInvoices = DataLoader.shop.getInvoices().size();
        double totalSales = 0;

        // Calculate total number of items and total sales from all invoices
        for (Invoice invoice : DataLoader.shop.getInvoices()) {
            totalItems += invoice.getItems().size();
            totalSales += invoice.getTotalAmount();
        }

        // Print statistics
        System.out.println("Total number of items sold: " + totalItems);
        System.out.println("Total number of invoices: " + totalInvoices);
        System.out.println("Total sales: $" + totalSales);
    }
    public static void getReportAllInvoice(){
        System.out.println("Report: All Invoices Menu:");
        List<Invoice> allInvoices = DataLoader.shop.getInvoices();
        if (allInvoices.isEmpty()) {
            System.out.println("No invoices found.");
        } else {

            //Brilliant use of string parameters
            System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Invoice No", "Invoice Date", "Customer Name", "No of Items", "Total");
            for (int i = 0; i < allInvoices.size(); i++) {
                Invoice invoice = allInvoices.get(i);
                System.out.printf("%-15d %-15s %-15s %-15d $%.2f\n", i + 1, invoice.getInvoiceDate(), invoice.getCustomerName(), invoice.getItems().size(), invoice.getTotalAmount());
            }
        }
    }
    public static void getSearchInvoice(){ //Good code can be improved
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search Invoices Menu:");
        System.out.print("Enter Invoice Number: ");
        int searchInvoiceNumber = scanner.nextInt();
        boolean found = false;

        for (Invoice invoice : DataLoader.shop.getInvoices()) {
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
    }
    // Getters for invoice details
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getQuantityForItem(Item item) {
        int index = items.indexOf(item);
        if (index != -1) {
            return quantities.get(index);
        }
        return 0;
    }

    public double getItemAmount(Item item) {
        int index = items.indexOf(item);
        if (index != -1) {
            return item.getUnitPrice() * quantities.get(index);
        }
        return 0;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getBalance() {
        return balance;
    }
}