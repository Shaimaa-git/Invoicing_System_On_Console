import java.util.Map;

public class Menu {

    //Perfect
    public static void show() {
        System.out.println("1- Shop Settings");
        System.out.println("2- Manage Shop Items");
        System.out.println("3- Create New Invoice");
        System.out.println("4- Report: Statistics");
        System.out.println("5- Report: All Invoices");
        System.out.println("6- Search Invoices");
        System.out.println("7- Program Statistics");
        System.out.println("8- Exit");
    }
    public static void shopSettingMenu() {
        System.out.println("Shop Settings Menu:");
        System.out.println("1- Load Data (Items and invoices)");
        System.out.println("2- Set Shop Name");
        System.out.println("3- Set Invoice Header");
        System.out.println("4- Go Back");
    }
    public static void manageShopItem(){
        System.out.println("Manage Shop Items Menu:");
        System.out.println("1- Add Item");
        System.out.println("2- Delete Item");
        System.out.println("3- Change Item Price");
        System.out.println("4- Report All Items");
        System.out.println("5- Go Back");
    }

}

