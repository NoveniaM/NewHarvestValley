import java.awt.image.BufferedImage;

public class Tool{
	
	//Attribute
	private int level = 1;
	private Nama name;
	private int jumlah = 1;
	//private int cost = 0;
	
	BufferedImage thumbnail;
	
	public static enum Nama {
		Pacul,
		PenyiramTanaman,
		Arit,
		BijiLobak,
		BijiKol,
		BijiJagung,
		BijiLabu,
		BijiStroberi,
		Milker,
		Clippers
	}
	
	//Method
	public Tool(Nama name, int cost, int jumlah){
		this.name = name;
        //this.cost = cost;
        this.jumlah = jumlah;
        
        /*switch(this.name){
        case Pacul :
        	try{
    			this.thumbnail = ImageIO.read(new File("./res/Pemain.png"));
    		} catch (IOException e) {
                e.printStackTrace();
            }
        	break;
        case PenyiramTanaman :
        	try{
    			this.thumbnail = ImageIO.read(new File("./res/Pemain.png"));
    		} catch (IOException e) {
                e.printStackTrace();
            }
        	break;
        case Arit :
        	try{
    			this.thumbnail = ImageIO.read(new File("./res/Pemain.png"));
    		} catch (IOException e) {
                e.printStackTrace();
            }
        	break;
        case BijiLobak :
        	try{
    			this.thumbnail = ImageIO.read(new File("./res/Pemain.png"));
    		} catch (IOException e) {
                e.printStackTrace();
            }
        	break;
        case BijiKol :
        	try{
    			this.thumbnail = ImageIO.read(new File("./res/Pemain.png"));
    		} catch (IOException e) {
                e.printStackTrace();
            }
        	break;
        case BijiJagung :
        	try{
    			this.thumbnail = ImageIO.read(new File("./res/Pemain.png"));
    		} catch (IOException e) {
                e.printStackTrace();
            }
        	break;
        case BijiLabu :
        	try{
    			this.thumbnail = ImageIO.read(new File("./res/Pemain.png"));
    		} catch (IOException e) {
                e.printStackTrace();
            }
        	break;
        case BijiStroberi :
        	try{
    			this.thumbnail = ImageIO.read(new File("./res/Pemain.png"));
    		} catch (IOException e) {
                e.printStackTrace();
            }
        	break;
        case Milker :
        	try{
    			this.thumbnail = ImageIO.read(new File("./res/Pemain.png"));
    		} catch (IOException e) {
                e.printStackTrace();
            }
        	break;
        case Clippers :
        	try{
    			this.thumbnail = ImageIO.read(new File("./res/Pemain.png"));
    		} catch (IOException e) {
                e.printStackTrace();
            }
        	break;
        }*/
	}
	
	public int getJumlah(){
		return(this.jumlah);
	}
	
	public void setJumlah(int jum){
		this.jumlah = jum;
	}
        
    //getter setter
	public Nama getName(){
		return(this.name);
	}
	
	public void setName(Nama name){
		this.name = name;
	}
	
	public int getLevel(){
		return(this.level);
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public void upgrade(){
		this.level++;
	}

}
