import java.awt.Color;
import java.awt.Graphics;

public class Border extends Entity{

	public Border(int x, int y){
		this.setLokasi(x, y);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect((this.getLokasi().getX()*Game.size + Game.getPemain().distanceDisplayedX()), (this.getLokasi().getY()*Game.size + Game.getPemain().distanceDisplayedY()), Game.size, Game.size);
		
	}

	@Override
	public void action(int i) {
		// TODO Auto-generated method stub
		
	}

}
