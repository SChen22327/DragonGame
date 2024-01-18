import java.util.Scanner;
public class DragonSlayer {
    private ItemInfo[] inventory;
    private Scanner scan;
    private Room currentRoom;
    private Player player;
    public DragonSlayer() {
        createItemList();
        scan = new Scanner(System.in);
    }

    public void play() {
        System.out.println("What is your name, adventurer? ");
        player = new Player(scan.nextLine());
        System.out.println("\nAfter a long day's journey, I have finally arrived at the dragons' lair, ready to make a name for myself.");
        Utility.sleep(1500);
        boolean gameOver = false;
        currentRoom = Room.enter();
        while (!gameOver) {
            menu();
            int choice = scan.nextInt();
            scan.next();
            if (choice == 1) {
                currentRoom.search(inventory[0]);
            }
        }
    }

    public void menu() {
        System.out.println("(1) Search room");
        System.out.println("(2) Go back to the town's shop");
        System.out.println("(3) Check inventory");
        System.out.println("(4) Fight");
        System.out.println("(5) Enter next room(all dragons in the current room must be defeated)");
        System.out.println("(6) Give up");
        System.out.println("Enter the number of what you want to do: ");
    }


    private void createItemList() {
        inventory = new ItemInfo[6];
        inventory[0] = new ItemInfo("HP Pot", 20, "Heals for 75 points at most. Maximum 5 can be held at a time. Can be found through searching\na room or purchasing from the shop.");
        inventory[1] = new ItemInfo("Strength Potion", 30, "Temporarily increases attack by 15 points. Buff ends after attacking. Can be found \nthrough searching a room or purchasing from the shop.");
        inventory[2] = new ItemInfo("Focus Potion", 30, "Permanently increases dodge by 5 points. Bought from the shop.");
        inventory[3] = new ItemInfo("\"Critical Hitting for Dummies\" Book", 50, "Permanently increases crit by 5 points. Bought from the shop.");
        inventory[4] = new ItemInfo("Armour", 50, "Decrease damage by 15%. 20% chance to be destroyed for every attack against you. Bought from\nthe shop.");
        inventory[5] = new ItemInfo("Machine Gun", 300, "You can equip and unequip. Increases your damage output to 100 when equipped, cannot\nget a critical hit. Bought from the shop.");
    }

    private void inventory() {
        System.out.println("--You currently have--");
        for (int i = 0; i < inventory.length; i++) {
            ItemInfo item = inventory[i];
            if (item.hasItem()) {
                System.out.println(item.getInfo());
            }
        }
        System.out.println("Enter EXACT name of the item you would like to use/toggle. Enter \"exit\" to exit inventory: ");
        String item = scan.nextLine();
        if (!item.equals("exit")) {
            if (item.equals(inventory[0].getName())) {
               player.useHPPot(inventory[0]);
            }
            if (item.equals(inventory[1].getName())) {
                player.useStregthPotion(inventory[1]);
            }
            if (item.equals(inventory[2].getName())) {

            }
            if (item.equals(inventory[3].getName())) {

            }
            if (item.equals(inventory[4].getName())) {

            }
            if (item.equals(inventory[5].getName())) {

            }

        }
    }
}
