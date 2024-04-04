public class HangmanLevels {

    private int currentLevel;


    public HangmanLevels() {
        currentLevel = 1; 
    }

    public void startHangman(String hangmanDifficulty) {
        HangmanUI hu = new HangmanUI(currentLevel, this, hangmanDifficulty);
        hu.initalizeUI();
    }

    public void increaseLevel() {
        ++currentLevel;
    }

}