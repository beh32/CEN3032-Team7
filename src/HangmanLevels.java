public class HangmanLevels {

    private int currentLevel;
    private int currentScore;

    public HangmanLevels() {
        currentLevel = 1;
        this.currentScore = 0;
    }

    public void startHangman(String hangmanDifficulty, boolean soundToggle, int volume) {
        HangmanUI hu = new HangmanUI(currentLevel, this, hangmanDifficulty, soundToggle, volume);
        hu.initalizeUI();
    }

    public void increaseLevel() {
        ++currentLevel;
        currentScore += 10;
    }

    public int getCurrentScore() {
        return currentScore;
    }
}
