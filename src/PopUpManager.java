import java.util.ArrayList;
import java.util.List;

public class PopUpManager  {
	private List<PopUp> list = new ArrayList<>();

	public List<PopUp> getList(){
		return this.list;
	}
	
	public void setList(List<PopUp> list) {
		this.list = list;
	}
}
