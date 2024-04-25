import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //Good idea to use Hashmaps
    static Map<Integer, Integer> menuSelections = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop("My Grocery Shop");

        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                Menu.show();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                menuSelections.put(choice, menuSelections.getOrDefault(choice, 0) + 1);
                switch (choice) {
                    case 1:
                        Menu.shopSettingMenu();
                        System.out.print("Enter your choice: ");
                        int settingChoice = scanner.nextInt();
                        switch (settingChoice) {
                            case 1:
                                DataLoader.getDataLoaderSetting();
                                break;
                            case 2:
                                Shop.getShopNameSetting();
                                break;
                            case 3:
                                Invoice.getInvoiceHeaderSetting();
                                break;
                            case 4:
                                // Go back to main menu
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                        break;
                    case 2:
                        Menu.manageShopItem();
                        System.out.print("Enter your choice: ");
                        int itemChoice = scanner.nextInt();
                        switch (itemChoice) {
                            case 1:
                                Item.getAddItemSetting();
                                break;
                            case 2:
                                Item.getItemDeletionSetting();
                                break;
                            case 3:
                                Item.getItemChangePriceSetting();
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
                        Invoice.getCreateNewInvoiceSetting();
                        break;

                    case 4:
                        Invoice.getReportStatistics();
                        break;

                    case 5:
                        Invoice.getReportAllInvoice();
                        break;

                    case 6:
                        Invoice.getSearchInvoice();
                        break;

                    case 7:
                        System.out.println("Program Statistics Menu:");
                        printMenuSelections();
                        break;
                    case 8:
                        Exit.exitSystem();
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
        for (Map.Entry<Integer, Integer> entry : Main.menuSelections.entrySet()) {
            System.out.println("Menu Option " + entry.getKey() + ": " + entry.getValue() + " times selected");
        }
    }
}