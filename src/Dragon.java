public class Dragon {
    private int health;
    private int level;
    public Dragon() {
        level = (int) (Math.random() * 3) + 1;
        health = 100;
    }


}
