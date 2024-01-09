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
        int random = (int) (Math.random() * 10) + 1;
        if (crit >= random) {
            return atk * 2;
        }
        return atk;
    }

    public int upgrade() {
        int random = (int) (Math.random() * 3) + 1;
        if (random == 1) {
            atk += 5;
        }
        if (random == 2) {
            dodge += 5;
        }
        if (random == 3) {
            crit += 5;
        }
        return random;
    }

    public String swordStats() {
        String str = "Attack: " + atk;
        str += "\nDodge rate: " + dodge + "%";
        str += "\nCritical Hit rate: " + crit + "%";
        return str;
    }
}
