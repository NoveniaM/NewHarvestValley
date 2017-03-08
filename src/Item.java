
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Item {
	private Nama name;
	private int cost = 0, price = 0, jumlah = 1;
    static Image imgTelur, imgSusu, imgWol, imgKol, imgLobak, imgJagung, imgLabu, imgStro, imgMayam, imgMternak;

	public enum Nama {
	    TELUR,
	    SUSU,
	    WOL,
        KOL,
        LOBAK,
        JAGUNG,
        LABU,
        STROBERI,
        MAKANANTERNAK,
        MAKANANAYAM
	}
	
    static {
    	try{
            imgTelur = ImageIO.read(new File("./res/egg.png"));
            imgSusu = ImageIO.read(new File("./res/milkItem.png"));
            imgWol = ImageIO.read(new File("./res/woolItem.png"));
            imgKol = ImageIO.read(new File("./res/KolItem.png"));
            imgLobak = ImageIO.read(new File("./res/LobakItem.png"));
            imgJagung = ImageIO.read(new File("./res/imgCorn.png"));
            imgLabu = ImageIO.read(new File("./res/LabuItem.png"));
            imgStro = ImageIO.read(new File("./res/imgStro.png"));
            imgMayam = ImageIO.read(new File("./res/imgMA.png"));
            imgMternak = ImageIO.read(new File("./res/imgMP.png"));
            //System.out.println("Read image");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't read image");
        }
    }
        
	public Item(Nama name){
		this.name = name;
		switch(name){
		case TELUR :
            this.cost = 0;
            this.price = 80;
            break;
		case SUSU :
            this.cost = 0;
            this.price = 120;
            break;
		case WOL :
            this.cost = 0;
            this.price = 100;
            break;
        case KOL :
            this.cost = 0;
            this.price = 80;
            break;
		case LOBAK :
            this.cost = 0;
            this.price = 120;
            break;
		case JAGUNG :
            this.cost = 0;
            this.price = 200;
            break;
        case LABU :
            this.cost = 0;
            this.price = 200;
            break;
        case STROBERI :
            this.cost = 0;
            this.price = 100;
            break;
		case MAKANANAYAM :
            this.cost = 20;
            this.price = 0;
            break;
		case MAKANANTERNAK :
            this.cost = 30;
            this.price = 0;
            break;
		}
	}        
        
        public Image getImage(){
            Image img = null;
            switch(this.name){
                case TELUR :
                    img = imgTelur;
                    break;
                case SUSU :
                    img = imgSusu;
                    break;
                case WOL :
                    img = imgWol;
                    break;
                case KOL :
                    img = imgKol;
                    break;
                case LOBAK :
                    img = imgLobak;
                    break;
                case JAGUNG :
                    img = imgJagung;
                    break;
                case LABU :
                    img = imgLabu;
                    break;
                case STROBERI :
                    img = imgStro;
                    break;
                case MAKANANAYAM :
                    img = imgMayam;
                    break;
                case MAKANANTERNAK :
                    img = imgMternak;
                    break;
            }
            return img;
        }
        
        
	//getter setter
	public Nama getName(){
		return(this.name);
	}
	
	public void setName(Nama name){
		this.name = name;
	}
	
	public int getPrice(){
		return(this.price);
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	public int getCost(){
		return(this.cost);
	}
	
	public void setCost(int cost){
		this.cost = cost;
	}
	
	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
}
