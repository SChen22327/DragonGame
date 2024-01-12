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
    public String getName() {
        return name;
    }
    public int getAmountOwned() {
        return amountOwned;
    }
    public void incrementAmountOwned(boolean enoughMoney) {
        amountOwned++;
    }
    public String getInfo() {
        String str = name;
        str += "\n -" + cost + " gold";
        str += "\n -" + description;
        return str;
    }
}
