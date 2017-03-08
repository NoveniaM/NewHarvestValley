import java.util.ArrayList;
import java.util.List;

public class EntityManager {
	private List<Entity> list = new ArrayList<>();
	
	public List<Entity> getList(){
		return this.list;
	}
	
	public void printList(){
		for (Entity entity : this.list){
			System.out.println(entity);
		}
	}
	
	public Pemain getPemain(){
		Pemain a = null;
		
		if (this.list.size() != 0){
			if (this.list.get(0) != null) {
				if (this.list.get(0) instanceof Pemain){
					a = ((Pemain) this.list.get(0));
				}
			}
		}
		
		return a;
	}
}
