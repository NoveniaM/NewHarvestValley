public class Stage  {
	private String namaStage = "Stage";
	private EntityManager entityManager = new EntityManager();
	private static StageManager stageManager;
	
	public Stage(StageManager stageManager){
    	stageManager.getList().add(this);
    }
	
	public Stage(StageManager stageManager, String nama){
    	stageManager.getList().add(this);
    	this.namaStage = nama;
    }
	
	public Stage(StageManager stageManager, String nama, int i1, int i2){
    	stageManager.getList().add(this);
    	this.namaStage = nama;
    	this.addBorder(i1, i2);
    }
	
	public String getNama(){
		return this.namaStage;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public static StageManager getStageManager() {
		return stageManager;
	}

	public static void setStageManager(StageManager stageManager) {
		Stage.stageManager = stageManager;
	}
	
	public void addBorder(int width, int height){
		for (int i = 0; i <= width; i++){
			this.getEntityManager().getList().add(new Border(i, 0));
		}
		for (int i = 0; i <= height; i++){
			this.getEntityManager().getList().add(new Border(0, i));
		}
		for (int i = 0; i <= height; i++){
			this.getEntityManager().getList().add(new Border(width, i));
		}
		for (int i = 0; i <= width; i++){
			this.getEntityManager().getList().add(new Border(i, height));
		}
	}
}
