import java.util.ArrayList;
import java.util.List;

public class StageManager {
	private List<Stage> list = new ArrayList<>();
	
	public void printList(){
		for (Stage stage : this.list){
			System.out.println(stage.getNama());
		}
	}

	public List<Stage> getList(){
		return this.list;
	}
	
	public void setList(List<Stage> list) {
		this.list = list;
	}
	
	public Stage getStageWithPemain(){
		Stage temp = null;
		
		for (Stage stage : this.list){
			if (stage.getEntityManager().getList().size() > 0){
				if (stage.getEntityManager().getPemain() != null) {				
					temp = stage;
				}
			}
		}
		
		return temp;
	}
}
