import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player {
    private Difficultly difficultly;
    private Random random;

    public Difficultly getDifficultly() {
        return difficultly;
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

    public void move(Board board) throws NoMovesException {
        if(board.getTotalStones() == 0) {
            throw new NoMovesException();
        }
        if(difficultly == Difficultly.Easy) {
           randomMove(board, 1);
       }
       else if (difficultly == Difficultly.Medium) {
            if(random.nextBoolean()) {
                randomMove(board, 0);
            }
            else {
                cleverMove(board);
            }
       }
    }
}

enum Difficultly {
    Easy, Medium, Hard;
}
