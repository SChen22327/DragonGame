public class Room {
    public static String[] names = new String[]{"The Entrance", "The Nursery", "The Den", "The Nest", "L̸̬̬͋͗̄̋̃o̶͎̦̎̅͋͘ş̸̗̬͇͎̖̞̀̈́͘ț̷̍ Corridor", "The Center"};
    private static int room = 0;
    private Dragon[] dragons;
    private int remaining;
    private Dragon currentFight;
    private String roomName;

    public Room() {
        room++;
        int rmNum = room;
        roomName = names[rmNum];
        boolean lost = rmNum == 5 && (int) (Math.random() * 10) == 0;
        //Lost adds a somewhat creepy aspect to the 5th room in addition to the name, makes all dragons level 3
        if (rmNum == 5 || rmNum == 6) { //Difficult is greatly increased for the final two rooms
            rmNum = 10;
        }
        rmNum /= 2;
        dragons = new Dragon[rmNum + 1];
        for (int i = 0; i < rmNum + 1; i++) {
            dragons[i] = new Dragon(lost);
        }
        remaining = dragons.length;
        currentFight = dragons[0];
    }

    public static Room enter() { //IDK WHAT TO DO HERE
        return new Room();
    }

    public static int getRoom() {
        return room;
    }
    public void search(ItemInfo hpPot) {
        int random = (int) (Math.random() * 5);
        if (random == 0) {
            hpPot.incrementAmountOwned();
            System.out.println("Cool, I found an HP Pot tucked behind a random cobweb. Now I have " + hpPot.getAmountOwned() + ".");
        } else {
            System.out.println("After spending a few minutes searching the room, I found nothing.");
        }
    }
}
