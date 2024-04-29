import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
    
    public static void playSound(String filePath) {
        File soundFile = new File(filePath);

        try {
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(AudioSystem.getAudioInputStream(soundFile));
            audioClip.start();

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            System.out.println("Invalid Sound or Sound Error.");
        }
    }
}
