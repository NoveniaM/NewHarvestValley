import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PopUpPeta extends PopUp{

    private SpriteManager spriteManager = new SpriteManager("./res/TilesStatusPemain.png", 3, 3);
    
    private BufferedImage kepala, peta;
    Pemain pemain;
    Font f = new Font("basic title font", Font.PLAIN, 14);
    //Inventory inventory;
    
    {
            this.width = 13;
            this.height = 10;
            
            this.setViewed(false);
            try {
                    this.kepala = ImageIO.read(new File("./res/kepala.png"));
                    this.peta = ImageIO.read(new File("./res/petaS.png"));

            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
    }

    public PopUpPeta(){
            super();
            this.pemain = Game.getPemain();
    }

    public PopUpPeta(PopUpManager popUpManager, Game game){
            super(popUpManager, game);
            this.pemain = Game.getPemain();
    }

    public PopUpPeta(PopUpManager popUpManager, Game game, int width, int height){
            super(popUpManager, game, width, height);
            this.pemain = Game.getPemain();
    }

    private int adjustmentX(){
            return (Game.d.width - this.width*this.spriteManager.getCurrentImage().getWidth())/2;
    }

    private int adjustmentY(){
            return (Game.d.height - this.height*this.spriteManager.getCurrentImage().getHeight())/2;
    }

    @Override
    public void paint(Graphics g) {
        if (this.isViewed()){
            //Gambar frame
//            for (int i = 0; i < this.height; i++){
//                for (int j = 0; j < this.width; j++){
//                    if ( i == 0){
//                            if (j == 0){
//                                    this.spriteManager.setCurrentImage(1);
//                                    g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
//                            } else {
//                                    if (j != this.width - 1){
//                                            this.spriteManager.setCurrentImage(2);
//                                            g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
//                                    } else {
//                                            this.spriteManager.setCurrentImage(3);
//                                            g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
//                                    }
//                            }
//                    } else {
//                            if (i != this.height - 1){
//                                    if (j == 0){
//                                            this.spriteManager.setCurrentImage(4);
//                                            g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
//                                    } else {
//                                            if (j != this.width - 1){
//                                                    this.spriteManager.setCurrentImage(5);
//                                                    g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
//                                            } else {
//                                                    this.spriteManager.setCurrentImage(6);
//                                                    g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
//                                            }
//                                    }
//                            } else {
//                                    if (j == 0){
//                                            this.spriteManager.setCurrentImage(7);
//                                            g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
//                                    } else {
//                                            if (j != this.width - 1){
//                                                    this.spriteManager.setCurrentImage(8);
//                                                    g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
//                                            } else {
//                                                    this.spriteManager.setCurrentImage(9);
//                                                    g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
//                                            }
//                                    }
//                            }
//                    }
//                }
//            }

           
            g.drawImage(peta, this.spriteManager.getCurrentImage().getWidth()/3 + adjustmentX(), this.spriteManager.getCurrentImage().getHeight()/3 + adjustmentY(), null);
            int xNum = game.getWidth()/2 - (this.width*this.spriteManager.getCurrentImage().getWidth())/2 + (pemain.getX()*16);
            int yNum = adjustmentY() + (this.height*this.spriteManager.getCurrentImage().getHeight())/2 - 305 + (pemain.getY()*15);

            g.drawImage(kepala, xNum, yNum, null);
            //System.out.println("xy: "+pemain.getX()+", "+ pemain.getY());
            
        }
    }
}