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

    public int getGold() {
        return gold;
    }
    public void loseGold(int lost) {
        gold -= lost;
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
        System.out.println("I got " + increment + " gold!\nCurrent Gold:" + gold + " gold");
}

    public void heal(int healAmt) {
        health += healAmt;
        if (health > 150) {
            health = 150;
        }
        System.out.println("I healed for " + healAmt + " HP.\nCurrent HP: " + health);
    }

    public void useHPPot(ItemInfo hpPot) {
        if (hpPot.hasItem()) {
            if (health == 150) {
                System.out.println("I'm at max health. I hastily put my HP Pot away.");
            }
            int healAmt = (150 - health);
            if (healAmt > 75) {
                healAmt = 75;
            }
            heal(healAmt);
            hpPot.decreaseAmountOwned();
        }
        System.out.println("I searched my bag but nothing turns up. I guess I don't have one.");
    }
    public void useStrengthPotion(ItemInfo strength) {
        sword.
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
