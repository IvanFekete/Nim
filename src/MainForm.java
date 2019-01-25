import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JPanel panel;
    private JButton newGameButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox difficultyComboBox;
    private MainFormController controller;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainForm() {
        controller = new MainFormController();
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.newGame(comboBox1, comboBox2, difficultyComboBox);
            }
        });
    }

    private void createUIComponents() {
        String[] variants = {"Player", "Computer"};
        Difficulty[] levels = {Difficulty.Easy, Difficulty.Medium, Difficulty.Hard};
        comboBox1 = new JComboBox(variants);
        comboBox2 = new JComboBox(variants);
        difficultyComboBox = new JComboBox(levels);


    }
}
