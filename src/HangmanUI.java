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
import javax.swing.JOptionPane;
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
    private String row1 = "a b c d e f g h i j k l m ";
    private String row2 = "n o p q r s t u v w x y z ";
    private String hangmanDifficulty;
    private CardLayout cardLayout;
    private JPanel bottomPanel;
    private boolean soundToggle;
    private int volume;

    public HangmanUI(int currentLevel, HangmanLevels hl, String hangmanDifficulty, boolean soundToggle, int volume) {
        hm = new HangmanModel();
        this.hl = hl;
        this.hangmanDifficulty = hangmanDifficulty;
        this.currentLevel = currentLevel;
        hm.hangmanRound(hangmanDifficulty);

        this.soundToggle = soundToggle;
        this.volume = volume;
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
                    frame.setVisible(false);
                    OpeningMenu hangmanMenu = new OpeningMenu();
                    hangmanMenu.createOpeningMenu(); //FIX INSTANCE PROBLEM
                }
            }); 

            topPanel.add(back);
            
            JButton hint = new JButton("hint");
            hint.setFont(new Font("Arial", Font.BOLD, 15));
            hint.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		hm.giveHint();
            		textLabel.setText(hm.getPrompt());
            	}
            });
            
            topPanel.add(hint);
            
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

    private void updateCenterPanel(char guess) {
        centerPanel.removeAll();
        centerPanel.add(createStickFigure(hm.getHangmanPartsDrawn()));
        centerPanel.add(createWordDisplay());
        updateAlphabet(guess);
        centerPanel.add(createAlphabetPanel());
        centerPanel.add(textLabel);
        
        centerPanel.revalidate();
        centerPanel.repaint();

        if (hm.getHangmanPartsDrawn() == 6) {
            displayGameOverAlert(hl.getCurrentScore());
        }
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
        JLabel alphabetRow1 = new JLabel(row1);
        alphabetRow1.setFont(new Font("Sans-serif", Font.BOLD, 30));
        alphabetPanel.add(alphabetRow1, BorderLayout.NORTH);
        JLabel alphabetRow2 = new JLabel(row2);
        alphabetRow2.setFont(new Font("Sans-serif", Font.BOLD, 30));
        alphabetPanel.add(alphabetRow2, BorderLayout.SOUTH);
        
        return alphabetPanel;
    }

    private void updateAlphabet(char guess) {
        if (guess <= 'm') {
            row1 = row1.replace(guess + " ", "   ");
        } else {
            row2 = row2.replace(guess + " ", "   ");
        }
    }

    private JPanel createBottomPanel() {
        bottomPanel = new JPanel(new CardLayout());
        cardLayout = (CardLayout) bottomPanel.getLayout();
        JPanel card1 = new JPanel();

            JLabel guessLabel= new JLabel("Guess a letter!");
            guessLabel.setFont(new Font("Sans-serif", Font.BOLD, 40));
            card1.add(guessLabel);
            JTextField guessField = new JTextField(1);
            guessField.setFont(new Font("Sans-serif", Font.BOLD, 40));
            guessField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    char guess = Character.toLowerCase(guessField.getText().charAt(0));
                    hm.validateUserInput(guess);
                    guessField.setText("");
                    wordBlanks.setText(hm.getWordDisplayString().replace("", " "));
                    textLabel.setText(hm.getPrompt());


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
                    updateCenterPanel(guess);
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
                    hangmanMenu.createOpeningMenu(); //FIX INSTANCE PROBLEM
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
                        
                    hl.startHangman(hangmanDifficulty, soundToggle, volume); //FIX INSTANCE PROBLEM
                }
            }); 
            card2.add(b2);

            bottomPanel.add(card2);

            return bottomPanel;
    }

    private void displayGameOverAlert(int currentScore) {
        String message = "Game Over!\n";
        message += "Game score: " + currentScore + "\n";

        JOptionPane.showMessageDialog(frame, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

}
