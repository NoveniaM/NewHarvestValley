import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class Hewan extends Entity implements Drawable, Runnable{
    
    Timer t0 = new Timer(180, new Hewan.Action0());// Move Up
    Timer t1 = new Timer(180, new Hewan.Action1());// Move Right
    Timer t2 = new Timer(180, new Hewan.Action2());// Move Down
    Timer t3 = new Timer(180, new Hewan.Action3());// Move Left

    String nama = "";
    int terakhirMakan = 0;
    StatusHewan status = StatusHewan.Lapar;

    StageManager stageManager;

    boolean isDoingSomething = false;
    
    boolean sudahDipanen = false;
    
    public static enum StatusHewan { //Nambah
		Sehat,
		Lapar
	}

	//Method
        
	Hewan(Stage s) {
        super(s);
    	this.setEntityManager(s.getEntityManager());
        new Thread(this).start();
    }
	
	Hewan(Stage s, String nama, int x, int y) {
        super(s, x, y);
        this.nama = nama;
        this.setX(x);
        this.setY(y);
        new Thread(this).start();
    }
	
	Hewan(Stage s, String nama) {
        super(s);
        this.nama = nama;
        new Thread(this).start();
    }
        
    public boolean isSiapPanen(){
    	return((this.status == StatusHewan.Sehat));
	}
    
    public boolean isSudahDipanen() {
		return sudahDipanen;
	}

	public void setSudahDipanen(boolean a){
    	this.sudahDipanen = a;
	}

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.getSpriteManager().getCurrentImage(),
        (this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX() - dx), 
        (this.getLokasi().getY()*Game.size  + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY() - dy), 
        null);
    }
	
    public void updateStatus(boolean adaMakanan){
		if (adaMakanan == true){ //ada makanan
            this.terakhirMakan = 0;
            this.sudahDipanen = false;
            //System.out.println("Kasih makan hewan berhasil");
        } else if (adaMakanan == false){ //tidak ada makanan
        	this.terakhirMakan++;
        	//System.out.println("Kasih makan hewan gagal");
        }
		
        if (this.terakhirMakan == 0){
        	this.status = StatusHewan.Sehat;
        } else {
        	this.status = StatusHewan.Lapar;
        }
        
        if (this.terakhirMakan > 3){
        	this.getEntityManager().getList().remove(this);
        }
        
	}
    
    public void updateStatus(boolean adaMakanan, Iterator iter){
		if (adaMakanan == true){ //ada makanan
            this.terakhirMakan = 0;
        } else if (adaMakanan == false){ //tidak ada makanan
        	this.terakhirMakan++;
        }
		
        if (this.terakhirMakan == 0){
        	this.status = StatusHewan.Sehat;
        } else {
        	this.status = StatusHewan.Lapar;
        }
        
        if (this.terakhirMakan > 3){
        	iter.remove();
        }
        
	}

    public int randInt(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min)+1)+min;
        return randomNum;
    }
    
    public void action(int i){
        switch(i){
        case 0: //Move Up
                t0.start();
                break;
        case 1: //Move Right
                t1.start();
                break;
        case 2: //Move Down
                t2.start();
                break;
        case 3: //Move Left
                t3.start();
                break;

        }

    }

    public boolean inFrontOfHewan(Entity s){
        boolean temp = false;

        switch (this.getArahHadap()){
        case 0 :
            temp = ((s.getX() <= this.getX() && s.getX() + s.getHeight() - 1 >= this.getX()) && (s.getY() <= this.getY() - 1) && s.getY()+ s.getWidth() - 1 >= this.getY() - 1);
            break;
        case 1 :
            temp = ((s.getX() <= this.getX() + 1 && s.getX() + s.getHeight() - 1 >= this.getX() + 1) && (s.getY() <= this.getY()) && s.getY()+ s.getWidth() - 1 >= this.getY());
            break;
        case 2 : 
            temp = ((s.getX() <= this.getX() && s.getX() + s.getHeight() - 1 >= this.getX()) && (s.getY() <= this.getY() + 1) && s.getY()+ s.getWidth() - 1 >= this.getY() + 1);
            break;
        case 3 : 
            temp = ((s.getX() <= this.getX() - 1 && s.getX() + s.getHeight() - 1 >= this.getX() - 1) && (s.getY() <= this.getY()) && s.getY() + s.getWidth() - 1 >= this.getY());
            break;    
        }
        return temp;
    }

    public Entity entityDepanHewan(EntityManager manager){
        Entity temp = null;

        for(Entity entity : manager.getList()){
                if (inFrontOfHewan(entity)){
                temp = entity;
            }
        }
        return temp;
    }

    //Attribut for display
    int dx = 0, dy = 0;
    int moveCount = 0;
    int moveNumber = 4;

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(200);
                this.action(randInt(0, 40));
            } catch (InterruptedException ex) {
                Logger.getLogger(Hewan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class Action0 implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Hewan.this.setArahHadap(0);
			if (Hewan.this.entityDepanHewan(Hewan.this.getEntityManager()) == null || Hewan.this.entityDepanHewan(Hewan.this.getEntityManager()).isStepable()){
				Hewan.this.isDoingSomething = true;
				Hewan.this.moveCount++;
				Hewan.this.getSpriteManager().setCurrentImage(13 + moveCount);
				dy += Game.size / Hewan.this.moveNumber;
			} else {
				Hewan.this.isDoingSomething = false;
				Hewan.this.getSpriteManager().setCurrentImage(13);
				t0.stop();
			}
			
			if (Hewan.this.moveCount == Hewan.this.moveNumber) {
				Hewan.this.setY(Hewan.this.getY() - 1);
				Hewan.this.moveCount = 0;
				Hewan.this.isDoingSomething = false;
				dy = 0;
				Hewan.this.getSpriteManager().setCurrentImage(13);
				t0.stop();
			}
			
			
		}
	}
	
	private class Action1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Hewan.this.setArahHadap(1);
			if (Hewan.this.entityDepanHewan(Hewan.this.getEntityManager()) == null || Hewan.this.entityDepanHewan(Hewan.this.getEntityManager()).isStepable()){
				Hewan.this.isDoingSomething = true;
				Hewan.this.moveCount++;
				Hewan.this.getSpriteManager().setCurrentImage(9 + moveCount);
				dx -= Game.size / Hewan.this.moveNumber;
			} else {
				Hewan.this.isDoingSomething = false;
				Hewan.this.getSpriteManager().setCurrentImage(9);
				t1.stop();
			}
			
			if (Hewan.this.moveCount == Hewan.this.moveNumber) {
				Hewan.this.setX(Hewan.this.getX() + 1);
				Hewan.this.moveCount = 0;
				Hewan.this.isDoingSomething = false;
				dx = 0;
				Hewan.this.getSpriteManager().setCurrentImage(9);
				t1.stop();
			}
		}
		
	}
	
	private class Action2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Hewan.this.setArahHadap(2);
			if (Hewan.this.entityDepanHewan(Hewan.this.getEntityManager()) == null || Hewan.this.entityDepanHewan(Hewan.this.getEntityManager()).isStepable()){
				Hewan.this.moveCount++;
				Hewan.this.getSpriteManager().setCurrentImage(1 + moveCount);
				dy -= Game.size / Hewan.this.moveNumber;
			} else {
				Hewan.this.isDoingSomething = false;
				Hewan.this.getSpriteManager().setCurrentImage(1);
				t2.stop();
			}
			
			if (Hewan.this.moveCount == Hewan.this.moveNumber) {
				Hewan.this.setY(Hewan.this.getY() + 1);
				Hewan.this.moveCount = 0;
				Hewan.this.isDoingSomething = false;
				dy = 0;
				Hewan.this.getSpriteManager().setCurrentImage(1);
				t2.stop();
			}
		}
		
	}
	
	private class Action3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Hewan.this.setArahHadap(3);
			if (Hewan.this.entityDepanHewan(Hewan.this.getEntityManager()) == null || Hewan.this.entityDepanHewan(Hewan.this.getEntityManager()).isStepable()){
				Hewan.this.isDoingSomething = true;
				Hewan.this.moveCount++;
				Hewan.this.getSpriteManager().setCurrentImage(5 + moveCount);
				dx += Game.size / Hewan.this.moveNumber;
			} else {
				Hewan.this.isDoingSomething = false;
				Hewan.this.getSpriteManager().setCurrentImage(5);
				t3.stop();
			}
			
			if (Hewan.this.moveCount == Hewan.this.moveNumber) {
				Hewan.this.setX(Hewan.this.getX() - 1);
				Hewan.this.moveCount = 0;
				Hewan.this.isDoingSomething = false;
				dx = 0;
				Hewan.this.getSpriteManager().setCurrentImage(5);
				t3.stop();
			}
		}
		
	}
}
    