//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import sun.audio.*;
//..\Game\Bin\RldOrigin.dll

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound{
    
    static Clip clip;
    
    
    public Sound() {
        try {
			Thread.sleep(0);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // looping as long as this thread is alive
        AudioInputStream inputStream = null;
		try {
			inputStream = AudioSystem.getAudioInputStream(new File("./sound/mainmenu.wav"));
		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clip = null;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			clip.open(inputStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        clip.loop(1);
    }
    
    public static void stop() {

            clip.stop();
            clip.close();

        }
            
}
