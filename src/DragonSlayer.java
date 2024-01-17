import java.util.Scanner;
public class DragonSlayer {
    private ItemInfo[] items;
    private Scanner scan;
    private Room currentRoom;
    public DragonSlayer() {
        createItemList();
        scan = new Scanner(System.in);
    }

    public void play() {
        System.out.println("After a long day's journey, I have finally arrived at the dragons' lair.");
        Utility.sleep(1500);
        currentRoom = Room.enter();
        System.out.println("You have entered Room " + Room.getRoom());
    }

    private void createItemList() {
        items = new ItemInfo[6];
        items[0] = new ItemInfo("HP Pot", 20, "Heals for 75 points at most. Maximum 5 can be held at a time. Can be found through searching\na room or purchasing from the shop.");
        items[1] = new ItemInfo("Strength Potion", 30, "Temporarily increases attack by 15 points. Buff ends after attacking. Can be found \nthrough searching a room or purchasing from the shop.");
        items[2] = new ItemInfo("Focus Potion", 30, "Permanently increases dodge by 5 points. Bought from the shop.");
        items[3] = new ItemInfo("\"Critical Hitting for Dummies\" Book", 50, "Permanently increases crit by 5 points. Bought from the shop.");
        items[4] = new ItemInfo("Armour", 50, "Decrease damage by 15%. 20% chance to be destroyed for every attack against you. Bought from\nthe shop.");
        items[5] = new ItemInfo("Machine Gun", 300, "You can equip and unequip. Increases your damage output to 100 when equipped, cannot\nget a critical hit. Bought from the shop.");
    }
}
