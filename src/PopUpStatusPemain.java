import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PopUpStatusPemain extends PopUp implements Serializable{
	
	public JButton savebutton, exittomenubutton;

    private SpriteManager spriteManager = new SpriteManager("./res/TilesStatusPemain.png", 3, 3);
    transient private BufferedImage box, orang, ayam, domba, sapi;
    Pemain pemain;
    Font f = new Font("basic title font", Font.PLAIN, 14);
    
    Font fo = new Font("basic title font", Font.PLAIN, 28);
    //Inventory inventory;
    
    {
            this.width = 13;
            this.height = 10;
            
            try {
                    this.box = ImageIO.read(new File("./res/ItemBoxKosong.png"));
                    this.orang = ImageIO.read(new File("./res/charaR.png"));
                    this.ayam = ImageIO.read(new File("./res/ayamL.png"));
                    this.domba = ImageIO.read(new File("./res/dombaL.png"));
                    this.sapi = ImageIO.read(new File("./res/sapiL.png"));

            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
    		
    		Icon saveIcon = new ImageIcon("./res/savebutton.png");
    		savebutton = new JButton(saveIcon);
    		savebutton.setBounds(10, 10, saveIcon.getIconWidth(), saveIcon.getIconHeight());
    		savebutton.setBorderPainted(false);
            savebutton.setContentAreaFilled(false); 
            savebutton.setFocusPainted(false); 
            savebutton.setOpaque(false);
    		savebutton.setBorder(null);
    		savebutton.setVisible(false);
    		savebutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	game.requestFocusInWindow();
                	Game.save();
                }
            });
            game.add(savebutton);
            
            Icon exittomenuIcon = new ImageIcon("./res/exit-button.png");
            exittomenubutton = new JButton(exittomenuIcon);
            exittomenubutton.setBounds(10, 20 + saveIcon.getIconHeight(), exittomenuIcon.getIconWidth(), exittomenuIcon.getIconHeight());
            exittomenubutton.setBorderPainted(false);
            exittomenubutton.setBorder(null);
            exittomenubutton.setContentAreaFilled(false); 
            exittomenubutton.setFocusPainted(false); 
            exittomenubutton.setOpaque(false);
            exittomenubutton.setVisible(false);
            exittomenubutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	game.requestFocusInWindow();
                	Game.setFocusedStage(Game.stageManager.getList().get(0));
                	Game.state = Game.State.MainMenu;
                	exittomenubutton.setVisible(false);
                	savebutton.setVisible(false);
                	PopUpStatusPemain.this.setViewed(false);
                	((StageMenu)Game.stageManager.getList().get(0)).restartMenu();
                	Game.waktu.setFlow(false);
                	MainSound.stop();
                }
            });
            game.add(exittomenubutton);
            
            
            this.setViewed(false);
    }
    
    public void setViewed(boolean viewed) {
		this.viewed = viewed;
		if(viewed){
			savebutton.setVisible(true);
			exittomenubutton.setVisible(true);
            game.setLayout(null);
		} else {
			savebutton.setVisible(false);
			exittomenubutton.setVisible(false);
		}
	}

    public PopUpStatusPemain(){
            super();
            this.pemain = Game.getPemain();
            
    }

    public PopUpStatusPemain(PopUpManager popUpManager, Game game){
            super(popUpManager, game);
            this.pemain = Game.getPemain();
    }

    public PopUpStatusPemain(PopUpManager popUpManager, Game game, int width, int height){
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
            for (int i = 0; i < this.height; i++){
                for (int j = 0; j < this.width; j++){
                    if ( i == 0){
                            if (j == 0){
                                    this.spriteManager.setCurrentImage(1);
                                    g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
                            } else {
                                    if (j != this.width - 1){
                                            this.spriteManager.setCurrentImage(2);
                                            g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
                                    } else {
                                            this.spriteManager.setCurrentImage(3);
                                            g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
                                    }
                            }
                    } else {
                            if (i != this.height - 1){
                                    if (j == 0){
                                            this.spriteManager.setCurrentImage(4);
                                            g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
                                    } else {
                                            if (j != this.width - 1){
                                                    this.spriteManager.setCurrentImage(5);
                                                    g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
                                            } else {
                                                    this.spriteManager.setCurrentImage(6);
                                                    g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
                                            }
                                    }
                            } else {
                                    if (j == 0){
                                            this.spriteManager.setCurrentImage(7);
                                            g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
                                    } else {
                                            if (j != this.width - 1){
                                                    this.spriteManager.setCurrentImage(8);
                                                    g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
                                            } else {
                                                    this.spriteManager.setCurrentImage(9);
                                                    g.drawImage(this.spriteManager.getCurrentImage(), j*this.spriteManager.getCurrentImage().getWidth() + adjustmentX(), i*this.spriteManager.getCurrentImage().getHeight() + adjustmentY(), null);
                                            }
                                    }
                            }
                    }
                }
            }	

            //Gambar status Pemain
            //Bagian Inventory
            g.drawImage(box, adjustmentX() + (this.width*this.spriteManager.getCurrentImage().getWidth())/2 - box.getWidth()/2, adjustmentY() + (this.height*this.spriteManager.getCurrentImage().getHeight())/2 - box.getHeight()/2 - 190, null);

            //gambar isi item
            //if (pemain.getInventori() != null){
                
            Inventory inventory = pemain.getInventori();
            int jumITem = inventory.getSize();
            Item[] itemitem = inventory.itemList();
            int[] jumlahI = inventory.getJumlahItem();
            
            for (int iter=1; iter<=jumITem; iter++){
                g.drawImage(itemitem[iter].getImage(), game.getWidth()/2 - box.getWidth(null)/2 + (iter * 53) - 30, adjustmentY() + (this.height*this.spriteManager.getCurrentImage().getHeight())/2 - box.getHeight()/2 - 168, null);
                int xNum = game.getWidth()/2 - box.getWidth(null)/2 + (iter * 53) - 8;
                int yNum = adjustmentY() + (this.height*this.spriteManager.getCurrentImage().getHeight())/2 - box.getHeight()/2 - 125;
                g.setColor(Color.orange);
                g.fillRect(xNum+2, yNum-20, 20, 20);
                g.setColor(Color.BLACK);
                g.setFont(f);
                g.drawString("x"+Integer.toString(jumlahI[iter]), xNum+7, yNum-5);
            }
            
            int mX = adjustmentX() + (this.width*this.spriteManager.getCurrentImage().getWidth())/2 - box.getWidth()/2;
            int mY = adjustmentY() + (this.height*this.spriteManager.getCurrentImage().getHeight())/2 - box.getHeight()/2 - 70;
            
            g.drawImage(orang, mX, mY, null);
            g.setColor(Color.orange);
            g.fillRect(mX, mY+285, 200, 60);
            g.setColor(Color.BLACK);
            g.setFont(fo);
            g.drawString("Name: "+pemain.getName(), mX+10, mY+310);
            
            g.drawString("Gold: "+pemain.getGold().getGold(), mX+10, mY+340);
            
            g.drawImage(ayam, mX+320, mY, null);
            g.setColor(Color.orange);
            g.fillRect(mX+470, mY+30, 40, 35);
            g.setColor(Color.BLACK);
            g.drawString(""+Ayam.jumlahAyam(), mX+480, mY+60);
            
            g.drawImage(domba, mX+320, mY+120, null);
            g.setColor(Color.orange);
            g.fillRect(mX+470, mY+150, 40, 35);
            g.setColor(Color.BLACK);
            g.drawString(""+Domba.jumlahDomba(), mX+480, mY+180);
            
            g.drawImage(sapi, mX+320, mY+240, null);
            g.setColor(Color.orange);
            g.fillRect(mX+470, mY+270, 40, 35);
            g.setColor(Color.BLACK);
            g.drawString(""+Sapi.jumlahSapi(), mX+480, mY+300);
			
        }
    }
}