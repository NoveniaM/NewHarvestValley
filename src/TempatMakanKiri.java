import java.awt.Graphics;

public class TempatMakanKiri extends TempatMakan{

private boolean terisiMakanan;

{
    this.setSpriteManager(new SpriteManager("./res/FCChicken1.png", 1, 2));
}
	public TempatMakanKiri(){
		super();
		this.terisiMakanan = false;
	}
	
	public TempatMakanKiri(Stage s){
		super(s);
		this.terisiMakanan = false;
                this.getSpriteManager().setCurrentImage(1);
	}
        
        public TempatMakanKiri(Stage s, int x, int y){
                super(s, x, y);
                this.terisiMakanan = false;
                this.getSpriteManager().setCurrentImage(1);
                
        }
	
	public void setTerisiMakanan(Boolean status){
		this.terisiMakanan = status;
                if (status == true){
                    this.getSpriteManager().setCurrentImage(2);
                }
                else{
                    this.getSpriteManager().setCurrentImage(1);
                }
	}
	
	public boolean getTerisiMakanan(){
		return terisiMakanan;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
                g.drawImage(this.getSpriteManager().getCurrentImage(), (this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX()), (this.getLokasi().getY()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY()), null);
		
		
	}

	@Override
	public void action(int i) {
		// TODO Auto-generated method stub
		
	}
}