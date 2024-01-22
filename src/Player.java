public class Player {
    private String name;
    private int health;
    private Sword sword;
    private int gold;
    private boolean armour;
    private boolean machineGun;
    public Player(String name) {
        health = 100;
        sword = new Sword();
        this.name = name;
        gold = 50;
        armour = false;
        machineGun = false;
    }

    public int getGold() {
        return gold;
    }
    public Sword getSword() {
        return sword;
    }
    public void loseGold(int lost) {
        gold -= lost;
    }
    public int attack() {
        if (machineGun) {
            return 100;
        }
        return sword.getAtk();
    }

    public void takeDMG(int dmg) {
        if (armour) {
            health -= (int) (dmg * 0.85);
            if ((int) (Math.random() * 5) == 0) {
                armour = false;
            }
        } else {
            health -= dmg;
        }
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
        DragonSlayer.addToNews("I got " + increment + " gold!\nCurrent Gold:" + gold + " gold");
}

    public void heal(int healAmt) {
        health += healAmt;
        if (health > 150) {
            health = 150;
        }
        DragonSlayer.addToNews("I healed for " + healAmt + " HP.\nCurrent HP: " + health);
    }

    public void useHPPot(ItemInfo hpPot) {
        if (hpPot.hasItem()) {
            if (health == 150) {
                DragonSlayer.addToNews("I'm at max health. I hastily put my HP Pot away.");
            }
            int healAmt = (150 - health);
            if (healAmt > 75) {
                healAmt = 75;
            }
            heal(healAmt);
            hpPot.decreaseAmountOwned();
        } else {
            DragonSlayer.addToNews("I searched my bag but nothing turns up. I guess I don't have one.");
        }
    }
    public void useStrengthPotion(ItemInfo strength) {
        if (strength.hasItem()) {
            sword.increaseAtk(15);
            strength.decreaseAmountOwned();
        } else {
            DragonSlayer.addToNews("I searched my bag but nothing turns up. I guess I don't have one.");
        }
    }
    public void useFocusPotion(ItemInfo focus) {
        if (focus.hasItem()) {
            sword.increaseDodge(5);
            focus.decreaseAmountOwned();
        } else {
            DragonSlayer.addToNews("I searched my bag but nothing turns up. I guess I don't have one.");
        }
    }
    public void useBook(ItemInfo book) {
        if (book.hasItem()) {
            sword.increaseCrit(5);
            book.decreaseAmountOwned();
        } else {
            DragonSlayer.addToNews("I searched my bag but nothing turns up. I guess I don't have one.");
        }
    }
    public void useArmour(ItemInfo armour) {
        if (armour.hasItem()) {
            this.armour = true;
            armour.decreaseAmountOwned();
        } else {
            DragonSlayer.addToNews("I searched my bag but nothing turns up. I guess I don't have one.");
        }
    }
    public void toggleMachineGun(ItemInfo machineGun) {
        if (machineGun.hasItem()) {
            this.machineGun = !this.machineGun;
        } else {
            DragonSlayer.addToNews("THEY HAVE A MACHINE GUN?! WHAT?! I NEED TO GO TO THE SHOP AND BUY ONE ASAP!!!");
        }
    }

    public void printPlayerStats() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health + "/150");
        System.out.println("Gold: " + gold + "\n");
    }
    public void printSwordStats() {
        System.out.println(sword.swordStats());
        System.out.println("\nMachine gun: " + machineGun + "\n");
    }
}
