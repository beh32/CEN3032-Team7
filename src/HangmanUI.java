import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanUI {
    public static void main(String[] args) {
        //Frame that holds everything
        JFrame frame = new JFrame("Hangman GUI");

        //Panel for the level, navigation controls, pause/play
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 10));
            ImageIcon backIcon = new ImageIcon("./images/angle-left.png");
            JButton back = new JButton(backIcon);
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // This button would take you back to the main menu I am assuming
                    // We need to decide how we plan on rendering each of the different screens
                    // In the past, I have used a layered pane to swap between them
                }
            }); 
            topPanel.add(back);

            JLabel level = new JLabel("Level 1");
            level.setFont(new Font("Sans-serif", Font.BOLD, 14));
            topPanel.add(level);

            ImageIcon pauseIcon = new ImageIcon("./images/pause.png");
            JButton pause = new JButton(pauseIcon); 
            pause.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Not sure what the pause button is for but the logic for that goes in here
                }
            });
            topPanel.add(pause);

        //Panel for the stick figure and word
        JPanel centerPanel = new JPanel();
            ImageIcon stickFigureIcon = new ImageIcon("./images/example.png");
            JLabel exampleStickFigure = new JLabel(stickFigureIcon);
            centerPanel.add(exampleStickFigure);
            /* Once we integrate all of the current branches to main, using the random word getter
            class to generate our word whenever you press the play button and then we get the correct
            number of blanks back to populate this JLabel */
            JLabel wordBlanks = new JLabel("_ _ _ _ _ _");
            wordBlanks.setFont(new Font("Sans-serif", Font.BOLD, 60));
            centerPanel.add(wordBlanks);

        //Panel for the alphabet 
        JPanel alphabetPanel = new JPanel(new BorderLayout(20, 0));
            JLabel alphabetRow1 = new JLabel("a b c d e f g h i j k l m");
            alphabetRow1.setFont(new Font("Sans-serif", Font.BOLD, 30));
            alphabetPanel.add(alphabetRow1, BorderLayout.NORTH);
            JLabel alphabetRow2 = new JLabel("n o p q r s t u v w x y z");
            alphabetRow2.setFont(new Font("Sans-serif", Font.BOLD, 30));
            alphabetPanel.add(alphabetRow2, BorderLayout.SOUTH);

        //Put alphabetPanel inside centerPanel
        centerPanel.add(alphabetPanel);

        //Panel for letter input
        JPanel bottomPanel = new JPanel();
            JLabel guessLabel= new JLabel("Guess a letter!");
            guessLabel.setFont(new Font("Sans-serif", Font.BOLD, 40));
            bottomPanel.add(guessLabel);
            JTextField guessField = new JTextField(1);
            guessField.setFont(new Font("Sans-serif", Font.BOLD, 40));
            guessField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // In here is where we will pass the input over to the validation
                    // InputValidation.validLetter(guessField.getText().charAt(0));

                    // After the input get validated we will then check if the letter is in the word
                    // InputValidation.wordContains(guessField.getText().charAt(0));

                    // Then we have to render either a new hangman limb or the letter on the correct lines
                }
            });
            bottomPanel.add(guessField);

        //Set layout manager for the frame
        frame.setLayout(new BorderLayout());

        // Add the panels to the frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Set frame properties
        frame.setSize(500, 700); // Set size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Make the frame visible
    }
}