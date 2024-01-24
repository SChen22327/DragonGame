import java.util.Scanner;
public class Shop {
    private ItemInfo[] items;
    private Scanner scan;
    private String tempMsg;
    public Shop(ItemInfo[] list, Scanner scan) {
        items = list;
        this.scan = scan;
        tempMsg = "";
    }

    public void menu(Player player) {
        Utility.clearScreen();
        if (tempMsg.isEmpty()) {
            System.out.println();
        } else {
            System.out.println(tempMsg + "\n");
        }
        System.out.println("Select an item to view its details.\n");
        System.out.println("Items For Sale");
        for (int i = 0; i < items.length; i++) {
            System.out.println("(" + (i + 1) + ") " + items[i].getName());
        }
        System.out.println("(7) Exit Shop");
        int choice = -1;
        while (choice > 6 || choice == -1) {
            if (choice > 6) {
                System.out.println("That's not a valid option.");
            }
            System.out.println();
            System.out.print("Enter the number of the item you'd like to buy: ");
            choice = scan.nextInt() - 1;
            scan.nextLine();
        }
        if (choice != 6) {
            System.out.println(items[choice].getInfo());
            System.out.print("\nDo you want go through with this purchase? (Y/N): ");
            String yn = scan.nextLine().toLowerCase();
            if (yn.equals("y")) {
                if (items[choice].hasEnough(player.getGold())) {
                    if (items[choice].hasItem()) {
                        if (choice == 0) {
                            if (items[0].getAmountOwned() > 5) {
                                tempMsg = "You already have 5 HP pots.";
                                menu(player);
                            } else {
                                items[0].incrementAmountOwned(player);
                                DragonSlayer.addToNews("HP pot added to inventory. Current amount: " + items[0].getAmountOwned());
                            }
                        } else {
                            tempMsg = "You already have a " + items[choice].getName() + ".";
                            menu(player);
                        }
                    } else {
                        items[choice].incrementAmountOwned(player);
                        DragonSlayer.addToNews(items[choice].getName() + " added to inventory.\nCheck inventory to use/toggle.");
                    }
                } else {
                    tempMsg = "You don't have enough money.";
                    menu(player);
                }
            } else {
                tempMsg = "Returning to shop menu...";
                menu(player);
            }
        }
    }
}
