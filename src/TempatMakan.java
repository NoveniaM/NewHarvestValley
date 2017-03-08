import java.awt.Graphics;

public class TempatMakan extends Entity{

private boolean terisiMakanan;

	public TempatMakan(){
		super();
		this.terisiMakanan = false;
	}
	
	public TempatMakan(Stage s){
		super(s);
		this.terisiMakanan = false;
	}
        
        public TempatMakan(Stage s, int x, int y){
                super(s, x, y);
                this.terisiMakanan = false;
                
        }
	
	public void setTerisiMakanan(Boolean status){
		this.terisiMakanan = status;
	}
	
	public boolean getTerisiMakanan(){
		return terisiMakanan;
	}
	
	@Override
	public void paint(Graphics g) {
		
	}

	@Override
	public void action(int i) {
		// TODO Auto-generated method stub
		
	}
}