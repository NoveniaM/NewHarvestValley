import java.io.Serializable;

public class Domba extends Hewan {
	
    {
        this.setSpriteManager(new SpriteManager("./res/domba.png", 4, 4));
    }
    
    public Domba(Stage s){
            super(s);
    }

    public Domba(Stage s, String nama){
            super(s, nama);
    }

    public Domba(Stage s, String nama, int x, int y){
            super(s, nama, x, y);
    }
	
    public static int jumlahDomba(){
		int temp = 0;
		for (Entity domba : Game.stageManager.getList().get(4).getEntityManager().getList()){
			if (domba instanceof Domba){
				temp++;
			}
		}
		return temp;
	}
}

