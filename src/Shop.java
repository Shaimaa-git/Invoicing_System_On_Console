import java.util.*;

public class Shop {

    private String shopName;
    private Map<String, String> invoiceHeader;
    private List<Item> items;
    private List<Invoice> invoices;

    public Shop(String shopName) {
        this.shopName = shopName;
        this.invoiceHeader = new HashMap<>();
        this.items = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    public static void setItems(List<Item> items) {
    }

    public static void setInvoices(List<Invoice> invoices) {
    }

    // Setters for shop name and invoice header
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    public static void getShopNameSetting(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new shop name: ");
        String newShopName = scanner.nextLine();
        Shop shop = new Shop(newShopName);
        DataLoader.shop = shop;
        System.out.println("Shop name set to: " + newShopName);
        scanner.nextLine(); // Clear the input buffer
    }

    public void setInvoiceHeader(String tel, String fax, String email, String website) {
        invoiceHeader.put("Telephone", tel);
        invoiceHeader.put("Fax", fax);
        invoiceHeader.put("Email", email);
        invoiceHeader.put("Website", website);
    }

    // Methods for managing items
    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void deleteItem(int itemId) {
        items.removeIf(item -> item.getItemId() == itemId);
    }

    public void changeItemPrice(int itemId, double newPrice) {
        for (Item item : items) {
            if (item.getItemId() == itemId) {
                item.setUnitPrice(newPrice);
                break;
            }
        }
    }

    public void reportAllItems() {
        System.out.println("All Shop Items:");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    // Methods for managing invoices
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public String getShopName() {
        return shopName;
    }

    public Map<String, String> getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(Map<String, String> invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(shopName, shop.shopName) && Objects.equals(invoiceHeader, shop.invoiceHeader) && Objects.equals(items, shop.items) && Objects.equals(invoices, shop.invoices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopName, invoiceHeader, items, invoices);
    }

}