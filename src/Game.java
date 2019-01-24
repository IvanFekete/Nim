public class Game {
    private Board board;
    private Player[] player = new Player[2];
    private int currentPlayer = 0;
    private boolean finished;

    public Game(Player player1, Player player2,  Board board) {
        this.board = board;
        finished = false;
        this.player[0] = player1;
        this.player[1] = player2;
    }

    public Game(Player player1, Player player2, int numberOfPiles) {
        this.board = new Board(numberOfPiles);
        finished = false;
        this.player[0] = player1;
        this.player[1] = player2;
    }

    public void performMove() {
        try {
            player[currentPlayer].move(board);
            currentPlayer++;
            currentPlayer %= 2;
        }
        catch (NoMovesException e) {
            finished = true;
        }
    }

    public final Player getCurrentPlayer() {
        return player[currentPlayer];
    }

    public boolean isFinished() {
        return finished;
    }
}
