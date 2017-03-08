import java.util.Iterator;

public class StageLadang extends Stage {

	{
		this.addPlotLadang(25, 4, 20, 20);
	}
	
	public StageLadang(StageManager stageManager){
		super(stageManager);
        Sound sound = new Sound();
	}
	
	public StageLadang(StageManager stageManager, String nama){
    	super(stageManager, nama);
        Sound sound = new Sound();
    }
	
	public StageLadang(StageManager stageManager, String nama, int i1, int i2) {
    	super(stageManager, nama, i1, i2);
        Sound sound = new Sound();
    }
	
	public void addPlotLadang (int x, int y, int width, int height){
		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				this.getEntityManager().getList().add(new PlotLadang(this, i + x, j + y));
			}
		}
	}
    
    public void stageGantiHari(){        
        for (Iterator<Entity> iterator = this.getEntityManager().getList().iterator(); iterator.hasNext();) {
            Entity tanaman = iterator.next();
            if (tanaman instanceof Tanaman) {
            	((Tanaman)tanaman).updateStatus(iterator);
            }
        }
        for (Iterator<Entity> iterator = this.getEntityManager().getList().iterator(); iterator.hasNext();) {
            Entity plot = iterator.next();
            if (plot instanceof PlotLadang) {
            	((PlotLadang) plot).setWatered(false);
            }
        }
    }
}
