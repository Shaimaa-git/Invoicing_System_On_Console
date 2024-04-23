import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    public static Shop shop;

    // Method to load sample items
    public static List<Item> loadItems() {
        List<Item> items = new ArrayList<>();
        // Dummy data for items
        items.add(new Item(1, "Apple", 1.5));
        items.add(new Item(2, "Banana", 0.75));
        items.add(new Item(3, "Orange", 1.0));
        return items;
    }

    // Method to load sample invoices
    public static List<Invoice> loadInvoices(List<Item> items) {
        List<Invoice> invoices = new ArrayList<>();
        // Dummy data for invoices
        invoices.add(createInvoice("John Doe", "1234567890", "2024-04-20", items, new int[]{0}, new int[]{2}));
        invoices.add(createInvoice("Jane Smith", "9876543210", "2024-04-19", items, new int[]{1, 2}, new int[]{3, 1}));
        return invoices;
    }

    private static Invoice createInvoice(String customerName, String phoneNumber, String invoiceDate, List<Item> items, int[] itemIndices, int[] quantities) {
        Invoice invoice = new Invoice(customerName, phoneNumber, invoiceDate);
        for (int i = 0; i < itemIndices.length; i++) {
            invoice.addItem(items.get(itemIndices[i]), quantities[i]);
        }
        return invoice;
    }

    public static void getDataLoaderSetting() {
        List<Item> items = DataLoader.loadItems();
        List<Invoice> invoices = DataLoader.loadInvoices(items);
        shop.setItems(items);
        shop.setInvoices(invoices);
        System.out.println("Data loaded successfully.");
    }

    public static Shop getShop() {
        return null;
    }

}
