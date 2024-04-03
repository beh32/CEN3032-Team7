public class HangmanLevels {

    private int currentLevel;


    public HangmanLevels() {
        currentLevel = 1; 
    }

    public void startHangman() {
        HangmanUI hu = new HangmanUI(currentLevel);
        hu.initalizeUI();
    }

    public void increaseLevel() {
        ++currentLevel;
    }

}