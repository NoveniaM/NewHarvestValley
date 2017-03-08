import java.awt.Color;
import java.awt.Graphics;

public class PlotLadang extends Entity{
	private boolean plantable, watered;
	
	{
		this.setSpriteManager(new SpriteManager("./res/FarmTile.png", 1, 3));
    	this.setPlantable(false);
    	this.setWatered(false);
    	super.setStepable(true);
	}
	
	public PlotLadang (){
    	super();
    }
	
	public PlotLadang (Stage s, int x, int y){
    	super(s, x, y);
    }
	
	public void paint(Graphics g){
		this.getSpriteManager().setCurrentImage(1);
		g.drawImage(this.getSpriteManager().getCurrentImage(), (this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX()), (this.getLokasi().getY()*Game.size  + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY()), null);
		if (plantable){
			if (watered){
				this.getSpriteManager().setCurrentImage(3);
			} else {
				this.getSpriteManager().setCurrentImage(2);
			}
			g.drawImage(this.getSpriteManager().getCurrentImage(), (this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX()), (this.getLokasi().getY()*Game.size  + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY()), null);
		}
	}
	
	public boolean getPlantable(){
		return this.plantable;
	}
	
	public void setPlantable(boolean a){
		this.plantable = a;
	}

	public boolean isWatered() {
		return watered;
	}

	public void setWatered(boolean watered) {
		this.watered = watered;
	}

	@Override
	public void action(int i) {
		// TODO Auto-generated method stub
		
	}
}
