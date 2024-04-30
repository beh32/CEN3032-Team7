import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public final class SoundPlayer {
    
    private static boolean soundOn = true;
    public static int volume = 50;

    public static void toggleSound() {
        soundOn = !soundOn;
    }


    public static void playSound(String filePath) {
        if (soundOn) {
            File soundFile = new File(filePath);

            try {
                Clip audioClip = AudioSystem.getClip();
                audioClip.open(AudioSystem.getAudioInputStream(soundFile));
                FloatControl volumeControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
                float range = volumeControl.getMaximum() - volumeControl.getMinimum();
                float gain = (range * volume / 100.0f) + volumeControl.getMinimum();
                volumeControl.setValue(gain);

                audioClip.start();

            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
                System.out.println("Invalid Sound or Sound Error.");
            }
        }
    }

    public static void updateVolume(int newVolume) {
        volume = newVolume;
    }
}
