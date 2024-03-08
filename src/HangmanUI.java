import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanUI extends JPanel implements ActionListener {

    private int WIDTH;
    private int HEIGHT;
    private boolean gameOver;

    public HangmanUI(int WIDTH, int HEIGHT, JPanel container, CardLayout cardLayout) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);
        add(createBottomPanel(), BorderLayout.SOUTH);

        this.gameOver = false;
    }

    // Panel for the level, navigation controls, pause/play
    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 10));

        ImageIcon backIcon = new ImageIcon("../images/angle-left.png");
        JButton back = new JButton(backIcon);
        back.addActionListener(e -> {
            // This button would take you back to the main menu I am assuming
            // We need to decide how we plan on rendering each of the different screens
            // In the past, I have used a layered pane to swap between them
        });
        topPanel.add(back);

        JLabel level = new JLabel("Level 1");
        level.setFont(new Font("Sans-serif", Font.BOLD, 14));
        topPanel.add(level);

        ImageIcon pauseIcon = new ImageIcon("../images/pause.png");
        JButton pause = new JButton(pauseIcon);
        pause.addActionListener(e -> {
            // Not sure what the pause button is for but the logic for that goes in here
        });
        topPanel.add(pause);

        return topPanel;
    }

    // Panel for the stick figure and word
    // Panel for the alphabet
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new BorderLayout());

        ImageIcon stickFigureIcon = new ImageIcon("../images/example.png");
        JLabel exampleStickFigure = new JLabel(stickFigureIcon);
        centerPanel.add(exampleStickFigure, BorderLayout.NORTH);

        /*
         * Once we integrate all of the current branches to main, using the random word
         * getter
         * class to generate our word whenever you press the play button and then we get
         * the correct
         * number of blanks back to populate this JLabel
         */

        JPanel wordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel wordBlanks = new JLabel("_ _ _ _ _ _");
        wordBlanks.setFont(new Font("Sans-serif", Font.BOLD, 60));
        wordPanel.add(wordBlanks);

        centerPanel.add(wordPanel, BorderLayout.CENTER);

        JPanel alphabetPanel = new JPanel(new GridLayout(2, 1));
        alphabetPanel.add(createAlphabetRow("a b c d e f g h i j k l m"));
        alphabetPanel.add(createAlphabetRow("n o p q r s t u v w x y z"));
        centerPanel.add(alphabetPanel, BorderLayout.SOUTH);

        return centerPanel;
    }

    private JPanel createAlphabetRow(String alphabet) {
        JPanel alphabetRowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel alphabetRow = new JLabel(alphabet);
        alphabetRow.setFont(new Font("Sans-serif", Font.BOLD, 30));
        alphabetRowPanel.add(alphabetRow);
        return alphabetRowPanel;
    }

    // Panel for letter input
    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel guessLabel = new JLabel("Guess a letter!");
        guessLabel.setFont(new Font("Sans-serif", Font.BOLD, 40));
        bottomPanel.add(guessLabel);

        JTextField guessField = new JTextField(1);
        guessField.setFont(new Font("Sans-serif", Font.BOLD, 40));
        guessField.addActionListener(e -> {
            // In here is where we will pass the input over to the validation
            // InputValidation.validLetter(guessField.getText().charAt(0));

            // After the input get validated we will then check if the letter is in the word
            // InputValidation.wordContains(guessField.getText().charAt(0));

            // Then we have to render either a new hangman limb or the letter on the correct
            // lines
        });
        bottomPanel.add(guessField);

        return bottomPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implementation if needed
    }
}
