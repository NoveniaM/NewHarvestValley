import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Game extends Display implements Serializable{
	
	//Atribute
	
	private static Stage focusedStage = null;
	private InputHandler inputHandler;
	public static StageManager stageManager = new StageManager();
	public static PopUpManager popUpManager = new PopUpManager();
	public static Dimension d;
	public final static int size = 64;
	public static Waktu waktu;
	public static State state = Game.State.MainMenu; //Nambah
	
	public static enum State { //Nambah
		MainMenu,
		Game,
		Shop,
		Sell
	}
	
	//Method
	
	public Game(){
		super();
		initGame();
		addKeyListener(inputHandler);
		this.requestFocus(true);
	}
	
	public void initGame(){
		
		//Inisiasi Panel
		d = new Dimension(800, 600);
		setMinimumSize(d);
		setPreferredSize(d);
		setMaximumSize(d);
		
		
		//Inisialisasi InputHandler
		inputHandler = new InputHandler(this);
		
		//Inisiasi Waktu
		waktu = new Waktu();
		
		//Inisialisasi Stage
		Stage.setStageManager(stageManager);
		Stage mainMenu = new StageMenu(stageManager, "Main Menu", this);
		Stage stageLadang = new StageLadang(stageManager, "Ladang", 50, 40);
		Stage stageRumah = new Stage(stageManager, "Rumah", 11, 7);
		Stage stageKandangAyam = new StageKandang(stageManager, "Kandang Ayam", 14, 10);
		Stage stageKandangSapiDomba = new StageKandang(stageManager, "Kandang Sapi & Domba", 14, 10);
        Stage stageShop = new Stage(stageManager, "Toko", 12, 7);
        Stage stageJualan = new Stage(stageManager, "Toko Jual", 12, 7);
		Game.setFocusedStage(mainMenu);
		
		Pemain atika = new Pemain(stageLadang, popUpManager, "", 20, 17);

        //Ladang

        for (int i=1; i<50; i++){
            Decorative tembokA = new Decorative(stageLadang, "wall",i, 1, 1, 1);
            Decorative tembokB = new Decorative(stageLadang, "wall",i, 39, 1, 1);
        }
        for (int j=1; j<40; j++){
            Decorative tembokC = new Decorative(stageLadang, "wall",1, j, 1, 1);
            Decorative tembokD = new Decorative(stageLadang, "wall",49, j, 1, 1);
        }
        
        for (int i=25; i<45; i++){
            Decorative terasLadang = new Decorative(stageLadang, "bush2",i, 3, 1, 1);
        }
            //Jalan rumput
        for (int j=6; j<13; j++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", 17,j, 1, 1);
        }
        for (int i=13; i<18; i++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", i,12, 1, 1);
        }
        for (int j=12; j<21; j++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", 13,j, 1, 1);
        }
        for (int i=14; i<17; i++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", i,17, 1, 1);
        }
        for (int i=13; i<42; i++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", i,37, 1, 1);
        }
        for (int i=7; i<14; i++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", i,31, 1, 1);
        }
        for (int j=34; j<38; j++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", 29,j, 1, 1);
        }
        for (int j=24; j<38; j++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", 13,j, 1, 1);
        }
        Decorative jalan3 = new Decorative(stageLadang, "jalanRumput", 7,30, 1, 1);

        for (int i=21; i<49; i++){
            for (int j=31; j<34; j++){
                Decorative bata3 = new Decorative(stageLadang, "bata", i,j, 1, 1);
            }
        }
        for (int i=2; i<49; i++){
            Decorative pohon3 = new Decorative(stageLadang, "tree2",i, 1, 1, 1);
        }
        Decorative jalan2 = new Decorative(stageLadang, "jalanRumput", 16,16, 1, 1);

        Decorative pohon1 = new Decorative(stageLadang, "tree1",48, 2, 1, 1);
        Decorative pohon2 = new Decorative(stageLadang, "tree2",45, 4, 1, 1);
        Decorative rumahku = new Decorative(stageLadang, "home",15, 2, 4, 4);
        Decorative kandangAyamku = new Decorative(stageLadang, "coop",40, 33, 4, 4);
        Decorative kandangSapiku = new Decorative(stageLadang, "barn",5, 26, 4, 4);
        Decorative tempatBelanja = new Decorative(stageLadang, "shop",14, 13, 3, 4);

        Decorative pohon4 = new Decorative(stageLadang, "tree1",19, 4, 2, 1);
        Decorative pond1 = new Decorative(stageLadang, "pond1", 4,7,3,5 );
        Decorative pond2 = new Decorative(stageLadang, "pond2", 34,27,3,10 );
        for (int i=2; i<22; i++){
            for (int j=21; j<24; j++){
                Decorative bata1 = new Decorative(stageLadang, "bata", i,j, 1, 1);
            }
        }
        for (int j=24; j<32; j++){
            Decorative bata2 = new Decorative(stageLadang, "bata", 21,j, 1, 1);
        }

        Decorative tangga1 = new Decorative(stageLadang, "stair",12,21,3,3);
        Decorative tangga2 = new Decorative(stageLadang, "stair",28,31,3,3);
        Decorative merchusuar = new Decorative(stageLadang, "merchusuar",44,31,3,1);
        Decorative well1 = new Decorative(stageLadang, "well",9,28,2,1);
        Decorative silo = new Decorative(stageLadang, "silo",3,27,3,1);
        Decorative car = new Decorative(stageLadang, "car",14,4,2,1);
        Decorative stable = new Decorative(stageLadang, "stable",23,3,3,2);

        //Jalan rumput
        for (int j=6; j<13; j++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", 17,j, 1, 1);
        }
        for (int i=13; i<18; i++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", i,12, 1, 1);
        }
        for (int j=12; j<21; j++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", 13,j, 1, 1);
        }
        for (int i=5; i<13; i++){
            Decorative jalan = new Decorative(stageLadang, "jalanRumput", i,20, 1, 1);
        }

        //Kandang Sapi
        for (int i=1; i<14; i++){
            for (int j=1; j<10; j++){
                Decorative lantaiKandang = new Decorative(stageKandangSapiDomba, "barnTile", i,j, 1, 1);
            }
        }
                
                FoodContainer fc1 = new FoodContainer(stageKandangSapiDomba, 2, 3);
                FoodContainer fc2 = new FoodContainer(stageKandangSapiDomba, 4, 3);
                FoodContainer fc3 = new FoodContainer(stageKandangSapiDomba, 6, 3);
                FoodContainer fc4 = new FoodContainer(stageKandangSapiDomba, 8, 3);
                FoodContainer fc5 = new FoodContainer(stageKandangSapiDomba, 10, 3);
                FoodContainer fc6 = new FoodContainer(stageKandangSapiDomba, 12, 3);
                FoodContainer fc7 = new FoodContainer(stageKandangSapiDomba, 2, 6);
                FoodContainer fc8 = new FoodContainer(stageKandangSapiDomba, 4, 6);
                FoodContainer fc9 = new FoodContainer(stageKandangSapiDomba, 6, 6);
                FoodContainer fc10 = new FoodContainer(stageKandangSapiDomba, 8, 6);
                FoodContainer fc11 = new FoodContainer(stageKandangSapiDomba, 10, 6);
                FoodContainer fc12 = new FoodContainer(stageKandangSapiDomba, 12, 6);

        Decorative wcn1 = new Decorative(stageKandangSapiDomba, "watercane",11, 1, 1, 1);
        Decorative wcn2 = new Decorative(stageKandangSapiDomba, "watercane",10, 1, 1, 1);
        Decorative box1 = new Decorative(stageKandangSapiDomba, "box",13, 1, 2, 1);
        Decorative box2 = new Decorative(stageKandangSapiDomba, "box",12, 1, 2, 1);


        //Kandang Ayam
        for (int i=1; i<14; i++){
            for (int j=1; j<10; j++){
                Decorative lantaiKandang = new Decorative(stageKandangAyam, "barnTile", i,j, 1, 1);
            }
        }

//        Decorative fcChicken1 = new Decorative(stageKandangAyam, "fcChicken",2, 3, 1, 1);
//        Decorative fcChicken2 = new Decorative(stageKandangAyam, "fcChicken",2, 4, 1, 1);
//        Decorative fcChicken3 = new Decorative(stageKandangAyam, "fcChicken",2, 5, 1, 1);
//        Decorative fcChicken4 = new Decorative(stageKandangAyam, "fcChicken",2, 6, 1, 1);
//        Decorative fcChicken5 = new Decorative(stageKandangAyam, "fcChicken",2, 7, 1, 1);
//        Decorative fcChicken6 = new Decorative(stageKandangAyam, "fcChicken2",12, 3, 1, 1);
//        Decorative fcChicken7 = new Decorative(stageKandangAyam, "fcChicken2",12, 4, 1, 1);
//        Decorative fcChicken8 = new Decorative(stageKandangAyam, "fcChicken2",12, 5, 1, 1);
//        Decorative fcChicken9 = new Decorative(stageKandangAyam, "fcChicken2",12, 6, 1, 1);
//        Decorative fcChicken10 = new Decorative(stageKandangAyam, "fcChicken2",12, 7, 1, 1);

                TempatMakanKiri fcChicken1 = new TempatMakanKiri(stageKandangAyam, 2, 3);
                TempatMakanKiri fcChicken2 = new TempatMakanKiri(stageKandangAyam, 2, 4);
                TempatMakanKiri fcChicken3 = new TempatMakanKiri(stageKandangAyam, 2, 5);
                TempatMakanKiri fcChicken4 = new TempatMakanKiri(stageKandangAyam, 2, 6);
                TempatMakanKiri fcChicken5 = new TempatMakanKiri(stageKandangAyam, 2, 7);
                TempatMakanKanan fcChicken6 = new TempatMakanKanan(stageKandangAyam, 12, 3);
                TempatMakanKanan fcChicken7 = new TempatMakanKanan(stageKandangAyam, 12, 4);
                TempatMakanKanan fcChicken8 = new TempatMakanKanan(stageKandangAyam, 12, 5);
                TempatMakanKanan fcChicken9 = new TempatMakanKanan(stageKandangAyam, 12, 6);
                TempatMakanKanan fcChicken10 = new TempatMakanKanan(stageKandangAyam, 12, 7);
        Decorative wcna1 = new Decorative(stageKandangAyam, "watercane",2, 9, 1, 1);
        Decorative wcna2 = new Decorative(stageKandangAyam, "watercane",3, 9, 1, 1);
        for (int j=1; j<9; j++){
            Decorative boxa1 = new Decorative(stageKandangAyam, "box",13, j, 2, 1);
        }
        for (int j=1; j<9; j++){
            Decorative boxa2 = new Decorative(stageKandangAyam, "box",1, j, 2, 1);
        }
        for (int i=2; i<13; i++){
            Decorative boxa2 = new Decorative(stageKandangAyam, "box",i, 1, 2, 1);
        }

        //RUMAH
        for (int i=1; i<11; i++){
            for (int j=1; j<7; j++){
                Decorative lantaiRumah = new Decorative(stageRumah, "homeFloor",i, j, 1, 1);
            }
        }
        for (int i=1; i<11; i++){
            Decorative dindingRumah = new Decorative(stageRumah, "homeWall",i, 1, 1, 1);
        }
        Decorative kasur = new Decorative(stageRumah, "bed", 1,1,2,1);
        Decorative tv = new Decorative(stageRumah, "tv", 4,1,1,1);
        Decorative self = new Decorative(stageRumah, "self", 5,1,1,1);
        Decorative kitchenSet = new Decorative(stageRumah, "kitchenSet", 8,1,1,1);
        Decorative table = new Decorative(stageRumah, "table", 5,4,1,2);
        Decorative chair1 = new Decorative(stageRumah, "chair", 4,4,1,1);
        Decorative chair2 = new Decorative(stageRumah, "chair", 7,4,1,1);
    
      //SHOP
        for (int i=1; i<12; i++){
            for (int j=1; j<7; j++){
                Decorative lantaiToko = new Decorative(stageShop, "shopFloor",i, j, 1, 1);
            }
        }
        for (int i=1; i<12; i++){
            Decorative dindingToko = new Decorative(stageShop, "homeWall",i, 1, 1, 1);
        }
        Decorative kotak1 = new Decorative(stageShop, "box",11, 1, 2, 1);
        Decorative kotak2 = new Decorative(stageShop, "box",10, 1, 2, 1);
        Decorative rak1 = new Decorative(stageShop, "self",1, 1, 2, 1);
        Decorative rak2 = new Decorative(stageShop, "self",4, 1, 2, 1);
        Decorative seller1 = new Decorative(stageShop, "seller1",1, 2, 1, 1);
        Decorative seller2 = new Decorative(stageShop, "seller2",4, 2, 1, 1);
        Decorative seller3 = new Decorative(stageShop, "seller3",7, 2, 1, 1);
        Decorative meja1 = new Decorative(stageShop, "tableShop2",1, 3, 1, 2);
        Decorative meja2 = new Decorative(stageShop, "tableShop2",4, 3, 1, 2);
        Decorative meja3 = new Decorative(stageShop, "tableShop2",7, 3, 1, 2);
        Decorative sekat1a = new Decorative(stageShop, "sekat",3, 1, 1, 1);
        Decorative sekat1b = new Decorative(stageShop, "sekat",3, 2, 1, 1);
        Decorative sekat1c = new Decorative(stageShop, "sekat",3, 3, 1, 1);
        Decorative sekat2a = new Decorative(stageShop, "sekat",6, 1, 1, 1);
        Decorative sekat2b = new Decorative(stageShop, "sekat",6, 2, 1, 1);
        Decorative sekat2c = new Decorative(stageShop, "sekat",6, 3, 1, 1);
        
        Decorative seed = new Decorative(stageShop, "seed",2, 1, 1, 1);
        Decorative cowSack = new Decorative(stageShop, "cowSack",5, 1, 1, 1);
        Decorative cow = new Decorative(stageShop, "cow",7, 1, 1, 1);

        //TOKO JUALAN
        Decorative tokoJualan = new Decorative(stageLadang, "tokoJualan",3, 16, 3, 4);
        
        for (int i=1; i<12; i++){
            for (int j=1; j<7; j++){
                Decorative lantaiToko = new Decorative(stageJualan, "shopFloor",i, j, 1, 1);
            }
        }
        for (int i=1; i<12; i++){
            Decorative dindingToko = new Decorative(stageJualan, "homeWall",i, 1, 1, 1);
        }
        for (int j=2; j<7; j++){
            Decorative dindingToko = new Decorative(stageJualan, "homeWall",1, j, 1, 1);
            Decorative dindingToko2 = new Decorative(stageJualan, "homeWall",11, j, 1, 1);
        }
        
        Decorative rakA = new Decorative(stageJualan, "self",2, 1, 2, 1);
        Decorative rakB = new Decorative(stageJualan, "self",6, 1, 2, 1);
        Decorative rakC = new Decorative(stageJualan, "self",10, 1, 2, 1);
        Decorative seller4 = new Decorative(stageJualan, "seller3",4, 2, 1, 1);
        Decorative seller5 = new Decorative(stageJualan, "seller4",8, 2, 1, 1);
        
        Decorative meja4 = new Decorative(stageJualan, "tableShop1",3, 3, 1, 2);
        Decorative meja5 = new Decorative(stageJualan, "tableShop1",7, 3, 1, 2);
        
        Decorative sapi = new Decorative(stageJualan, "cow",4, 1, 1, 1);
        
        Decorative kol = new Decorative(stageJualan, "kol",7, 1, 1, 1);
        Decorative jagung = new Decorative(stageJualan, "corn",8, 1, 1, 1);
        Decorative labu = new Decorative(stageJualan, "labu",9, 1, 1, 1);
            
        //PINTU
        Decorative pintu1 = new Decorative(stageRumah, "homeFloor",3, 7, 1, 1);
        Decorative pintu2 = new Decorative(stageKandangAyam, "barnTile",8, 10, 1, 1);
        Decorative pintu3 = new Decorative(stageKandangSapiDomba, "barnTile",8, 10, 1, 1);
        Decorative pintu4 = new Decorative(stageShop, "shopFloor",3, 7, 1, 1);
        Decorative pintu5 = new Decorative(stageJualan, "shopFloor",3, 7, 1, 1);
        
        Pintu pintuToRumah = new Pintu(stageLadang, 17, 5, stageRumah);
        Pintu pintuToAyam = new Pintu(stageLadang, 41, 36, stageKandangAyam);
        Pintu pintuToSapi = new Pintu(stageLadang, 7, 29, stageKandangSapiDomba);
        Pintu pintuRumahkeLadang = new Pintu(stageRumah, 3, 7, stageLadang);
        Pintu pintuKandangAyamkeLadang = new Pintu(stageKandangAyam, 8, 10, stageLadang);
        Pintu pintuKandangSapiDombakeLadang = new Pintu(stageKandangSapiDomba, 8, 10, stageLadang);
        Pintu pintuShopToLadang = new Pintu(stageShop, 3, 7, stageLadang);
        Pintu pintuToShop = new Pintu(stageLadang, 16, 15, stageShop);
        Pintu pintuToJualan = new Pintu(stageLadang, 5, 18, stageJualan);
        Pintu pintuJualanToLadang = new Pintu(stageJualan, 3, 7, stageLadang);
       
        Hewan ayam1 = new Ayam(stageKandangAyam, "Ayam1", 4, 6) {};
        Hewan ayam2 = new Ayam(stageKandangAyam, "Ayam2", 6, 5) {};
        Hewan ayam3 = new Ayam(stageKandangAyam, "Ayam3", 5, 4) {};
        Hewan ayam4 = new Ayam(stageKandangAyam, "Ayam4", 6, 8) {};
        Hewan ayam5 = new Ayam(stageKandangAyam, "Ayam5", 4, 7) {};
	
        Hewan sapi1 = new Sapi(stageKandangSapiDomba, "Sapi1", 4, 5) {};
        Hewan sapi2 = new Sapi(stageKandangSapiDomba, "Sapi2", 8, 6) {};
        Hewan sapi3 = new Sapi(stageKandangSapiDomba, "Sapi3", 5, 7) {};
        Hewan sapi4 = new Sapi(stageKandangSapiDomba, "Sapi4", 8, 9) {};
        Hewan domba1 = new Domba(stageKandangSapiDomba, "Domba1", 5, 6) {};
        Hewan domba2 = new Domba(stageKandangSapiDomba, "Domba2", 8, 4) {};
        Hewan domba3 = new Domba(stageKandangSapiDomba, "Domba3", 2, 4) {};
        Hewan domba4 = new Domba(stageKandangSapiDomba, "Domba4", 7, 5) {};
        
        
        //Inisiasi PopUp
		PopUpToolBox itemBox = new PopUpToolBox(atika, popUpManager, this);
		PopUpTimeBox timeBox = new PopUpTimeBox(popUpManager, this);
		PopUpStatusPemain statusPemain = new PopUpStatusPemain(popUpManager, this);
        PopUpPeta peta = new PopUpPeta(popUpManager, this);
        PopUpDialogBeliBiji dialogbelibiji = new PopUpDialogBeliBiji(popUpManager, this);
        PopUpDialogBeliMakananTernak dialogbelimakan = new PopUpDialogBeliMakananTernak(popUpManager, this);
        PopUpDialogBeliHewan dialogbelihewan = new PopUpDialogBeliHewan(popUpManager, this);
        PopUpDialogJualHasilPanen dialogjualhasilpanen = new PopUpDialogJualHasilPanen(popUpManager, this);
        PopUpDialogJualHasilTernak dialogjualhasilternak = new PopUpDialogJualHasilTernak(popUpManager, this);
        
	}

	public static Stage getFocusedStage() {
		return focusedStage;
	}
	
	public static void save(){
        PrintWriter outputStream = null;
        try{
            try {
				outputStream = new PrintWriter(new FileWriter("testfile.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            	switch(Game.getFocusedStage().getNama()){
            	case "Rumah" :
            		outputStream.print(2);
            		break;
            	case "Ladang" :
            		outputStream.print(1);
            		break;
				case "Kandang Ayam" :
					outputStream.print(3);
					break;
				case "Kandang Sapi & Domba" :
					outputStream.print(4);
					break;
				case "Toko" :
					outputStream.print(5);
					break;
				case "Toko Jual" :
					outputStream.print(6);
					break;
            	}
            	outputStream.print("/");
            
                outputStream.print(Game.getPemain().getName());
                outputStream.print("/");
                outputStream.print(Game.getPemain().getX());
                outputStream.print("/");
                outputStream.print(Game.getPemain().getY());
                outputStream.print("/");
                outputStream.print(Game.getPemain().getArahHadap());
                outputStream.print("/");
                outputStream.print(Game.getPemain().getGold().getGold());
                outputStream.print("/");
                outputStream.print(waktu.getNoHari());
                outputStream.print("/");
                outputStream.print(Ayam.jumlahAyam());
                outputStream.print("/");
                outputStream.print(Domba.jumlahDomba());
                outputStream.print("/");
                outputStream.print(Sapi.jumlahSapi());
                outputStream.print("/");
                outputStream.println();
                for(Entity entity : Game.stageManager.getList().get(1).getEntityManager().getList()){
                	if (entity instanceof Tanaman){
                		if (entity instanceof Lobak){
                			outputStream.print("Lobak/");
                			outputStream.print(((Tanaman) entity).fase + "/");
                			outputStream.print(entity.getX() + "/");
                			outputStream.print(entity.getY() + "/");
                			outputStream.println();
                    	}
                		if (entity instanceof Kol){
                			outputStream.print("Kol/");
                			outputStream.print(((Tanaman) entity).fase + "/");
                			outputStream.print(entity.getX() + "/");
                			outputStream.print(entity.getY() + "/");
                			outputStream.println();
                    	}
                		if (entity instanceof Jagung){
                			outputStream.print("Jagung/");
                			outputStream.print(((Tanaman) entity).fase + "/");
                			outputStream.print(entity.getX() + "/");
                			outputStream.print(entity.getY() + "/");
                			outputStream.println();
                    	}
                		if (entity instanceof Labu){
                			outputStream.print("Labu/");
                			outputStream.print(((Tanaman) entity).fase + "/");
                			outputStream.print(entity.getX() + "/");
                			outputStream.print(entity.getY() + "/");
                			outputStream.println();
                    	}
                		if (entity instanceof Stroberi){
                			outputStream.print("Stroberi/");
                			outputStream.print(((Tanaman) entity).fase + "/");
                			outputStream.print(entity.getX() + "/");
                			outputStream.print(entity.getY() + "/");
                			outputStream.println();
                    	}
                	}
                }
                System.out.println("Saved!!!");
            
        }
        finally{
            if (outputStream != null){
                    outputStream.close();
            }
        }
    }

	public static void setFocusedStage(Stage focusedStage) {
		Game.focusedStage = focusedStage;
	}
	
	public int getCurrentWidth(){
		return this.getSize().width;
	}
	
	public int getCurrentHeight(){
		return this.getSize().height;
	}
	
	public void paintComponent(Graphics g){
		d.setSize(getCurrentWidth(), getCurrentHeight());
		if(Game.getFocusedStage() != null){
			if(Game.getFocusedStage() == Game.stageManager.getStageWithPemain()){
				super.paintComponent(g);
				
				for(Entity entity : focusedStage.getEntityManager().getList()){
					if ((entity.getLokasi().getX()*Game.size + Game.getPemain().distanceDisplayedX()) > -300){
						if ((entity.getLokasi().getX()*Game.size + Game.getPemain().distanceDisplayedX()) < Game.d.width + 300){
							if ((entity.getLokasi().getY()*Game.size  + Game.getPemain().distanceDisplayedY()) > -300){
								if ((entity.getLokasi().getY()*Game.size  + Game.getPemain().distanceDisplayedY()) < Game.d.height + 300){
									entity.paint(g);
								}
							}
						}
					}
				}

				Game.getPemain().paint(g);
				
				for(PopUp popUp : popUpManager.getList()){
					popUp.paint(g);
				}
				
			}
		}
//		if (Game.state == State.Game){
//			if(Game.getFocusedStage() != null){
//				if(Game.getFocusedStage() == Game.stageManager.getStageWithPemain()){
//					super.paintComponent(g);
//					
//					for(Entity entity : focusedStage.getEntityManager().getList()){
//						entity.paint(g);
//					}
//
//					Game.getPemain().paint(g);
//					
//					for(PopUp popUp : popUpManager.getList()){
//						popUp.paint(g);
//					}
//					
//				}
//			}
//		}
	}	
	
	public static Pemain getPemain(){
		return Game.stageManager.getStageWithPemain().getEntityManager().getPemain();
	}
}
