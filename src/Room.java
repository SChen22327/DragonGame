public class Room {
    public static String[] names = new String[]{"The Entrance", "The Nursery", "The Den", "The Nest", "L̸̬̬͋͗̄̋̃o̶͎̦̎̅͋͘ş̸̗̬͇͎̖̞̀̈́͘ț̷̍ Corridor", "The Center"};
    private static int room = 0;
    private Dragon[] dragons;
    private int currentFight;
    private int remaining;
    private String roomName;
    private boolean searched;

    public Room() {
        room++;
        int rmNum = room;
        roomName = names[rmNum];
        boolean lost = rmNum == 5 && (int) (Math.random() * 10) == 0;
        //Lost adds a somewhat creepy aspect to the 5th room in addition to the name, makes all dragons level 3
        if (rmNum == 5 || rmNum == 6) { //Difficult is greatly increased for the final two rooms
            rmNum = 8;
        }
        rmNum /= 2;
        dragons = new Dragon[rmNum + 1];
        for (int i = 0; i < rmNum + 1; i++) {
            dragons[i] = new Dragon(lost);
        }
        remaining = dragons.length;
        currentFight = 0;
        searched = false;
    }

    public static Room enter() {
        Room room = new Room();
        System.out.println("You have entered Room " + getRoom() + ", " + room.getRoomName());
        return new Room();
    }
    public boolean dragonsDead() {
        boolean allDead = true;
        for (Dragon dragon : dragons) {
            if (!dragon.checkDead()) {
                allDead = false;
            }
        }
        return allDead;
    }

    public static int getRoom() {
        return room;
    }
    public String getRoomName() {
        return roomName;
    }
    public void search(ItemInfo hpPot) {
        if (!searched) {
            searched = true;
            int random = (int) (Math.random() * 5);
            if (random == 0) {
                hpPot.incrementAmountOwned();
                System.out.println("Cool, I found an HP Pot tucked behind a random cobweb. Now I have " + hpPot.getAmountOwned() + ".");
            } else {
                System.out.println("After spending a few minutes searching the room, I found nothing.");
            }
        } else {
            System.out.println("I already searched the room, I am NOT spending another hour looking at dust.");
        }
    }
}
