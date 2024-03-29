public class Dragon {
    private int health;
    private int level;
    public Dragon(boolean lost) {
        level = (int) (Math.random() * 3) + 1;
        if (lost) {
            level = 3;
        }
        health = 100 + (50 * level);

    }

    public int attack() {
        return (int) (Math.random() * (10 * level)) + level;
    }

    public void takeDMG(int dmg, Player player) {
        health -= dmg;
        if (checkDead()) {
            Sword sword = player.getSword();
            int random = (int) (Math.random() * 4) + 1;
            if (random == 1) {
                sword.upgrade();
            }
            if (random == 2) {
                player.increaseGold((int) (Math.random() * 51) + 5 * level);
            }
            if (random == 3) {
                player.heal((int) Math.pow(level, 3) + 50);
            }
            if (random == 4) {
                DragonSlayer.addToNews("After searching the dragon's remains, you couldn't find anything...");
            }
        }
    }

    public boolean checkDead() {
        if (health <= 0) {
            health = 0;
            return true;
        }
        return false;
    }

    public void dragonStats() {
        System.out.println("--Nearest Dragon's stats--");
        System.out.println("Level: " + level);
        System.out.println("Health: " + health + "\n");
    }
}
