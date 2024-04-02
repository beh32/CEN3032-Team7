import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanUI extends JPanel implements ActionListener {

    private int WIDTH;
    private int HEIGHT;
    private int numGuesses;
    private boolean gameOver;
    private BackButton backButton;
    private CardLayout cardLayout;
    private Container container;
    private Word wordToGuess;
    private char[] guessedLetters;
    private Image hangman = new ImageIcon("../images/example.png").getImage();

    public HangmanUI(int WIDTH, int HEIGHT, JPanel container, CardLayout cardLayout, WordList wordList) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.cardLayout = cardLayout;
        this.container = container;

        this.backButton = new BackButton("<", 80, 80, 80, 80, container, cardLayout);
        this.backButton.addActionListener(this);

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        // add(createCenterPanel(), BorderLayout.CENTER);
        add(createBottomPanel(), BorderLayout.SOUTH);

        this.wordToGuess = wordList.selectRandomWord();
        System.out.println("Word to guess: " + wordToGuess.getWord());

        this.numGuesses = 6;
        this.gameOver = false;

        guessedLetters = new char[wordToGuess.getWord().length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '\0';
        }
    }

    // Panel for the level, navigation controls, pause/play
    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 10));

        // ImageIcon backIcon = new ImageIcon("../images/angle-left.png");
        // JButton back = new JButton(backIcon);
        // back.addActionListener(e -> {

        // });

        topPanel.add(backButton);

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

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2D = (Graphics2D) g.create();
        super.paintComponent(g2D);

        char[] wordToChar = this.wordToGuess.getLettersInWord();
        int space = 10;
        int spacesLength = this.calculatePlaceholderLength(this.wordToGuess.getWord(), space);
        int x1 = this.calculateX1(spacesLength, this.wordToGuess.getWord(), space);
        int y1 = this.HEIGHT / 2 + 90;
        int x2 = x1 + spacesLength;
        int y2 = y1;
        int fontSize = this.calculatePlaceholderLength(this.wordToGuess.getWord(), space);
        String fontName = g2D.getFont().getFontName();
        Font font = new Font(fontName, Font.BOLD, fontSize);

        // g2D.drawImage(this.backgroundImg, 0, 0, null);

        int hangmanX = (this.WIDTH / 2) - hangman.getWidth(null) / 2;
        int hangmanY = 70;
        g2D.drawImage(hangman, hangmanX, hangmanY,
                null);

        g2D.setPaint(Color.black);
        g2D.setStroke(new BasicStroke(5));
        g2D.setFont(font);

        this.drawEmptySpaces(g2D, wordToChar, x1, y1, x2, y2, space, spacesLength);

        this.drawGuessedLetters(g2D, x1, y1, x2, space, spacesLength);

        if (this.gameOver && !this.guessedWordisCorrect()) {
            this.drawMissingLetters(g2D, x1, y1, x2, space, spacesLength);
        }

        if (this.gameOver) {
            this.drawGameOverText(g2D);
        }
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
            String guess = guessField.getText();
            if (guess.length() == 1) {
                checkGuess(guess.toCharArray()[0]);
                guessField.setText("");
                checkWin();
                if (this.gameOver == true) {
                    guessField.setEnabled(false);
                }
            }
        });
        bottomPanel.add(guessField);

        return bottomPanel;
    }

    private void drawGuessedLetters(Graphics2D g2D, int x1, int y1, int x2, int space, int placeholderLength) {

        int charX1 = x1;
        int charX2 = x2;

        for (int i = 0; i < this.guessedLetters.length; i++) {
            char ch = this.guessedLetters[i];
            int x = charX1 + (placeholderLength / 2)
                    - (g2D.getFontMetrics().stringWidth(String.valueOf(ch).toUpperCase()) / 2);
            int y = y1 - 10;

            if (String.valueOf(ch).matches("[a-zA-Z0-9]")) {
                g2D.drawString(String.valueOf(ch).toUpperCase(), x, y);
            }
            charX1 = charX2 + space;
            charX2 = charX1 + placeholderLength;
        }
        repaint();
    }

    private void drawMissingLetters(Graphics2D g2D, int x1, int y1, int x2, int space, int spacesLength) {

        g2D.setPaint(Color.RED);

        int charX1 = x1;
        int charX2 = x2;

        for (int i = 0; i < this.wordToGuess.getLettersInWord().length; i++) {
            char ch = this.wordToGuess.getLettersInWord()[i];
            int x = charX1 + (spacesLength / 2)
                    - (g2D.getFontMetrics().stringWidth(String.valueOf(ch).toUpperCase()) / 2);
            int y = y1 - 10;

            if (String.valueOf(ch).matches("[a-zA-Z0-9]")
                    && this.guessedLetters[i] != this.wordToGuess.getLettersInWord()[i]) {
                g2D.drawString(String.valueOf(ch).toUpperCase(), x, y);
            }
            charX1 = charX2 + space;
            charX2 = charX1 + spacesLength;
        }
    }

    private void drawEmptySpaces(Graphics2D g2D, char[] wordToChar, int x1, int y1, int x2, int y2, int space,
            int placeholderLength) {

        int placeholderX1 = x1;
        int placeholderX2 = x2;
        int placeholderY1 = y1;
        int placeholderY2 = y2;

        for (int i = 0; i < wordToChar.length; i++) {
            char ch = wordToChar[i];
            int charX = placeholderX1 + (placeholderLength / 2)
                    - (g2D.getFontMetrics().stringWidth(String.valueOf(ch).toUpperCase()) / 2);
            int charY = placeholderY1 - 10;

            if (String.valueOf(ch).matches("[a-zA-Z0-9]")) {
                g2D.drawLine(placeholderX1, placeholderY1, placeholderX2, placeholderY2);
            } else {
                g2D.drawString(String.valueOf(ch).toUpperCase(), charX, charY);
            }

            placeholderX1 = placeholderX2 + space;
            placeholderX2 = placeholderX1 + placeholderLength;
        }
    }

    private int calculatePlaceholderLength(String word, int space) {
        /*
         * Calculates the length of the letter placeholder based on the screen width,
         * space between placeholders and the
         * length of the word to dynamically adjust the placeholder size to fit the
         * screen.
         */

        int placeholderLength;
        if (word.length() <= 10) {
            placeholderLength = ((this.WIDTH - 40) / 10) - space;
        } else {
            placeholderLength = ((this.WIDTH - 20) / word.length()) - space;
        }
        return placeholderLength;
    }

    private int calculateX1(int placeholderLength, String word, int space) {

        int x = (this.WIDTH / 2) - ((placeholderLength * word.length() + space * (word.length() + 1)) / 2);
        return x;
    }

    private boolean checkGuess(char userGuess) {
        boolean correctGuess = false;
        char[] wordLetters = wordToGuess.getLettersInWord();
        for (int i = 0; i < wordLetters.length; i++) {
            if (userGuess == wordLetters[i]) {
                guessedLetters[i] = userGuess;
                System.out.println("Correct guess");
                correctGuess = true;
            }
        }
        if (correctGuess == false) {
            numGuesses -= 1;
            System.out.println("Incorrect guess, number of guesses remaining " + numGuesses);
        }
        return correctGuess;
    }

    private void checkWin() {
        if (this.numGuesses == 0) {
            System.out.println("Game over, you lose");
            this.gameOver = true;
            repaint();
        }

        if (this.guessedWordisCorrect()) {
            System.out.println("Game over, you win");
            this.gameOver = true;
            repaint();
        }
    }

    private boolean guessedWordisCorrect() {
        String word = this.wordToGuess.getWord();
        StringBuilder guessedWordBuilder = new StringBuilder();

        for (char letter : guessedLetters) {
            guessedWordBuilder.append(letter);
        }
        String guessedWord = guessedWordBuilder.toString();

        return word.equals(guessedWord);
    }

    private String setWinLossText() {
        return this.gameOver && this.guessedWordisCorrect() ? "YOU WON!" : "YOU LOST!";
    }

    private void drawGameOverText(Graphics2D g2D) {

        String text = this.setWinLossText();
        String fontName = g2D.getFont().getFontName();
        int fontSize = 100;
        Font font = new Font(fontName, Font.BOLD, fontSize);
        g2D.setFont(font);

        int textX = (this.WIDTH / 2) - (g2D.getFontMetrics().stringWidth(text) / 2);
        int textY = (this.HEIGHT / 2) - (g2D.getFontMetrics().getHeight() / 2);

        if (text.equals("YOU WON!")) {
            g2D.setPaint(Color.GREEN);
        } else {
            g2D.setPaint(Color.RED);
        }
        g2D.drawString(text, textX, textY);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {
            this.backButton.swapCard("1");
        }
    }
}
