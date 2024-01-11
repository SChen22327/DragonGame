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
        gold = 50;
        hpPot = false;
    }

    public int attack() {
        return sword.getAtk();
    }

    public void takeDMG(int dmg) {
        health -= dmg;
    }

    public boolean isDead() {
        if (health <= 0) {
             health = 0;
             return true;
        }
        return false;
    }
    
    public void increaseGold(int increment) {
        gold += increment;
        System.out.println("You got " + increment + " gold. You now have " + gold + " gold.");
}

    public void heal(int healAmt) {
        health += healAmt;
        if (health > 150) {
            health = 150;
        }
        System.out.println("You were healed for " + healAmt + " HP. Your current HP: " + health + ".");
    }

    public int useHPPot() {
        if (hpPot) {
            int healAmt = (150 - health) / 2;
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
