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
        //TODO: Update variable name
        Invoice invoice1 = new Invoice("John Doe", "1234567890", "2024-04-20");
        invoice1.addItem(items.get(0), 2); // Add Apple (ID: 1) with quantity 2
        invoices.add(invoice1);

        //TODO: Instead of repeating the code make function and pass params
        Invoice invoice2 = new Invoice("Jane Smith", "9876543210", "2024-04-19");
        invoice2.addItem(items.get(1), 3); // Add Banana (ID: 2) with quantity 3
        invoice2.addItem(items.get(2), 1); // Add Orange (ID: 3) with quantity 1
        invoices.add(invoice2);

        return invoices;
    }
    public static void getDataLoaderSetting(){
        List<Item> items = DataLoader.loadItems();
        List<Invoice> invoices = DataLoader.loadInvoices(items);
        shop.setItems(items);
        shop.setInvoices(invoices);
        System.out.println("Data loaded successfully.");
    }
}

