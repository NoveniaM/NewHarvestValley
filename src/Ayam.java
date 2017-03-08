public class Ayam extends Hewan {
	
    {
        this.setSpriteManager(new SpriteManager("./res/ayam.png", 4, 4));
    }
    
	public Ayam(Stage s){
		super(s);
	}
	
	public Ayam(Stage s, String nama){
		super(s, nama);
	}
	
	public Ayam(Stage s, String nama, int x, int y){
		super(s, nama, x, y);
	}
	
	public static int jumlahAyam(){
		int temp = 0;
		for (Entity ayam : Game.stageManager.getList().get(3).getEntityManager().getList()){
			if (ayam instanceof Ayam){
				temp++;
			}
		}
		return temp;
	}
}