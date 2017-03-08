import java.awt.Graphics;
import java.util.Iterator;

public abstract class Tanaman extends Entity implements Drawable{
	String nama = "";
	String status;
	Point lokasi;
	Fase fase;
	String jenis;
	int siramTerakhir;
	PlotLadang plot;
	
	public static enum Fase { //Nambah
		Biji,
		Tunas,
		Tumbuhan,
		Tumbuhan2,
		Panen,
		SudahDipanen
	}
	
	{
		for (Entity plot : this.getEntityManager().getList()){
			if (plot instanceof PlotLadang){
				if (plot.getX() == this.getX() && plot.getY() == this.getY()){
					this.plot = ((PlotLadang)plot);
				}
			}
		}
	}
	
	Tanaman(Stage s) {
        super(s);
    }
	
	Tanaman(Stage s, String nama) {
        super(s);
        this.nama = nama;
    }

	Tanaman(Stage s, String nama, Point lokasi){
		super(s, lokasi.getX(), lokasi.getY());
		this.nama = nama;
		this.fase = Fase.Biji;
		//muncul gambar biji
	}
	
		public void setFase(Fase fase) {
		this.fase = fase;
		switch(this.fase){
		case SudahDipanen :
			this.getSpriteManager().setCurrentImage(7);
			break;
		}
	}

	//@Override
	public abstract void paint(Graphics g);
        /*g.drawImage(this.getSpriteManager().getCurrentImage(),
        (this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX() + 15), 
        (this.getLokasi().getY()*Game.size  + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY() - 3), 
        null);*/

	@Override
	public void action(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean cekDisiram(){
		return this.plot.isWatered();
	}
	
	public void siramTanaman(){
		this.siramTerakhir=0;
	}
	
	public boolean isSiapPanen(){
		return(this.fase == Fase.Panen);
	}
  
    public void updateStatus(){
        this.siramTerakhir++;
        if (siramTerakhir>3){
            this.getEntityManager().getList().remove(this);
        }
    }
    
    public void updateStatus(Iterator iter){
    	this.siramTerakhir++;
    	if (this.plot.isWatered()){
       		this.siramTerakhir = 0;
       		this.siram();
       	}
        if (this.fase != Fase.Biji){
        	if (siramTerakhir>3){
                iter.remove();
            }
        }
    }
	
	public abstract void siram();
	
	
}
