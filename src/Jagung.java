import java.awt.Graphics;

public class Jagung extends Tanaman implements Drawable{

	//konstruktor
	{
		this.setSpriteManager(new SpriteManager("./res/Jagung.png", 1, 7));
	}
	
	Jagung(Stage s) {
        super(s);
    }
	
	Jagung(Stage s, String nama) {
        super(s);
        this.nama = nama;
    }

	Jagung(Stage s, String nama, Point lokasi){
		super(s, nama, lokasi);
		//muncul gambar biji
		this.getSpriteManager().setCurrentImage(1);
	}
	
	//siram tanaman, tidak mungkin ada tumbuhan yang layu karena sudah otomatis dihapus ketika hari berganti
	public void siram(){
		//munculin gambar siraman
		//periksa umur terlebih dahulu
		if (this.fase == Fase.SudahDipanen) {
			this.fase=Fase.Panen;
			this.getSpriteManager().setCurrentImage(6);
		}
		else if (this.fase == Fase.Tumbuhan2) {
			this.fase=Fase.Panen;
			this.getSpriteManager().setCurrentImage(6);
		}
		else if (this.fase == Fase.Tumbuhan) {
			this.fase=Fase.Tumbuhan2;
			siramTanaman();
			this.getSpriteManager().setCurrentImage(5);
		}
		else if (this.fase == Fase.Tunas) {
			this.fase=Fase.Tumbuhan;
			siramTanaman();
			this.getSpriteManager().setCurrentImage(4);
		}
		else if (this.fase == Fase.Biji) {
			this.fase=Fase.Tunas;
			siramTanaman();
			this.getSpriteManager().setCurrentImage(3);
		}
	}

	public void paint(Graphics g){
		g.drawImage(this.getSpriteManager().getCurrentImage(),
		        (this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX() + 15), 
		        (this.getLokasi().getY()*Game.size  + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY() - 23), 
		        null);
	}
	
}
