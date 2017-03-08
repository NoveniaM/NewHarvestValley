import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Pemain extends Entity implements Drawable{
	
	//Attribute
	
	private Inventory inventori = new Inventory();
    private Tool[] tools = new Tool[10];
    private int heldTool = 0;
    private int[] toolJum = new int[10];
    String name = "";
    private Gold gold = new Gold();

    Timer t0 = new Timer(30, new Action0());// Move Up
	Timer t1 = new Timer(30, new Action1());// Move Right
	Timer t2 = new Timer(30, new Action2());// Move Down
	Timer t3 = new Timer(30, new Action3());// Move Left
	Timer t4 = new Timer(10, new Action4());// Interact with Tool
	Timer t5 = new Timer(50, new Action5());// Interact without Tool
	Timer t6 = new Timer(50, new Action6());// Show Pop Up Status
    Timer t7 = new Timer(50, new Action7());// Interaksi dengan seller/buyer
    Timer t8 = new Timer(50, new Action8());// Show Pop Up Status
	Timer t10 = new Timer(50, new Action10());// Sleep
	Timer t11 = new Timer(0, new Action11());// Teleport to Ladang
	Timer t12 = new Timer(0, new Action12());// Teleport to Rumah
	Timer t13 = new Timer(0, new Action13());// Teleport to Kandang Ayam
	Timer t14 = new Timer(0, new Action14());// Teleport to Kandang Sapi & Domba
    Timer t15 = new Timer(0, new Action15());// Teleport to Shop                         //!!
    Timer t16 = new Timer(0, new Action16());// Teleport to Jualan
	Timer t20 = new Timer(0, new Action20());
    Timer t21 = new Timer(50, new Action21());
    Timer t22 = new Timer(50, new Action22());
    Timer t23 = new Timer(50, new Action23());
    Timer t24 = new Timer(50, new Action24());
    Timer t25 = new Timer(50, new Action25());
    Timer t26 = new Timer(50, new Action26());
    Timer t27 = new Timer(50, new Action27());
    Timer t28 = new Timer(50, new Action28());
    Timer t29 = new Timer(50, new Action29());
	
	StageManager stageManager;
	PopUpManager popUpManager;
	
	boolean isDoingSomething = false;
	
	//Method
	
	{
		this.setSpriteManager(new SpriteManager("./res/PemainWithTools.png", 9, 4));
		this.getSpriteManager().setCurrentImage(13);
		tools[0] = new Tool(Tool.Nama.Pacul, 0, 1);
		tools[1] = new Tool(Tool.Nama.PenyiramTanaman, 0, 1);
		tools[2] = new Tool(Tool.Nama.Arit, 0, 1);
		tools[3] = new Tool(Tool.Nama.BijiLobak, 0, 10);
		tools[4] = new Tool(Tool.Nama.BijiKol, 0, 10);
		tools[5] = new Tool(Tool.Nama.BijiJagung, 0, 10);
		tools[6] = new Tool(Tool.Nama.BijiLabu, 0, 10);
		tools[7] = new Tool(Tool.Nama.BijiStroberi, 0, 10);
		tools[8] = new Tool(Tool.Nama.Milker, 0, 1);
		tools[9] = new Tool(Tool.Nama.Clippers, 0, 1);
	}
	
	//Konstruktor
	Pemain(Stage s, PopUpManager popUpManager) {
		s.getEntityManager().getList().add(0, this);
    	this.setEntityManager(s.getEntityManager());
    	this.popUpManager = popUpManager;
    }
	
	Pemain(Stage s, PopUpManager popUpManager, String nama, int x, int y) {
		s.getEntityManager().getList().add(0, this);
    	this.setEntityManager(s.getEntityManager());
    	this.popUpManager = popUpManager;
		this.setX(x);
		this.setY(y);
		this.name = nama;
    }
	
	public String getName() {
		return name;
	}

	public void setName(String nama) {
		this.name = nama;
	}

	public Gold getGold() {
		return gold;
	}

	public void setGold(Gold gold) {
		this.gold = gold;
	}

	//Setter Getter untuk Item dan Tool
	public int[] getJumlahTool(int lokasiBiji, int jumlahBiji){
		
        for (int i = lokasiBiji; i < lokasiBiji + jumlahBiji; i++){
            this.toolJum[i] = this.tools[i].getJumlah();
        }
        return this.toolJum;
	}
	
	public int getHeldTool() {
		return heldTool;
	}

	public void setHeldTool(int heldTool) {
		this.heldTool = heldTool;
	}

	public Inventory getInventori() {
		return inventori;
	}

	public Tool[] getTools() {
		return tools;
	}

	public void setTools(Tool[] tools) {
		this.tools = tools;
	}

	//Action yang dapat dilakukan pemain
	public void action(int i){
		//Yang hanya satu kegiatan satu waktu
		if(!isDoingSomething){
			switch(i){
			case 0: //Move Up
				isDoingSomething = true;
				t0.start();
				break;
			case 1: //Move Right
				isDoingSomething = true;
				t1.start();
				break;
			case 2: //Move Down
				isDoingSomething = true;
				t2.start();
				break;
			case 3: //Move Left
				isDoingSomething = true;
				t3.start();
				break;
			case 4: //Interact with tool
				isDoingSomething = true;
				t4.start();
				break;
			case 5: //Interact without tool
				isDoingSomething = true;
				t5.start();
				break;
	        case 7: //interaksi dengan buyer/seller
                isDoingSomething = true;
                t7.start();
                break;
	        case 20:
                isDoingSomething = true;
                t20.start();
                break;
	        case 21:
                isDoingSomething = true;
                t21.start();
                break;
	        case 22:
                isDoingSomething = true;
                t22.start();
                break;
	        case 23:
                isDoingSomething = true;
                t23.start();
                break;
	        case 24:
                isDoingSomething = true;
                t24.start();
                break;
	        case 25:
                isDoingSomething = true;
                t25.start();
                break;
	        case 26:
                isDoingSomething = true;
                t26.start();
                break;
	        case 27:
                isDoingSomething = true;
                t27.start();
                break;
	        case 28:
                isDoingSomething = true;
                t28.start();
                break;
	        case 29:
                isDoingSomething = true;
                t29.start();
                break;
			}

		}
		//Yang bisa barengan
		switch(i){
		case 6: //Show Status Pemain
			isDoingSomething = true;
			t6.start();
			break;
        case 8: //Show Status Pemain
			isDoingSomething = true;
			t8.start();
			break;
		case 10: //Bobok
			t10.start();
			break;

		}
	}

	
	
	//Bagian UI Pemain
	
	private int pemainDisplayedX(){
		return Game.d.width/2 - (this.getWidth()*Game.size/2);
	}
	
	private int pemainDisplayedY(){
		return Game.d.height/2 - (this.getWidth()*Game.size/2);
	}
	
	public int distanceDisplayedX(){
		return this.pemainDisplayedX() - this.getX()*Game.size + dx;
	}
	
	public int distanceDisplayedY(){
		return this.pemainDisplayedY() - this.getY()*Game.size + dy;
	}
	
	public boolean inFrontOfPemain(Entity s){
        boolean temp = false;
        
        switch (this.getArahHadap()){
            case 0 :
                temp = ((s.getX() <= this.getX() && s.getX() + s.getHeight() - 1 >= this.getX()) && (s.getY() <= this.getY() - 1) && s.getY()+ s.getWidth() - 1 >= this.getY() - 1);
                break;
            case 1 :
                temp = ((s.getX() <= this.getX() + 1 && s.getX() + s.getHeight() - 1 >= this.getX() + 1) && (s.getY() <= this.getY()) && s.getY()+ s.getWidth() - 1 >= this.getY());
                break;
            case 2 : 
                temp = ((s.getX() <= this.getX() && s.getX() + s.getHeight() - 1 >= this.getX()) && (s.getY() <= this.getY() + 1) && s.getY()+ s.getWidth() - 1 >= this.getY() + 1);
                break;
            case 3 : 
                temp = ((s.getX() <= this.getX() - 1 && s.getX() + s.getHeight() - 1 >= this.getX() - 1) && (s.getY() <= this.getY()) && s.getY() + s.getWidth() - 1 >= this.getY());
                break;    
        }
        
        return temp;
    }
    
    public Entity entityDepanPemain(EntityManager manager){
        Entity temp = null;
        
        for(Entity entity : manager.getList()){
        	if (inFrontOfPemain(entity)){
                temp = entity;
            }
        }
        return temp;
    }
    
	@Override
	public void paint(Graphics g) {
		g.drawImage(this.getSpriteManager().getCurrentImage(), this.pemainDisplayedX() + ((Game.size/2) - (this.getSpriteManager().getCurrentImage().getWidth()/2)), this.pemainDisplayedY() + ((Game.size/2) - (this.getSpriteManager().getCurrentImage().getHeight()/2)), null);
	}
	
	
	//Attribut for display
	int dx = 0, dy = 0;
	int moveCount = 0;
	int moveNumber = 4;
	
	private class Action0 implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (Pemain.this.getArahHadap() == 0){
				if (Pemain.this.entityDepanPemain(Pemain.this.getEntityManager()) == null || Pemain.this.entityDepanPemain(Pemain.this.getEntityManager()).isStepable()){
					Pemain.this.moveCount++;
					Pemain.this.getSpriteManager().setCurrentImage(13 + moveCount);
					dy += Game.size / Pemain.this.moveNumber;
				} else {
					Pemain.this.isDoingSomething = false;
					Pemain.this.getSpriteManager().setCurrentImage(13);
					t0.stop();
				}
				
				if (Pemain.this.moveCount == Pemain.this.moveNumber) {
					Pemain.this.setY(Pemain.this.getY() - 1);
					Pemain.this.moveCount = 0;
					Pemain.this.isDoingSomething = false;
					dy = 0;
					Pemain.this.getSpriteManager().setCurrentImage(13);
					t0.stop();
				}
			} else {
				Pemain.this.setArahHadap(0);
				Pemain.this.isDoingSomething = false;
				Pemain.this.getSpriteManager().setCurrentImage(13);
				t0.stop();
			}
		}
	}
	
	private class Action1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (Pemain.this.getArahHadap() == 1){
				if (Pemain.this.entityDepanPemain(Pemain.this.getEntityManager()) == null || Pemain.this.entityDepanPemain(Pemain.this.getEntityManager()).isStepable()){
					Pemain.this.moveCount++;
					Pemain.this.getSpriteManager().setCurrentImage(9 + moveCount);
					dx -= Game.size / Pemain.this.moveNumber;
				} else {
					Pemain.this.isDoingSomething = false;
					Pemain.this.getSpriteManager().setCurrentImage(9);
					t1.stop();
				}
				
				if (Pemain.this.moveCount == Pemain.this.moveNumber) {
					Pemain.this.setX(Pemain.this.getX() + 1);
					Pemain.this.moveCount = 0;
					Pemain.this.isDoingSomething = false;
					dx = 0;
					Pemain.this.getSpriteManager().setCurrentImage(9);
					t1.stop();
				}
			} else {
				Pemain.this.setArahHadap(1);
				Pemain.this.isDoingSomething = false;
				Pemain.this.getSpriteManager().setCurrentImage(9);
				t1.stop();
			}
		}
		
	}
	
	private class Action2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (Pemain.this.getArahHadap() == 2){
				if (Pemain.this.entityDepanPemain(Pemain.this.getEntityManager()) == null || Pemain.this.entityDepanPemain(Pemain.this.getEntityManager()).isStepable()){
					Pemain.this.moveCount++;
					Pemain.this.getSpriteManager().setCurrentImage(1 + moveCount);
					dy -= Game.size / Pemain.this.moveNumber;
				} else {
					Pemain.this.isDoingSomething = false;
					Pemain.this.getSpriteManager().setCurrentImage(1);
					t2.stop();
				}
				
				if (Pemain.this.moveCount == Pemain.this.moveNumber) {
					Pemain.this.setY(Pemain.this.getY() + 1);
					Pemain.this.moveCount = 0;
					Pemain.this.isDoingSomething = false;
					dy = 0;
					Pemain.this.getSpriteManager().setCurrentImage(1);
					t2.stop();
				}
			} else {
				Pemain.this.setArahHadap(2);
				Pemain.this.isDoingSomething = false;
				Pemain.this.getSpriteManager().setCurrentImage(1);
				t2.stop();
			}
			
		}
		
	}
	
	private class Action3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (Pemain.this.getArahHadap() == 3){
				if (Pemain.this.entityDepanPemain(Pemain.this.getEntityManager()) == null || Pemain.this.entityDepanPemain(Pemain.this.getEntityManager()).isStepable()){
					Pemain.this.moveCount++;
					Pemain.this.getSpriteManager().setCurrentImage(5 + moveCount);
					dx += Game.size / Pemain.this.moveNumber;
				} else {
					Pemain.this.isDoingSomething = false;
					Pemain.this.getSpriteManager().setCurrentImage(5);
					t3.stop();
				}
				
				if (Pemain.this.moveCount == Pemain.this.moveNumber) {
					Pemain.this.setX(Pemain.this.getX() - 1);
					Pemain.this.moveCount = 0;
					Pemain.this.isDoingSomething = false;
					dx = 0;
					Pemain.this.getSpriteManager().setCurrentImage(5);
					t3.stop();
				} 
			} else {
				Pemain.this.setArahHadap(3);
				Pemain.this.isDoingSomething = false;
				Pemain.this.getSpriteManager().setCurrentImage(5);
				t3.stop();
			}
		}
		
	}
	
	//Interact with Tool
	private class Action4 implements ActionListener{
		private int animationduration = 8;
		private int animationcount = 0;
		private boolean actiondone = false;
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!actiondone){
				if (Pemain.this.entityDepanPemain(getEntityManager()) != null){
					
					Entity entity = Pemain.this.entityDepanPemain(getEntityManager());
					
					switch(Pemain.this.heldTool){
					
					case 0:// Pacul
						if (entity instanceof PlotLadang){
							((PlotLadang) entity).setPlantable(true);
							new PaculSound();
							switch (Pemain.this.getArahHadap()){
							case 0:
								Pemain.this.getSpriteManager().setCurrentImage(19);
								break;
							case 1:
								Pemain.this.getSpriteManager().setCurrentImage(20);
								break;
							case 2:
								Pemain.this.getSpriteManager().setCurrentImage(17);
								break;
							case 3:
								Pemain.this.getSpriteManager().setCurrentImage(18);
								break;
							}
						}
						break;
					case 1:// Penyiram Tanaman
						if (entity instanceof PlotLadang){
							if (((PlotLadang) entity).getPlantable()){
								((PlotLadang) entity).setWatered(true);
								new SiramSound();
								switch (Pemain.this.getArahHadap()){
								case 0:
									Pemain.this.getSpriteManager().setCurrentImage(23);
									break;
								case 1:
									Pemain.this.getSpriteManager().setCurrentImage(24);
									break;
								case 2:
									Pemain.this.getSpriteManager().setCurrentImage(21);
									break;
								case 3:
									Pemain.this.getSpriteManager().setCurrentImage(22);
									break;
								}
							}
						}
						if (entity instanceof Tanaman){
							((Tanaman) entity).plot.setWatered(true);
							new SiramSound();
							switch (Pemain.this.getArahHadap()){
							case 0:
								Pemain.this.getSpriteManager().setCurrentImage(23);
								break;
							case 1:
								Pemain.this.getSpriteManager().setCurrentImage(24);
								break;
							case 2:
								Pemain.this.getSpriteManager().setCurrentImage(21);
								break;
							case 3:
								Pemain.this.getSpriteManager().setCurrentImage(22);
								break;
							}
						}          
						break;
					case 2:// Arit
						if (entity instanceof Tanaman){
							Pemain.this.getEntityManager().getList().remove(entity);
							AritSound arit = new AritSound();
							switch (Pemain.this.getArahHadap()){
							case 0:
								Pemain.this.getSpriteManager().setCurrentImage(27);
								break;
							case 1:
								Pemain.this.getSpriteManager().setCurrentImage(28);
								break;
							case 2:
								Pemain.this.getSpriteManager().setCurrentImage(25);
								break;
							case 3:
								Pemain.this.getSpriteManager().setCurrentImage(26);
								break;
							}
						}              
						break;
					case 3:// Biji Lobak
						Pemain.this.tools[3].setJumlah(Pemain.this.tools[3].getJumlah()-1);
						if (Pemain.this.tools[3].getJumlah() > 0){
							if (entity instanceof PlotLadang){
								if (((PlotLadang) entity).getPlantable()){
									new Lobak(Game.getFocusedStage(), "Lobak", entity.getLokasi());
									TanamSound tanam = new TanamSound();
									switch (Pemain.this.getArahHadap()){
									case 0:
										Pemain.this.getSpriteManager().setCurrentImage(31);
										break;
									case 1:
										Pemain.this.getSpriteManager().setCurrentImage(32);
										break;
									case 2:
										Pemain.this.getSpriteManager().setCurrentImage(29);
										break;
									case 3:
										Pemain.this.getSpriteManager().setCurrentImage(30);
										break;
									}
								}
							}
						}  
						break;
					case 4:// Biji Kol
						Pemain.this.tools[4].setJumlah(Pemain.this.tools[4].getJumlah()-1);
						if (Pemain.this.tools[4].getJumlah() > 0){
							if (entity instanceof PlotLadang){
								if (((PlotLadang) entity).getPlantable()){
									new Kol(Game.getFocusedStage(), "Kol", entity.getLokasi());
									TanamSound tanam2 = new TanamSound();
									switch (Pemain.this.getArahHadap()){
									case 0:
										Pemain.this.getSpriteManager().setCurrentImage(31);
										break;
									case 1:
										Pemain.this.getSpriteManager().setCurrentImage(32);
										break;
									case 2:
										Pemain.this.getSpriteManager().setCurrentImage(29);
										break;
									case 3:
										Pemain.this.getSpriteManager().setCurrentImage(30);
										break;
									}
								}
							}
						}      
						break;
					case 5://Biji Jagung
						Pemain.this.tools[5].setJumlah(Pemain.this.tools[5].getJumlah()-1);
						if (Pemain.this.tools[5].getJumlah() > 0){
							if (entity instanceof PlotLadang){
								if (((PlotLadang) entity).getPlantable()){
									new Jagung(Game.getFocusedStage(), "Jagung", entity.getLokasi());
									TanamSound tanam3 = new TanamSound();
									switch (Pemain.this.getArahHadap()){
									case 0:
										Pemain.this.getSpriteManager().setCurrentImage(31);
										break;
									case 1:
										Pemain.this.getSpriteManager().setCurrentImage(32);
										break;
									case 2:
										Pemain.this.getSpriteManager().setCurrentImage(29);
										break;
									case 3:
										Pemain.this.getSpriteManager().setCurrentImage(30);
										break;
									}
								}
							}
						}
						break;
					case 6://Biji Labu
						Pemain.this.tools[6].setJumlah(Pemain.this.tools[6].getJumlah()-1);
						if (Pemain.this.tools[6].getJumlah() > 0){
							if (entity instanceof PlotLadang){
								if (((PlotLadang) entity).getPlantable()){
									new Labu(Game.getFocusedStage(), "Labu", entity.getLokasi());
									TanamSound tanam4 = new TanamSound();
									switch (Pemain.this.getArahHadap()){
									case 0:
										Pemain.this.getSpriteManager().setCurrentImage(31);
										break;
									case 1:
										Pemain.this.getSpriteManager().setCurrentImage(32);
										break;
									case 2:
										Pemain.this.getSpriteManager().setCurrentImage(29);
										break;
									case 3:
										Pemain.this.getSpriteManager().setCurrentImage(30);
										break;
									}
								}
							}
						}
						break;
					case 7:// Biji Stroberi
						Pemain.this.tools[7].setJumlah(Pemain.this.tools[7].getJumlah()-1);
						if (Pemain.this.tools[7].getJumlah() > 0){
							if (entity instanceof PlotLadang){
								if (((PlotLadang) entity).getPlantable()){
									new Stroberi(Game.getFocusedStage(), "Stroberi", entity.getLokasi());
									TanamSound tanam5 = new TanamSound();
									switch (Pemain.this.getArahHadap()){
									case 0:
										Pemain.this.getSpriteManager().setCurrentImage(31);
										break;
									case 1:
										Pemain.this.getSpriteManager().setCurrentImage(32);
										break;
									case 2:
										Pemain.this.getSpriteManager().setCurrentImage(29);
										break;
									case 3:
										Pemain.this.getSpriteManager().setCurrentImage(30);
										break;
									}
								}
							}
						}
						break;
					case 8:// Milker
						if(entity instanceof Sapi){
							if (((Sapi) entity).isSiapPanen()){
								if (!((Sapi) entity).isSudahDipanen()){
									((Sapi) entity).setSudahDipanen(true);
									Pemain.this.getInventori().addItem(Item.Nama.SUSU);
									MilkerSound milker = new MilkerSound();
									switch (Pemain.this.getArahHadap()){
									case 0:
										Pemain.this.getSpriteManager().setCurrentImage(35);
										break;
									case 1:
										Pemain.this.getSpriteManager().setCurrentImage(36);
										break;
									case 2:
										Pemain.this.getSpriteManager().setCurrentImage(33);
										break;
									case 3:
										Pemain.this.getSpriteManager().setCurrentImage(34);
										break;
									}
								}
							}
						}
						break;
					case 9:// Clipper
						if(entity instanceof Domba){
							if (((Domba) entity).isSiapPanen()){
								if (!((Domba) entity).isSudahDipanen()){
									((Domba) entity).setSudahDipanen(true);
									Pemain.this.getInventori().addItem(Item.Nama.WOL);
									ClipperSound clipper = new ClipperSound();
									switch (Pemain.this.getArahHadap()){
									case 0:
										Pemain.this.getSpriteManager().setCurrentImage(35);
										break;
									case 1:
										Pemain.this.getSpriteManager().setCurrentImage(36);
										break;
									case 2:
										Pemain.this.getSpriteManager().setCurrentImage(33);
										break;
									case 3:
										Pemain.this.getSpriteManager().setCurrentImage(34);
										break;
									}
								}
							}
						}            
						break;
					}					
				}
				actiondone = true;
			}
			
			animationcount++;
			
			if (animationcount == animationduration) {
				animationcount = 0;
				actiondone = false;
				switch (Pemain.this.getArahHadap()){
				case 0:
					Pemain.this.getSpriteManager().setCurrentImage(13);
					break;
				case 1:
					Pemain.this.getSpriteManager().setCurrentImage(9);
					break;
				case 2:
					Pemain.this.getSpriteManager().setCurrentImage(1);
					break;
				case 3:
					Pemain.this.getSpriteManager().setCurrentImage(5);
					break;
				}
				Pemain.this.isDoingSomething = false;
				t4.stop();
			} 
			
		}
		
	}
	
	//Interact without Tool
	private class Action5 implements ActionListener{ 
		private int animationduration = 8;
		private int animationcount = 0;
		private boolean panen = false;
		@Override
		public void actionPerformed(ActionEvent e) {
			
			animationcount++;
			
			if (Pemain.this.entityDepanPemain(getEntityManager()) != null){
				
				Entity entity = Pemain.this.entityDepanPemain(getEntityManager());
				
				//Interaksi dengan pintu
				if (entity instanceof Pintu){

					//Kalau tujuannya Ladang
					if (((Pintu) entity).getTujuan() == Game.stageManager.getList().get(1)){
						t11.start();
						Game.state=Game.State.Game;
						//Kalau dari Rumah
						if (((Pintu) Pemain.this.entityDepanPemain(getEntityManager())).getDari() == Game.stageManager.getList().get(2)){
							Pemain.this.setLokasi(17, 6);
						}
						//Kalau dari Kandang Ayam
						if (((Pintu) entity).getDari() == Game.stageManager.getList().get(3)){
							Pemain.this.setLokasi(41, 37);
						}
						//Kalau dari Kandang Sapi & Domba
						if (((Pintu) entity).getDari() == Game.stageManager.getList().get(4)){
							Pemain.this.setLokasi(7, 30);
						}
                        //Kalau dari Shop
						if (((Pintu) entity).getDari() == Game.stageManager.getList().get(5)){
							Pemain.this.setLokasi(16, 16);
						}
                        //Kalau dari Jualan
						if (((Pintu) entity).getDari() == Game.stageManager.getList().get(6)){
							Pemain.this.setLokasi(5, 19);
						}
					}

					//Kalau tujuannya Rumah
					if (((Pintu) entity).getTujuan() == Game.stageManager.getList().get(2)){
						t12.start();
						Pemain.this.setLokasi(3, 6);
					}

					//Kalau tujuannya Kandang Ayam
					if (((Pintu) entity).getTujuan() == Game.stageManager.getList().get(3)){
						t13.start();
						Pemain.this.setLokasi(8, 9);
					}

					//Kalau tujuannya Kandang Sapi & Domba
					if (((Pintu) entity).getTujuan() == Game.stageManager.getList().get(4)){
						t14.start();
						Pemain.this.setLokasi(8, 9);
					}

                    //Kalau tujuannya Shop
					if (((Pintu) entity).getTujuan() == Game.stageManager.getList().get(5)){
						t15.start();
						Pemain.this.setLokasi(3, 6);
                        //Game.state=Game.State.Shop;
					}

                    //Kalau tujuannya Jualan
					if (((Pintu) entity).getTujuan() == Game.stageManager.getList().get(6)){
						t16.start();
						Pemain.this.setLokasi(3, 6);
						//Game.state=Game.State.Sell;
					}

                    if ((Game.getFocusedStage()==Game.stageManager.getList().get(2))&&(Pemain.this.getX()==2)&&(Pemain.this.getY()==2)){
                        t10.start();
                    }

					
				}
				
				if((entity instanceof TempatMakan) && (Game.getFocusedStage() == Game.stageManager.getList().get(3))){
                                    if(Pemain.this.getInventori().getJumlahItemIni(Item.Nama.MAKANANAYAM) > 0){
                                        ((TempatMakan)entity).setTerisiMakanan(true);
                                        Pemain.this.getInventori().getThisItem(Item.Nama.MAKANANAYAM).setJumlah((Pemain.this.getInventori().getThisItem(Item.Nama.MAKANANAYAM).getJumlah())-1);
                                        if (Pemain.this.getInventori().getThisItem(Item.Nama.MAKANANAYAM).getJumlah()==0){
                                            Pemain.this.getInventori().remove(Item.Nama.MAKANANAYAM);
                                        }
                                    }    
				}
                        else if ((entity instanceof TempatMakan) && (Game.getFocusedStage() == Game.stageManager.getList().get(4))){
                            if(Pemain.this.getInventori().getJumlahItemIni(Item.Nama.MAKANANTERNAK) > 0){
                                ((TempatMakan)entity).setTerisiMakanan(true);
                                Pemain.this.getInventori().getThisItem(Item.Nama.MAKANANTERNAK).setJumlah((Pemain.this.getInventori().getThisItem(Item.Nama.MAKANANTERNAK).getJumlah())-1);
                                if (Pemain.this.getInventori().getThisItem(Item.Nama.MAKANANTERNAK).getJumlah()==0){
                                    Pemain.this.getInventori().remove(Item.Nama.MAKANANTERNAK);
                                }
                            }
               }
                                
                                
				if(entity instanceof Ayam){
					if (((Ayam) entity).isSiapPanen()){
						if (!((Ayam) entity).isSudahDipanen()){
							((Ayam) entity).setSudahDipanen(true);
							Pemain.this.getInventori().addItem(Item.Nama.TELUR);
						}
					}
					Pemain.this.getInventori().printList();
				}
				
				if (entity instanceof Decorative){
					if(((Decorative) entity).kategori == "bed"){
						t10.start();
					}
				}
				
				if(entity instanceof Tanaman){
					panen = true;
					switch (Pemain.this.getArahHadap()){
					case 0:
						Pemain.this.getSpriteManager().setCurrentImage(35);
						break;
					case 1:
						Pemain.this.getSpriteManager().setCurrentImage(36);
						break;
					case 2:
						Pemain.this.getSpriteManager().setCurrentImage(33);
						break;
					case 3:
						Pemain.this.getSpriteManager().setCurrentImage(34);
						break;
					}
				}
				
				if(entity instanceof Lobak){
					if (((Lobak) entity).isSiapPanen()){
						entity.getEntityManager().getList().remove(entity);
						Pemain.this.getInventori().addItem(Item.Nama.LOBAK);
					}
				}
				
				if(entity instanceof Kol){
					if (((Kol) entity).isSiapPanen()){
						entity.getEntityManager().getList().remove(entity);
						Pemain.this.getInventori().addItem(Item.Nama.KOL);
					}
				}
				
				if(entity instanceof Labu){
					if (((Labu) entity).isSiapPanen()){
						entity.getEntityManager().getList().remove(entity);
						Pemain.this.getInventori().addItem(Item.Nama.LABU);
					}
				}
				
				if(entity instanceof Jagung){
					if (((Jagung) entity).isSiapPanen()){
						((Jagung) entity).setFase(Tanaman.Fase.SudahDipanen);
						Pemain.this.getInventori().addItem(Item.Nama.JAGUNG);
					}
				}
				
				if(entity instanceof Stroberi){
					if (((Stroberi) entity).isSiapPanen()){
						((Stroberi) entity).setFase(Tanaman.Fase.SudahDipanen);
						Pemain.this.getInventori().addItem(Item.Nama.STROBERI);
					}
				}
				
				if (!panen || animationcount == animationduration){
					Pemain.this.isDoingSomething = false;
					switch (Pemain.this.getArahHadap()){
					case 0:
						Pemain.this.getSpriteManager().setCurrentImage(13);
						break;
					case 1:
						Pemain.this.getSpriteManager().setCurrentImage(9);
						break;
					case 2:
						Pemain.this.getSpriteManager().setCurrentImage(1);
						break;
					case 3:
						Pemain.this.getSpriteManager().setCurrentImage(5);
						break;
					}
					animationcount = 0;
					t5.stop();
				}
			}			
		}
	}
	
	//Show Pop Up Status
        private class Action6 implements ActionListener{ 
                @Override
                public void actionPerformed(ActionEvent e) {

                        for (PopUp popUp : Pemain.this.popUpManager.getList()){
                                if (popUp instanceof PopUpStatusPemain){
                                        popUp.setViewed(!popUp.isViewed());
                                }
                                if (popUp.isViewed() == false){
                                        Pemain.this.isDoingSomething = false;

                                }
                        }
                        t6.stop();
                }
        }

        private class Action7 implements ActionListener{
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if ((Pemain.this.getX() == 1) && (Pemain.this.getY() == 4) && (Game.getFocusedStage() == Game.stageManager.getList().get(5)) && (Game.getPemain().getArahHadap() == 0)){
                            for (PopUp popUp : Pemain.this.popUpManager.getList()){ //muncul dialog
                                if (popUp instanceof PopUpDialogBeliBiji){
                                    popUp.setViewed(!popUp.isViewed());
                                    if(popUp.isViewed()){
                                    	Game.state = Game.State.Shop;
                                    } else {
                                    	Game.state = Game.State.Game;
                                    }
                                }
                                if (popUp.isViewed() == false){
                                    Pemain.this.isDoingSomething = false;
                                }
                            }       
                            System.out.println("Mau beli biji");
                            System.out.println("Game state:"+ Game.state);
                        Pemain.this.isDoingSomething = false;
                        t7.stop();
                        }
                        else if ((Pemain.this.getX() == 4) && (Pemain.this.getY() == 4) && (Game.getFocusedStage() == Game.stageManager.getList().get(5)) && (Game.getPemain().getArahHadap() == 0)){
                                for (PopUp popUp : Pemain.this.popUpManager.getList()){ //muncul dialog
                                    if (popUp instanceof PopUpDialogBeliMakananTernak){
                                        popUp.setViewed(!popUp.isViewed());
                                        if(popUp.isViewed()){
                                        	Game.state = Game.State.Shop;
                                        } else {
                                        	Game.state = Game.State.Game;
                                        }
                                    }
                                        if (popUp.isViewed() == false){
                                            Pemain.this.isDoingSomething = false;
                                        }
                                }
                                System.out.println("Mau beli makanan hewan");
                                System.out.println("Game state:"+ Game.state);
                        Pemain.this.isDoingSomething = false;
			t7.stop();        
                        }
                        else if ((Pemain.this.getX() == 7) && (Pemain.this.getY() == 4) && (Game.getFocusedStage() == Game.stageManager.getList().get(5)) && (Game.getPemain().getArahHadap() == 0)){
                                for (PopUp popUp : Pemain.this.popUpManager.getList()){//muncul dialog box hewan ternak
                                    if (popUp instanceof PopUpDialogBeliHewan){
                                        popUp.setViewed(!popUp.isViewed());
                                        if(popUp.isViewed()){
                                        	Game.state = Game.State.Shop;
                                        } else {
                                        	Game.state = Game.State.Game;
                                        }
                                    }
                                        if (popUp.isViewed() == false){
                                            Pemain.this.isDoingSomething = false;
                                        }
                                }
                                System.out.println("Mau beli hewan");
                                System.out.println("Game state:"+ Game.state);
                        Pemain.this.isDoingSomething = false;
			t7.stop();        
                        }
                        else if ((Pemain.this.getX() == 4) && (Pemain.this.getY() == 4) && (Game.getFocusedStage() == Game.stageManager.getList().get(6)) && (Game.getPemain().getArahHadap() == 0)){
                                //muncul dialog box untuk jual hasil ternak
                                for (PopUp popUp : Pemain.this.popUpManager.getList()){//muncul dialog box hewan ternak
                                    if (popUp instanceof PopUpDialogJualHasilTernak){
                                        popUp.setViewed(!popUp.isViewed());
                                        if(popUp.isViewed()){
                                        	Game.state = Game.State.Sell;
                                        } else {
                                        	Game.state = Game.State.Game;
                                        }
                                    }
                                        if (popUp.isViewed() == false){
                                            Pemain.this.isDoingSomething = false;
                                        }
                                }
                                System.out.println("Mau jual panen hewan");
                        Pemain.this.isDoingSomething = false;
			t7.stop();        
                        }
                        else if ((Pemain.this.getX() == 8) && (Pemain.this.getY() == 4) && (Game.getFocusedStage() == Game.stageManager.getList().get(6)) && (Game.getPemain().getArahHadap() == 0)){
                                //muncul dialog box untuk jual hasil panen
                                for (PopUp popUp : Pemain.this.popUpManager.getList()){//muncul dialog box hewan ternak
                                    if (popUp instanceof PopUpDialogJualHasilPanen){
                                        popUp.setViewed(!popUp.isViewed());
                                        if(popUp.isViewed()){
                                        	Game.state = Game.State.Sell;
                                        } else {
                                        	Game.state = Game.State.Game;
                                        }
                                    }
                                        if (popUp.isViewed() == false){
                                            Pemain.this.isDoingSomething = false;
                                        }
                                }
                                System.out.println("Mau beli hasil panen");
                        Pemain.this.isDoingSomething = false;
                        t7.stop();        
                        }
                        Pemain.this.isDoingSomething = false;
                        t7.stop(); 
                }
                    
        }
        //Show Map
        private class Action8 implements ActionListener{ 
                @Override
                public void actionPerformed(ActionEvent e) {

                        for (PopUp popUp : Pemain.this.popUpManager.getList()){
                                if (popUp instanceof PopUpPeta){
                                        popUp.setViewed(!popUp.isViewed());
                                }
                                if (popUp.isViewed() == false){
                                        Pemain.this.isDoingSomething = false;

                                }
                        }
                        t8.stop();
                }
        }
        
	private class Action10 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.waktu.tidur();
			for (Stage stage : Game.stageManager.getList()){
				if (stage instanceof StageLadang){
					((StageLadang) stage).stageGantiHari();
				}
				
				if (stage instanceof StageKandang){
					((StageKandang) stage).stageGantiHari();
				}
                        
			}
            for(Entity tempatmakan : Game.stageManager.getList().get(3).getEntityManager().getList()){
                if (tempatmakan instanceof TempatMakan){
                    ((TempatMakan) tempatmakan).setTerisiMakanan(false);
                }
            }
            for(Entity tempatmakan : Game.stageManager.getList().get(4).getEntityManager().getList()){
                if (tempatmakan instanceof TempatMakan){
                    ((TempatMakan) tempatmakan).setTerisiMakanan(false);
                }
            }
                          
			t10.stop();
		}
	}
		
	private class Action11 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.getFocusedStage().getEntityManager().getList().remove(0);
			Game.setFocusedStage(Stage.getStageManager().getList().get(1));
			if (Game.getFocusedStage().getEntityManager().getPemain() == null){
				Game.getFocusedStage().getEntityManager().getList().add(0, Pemain.this);
			}
            new Sound2();
			Pemain.this.setEntityManager(Game.getFocusedStage().getEntityManager());
			Game.waktu.setFlow(true);
			t11.stop();
		}
	}
	
	private class Action12 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.getFocusedStage().getEntityManager().getList().remove(0);
			Game.setFocusedStage(Stage.getStageManager().getList().get(2));
			if (Game.getFocusedStage().getEntityManager().getPemain() == null){
				Game.getFocusedStage().getEntityManager().getList().add(0, Pemain.this);
			}
                        Sound2 sound2 = new Sound2();
			Pemain.this.setEntityManager(Game.getFocusedStage().getEntityManager());
			Game.waktu.setFlow(false);
			t12.stop();
		}
	}
	
	private class Action13 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.getFocusedStage().getEntityManager().getList().remove(0);
			Game.setFocusedStage(Stage.getStageManager().getList().get(3));
			if (Game.getFocusedStage().getEntityManager().getPemain() == null){
				Game.getFocusedStage().getEntityManager().getList().add(0, Pemain.this);
			}
                        Sound2 sound2 = new Sound2();
                        ChickenSound soundc = new ChickenSound();
			Pemain.this.setEntityManager(Game.getFocusedStage().getEntityManager());
			Game.waktu.setFlow(false);
			t13.stop();
		}
	}
	
	private class Action14 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.getFocusedStage().getEntityManager().getList().remove(0);
			Game.setFocusedStage(Stage.getStageManager().getList().get(4));
			if (Game.getFocusedStage().getEntityManager().getPemain() == null){
				Game.getFocusedStage().getEntityManager().getList().add(0, Pemain.this);
			}
                        Sound2 sound2 = new Sound2();
                        CowSound soundc = new CowSound();
                        SheepSound sounds = new SheepSound();
			Pemain.this.setEntityManager(Game.getFocusedStage().getEntityManager());
			Game.waktu.setFlow(false);
			t14.stop();
		}
	}
        
        private class Action15 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.getFocusedStage().getEntityManager().getList().remove(0);
			Game.setFocusedStage(Stage.getStageManager().getList().get(5));
			if (Game.getFocusedStage().getEntityManager().getPemain() == null){
				Game.getFocusedStage().getEntityManager().getList().add(0, Pemain.this);
			}
                        Sound2 sound2 = new Sound2();
			Pemain.this.setEntityManager(Game.getFocusedStage().getEntityManager());
			Game.waktu.setFlow(false);
			t15.stop();
		}
	}
        
        private class Action16 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Game.getFocusedStage().getEntityManager().getList().remove(0);
			Game.setFocusedStage(Stage.getStageManager().getList().get(6));
			if (Game.getFocusedStage().getEntityManager().getPemain() == null){
				Game.getFocusedStage().getEntityManager().getList().add(0, Pemain.this);
			}
                        Sound2 sound2 = new Sound2();
			Pemain.this.setEntityManager(Game.getFocusedStage().getEntityManager());
			Game.waktu.setFlow(false);
			t16.stop();
		}
	}
        
        private class Action20 implements ActionListener{ //kalo pilih key 1
                @Override
                public void actionPerformed(ActionEvent e){
                        System.out.println("Coba1 sukses");
                        if ((Pemain.this.getX() == 1) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Shop)){ //beli biji jagung
                            if ((Pemain.this.gold.getGold()) >= 10){
                                System.out.println("Coba2 sukses");
                                for (Tool tool : Pemain.this.getTools()){
                                       if (((Tool)tool).getName() == Tool.Nama.BijiJagung){
                                       tool.setJumlah((tool.getJumlah()) + 1); //menambahkan jumlah stok biji jagung di tools
                                       System.out.println("Beli biji jagung berhasil");
                                       Pemain.this.gold.kurangiGold(10);
                                  }
                                }
                            }
                            else {
                                System.out.println("Gold tidak cukup!");
                            }
                        }
                        else if ((Pemain.this.getX() == 7) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Shop)){ //beli ayam
                            if ((Pemain.this.gold.getGold()) >= 20){
                                System.out.println("Beli ayam berhasil");
                                //bikin ayam di kandang
                                Game.stageManager.getList().get(3).getEntityManager().getList().add(new Ayam(Game.stageManager.getList().get(3), "Ayam", 2, 2));
                                Pemain.this.gold.kurangiGold(20);
                            }
                            else {
                                System.out.println("Gold tidak cukup!");
                            }
                        }
                        else if ((Pemain.this.getX() == 4) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Shop)){ //beli pakan ayam
                            if ((Pemain.this.gold.getGold()) >= 20){
                                Pemain.this.getInventori().addItem(Item.Nama.MAKANANAYAM);
                                Pemain.this.gold.kurangiGold(20);
                            }
                            else {
                                System.out.println("Gold tidak cukup!");
                            }
                        }
                        Pemain.this.isDoingSomething = false;
			t20.stop();
                    }
                }
                
        private class Action21 implements ActionListener{ //kalo pilih key 2
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if ((Pemain.this.getX() == 1) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Shop)){ //beli biji kol
                            if ((Pemain.this.gold.getGold()) > 10){
                                for (Tool tool : Pemain.this.getTools()){
                                       if (((Tool)tool).getName() == Tool.Nama.BijiKol){
                                       tool.setJumlah((tool.getJumlah()) + 1); //menambahkan jumlah stok biji jagung di tools
                                       System.out.println("Beli biji kol berhasil");
                                       Pemain.this.gold.kurangiGold(10);
                                  }
                                }
                            }
                            else {
                                System.out.println("Gold tidak cukup!");
                            }
                        }
                        else if ((Pemain.this.getX() == 7) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Shop)){ //beli domba
                            if ((Pemain.this.gold.getGold()) > 50){
                                //bikin ayam di kandang
                                Game.stageManager.getList().get(4).getEntityManager().getList().add(new Domba(Game.stageManager.getList().get(4),"domba",2,2));
                                Pemain.this.gold.kurangiGold(50);
                                System.out.println("Beli domba berhasil");
                            }
                            else {
                                System.out.println("Gold tidak cukup!");
                            }
                        }
                        else if ((Pemain.this.getX() == 4) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Shop)){ //beli pakan ternak
                            if ((Pemain.this.gold.getGold()) > 30){
                                Pemain.this.getInventori().addItem(Item.Nama.MAKANANTERNAK);
                                Pemain.this.gold.kurangiGold(30);
                                System.out.println("Beli makanan ternak berhasil");
                            }
                            else {
                                System.out.println("Gold tidak cukup!");
                            }
                        }
                        Pemain.this.isDoingSomething = false;
						t21.stop();
                    }
                }
                
        private class Action22 implements ActionListener{ //kalo pilih key 3
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if ((Pemain.this.getX() == 1) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Shop)){ //beli biji labu
                            if ((Pemain.this.gold.getGold()) > 10){
                                for (Tool tool : Pemain.this.getTools()){
                                       if (((Tool)tool).getName() == Tool.Nama.BijiLabu){
                                       tool.setJumlah((tool.getJumlah()) + 1); //menambahkan jumlah stok biji jagung di tools
                                       System.out.println("Beli biji labu berhasil");
                                       Pemain.this.gold.kurangiGold(10);
                                  }
                                }
                            }
                            else {
                                System.out.println("Gold tidak cukup!");
                            }
                        }
                        else if ((Pemain.this.getX() == 7) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Shop)){ //beli sapi
                            if ((Pemain.this.gold.getGold()) > 170){
                                //bikin ayam di kandang
                                Game.stageManager.getList().get(4).getEntityManager().getList().add(new Sapi(Game.stageManager.getList().get(4),"sapi",2,2));
                                Pemain.this.gold.kurangiGold(170);
                                System.out.println("Beli sapi berhasil");
                            }
                            else {
                                System.out.println("Gold tidak cukup!");
                            }   
                        }
			Pemain.this.isDoingSomething = false;
			t22.stop();
                    }
                }
	
        private class Action23 implements ActionListener{ //kalo pilih key 4
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if ((Pemain.this.getX() == 1) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Shop)){ //beli biji lobak
                            if ((Pemain.this.gold.getGold()) > 10){
                                for (Tool tool : Pemain.this.getTools()){
                                       if (((Tool)tool).getName() == Tool.Nama.BijiLobak){
                                       tool.setJumlah((tool.getJumlah()) + 1); //menambahkan jumlah stok biji jagung di tools
                                       System.out.println("Beli biji lobak berhasil");
                                       Pemain.this.gold.kurangiGold(10);
                                  }
                                }
                            }
                            else {
                                System.out.println("Gold tidak cukup!");
                            }
                        }
                        Pemain.this.isDoingSomething = false;
			t23.stop();
                    }
                }
                
        private class Action24 implements ActionListener{ //kalo pilih key 5
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if ((Pemain.this.getX() == 1) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Shop)){ //beli biji stroberi
                            if ((Pemain.this.gold.getGold()) > 10){
                                for (Tool tool : Pemain.this.getTools()){
                                       if (((Tool)tool).getName() == Tool.Nama.BijiStroberi){
                                       tool.setJumlah((tool.getJumlah()) + 1); //menambahkan jumlah stok biji jagung di tools
                                       System.out.println("Beli biji stroberi berhasil");
                                       Pemain.this.gold.kurangiGold(10);
                                  }
                                }
                            }
                            else {
                                System.out.println("Gold tidak cukup!");
                            }
                        }
                        Pemain.this.isDoingSomething = false;
			t24.stop();
                    }
                }
                
        private class Action25 implements ActionListener{ //kalo pilih key 1 di buyer shop
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if ((Pemain.this.getX() == 8) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Sell)){ //jual jagung
                            if ((Pemain.this.getInventori().getJumlahItemIni(Item.Nama.JAGUNG)) >= 1){
                                    Pemain.this.getInventori().getThisItem(Item.Nama.JAGUNG).setJumlah((Pemain.this.getInventori().getThisItem(Item.Nama.JAGUNG).getJumlah())-1);
                                    Pemain.this.gold.tambahGold(30);
                                    Pemain.this.getInventori().printList();
                                    if (Pemain.this.getInventori().getThisItem(Item.Nama.JAGUNG).getJumlah()==0){
                                        Pemain.this.getInventori().remove(Item.Nama.JAGUNG);
                                        System.out.println("jagung habis");
                                    }
                                    
                            }
                            else{
                                System.out.println("Tidak ada stok jagung!");
                            }
                            }
                        else if ((Pemain.this.getX() == 4) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Sell)){ //jual telur
                            if ((Pemain.this.getInventori().getJumlahItemIni(Item.Nama.TELUR)) >= 1){
                                    Pemain.this.getInventori().getThisItem(Item.Nama.TELUR).setJumlah((Pemain.this.getInventori().getThisItem(Item.Nama.TELUR).getJumlah())-1);
                                    Pemain.this.gold.tambahGold(80);
                                    System.out.println("Jual telur berhasil");
                                    if (Pemain.this.getInventori().getThisItem(Item.Nama.TELUR).getJumlah()==0){
                                        Pemain.this.getInventori().remove(Item.Nama.TELUR);
                                        System.out.println("telur habis");
                                    }
                            }
                            else{
                                System.out.println("Tidak ada stok telur!");
                            } 
                        }
                        Pemain.this.isDoingSomething = false;
			t25.stop();
                    }
                }
        private class Action26 implements ActionListener{ //kalo pilih key 2
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if ((Pemain.this.getX() == 8) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Sell)){ //jual jagung
                            if ((Pemain.this.getInventori().getJumlahItemIni(Item.Nama.KOL)) >= 1){
                                Pemain.this.getInventori().printList();
                                    Pemain.this.getInventori().getThisItem(Item.Nama.KOL).setJumlah((Pemain.this.getInventori().getThisItem(Item.Nama.KOL).getJumlah())-1);
                                    Pemain.this.gold.tambahGold(20);
                                    if (Pemain.this.getInventori().getThisItem(Item.Nama.KOL).getJumlah()==0){
                                        Pemain.this.getInventori().remove(Item.Nama.KOL);
                                        System.out.println("kol habis");
                                    }
                            }
                            else{
                                System.out.println("Tidak ada stok kol!");
                            }
                            }
                        else if ((Pemain.this.getX() == 4) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Sell)){ //jual wol
                            if ((Pemain.this.getInventori().getJumlahItemIni(Item.Nama.WOL)) >= 1){
                                    Pemain.this.getInventori().getThisItem(Item.Nama.WOL).setJumlah((Pemain.this.getInventori().getThisItem(Item.Nama.WOL).getJumlah())-1);
                                    Pemain.this.gold.tambahGold(100);
                                    System.out.println("Jual wol berhasil");
                                    if (Pemain.this.getInventori().getThisItem(Item.Nama.WOL).getJumlah()==0){
                                        Pemain.this.getInventori().remove(Item.Nama.WOL);
                                        System.out.println("wol habis");
                                    }
                            }
                            else{
                                System.out.println("Tidak ada stok wol!");
                            } 
                        }
                        Pemain.this.isDoingSomething = false;
			t26.stop();
                    }
                }
        private class Action27 implements ActionListener{ //kalo pilih key 3
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if ((Pemain.this.getX() == 8) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Sell)){ //jual jagung
                            if ((Pemain.this.getInventori().getJumlahItemIni(Item.Nama.LABU)) >= 1){
                                    Pemain.this.getInventori().getThisItem(Item.Nama.LABU).setJumlah((Pemain.this.getInventori().getThisItem(Item.Nama.LABU).getJumlah())-1);
                                    Pemain.this.gold.tambahGold(20);
                                    if (Pemain.this.getInventori().getThisItem(Item.Nama.LABU).getJumlah()==0){
                                        Pemain.this.getInventori().remove(Item.Nama.LABU);
                                        System.out.println("labu habis");
                                    }
                            }
                            else{
                                System.out.println("Tidak ada stok labu!");
                            }
                            }
                        else if ((Pemain.this.getX() == 4) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Sell)){ //jual telur
                            if ((Pemain.this.getInventori().getJumlahItemIni(Item.Nama.SUSU)) >= 1){
                                    Pemain.this.getInventori().getThisItem(Item.Nama.SUSU).setJumlah((Pemain.this.getInventori().getThisItem(Item.Nama.SUSU).getJumlah())-1);
                                    Pemain.this.gold.tambahGold(120);
                                    if (Pemain.this.getInventori().getThisItem(Item.Nama.SUSU).getJumlah()==0){
                                        Pemain.this.getInventori().remove(Item.Nama.SUSU);
                                        System.out.println("susu habis");
                                    }
                            }
                            else{
                                System.out.println("Tidak ada stok susu!");
                            } 
                        }
                        Pemain.this.isDoingSomething = false;
			t27.stop();
                    }
                }
        private class Action28 implements ActionListener{ //kalo pilih key 4
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if ((Pemain.this.getX() == 8) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Sell)){ //jual lobak
                            if ((Pemain.this.getInventori().getJumlahItemIni(Item.Nama.LOBAK)) >= 1){
                                    Pemain.this.getInventori().getThisItem(Item.Nama.LOBAK).setJumlah((Pemain.this.getInventori().getThisItem(Item.Nama.LOBAK).getJumlah())-1);
                                    Pemain.this.gold.tambahGold(20);
                                    if (Pemain.this.getInventori().getThisItem(Item.Nama.LOBAK).getJumlah()==0){
                                        Pemain.this.getInventori().remove(Item.Nama.LOBAK);
                                        System.out.println("lobak habis");
                                    }
                            }
                            else{
                                System.out.println("Tidak ada stok lobak!");
                            }
						}
                        Pemain.this.isDoingSomething = false;
			t28.stop();
                    }
                }
        private class Action29 implements ActionListener{ //kalo pilih key 5
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if ((Pemain.this.getX() == 8) && (Pemain.this.getY() == 4) && (Game.state == Game.State.Sell)){ //jual lobak
                            if ((Pemain.this.getInventori().getJumlahItemIni(Item.Nama.STROBERI)) >= 1){
                                    Pemain.this.getInventori().getThisItem(Item.Nama.STROBERI).setJumlah((Pemain.this.getInventori().getThisItem(Item.Nama.STROBERI).getJumlah())-1);
                                    Pemain.this.gold.tambahGold(30);
                                    if (Pemain.this.getInventori().getThisItem(Item.Nama.STROBERI).getJumlah()==0){
                                        Pemain.this.getInventori().remove(Item.Nama.STROBERI);
                                        System.out.println("stroberi habis");
                                    }
                            }
                            else{
                                System.out.println("Tidak ada stok stroberi!");
                            }
                        }
                        Pemain.this.isDoingSomething = false;
                        t29.stop();
                    }
                }
}
