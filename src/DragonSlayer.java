import jdk.jshell.execution.Util;

import java.util.Objects;
import java.util.Scanner;
public class DragonSlayer {
    private ItemInfo[] inventory;
    private Scanner scan;
    private Room currentRoom;
    private Dragon currentDragon;
    private Player player;
    private Shop shop;
    private boolean startedFight;
    private static String newsMessage;
    public DragonSlayer() {
        createItemList();
        scan = new Scanner(System.in);
        shop = new Shop(inventory, scan);
        startedFight = false;
        newsMessage = "";
        System.out.print("What is your name, adventurer? ");
        String name = scan.nextLine();
        player = new Player(name);
    }

    public void play() {
        newsMessage += "\nAfter a long day's journey, I have finally arrived at the dragons' lair, ready to make a name for myself.";
        boolean gameOver = false;
        currentRoom = Room.enter();
        currentDragon = currentRoom.nextDragon();
        while (!gameOver) {
            Utility.clearScreen();
            System.out.println(newsMessage + "\n");
            newsMessage = "";
            player.printPlayerStats();
            player.printSwordStats();
            System.out.println("Dragons remaining in the room: " + currentRoom.getRemaining());
            currentDragon.dragonStats();
            gameOver = menu();
            if (startedFight) {
                if (currentDragon.checkDead()) {
                    if (currentRoom.dragonsDead()) {
                        addToNews("All dragons have been slain.");
                        if (Room.getRoom() == 6) {
                            gameOver = true;
                        } else {
                            addToNews("Move onto the next room whenever you're ready.");
                        }
                    } else {
                        currentDragon = currentRoom.nextDragon();;
                    }
                } else {
                    int dmg = currentDragon.attack();
                    player.takeDMG(dmg);
                    addToNews("Ouch, the dragon hits me with " + dmg + " damage!");
                    if (player.isDead()) {
                        gameOver = true;
                    }
                }
                System.out.println();
                startedFight = false;
            }
        }
        if (Room.getRoom() == 6 && !player.isDead()) {
            System.out.println("Hooray, I cleared all the rooms and killed all the dragons!");
            Utility.sleep(1500);
            System.out.println("W-wait, why am I getting arrested?");
            Utility.sleep(1000);
            System.out.println("Killing all those dragons is considered mass murder?");
            Utility.sleep(500);
            System.out.println("I'm innocent, I swear!\n");
            System.out.println("\uD83D\uDC51\uD83D\uDE93" + Utility.RED + "You win?" + Utility.RESET + "\uD83D\uDE93\uD83D\uDC51");
        } else {
            System.out.println("Noooo...I don't want to die...before...I search every...room...*passes away cutely*");
            System.out.println("Game Over: You died and now you're dead");
        }
    }

    public boolean menu() {
        System.out.println("(1) Search room");
        System.out.println("(2) Go to the town's shop");
        System.out.println("(3) Check inventory");
        System.out.println("(4) Fight");
        System.out.println("(5) Enter next room(all dragons in the current room must be defeated)");
        System.out.println("(6) Give up");
        System.out.print("Enter the number of what you want to do: ");
        int choice = scan.nextInt();
        scan.nextLine();
        System.out.println();
        if (choice == 1) {
            currentRoom.search(inventory[0]);
            return false;
        } else if (choice == 2) {
            shop.menu(player);
            return false;
        } else if (choice == 3) {
            inventory();
            return false;
        } else if (choice == 4) {
            startedFight = true;
            int dmg = player.attack();
            addToNews("You deal " + dmg + " damage to the dragon.");
            currentDragon.takeDMG(dmg, player);
            return false;
        } else if (choice == 5) {
            if (currentRoom.dragonsDead() && Room.getRoom() != 6) {
                currentRoom = Room.enter();
            } else {
                addToNews("Not all the dragons in this room have been killed.");
            }
            return false;
        } else {
            System.out.println("The dragon takes a final slash at you, fatally wounding you.\nOh no, you're bleeding out.");
            return true;
        }
    }

    private void createItemList() {
        inventory = new ItemInfo[6];
        inventory[0] = new ItemInfo("HP Pot", 20, "Heals for 75 points at most. Maximum 5 can be held at a time. Can be found through searching\na room or purchasing from the shop.");
        inventory[1] = new ItemInfo("Strength Potion", 30, "Permanently increases attack by 15 points. Can be found through searching a room or\npurchasing from the shop.");
        inventory[2] = new ItemInfo("Focus Potion", 30, "Permanently increases dodge by 5 points. Bought from the shop.");
        inventory[3] = new ItemInfo("\"Critical Hitting for Dummies\" Book", 50, "Permanently increases crit by 5 points. Bought from the shop.");
        inventory[4] = new ItemInfo("Armour", 50, "Decrease damage by 15%. 20% chance to be destroyed for every attack against you. Bought from\nthe shop.");
        inventory[5] = new ItemInfo("Machine Gun", 300, "You can equip and unequip. Increases your damage output to 100 when equipped, cannot\nget a critical hit. Bought from the shop.");
    }

    private void inventory() {
        System.out.println("--You currently have--");
        for (ItemInfo item : inventory) {
            if (item.hasItem()) {
                System.out.println(item.getInfo());
            }
        }
        System.out.println("\nEnter the first letter of the item you would like to use/toggle(i.e. H/h for HP Pot).\nEnter \"exit\" to exit inventory: ");
        String item = scan.nextLine().toLowerCase();
        if (!item.equals("exit")) {
            if (item.equals(inventory[0].getName().substring(0,1).toLowerCase())) {
               player.useHPPot(inventory[0]);
            } else if (item.equals(inventory[1].getName().substring(0,1).toLowerCase())) {
                player.useStrengthPotion(inventory[1]);
            } else if (item.equals(inventory[2].getName().substring(0,1).toLowerCase())) {
                player.useFocusPotion(inventory[2]);
            } else if (item.equals(inventory[3].getName().substring(0,1).toLowerCase())) {
                player.useBook(inventory[3]);
            } else if (item.equals(inventory[4].getName().substring(0,1).toLowerCase())) {
                player.useArmour(inventory[4]);
            } else if (item.equals(inventory[5].getName().substring(0,1).toLowerCase())) {
                player.toggleMachineGun(inventory[5]);
            } else {
                addToNews("Seems like I don't have that item. Hopefully a magical fairy blesses me with something...");
            }
        }
    }

    public static void addToNews(String addition) {
        newsMessage += "\n" + addition;
    }
}
