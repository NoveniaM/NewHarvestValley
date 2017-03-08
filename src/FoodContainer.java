import java.awt.Graphics;

public class FoodContainer extends TempatMakan {
    boolean terisiMakanan;
    int width;
    int height;
    {
    		this.setSpriteManager(new SpriteManager("./res/FCCow.png", 1, 2));
	}
	
         public FoodContainer(){
		super();
		this.terisiMakanan = false;
	}
	
	public FoodContainer(Stage s){
		super(s);
		this.terisiMakanan = false;
                this.getSpriteManager().setCurrentImage(1);
	}
        
        public FoodContainer(Stage s, int x, int y){
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
		g.drawImage(this.getSpriteManager().getCurrentImage(), (this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX()), (this.getLokasi().getY()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY()), null);
                //g.setColor(Color.BLUE);
		//g.fillRect((this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX()), (this.getLokasi().getY()*Game.size  + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY()), this.getWidth()*Game.size, this.getHeight()*Game.size);
	}

	@Override
	public void action(int i) {
		// TODO Auto-generated method stub
		
	}

}
