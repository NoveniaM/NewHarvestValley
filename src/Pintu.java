import java.awt.Color;
import java.awt.Graphics;

public class Pintu extends Entity{

    private Stage tujuan;
    private Stage dari;
    
    public Pintu (Stage s, int x, int y, Stage tujuan){
    	super(s, x, y);
    	this.tujuan = tujuan;
    	this.dari = s;
    }
    
    public Stage getTujuan(){
        return this.tujuan;
    }
    
    public Stage getDari(){
        return this.dari;
    }

	@Override
	public void paint(Graphics g) {
		//g.setColor(Color.GREEN);
		//g.fillRect((this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX()), (this.getLokasi().getY()*Game.size  + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY()), this.getWidth()*Game.size, this.getHeight()*Game.size);
	}

	@Override
	public void action(int i) {
		// TODO Auto-generated method stub
		
	}
}
