import java.util.Objects;
import java.util.Scanner;

public class Item {
    private int itemId;
    private String itemName;
    private double unitPrice;

    public Item(int itemId, String itemName, double unitPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
    }
    public static void getAddItemSetting(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Item ID: ");
        int itemId = scanner.nextInt();
        System.out.print("Enter Item Name: ");
        String itemName = scanner.next();
        System.out.print("Enter Unit Price: ");
        double unitPrice = scanner.nextDouble();
        Item newItem = new Item(itemId, itemName, unitPrice);
        DataLoader.shop.addItem(newItem);
        System.out.println("Item added successfully.");
    }
    public static void getItemDeletionSetting(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Item ID to delete: ");
        int deleteItemId = scanner.nextInt();
        DataLoader.shop.deleteItem(deleteItemId);
    }
    public static void getItemChangePriceSetting(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Item ID to change price: ");
        int changeItemId = scanner.nextInt();
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        DataLoader.shop.changeItemPrice(changeItemId, newPrice);
    }
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(unitPrice, item.unitPrice) == 0 && Objects.equals(itemName, item.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, unitPrice);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}