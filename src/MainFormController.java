import javax.swing.*;

public class MainFormController {
    private Game currentGame;
    private HumanMovesHandler handler1, handler2;

    public MainFormController() {
        currentGame = null;
        handler1 = null;
        handler2 = null;
    }

    private void draw()

    public void newGame(JComboBox comboBox1, JComboBox comboBox2, JComboBox difficultyComboBox) {
        String player1Type = comboBox1.getSelectedItem().toString();
        String player2Type = comboBox2.getSelectedItem().toString();
        Player player1, player2;
        if(player1Type.equals("Player")) {
            handler1 = new HumanMovesHandler();
            player1 = new HumanPlayer("Player 1", handler1);
        }
        else {
            player1 = new ComputerPlayer("Player 1", (Difficulty) difficultyComboBox.getSelectedItem());
        }
        if(player2Type.equals("Player")) {
            handler2 = new HumanMovesHandler();
            player2 = new HumanPlayer("Player 2", handler2);
        }
        else {
            player2 = new ComputerPlayer("Player 2", (Difficulty) difficultyComboBox.getSelectedItem());
        }
        currentGame = new Game(player1, player2, 5);
    }


}
