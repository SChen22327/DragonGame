public class ItemInfo {
    private boolean hasItem;
    private String name;
    private int cost;
    private String description;
    private int amountOwned;
    public ItemInfo(String name, int cost, String info) {
        hasItem = false;
        this.name = name;
        this.cost = cost;
        description = info;
        amountOwned = 0;
    }

    public boolean hasItem() {
        return hasItem;
    }
    public boolean hasEnough(int gold) {
        return gold >= cost;
    }
    public String getName() {
        return name;
    }
    public int getAmountOwned() {
        return amountOwned;
    }
    public void incrementAmountOwned() {
        amountOwned++;
        if (amountOwned > 5) {
            amountOwned = 5;
        }
        hasItem = true;
    }
    public void incrementAmountOwned(Player player) {
        player.loseGold(cost);
        amountOwned++;
        hasItem = true;
    }
    public void decreaseAmountOwned() {
        amountOwned--;
        if (amountOwned == 0) {
            hasItem = false;
        }
    }
    public String getInfo() {
        String str = name;
        str += "\n -" + cost + " gold";
        str += "\n -" + description + "\n";
        return str;
    }
}
