import java.util.List;
public interface invoiceBehavior {
        int getInvoiceNumber();
        String getCustomerName();
        String getPhoneNumber();
        String getInvoiceDate();
        List<Item> getItems();
        int getQuantityForItem(Item item);
        double getItemAmount(Item item);
        double getTotalAmount();
        double getPaidAmount();
        double getBalance();
    }


