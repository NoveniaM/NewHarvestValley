import java.awt.Graphics;

public abstract class Entity {
	
	//Atribute
	
	private Point lokasi = new Point();
    private int arahHadap = 0; //0 : atas; 1 : kanan; 2 : bawah; 3 : kiri;
    private int height = 1;
    private int width = 1;
    private boolean stepable = false;
    private transient SpriteManager spriteManager;

	private EntityManager manager;
    
    //Method
    
    public Entity(){
    	
    }
    
    public Entity(Stage stage){
    	stage.getEntityManager().getList().add(this);
    	manager = stage.getEntityManager();
    }
    
    public Entity(Stage stage, int x, int y){
    	stage.getEntityManager().getList().add(this);
    	manager = stage.getEntityManager();
    	this.setX(x);
    	this.setY(y);
    }

	public Point getLokasi() {
		return lokasi;
	}
	
	public int getX(){
		return this.lokasi.getX();
	}
	
	public int getY(){
		return this.lokasi.getY();
	}

	public void setLokasi(Point lokasi) {
		this.lokasi = lokasi;
	}
	
	public void setLokasi(int i1, int i2) {
		this.lokasi.setX(i1);
		this.lokasi.setY(i2);
	}
	
	public void setX(int x){
		this.lokasi.setX(x);
	}
	
	public void setY(int y){
		this.lokasi.setY(y);
	}

	public int getArahHadap() {
		return arahHadap;
	}

	public void setArahHadap(int arahHadap) {
		this.arahHadap = arahHadap;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int length) {
		this.height = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public EntityManager getEntityManager() {
		return manager;
	}

	public void setEntityManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public boolean isStepable() {
		return stepable;
	}

	public void setStepable(boolean stepable) {
		this.stepable = stepable;
	}
	
	public SpriteManager getSpriteManager() {
		return spriteManager;
	}

	public void setSpriteManager(SpriteManager spriteManager) {
		this.spriteManager = spriteManager;
	}

	public abstract void paint(Graphics g);
	
	public abstract void action(int i);
}
