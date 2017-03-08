import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Display extends JPanel {//implements KeyListener{
	
	public int width = 10;
	public int height = 10;
	
	public Display(){
		Dimension d = new Dimension (width*Game.size, height*Game.size);		
		setMinimumSize(d);
		setPreferredSize(d);
		setMaximumSize(d);
		//addKeyListener(this);
		setFocusable(true);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
        
		//Buat ngeliatin grid, animasi jadi kacau
		/*
        try{
        	Image img = ImageIO.read(new File("./res/rumput.png"));
        	Image img2 = ImageIO.read(new File("./res/rumput2.png"));
        	Image imgd = img;
        	boolean n1 = true;
        	boolean n2 = true;
        	
        	if (Game.stageManager.getStageWithPemain().getEntityManager().getPemain().getX() % 2 != 0){
        		n1 = !n1;
        	}
        	if (Game.stageManager.getStageWithPemain().getEntityManager().getPemain().getY() % 2 != 0){
        		n1 = !n1;
        	}
        	
        	for (int i = 0; i < getWidth() + Game.size; i += Game.size){
        		if (n1 == n2){
        			n2 = !n2;
        		}
        		n1 = !n1;
        		for (int y = 0; y < getHeight() + Game.size; y += Game.size){
        			if (n2 == true){
            			imgd = img2;
            		} else {
            			imgd = img;
            		}
            		n2 = !n2;
        			
        			g.drawImage(imgd, i + (Game.stageManager.getStageWithPemain().getEntityManager().getPemain().distanceDisplayedX() % Game.size) - Game.size, (y + Game.stageManager.getStageWithPemain().getEntityManager().getPemain().distanceDisplayedY() % Game.size) - Game.size, null);
        		}
        	}
		} catch (IOException e) {
            e.printStackTrace();
        }
        */
		
        try{
        	Image img = ImageIO.read(new File("./res/RumputLadang.png"));
        	
        	for (int i = 0; i < getWidth() + 2*Game.size; i += Game.size){
        		for (int y = 0; y < getHeight() + 2*Game.size; y += Game.size){
        			g.drawImage(img, i + (Game.stageManager.getStageWithPemain().getEntityManager().getPemain().distanceDisplayedX() % Game.size) - Game.size, (y + Game.stageManager.getStageWithPemain().getEntityManager().getPemain().distanceDisplayedY() % Game.size) - Game.size, null);
        		}
        	}
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
}
