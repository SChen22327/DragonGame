import java.util.Scanner;
public class Shop {
    private ItemInfo[] items;
    private Scanner scan;
    public Shop(ItemInfo[] list, Scanner scan) {
        items = list;
        this.scan = scan;
    }

    public void menu() {
        System.out.println();
        for (int i = 0; i < items.length; i++) {
            System.out.println("(" + (i + 1) + ") " + items[i].getName());
        }
        System.out.println();
        int choice = -1;
        while (choice > 5 || choice == -1) {
            if (choice > 5) {
                System.out.println("That's not a valid option.");
            }
            System.out.println();
            System.out.println("Enter the number of the item you'd like to buy: ");
            choice = scan.nextInt() - 1;
            scan.next();
        }
        System.out.println(items[choice].getInfo());
        System.out.println("Do you want go through with this purchase? ");
        String yn = scan.nextLine().toLowerCase();
        if (yn.equals("y")) {
            if (items[choice].hasItem()) {
                if (choice == 0) {
                    if (items[0].getAmountOwned() > 5) {
                        System.out.println("You already have 5 HP pots.");
                        menu();
                    } else {
                        items[0].incrementAmountOwned();
                        System.out.println("HP pot added to inventory. Current amount: " + items[0].getAmountOwned());
                    }
                } else {
                    System.out.println("You already have a " + items[choice].getName() + ".");
                    menu();
                }
            } else {
                items[choice].incrementAmountOwned();
                System.out.println(items[choice].getName() + " added to inventory.");
            }
        } else {
            menu();
        }
    }
}
