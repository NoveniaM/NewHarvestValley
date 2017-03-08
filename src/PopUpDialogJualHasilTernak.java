import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class PopUpDialogJualHasilTernak extends PopUp {

    private SpriteManager spriteManager = new SpriteManager("./res/TilesStatusPemain.png", 3, 3);
    private BufferedImage dialog;
    Pemain pemain;
    Font f = new Font("basic title font", Font.PLAIN, 14);
    //Inventory inventory;
    
    {
            this.width = 13;
            this.height = 10;
            
            this.setViewed(false);
            try {
                    this.dialog = ImageIO.read(new File("./res/JualTernak1.png"));

            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
    }

    public PopUpDialogJualHasilTernak(){
            super();
            this.pemain = Game.getPemain();
    }

    public PopUpDialogJualHasilTernak(PopUpManager popUpManager, Game game){
            super(popUpManager, game);
            this.pemain = Game.getPemain();
    }

    public PopUpDialogJualHasilTernak(PopUpManager popUpManager, Game game, int width, int height){
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
            g.drawImage(dialog, this.spriteManager.getCurrentImage().getWidth()/3 + adjustmentX(), this.spriteManager.getCurrentImage().getHeight()/3 + adjustmentY(), null);
            
        }
    }
}    

