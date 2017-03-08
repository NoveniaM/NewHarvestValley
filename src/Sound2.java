import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound2{
    
    public Sound2() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./sound/door-9-open.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            
            AudioInputStream audioInputStream2 = AudioSystem.getAudioInputStream(new File("./sound/door-9-close.wav").getAbsoluteFile());
            Clip clip2 = AudioSystem.getClip();
            clip2.open(audioInputStream2);
            clip2.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
            
}