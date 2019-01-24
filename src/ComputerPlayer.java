import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player {
    private Difficulty difficulty;
    private Random random;

    public ComputerPlayer(String name, Difficulty difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.random = new Random(System.currentTimeMillis());
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    private void randomMove(Board board, int howMany) {
        ArrayList<Integer> nonEmptyPiles = new ArrayList<>();
        for(int i = 0; i < board.getNumberOfPiles(); i++) {
            if(board.getStones(i) != 0) {
                nonEmptyPiles.add(i);
            }
        }
        int pileToGet = nonEmptyPiles.get(
                random.nextInt(nonEmptyPiles.size()));
        try {
            if(howMany == 0) {
                howMany = random.nextInt(board.getStones(pileToGet));
            }
            board.getStonesFromPile(pileToGet, howMany);
        }
        catch (NumberOfStonesException e) {
            e.printStackTrace();
        }
    }

    private void cleverMove(Board board) {
        int totalXor = board.getTotalXor();
        if(totalXor == 0) {
            randomMove(board, 1);
        }
        else {
            for(int i = 0; i < board.getNumberOfPiles(); i++) {
                int stonesHere = board.getStones(i);
                int mayBeGoodMove = (totalXor ^ stonesHere) - stonesHere;
                try {
                    board.getStonesFromPile(i, mayBeGoodMove);
                    return;
                }
                catch (NumberOfStonesException e) {

                }
            }
        }
    }

    @Override
    public void move(Board board) throws NoMovesException {
        if(board.getTotalStones() == 0) {
            throw new NoMovesException();
        }
        if(difficulty == Difficulty.Easy) {
           randomMove(board, 1);
       }
       else if (difficulty == Difficulty.Medium) {
            if(random.nextBoolean()) {
                randomMove(board, 0);
            }
            else {
                cleverMove(board);
            }
       }
       else { //difficulty == Difficulty.Hard
           cleverMove(board);
        }
    }
}

enum Difficulty {
    Easy, Medium, Hard;
}
