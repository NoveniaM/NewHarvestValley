public class Sapi extends Hewan {

    {
        this.setSpriteManager(new SpriteManager("./res/sapi.png", 4, 4));
    }
	
    
    public Sapi(Stage s) {
        super(s);
    }
	
    public Sapi(Stage s, String nama, int x, int y) {
        super(s, nama, x, y);
    }
	
    public Sapi(Stage s, String nama) {
        super(s, nama);
    }
    
    public static int jumlahSapi(){
		int temp = 0;
		for (Entity sapi : Game.stageManager.getList().get(4).getEntityManager().getList()){
			if (sapi instanceof Sapi){
				temp++;
			}
		}
		return temp;
	}
}

