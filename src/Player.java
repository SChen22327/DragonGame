public class Player {
    private String name;
    private int health;
    private Sword sword;
    private int gold;
    private boolean hpPot;
    public Player(String name) {
        health = 100;
        sword = new Sword();
        this.name = name;
        //gold = idk;
        hpPot = false;
    }

    public int attack() {
        return sword.getAtk();
    }

    public void takeDMG(int dmg) {
        health -= dmg;
    }

    public boolean checkDead() {
        if (health <= 0) {
             health = 0;
             return true;
        }
        return false;
    }

    public void heal(int healAmt) {
        health += healAmt;
    }

    public int useHPPot() {
        if (hpPot) {
            int healAmt = (100 - health) / 2;
            health += healAmt;
            hpPot = false;
            return healAmt;
        }
        return 0;
    }

    public void printPlayerStats() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Gold: " + gold);
        System.out.println("Has HP Pot: " + hpPot);
    }
    public void printSwordStats() {
        System.out.println(sword.swordStats());
    }
}
