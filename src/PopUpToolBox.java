import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PopUpToolBox extends PopUp {
	
	//Attribute
	BufferedImage box;
	Image displayed;
	Font f = new Font("basic title font", Font.PLAIN, 12);
	BufferedImage boxGlow;
        
        //boolean changing = true;
	Pemain pemain;
	
	final int adjustmentX = 12;
	final int adjustmentY = 12;

	//Method
	{
		try{
			this.box = ImageIO.read(new File("./res/ItemBox10.png"));
		} catch (IOException e) {
            e.printStackTrace();
        }
		displayed = box.getScaledInstance(box.getWidth()*4/5, box.getHeight()*4/5,  Image.SCALE_SMOOTH);
		
		try{
			boxGlow = ImageIO.read(new File("./res/itemBoxGlow.png"));
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public PopUpToolBox(Pemain pemain){
		super();
		this.pemain = pemain;
	}
	
	public PopUpToolBox(Pemain pemain, PopUpManager popUpManager, Game game){
		super(popUpManager, game);
		this.pemain = pemain;
	}
	
	public PopUpToolBox(Pemain pemain, PopUpManager popUpManager, Game game, int width, int height){
		super(popUpManager, game, width, height);
		this.pemain = pemain;
	}
        
	@Override
	public void paint(Graphics g) {
		if (this.isViewed()){
			g.drawImage(displayed, game.getWidth()/2 - displayed.getWidth(null)/2, game.getHeight()*7/8, null);
			g.drawImage(boxGlow, game.getWidth()/2 - displayed.getWidth(null)/2 + adjustmentX + (pemain.getHeldTool() * boxGlow.getWidth()), game.getHeight()*7/8 + adjustmentY, null);
                        //if (changing){
                        int[] jumlahI = pemain.getJumlahTool(3, 5);
                        g.setColor(Color.BLACK);
                        g.setFont(f);
                        g.drawString((pemain.getTools())[pemain.getHeldTool()].getName().toString(), game.getWidth()/2 - displayed.getWidth(null)/2 + adjustmentX + (pemain.getHeldTool() * boxGlow.getWidth()), game.getHeight()*7/8 + adjustmentY);
                        for (int i=3; i<8; i++){
                            g.setColor(Color.orange);
                            g.fillRect(game.getWidth()/2 - displayed.getWidth(null)/2 + adjustmentX + ((i) * boxGlow.getWidth()) + 22, game.getHeight()*7/8 + adjustmentY + 25, 18, 15);
                            g.setColor(Color.BLACK);
                            g.drawString("x"+Integer.toString(jumlahI[i]), game.getWidth()/2 - displayed.getWidth(null)/2 + adjustmentX + ((i) * boxGlow.getWidth()) + 22, game.getHeight()*7/8 + adjustmentY + 38);
                        }
		}
	}
}
