public class Sword {
    private int atk;
    private int dodge;
    private int crit;
    public Sword() {
        atk = 10;
        dodge = 25;
        crit = 30;
    }

    public int getAtk() {
        int random = (int) (Math.random() * 100) + 1;
        if (crit >= random) {
            DragonSlayer.addToNews("You got a critical hit and deal twice the normal amount.");
            return (atk + (int) Math.sqrt(random)) * 2;
        }
        return atk + (int) Math.sqrt(random);
    }
    public boolean failedDodge() {
        return (int) (Math.random() * 100) > dodge;
    }

    public void upgrade() {
        int random = (int) (Math.random() * 4) + 1;
        if (random == 1) {
            atk += 10;
            DragonSlayer.addToNews("Your sword's attack has been upgraded to " + atk + ".");
        }
        if (random == 2) {
            dodge += 10;
            DragonSlayer.addToNews("Your dodge rate has increased to " + dodge + "%.");
        }
        if (random == 3) {
            crit += 10;
            DragonSlayer.addToNews("Your critical hit rate has increased to " + crit + "%.");
        }
        if (random == 4) {
            atk += 20;
            dodge += 20;
            crit += 20;
            DragonSlayer.addToNews("Lucky! All sword stats have increased by 20.");
        }
    }

    public void increaseAtk(int amt) {
        atk += amt;
        DragonSlayer.addToNews("Your sword's attack has been upgraded to " + atk + ".");
    }
    public void increaseDodge(int amt) {
        dodge += amt;
        DragonSlayer.addToNews("Your dodge rate has increased to " + dodge + "%.");
    }
    public void increaseCrit(int amt) {
        crit += amt;
        DragonSlayer.addToNews("Your critical hit rate has increased to " + crit + "%.");
    }

    public String swordStats() {
        String str = "--Current stats--";
        str += "\nAttack: " + atk;
        str += "\nDodge rate: " + dodge + "%";
        str += "\nCritical Hit rate: " + crit + "%";
        return str;
    }
}
