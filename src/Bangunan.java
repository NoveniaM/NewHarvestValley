import java.awt.Graphics;

public class Bangunan extends Entity {
    
	{
		this.setSpriteManager(new SpriteManager("./res/Home.png"));
	}
	
    public Bangunan (Stage s, int x, int y, int width, int height){
        super(s, x, y);
        this.setWidth(width);
        this.setHeight(height);
    }

	@Override
	public void paint(Graphics g) {
		g.drawImage(this.getSpriteManager().getCurrentImage(), (this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX()), (this.getLokasi().getY()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY()), null);
		//g.setColor(Color.BLUE);
		//g.fillRect((this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX()), (this.getLokasi().getY()*Game.size  + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY()), this.getWidth()*Game.size, this.getHeight()*Game.size);
	}

	@Override
	public void action(int i) {
		// TODO Auto-generated method stub
		
	}
}
