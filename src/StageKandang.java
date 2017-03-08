import java.util.Iterator;

public class StageKandang extends Stage {
   
	public StageKandang(StageManager stageManager){
    	super(stageManager);
    }
	
	public StageKandang(StageManager stageManager, String nama){
        super(stageManager, nama);
    }
	
	public StageKandang(StageManager stageManager, String nama, int i1, int i2){
        super(stageManager, nama, i1, i2);
    }
    
    public int jumlahMakanan(){
        int temp = 0;
        for (Entity a : (this.getEntityManager().getList())){
            if (a instanceof TempatMakan){
                if ((((TempatMakan)a).getTerisiMakanan()) == true) {
                    temp++;
                }
            }
        }
        return temp;
    }
    
    public void stageGantiHari(){
        int temp = this.jumlahMakanan();
        
        for (Iterator<Entity> iterator = this.getEntityManager().getList().iterator(); iterator.hasNext();) {
            Entity hewan = iterator.next();
            if (hewan instanceof Hewan) {
            	if (temp != 0){ //ada makanan
                    ((Hewan)hewan).updateStatus(true);
                    temp = temp - 1; //pengurangan stok makanan
                } else { //tidak ada makanan
                    ((Hewan)hewan).updateStatus(false, iterator);
                }
            }
        }
    }
}
