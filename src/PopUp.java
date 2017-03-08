import java.awt.Graphics;

public abstract class PopUp implements Drawable { //Ditampilkan tapi bukan Entity

	boolean viewed = true;
	
	int width = 1, height = 1;
	
	Game game;
	
	public PopUp(){
	}
	
	public PopUp(PopUpManager popUpManager){
		popUpManager.getList().add(this);
	}

	public PopUp(PopUpManager popUpManager, Game game){
		popUpManager.getList().add(this);
		this.game = game;
	}
	
	public PopUp(PopUpManager popUpManager, Game game, int width, int height){
		popUpManager.getList().add(this);
		this.game = game;
		this.width = width;
		this.height = height;
	}
	
	public boolean isViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	public abstract void paint (Graphics g);
	
}
