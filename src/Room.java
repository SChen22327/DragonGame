public class Room {
    private Dragon[] dragons;

    public Room(int rmNum) {
        dragons = new Dragon[rmNum];
        for (int i = 0; i < rmNum; i++) {
            dragons[i] = new Dragon();
        }
    }


}
