public class Dragon {
    private int health;
    private int level;
    private Sword sword;
    private Player player;
    public Dragon(Sword sword, Player player) {
        level = (int) (Math.random() * 3) + 1;
        health = 100;
        this.sword = sword;
        this.player = player;
    }

    public int attack() {
        return (int) (Math.random() * 10 * level) + level;
    }

    public void takeDMG(int dmg) {
        health -= dmg;
        if (checkDead()) {
            int random = (int) (Math.random() * 4) + 1;
            if (random == 1) {
                sword.upgrade();
            }
            if (random == 2) {
                player.setGold((int) (Math.random() * 51) + 5 * level);
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
}
