import javax.swing.*;

public class HumanPlayer extends Player {
    HumanMovesHandler handler;
    public HumanPlayer(String name, HumanMovesHandler handler) {
        this.name = name;
        this.handler = handler;
    }

    @Override
    public void move(Board board) throws NoMovesException {
        if(board.getTotalStones() == 0) {
            throw new NoMovesException();
        }

        Move move = handler.getMoveToDo();
        if(move != null) {
            try {
                board.getStonesFromPile(move.getId(), move.getStones());
            }
            catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null,
                        "There is no pile with this index.");
            }
            catch (NumberOfStonesException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            handler.setMoveToDo(null);
        }
    }

}
