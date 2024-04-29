import java.util.List;
import java.util.Map;

public interface shopBehavior {
    void setShopName(String shopName);
    void setInvoiceHeader(String tel, String fax, String email, String website);
    void addItem(Item item);
    List<Item> getItems();
    void deleteItem(int itemId);
    void changeItemPrice(int itemId, double newPrice);
    void reportAllItems();
    void addInvoice(Invoice invoice);
    List<Invoice> getInvoices();
    String getShopName();
    Map<String, String> getInvoiceHeader();
    void setInvoiceHeader(Map<String, String> invoiceHeader);
}
