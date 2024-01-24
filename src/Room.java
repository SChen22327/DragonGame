public class Room {
    public static String[] names = new String[]{"The Entrance", "The Nursery", "The Den", "The Nest", "Lost Corridor", "The Center"};
    private static int room = -1;
    private static int highscore = 0;
    private static int score = 0;
    private Dragon[] dragons;
    private int currentFight;
    private int remaining;
    private String roomName;
    private boolean searched;

    public Room() {
        room++;
        int rmNum = room;
        roomName = names[rmNum];
        boolean lost = rmNum == 5 && (int) (Math.random() * 10) == 0; //just to keep it interesting
        if (rmNum == 5 || rmNum == 6) { //Difficult is greatly increased for the final two rooms
            rmNum = 8;
        }
        int diffIncrease = (int) (Math.random() * 3);
        rmNum /= 2;
        dragons = new Dragon[rmNum + 1 + diffIncrease];
        for (int i = 0; i < dragons.length; i++) {
            dragons[i] = new Dragon(lost);
        }
        currentFight = -1;
        remaining = dragons.length + 1;
        searched = false;
    }

    public static Room enter() {
        Room room = new Room();
        DragonSlayer.addToNews("You have entered Room " + getRoom() + ", " + room.getRoomName());
        return room;
    }

    public static int getHighscore() {
        return highscore;
    }
    public static void increaseScore() {
        score++;
    }
    public static int getScore() {
        return score;
    }
    public static void resetScore() {
        score = 0;
    }
    public static void resetRoom() {
        room = -1;
    }

    public Dragon nextDragon() {
        if (score > highscore) {
            highscore = score;
        }
        currentFight++;
        remaining--;
        return dragons[currentFight];
    }
    public boolean dragonsDead() {
        boolean allDead = true;
        for (Dragon dragon : dragons) {
            if (!dragon.checkDead()) {
                allDead = false;
            }
        }
        if (allDead) {
            remaining = 0;
        }
        return allDead;
    }
    public int getRemaining() {
        return remaining;
    }
    public static int getRoom() {
        return room + 1;
    }
    public String getRoomName() {
        return roomName;
    }
    public void search(ItemInfo hpPot) {
        if (!searched) {
            searched = true;
            int random = (int) (Math.random() * 5);
            if (random < 2) {
                hpPot.incrementAmountOwned();
                DragonSlayer.addToNews("Cool, I found an HP Pot tucked behind a random cobweb. Now I have " + hpPot.getAmountOwned() + ".");
            } else {
                DragonSlayer.addToNews("After spending a few minutes searching the room, I found nothing.");
            }
        } else {
            DragonSlayer.addToNews("I already searched the room, I am NOT spending another hour looking at dust.");
        }
    }
}
