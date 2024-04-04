import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HangmanUI {

    private HangmanModel hm;
    private HangmanLevels hl;
    private JFrame frame;
    private JButton b2;
    private JLabel wordBlanks;
    private JLabel textLabel;
    private int currentLevel;
    private JPanel centerPanel;

    public HangmanUI(int currentLevel, HangmanLevels hl) {
        hm = new HangmanModel();
        this.hl = hl;
        hm.hangmanRound();
        this.currentLevel = currentLevel;

    }

    public void initalizeUI() {
        //Frame that holds everything
        frame = new JFrame("Hangman GUI");

        //Set layout manager for the frame
        frame.setLayout(new BorderLayout());

        // Add the panels to the frame
        frame.add(createTopPanel(), BorderLayout.NORTH);
        frame.add(createCenterPanel(), BorderLayout.CENTER);
        frame.add(createBottomPanel(), BorderLayout.SOUTH);

        // Set frame properties
        frame.setSize(500, 700); // Set size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Make the frame visible
    }

    private JPanel createTopPanel() {
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

            JLabel level = new JLabel("Level " + Integer.toString(currentLevel));
            level.setFont(new Font("Sans-serif", Font.BOLD, 14));
            topPanel.add(level);

            ImageIcon pauseIcon = new ImageIcon("./images/pause.png");
            JButton pause = new JButton(pauseIcon); 
            pause.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Not sure what the pause button is for but the logic for that goes in here
                    new PauseMenu();
                }
            });
            topPanel.add(pause);

            return topPanel;
    }

    private JPanel createCenterPanel() {
        //Panel for the stick figure and word
        centerPanel = new JPanel();
            centerPanel.add(createStickFigure(0));
            centerPanel.add(createWordDisplay());
            centerPanel.add(createAlphabetPanel());

            textLabel = new JLabel("");
            textLabel.setFont(new Font("Sans-serif", Font.BOLD, 30));
            centerPanel.add(textLabel);

            return centerPanel;

    }

    private void updateCenterPanel() {
        centerPanel.removeAll();
        centerPanel.add(createStickFigure(hm.getHangmanPartsDrawn()));
        centerPanel.add(createWordDisplay());
        centerPanel.add(createAlphabetPanel());
        centerPanel.add(textLabel);
        
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private JLabel createStickFigure(int parts) {
        ImageIcon stickFigureIcon = new ImageIcon();
        if (parts == 1) {
            stickFigureIcon = new ImageIcon("./images/1.png");
        } else if (parts == 2) {
            stickFigureIcon = new ImageIcon("./images/2.png");
        } else if (parts == 3) {
            stickFigureIcon = new ImageIcon("./images/3.png");
        } else if (parts == 4) {
            stickFigureIcon = new ImageIcon("./images/4.png");
        } else if (parts == 5) {
            stickFigureIcon = new ImageIcon("./images/5.png");
        } else if (parts == 6) {
            stickFigureIcon = new ImageIcon("./images/6.png");
        } else {
            stickFigureIcon = new ImageIcon("./images/empty.png");
        }
        
        JLabel exampleStickFigure = new JLabel(stickFigureIcon);
        
        return exampleStickFigure;
    }

    private JLabel createWordDisplay() {
        wordBlanks = new JLabel(hm.getWordDisplayString().replace("", " "));
        wordBlanks.setFont(new Font("Sans-serif", Font.BOLD, 60));
        return wordBlanks;
    }

    private JPanel createAlphabetPanel() {
        JPanel alphabetPanel = new JPanel(new BorderLayout(20, 0));
        JLabel alphabetRow1 = new JLabel("a b c d e f g h i j k l m");
        alphabetRow1.setFont(new Font("Sans-serif", Font.BOLD, 30));
        alphabetPanel.add(alphabetRow1, BorderLayout.NORTH);
        JLabel alphabetRow2 = new JLabel("n o p q r s t u v w x y z");
        alphabetRow2.setFont(new Font("Sans-serif", Font.BOLD, 30));
        alphabetPanel.add(alphabetRow2, BorderLayout.SOUTH);
        
        return alphabetPanel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new CardLayout());
        CardLayout cardLayout = (CardLayout) bottomPanel.getLayout();
        JPanel card1 = new JPanel();

            JLabel guessLabel= new JLabel("Guess a letter!");
            guessLabel.setFont(new Font("Sans-serif", Font.BOLD, 40));
            card1.add(guessLabel);
            JTextField guessField = new JTextField(1);
            guessField.setFont(new Font("Sans-serif", Font.BOLD, 40));
            guessField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    hm.validateUserInput(guessField.getText().charAt(0));
                    guessField.setText("");
                    wordBlanks.setText(hm.getWordDisplayString().replace("", " "));
                    textLabel.setText(hm.getPrompt());
                    updateCenterPanel();

                    if (hm.getHangmanPartsDrawn() == 6) {
                        b2.setText("Restart");
                        cardLayout.next(bottomPanel);
                        hm.endRound();
                        textLabel.setForeground(Color.RED);
                        textLabel.setText(hm.getPrompt());
                    }

                    if (hm.isWordGuessed()) {
                        cardLayout.next(bottomPanel);
                        hm.endRound();
                        textLabel.setForeground(Color.GREEN);
                        textLabel.setText(hm.getPrompt());
                    }        
            
                }

                });
                
            
            card1.add(guessField);
            bottomPanel.add(card1);

            JPanel card2 = new JPanel();
            JButton b1 = new JButton("Return to Menu");
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    frame.setVisible(false);
                    OpeningMenu hangmanMenu = new OpeningMenu();
                    hangmanMenu.createOpeningMenu();
                }
            }); 
            card2.add(b1);

            b2 = new JButton("Continue");
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                    frame.setVisible(false);
                    hl.increaseLevel();

                    if (!hm.isWordGuessed()) 
                        hl = new HangmanLevels();
                    hl.startHangman();
                }
            }); 
            card2.add(b2);

            bottomPanel.add(card2);
            

            return bottomPanel;
    }
}
