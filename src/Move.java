public class Move {
    int id, stones;

    public int getStones() {
        return stones;
    }

    public int getId() {
        return id;
    }

    public Move(int id, int stones) {
        this.id = id;
        this.stones = stones;
    }
}
