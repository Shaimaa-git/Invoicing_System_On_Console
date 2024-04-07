import java.util.ArrayList;
import java.util.List;

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
