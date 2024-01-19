public class Sword {
    private int atk;
    private int dodge;
    private int crit;
    public Sword() {
        atk = 10;
        dodge = 20;
        crit = 30;
    }

    public int getAtk() {
        int random = (int) (Math.random() * 100) + 1;
        if (crit >= random) {
            return atk * 2;
        }
        return atk + random / atk;
    }

    public void upgrade() {
        int random = (int) (Math.random() * 4) + 1;
        if (random == 1) {
            atk += 5;
            System.out.println("Your sword's attack has been upgraded to " + atk + ".");
        }
        if (random == 2) {
            dodge += 5;
            System.out.println("Your dodge rate has increased to " + dodge + "%.");
        }
        if (random == 3) {
            crit += 5;
            System.out.println("Your critical hit rate has increased to " + crit + "%.");
        }
        if (random == 4) {
            atk += 10;
            dodge += 10;
            crit += 10;
            System.out.println("Lucky! All sword stats have increased by 10.\n" + swordStats());
        }
    }

    public void increaseAtk(int amt) {
        atk += amt;
        System.out.println("Your sword's attack has been upgraded to " + atk + ".");
    }
    public void increaseDodge(int amt) {
        dodge += amt;
        System.out.println("Your dodge rate has increased to " + dodge + "%.");
    }
    public void increaseCrit(int amt) {
        crit += amt;
        System.out.println("Your critical hit rate has increased to " + crit + "%.");
    }

    public String swordStats() {
        String str = "--Current stats--";
        str += "\nAttack: " + atk;
        str += "\nDodge rate: " + dodge + "%";
        str += "\nCritical Hit rate: " + crit + "%\n";
        return str;
    }
}
