import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PopUpTimeBox extends PopUp{

	private SpriteManager spriteManager = new SpriteManager("./res/TilesTimeBox.png", 3, 3);
	Font f = new Font("basic title font", Font.PLAIN, 14);
	
	{
		this.setViewed(true);
		this.width = 4;
		this.height = 3;
	}
	
	public PopUpTimeBox(){
		super();
	}
	
	public PopUpTimeBox(PopUpManager popUpManager, Game game){
		super(popUpManager, game);
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
							g.drawImage(this.spriteManager.getCurrentImage(), Game.d.width - (this.height - j + 1)*this.spriteManager.getCurrentImage().getWidth(), i*this.spriteManager.getCurrentImage().getHeight(), null);
						} else {
							if (j != this.width - 1){
								this.spriteManager.setCurrentImage(2);
								g.drawImage(this.spriteManager.getCurrentImage(), Game.d.width - (this.height - j + 1)*this.spriteManager.getCurrentImage().getWidth(), i*this.spriteManager.getCurrentImage().getHeight(), null);
							} else {
								this.spriteManager.setCurrentImage(3);
								g.drawImage(this.spriteManager.getCurrentImage(), Game.d.width - (this.height - j + 1)*this.spriteManager.getCurrentImage().getWidth(), i*this.spriteManager.getCurrentImage().getHeight(), null);
							}
						}
					} else {
						if (i != this.height - 1){
							if (j == 0){
								this.spriteManager.setCurrentImage(4);
								g.drawImage(this.spriteManager.getCurrentImage(), Game.d.width - (this.height - j + 1)*this.spriteManager.getCurrentImage().getWidth(), i*this.spriteManager.getCurrentImage().getHeight(), null);
							} else {
								if (j != this.width - 1){
									this.spriteManager.setCurrentImage(5);
									g.drawImage(this.spriteManager.getCurrentImage(), Game.d.width - (this.height - j + 1)*this.spriteManager.getCurrentImage().getWidth(), i*this.spriteManager.getCurrentImage().getHeight(), null);
								} else {
									this.spriteManager.setCurrentImage(6);
									g.drawImage(this.spriteManager.getCurrentImage(), Game.d.width - (this.height - j + 1)*this.spriteManager.getCurrentImage().getWidth(), i*this.spriteManager.getCurrentImage().getHeight(), null);
								}
							}
						} else {
							if (j == 0){
								this.spriteManager.setCurrentImage(7);
								g.drawImage(this.spriteManager.getCurrentImage(), Game.d.width - (this.height - j + 1)*this.spriteManager.getCurrentImage().getWidth(), i*this.spriteManager.getCurrentImage().getHeight(), null);
							} else {
								if (j != this.width - 1){
									this.spriteManager.setCurrentImage(8);
									g.drawImage(this.spriteManager.getCurrentImage(), Game.d.width - (this.height - j + 1)*this.spriteManager.getCurrentImage().getWidth(), i*this.spriteManager.getCurrentImage().getHeight(), null);
								} else {
									this.spriteManager.setCurrentImage(9);
									g.drawImage(this.spriteManager.getCurrentImage(), Game.d.width - (this.height - j + 1)*this.spriteManager.getCurrentImage().getWidth(), i*this.spriteManager.getCurrentImage().getHeight(), null);
								}
							}
						}
					}
				}
			}	
			
			//Gambar Jam
			g.setColor(Color.BLACK);
			g.setFont(f);
			g.drawString(Waktu.stringHari, Game.d.width - (this.width*this.spriteManager.getCurrentImage().getHeight()/2) - 55, (this.height*this.spriteManager.getCurrentImage().getHeight()/2) - 6);
			g.drawString(Waktu.stringJam, Game.d.width - (this.width*this.spriteManager.getCurrentImage().getHeight()/2) - 55, (this.height*this.spriteManager.getCurrentImage().getHeight()/2) + 14);
			
		}
		
	}

}
