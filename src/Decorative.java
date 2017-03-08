import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Nindy
 */



public class Decorative extends Entity {

	public String kategori = "";
	
    private static Image bed;
    private static Image tree1;
    private static Image tree2;
    private static Image tree3;
    private static Image tree4;
    private static Image bush1;
    private static Image bush2;
    private static Image bush3;
    private static Image rock1;
    private static Image rock2;
    private static Image tv;
    private static Image table;
    private static Image self;
    private static Image barnTile;
    private static Image jalanRumput;
    private static Image rumputLadang;
    private static Image homeFloor;
    private static Image homeWall;
    private static Image kitchenSet;
    private static Image chair;
    private static Image barn;
    private static Image coop;
    private static Image shop;
    private static Image home;
    private static Image hoeDirt;
    private static Image wall;
    private static Image pond1;
    private static Image bata;
    private static Image stair;
    private static Image pond2;
    private static Image well;
    private static Image stable;
    private static Image silo;
    private static Image merchusuar;
    private static Image car;
    private static Image fcCow; //food container cow
    private static Image fcChicken; //food container chicken
    private static Image fcChicken2; //food container chicken
    private static Image watercane;
    private static Image box;
    private static Image door;
    private static Image farmTile;
    private static Image sheep;
    private static Image chicken;
    private static Image corn;
    private static Image kol;
    private static Image labu;
    private static Image shopFloor;
    private static Image tableShop1;
    private static Image tableShop2;
    private static Image seller1;
    private static Image seller2;
    private static Image seller3;
    private static Image seller4;
    private static Image sekat;
    private static Image seed;
    private static Image cowSack;
    private static Image cow;
    private static Image tokoJualan;

    private Image currentImg;

    static {
        try{
        	bed = ImageIO.read(new File("./res/NewBed.png"));
            tree1 = ImageIO.read(new File("./res/Tree1.png"));
            tree2 = ImageIO.read(new File("./res/Tree2.png"));
            tree3 = ImageIO.read(new File("./res/Tree3.png"));
            tree4 = ImageIO.read(new File("./res/Tree4.png"));
            bush1 = ImageIO.read(new File("./res/bush1.png"));
            bush2 = ImageIO.read(new File("./res/bush21.png"));
            bush3 = ImageIO.read(new File("./res/bush3.png"));
            rock1 = ImageIO.read(new File("./res/rock1.png"));
            rock2 = ImageIO.read(new File("./res/rock2.png"));
            tv = ImageIO.read(new File("./res/tv2.png"));
            table = ImageIO.read(new File("./res/Table2.png"));
            chair = ImageIO.read(new File("./res/Chair.png"));
            self = ImageIO.read(new File("./res/Self.png"));
            barnTile = ImageIO.read(new File("./res/BarnTile.png"));
            jalanRumput = ImageIO.read(new File("./res/JalanRumput.png"));
            rumputLadang = ImageIO.read(new File("./res/RumputLadang.png"));
            homeFloor = ImageIO.read(new File("./res/HomeFloors.png"));
            homeWall = ImageIO.read(new File("./res/HomeWall.png"));
            kitchenSet = ImageIO.read(new File("./res/KitchenSet.png"));
            barn = ImageIO.read(new File("./res/Barn.png"));
            coop = ImageIO.read(new File("./res/Coop.png"));
            home = ImageIO.read(new File("./res/Home.png"));
            shop = ImageIO.read(new File("./res/Shop.png"));
            hoeDirt = ImageIO.read(new File("./res/HoeDirt.png"));
            wall = ImageIO.read(new File("./res/Wall.png"));
            pond1 = ImageIO.read(new File("./res/pond1.png"));
            pond2 = ImageIO.read(new File("./res/pond2.png"));
            bata = ImageIO.read(new File("./res/bata.jpg"));
            stair = ImageIO.read(new File("./res/Stair.png"));
            well = ImageIO.read(new File("./res/Well.png"));
            stable= ImageIO.read(new File("./res/Stable.png"));
            silo= ImageIO.read(new File("./res/Silo.png"));
            merchusuar= ImageIO.read(new File("./res/Merchusuar.png"));
            car= ImageIO.read(new File("./res/Car.png"));
            fcCow= ImageIO.read(new File("./res/FoodContainer.png"));
            fcChicken= ImageIO.read(new File("./res/FoodContainerChicken.png"));
            fcChicken2= ImageIO.read(new File("./res/FoodContainerChicken2.png"));
            watercane= ImageIO.read(new File("./res/WaterCane.png"));
            box = ImageIO.read(new File("./res/Box.png"));
            door = ImageIO.read(new File("./res/door.png"));
            farmTile = ImageIO.read(new File("./res/FarmTile.png"));
            shopFloor = ImageIO.read(new File("./res/ShopFloor.png"));
            tableShop1 = ImageIO.read(new File("./res/TableShop3.png"));
            tableShop2 = ImageIO.read(new File("./res/TableShop2.png"));
            seller1 = ImageIO.read(new File("./res/Seller1.png"));
            seller2 = ImageIO.read(new File("./res/Seller2.png"));
            seller3 = ImageIO.read(new File("./res/Seller3.png"));
            seller4 = ImageIO.read(new File("./res/Seller4.png"));
            sekat = ImageIO.read(new File("./res/Partition.png"));
            seed = ImageIO.read(new File("./res/Seed.png"));
            cowSack = ImageIO.read(new File("./res/CowSack.png"));
            cow = ImageIO.read(new File("./res/CowCow.png"));
            sheep = ImageIO.read(new File("./res/Sheep.png"));
            chicken = ImageIO.read(new File("./res/Chicken.png"));
            corn = ImageIO.read(new File("./res/imgCorn.png"));
            kol = ImageIO.read(new File("./res/KolItem.png"));
            labu = ImageIO.read(new File("./res/LabuItem.png"));
            tokoJualan = ImageIO.read(new File("./res/TokoJualan.png"));
		}
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Decorative (Stage s, String kategori, int x, int y, int width, int height){
        super(s, x, y);
        this.kategori = kategori;
        this.setWidth(width);
        this.setHeight(height);
        switch (kategori){
            case "bed" :
                this.currentImg=bed;
                break;
            case "tree1" :
                this.currentImg=tree1;
                break;
            case "tree2" :
                this.currentImg=tree2;
                break;
            case "tree3" :
                this.currentImg=tree3;
                break;
            case "tree4" :
                this.currentImg=tree4;
                break;
            case "bush1" :
                this.currentImg=bush1;
                break;
            case "bush2" :
                this.currentImg=bush2;
                break;
            case "bush3" :
                this.currentImg=bush3;
                break;
            case "rock1" :
                this.currentImg=rock1;
                break;
            case "rock2" :
                this.currentImg=rock2;
                break;
            case "tv" :
                this.currentImg=tv;
                break;
            case "table" :
                this.currentImg=table;
                break;
            case "self" :
                this.currentImg=self;
                break;
            case "barnTile" :
                this.currentImg=barnTile;
                this.setStepable(true);
                break;
            case "jalanRumput" :
                this.currentImg=jalanRumput;
                this.setStepable(true);
                break;
            case "rumputLadang" :
                this.currentImg=rumputLadang;
                this.setStepable(true);
                break;
            case "homeFloor" :
                this.currentImg=homeFloor;
                this.setStepable(true);
                break;
            case "homeWall" :
                this.currentImg=homeWall;
                break;
            case "kitchenSet" :
                this.currentImg=kitchenSet;
                break;
            case "chair" :
                this.currentImg=chair;
                break;
            case "barn" :
                this.currentImg=barn;
                break;
            case "coop" :
                this.currentImg=coop;
                break;
            case "shop" :
                this.currentImg=shop;
                break;
            case "home" :
                this.currentImg=home;
                break;
            case "hoeDirt" :
                this.currentImg=hoeDirt;
                this.setStepable(true);
                break;
            case "wall" :
                this.currentImg=wall;
                break;
            case "pond1" :
                this.currentImg=pond1;
                break;
            case "pond2" :
                this.currentImg=pond2;
                break;
            case "bata" :
                this.currentImg=bata;
                break;
            case "stair" :
                this.currentImg=stair;
                this.setStepable(true);
                break;
            case "well" :
                this.currentImg=well;
                break;
            case "stable" :
                this.currentImg=stable;
                break;
            case "silo" :
                this.currentImg=silo;
                this.setStepable(true);
                break;
            case "merchusuar" :
                this.currentImg=merchusuar;
                break;
            case "car" :
                this.currentImg=car;
                break;
            case "fcCow" :
                this.currentImg=fcCow;
                break;
            case "fcChicken" :
                this.currentImg=fcChicken;
                break;
            case "fcChicken2" :
                this.currentImg=fcChicken2;
                break;
            case "watercane" :
                this.currentImg=watercane;
                break;
            case "box" :
                this.currentImg=box;
                break;
            case "door" :
                this.currentImg=door;
                break;
            case "farmTile" :
                this.currentImg=farmTile;
                this.setStepable(true);
                break;
            case "shopFloor" :
                this.currentImg=shopFloor;
                this.setStepable(true);
                break;
            case "tableShop1" :
                this.currentImg=tableShop1;
                break;
            case "tableShop2" :
                this.currentImg=tableShop2;
                break;
            case "seller1" :
                this.currentImg=seller1;
                break;
            case "seller2" :
                this.currentImg=seller2;
                break;
            case "seller3" :
                this.currentImg=seller3;
                break;
            case "seller4" :
                this.currentImg=seller4;
                break;
            case "sekat" :
                this.currentImg=sekat;
                break;
            case "seed" :
                this.currentImg=seed;
                break;
            case "cowSack" :
                this.currentImg=cowSack;
                break;
            case "cow" :
                this.currentImg=cow;
                break;
            case "tokoJualan" :
                this.currentImg=tokoJualan;
                break;
            case "sheep" :
                this.currentImg=sheep;
                break;
            case "chicken" :
                this.currentImg=chicken;
                break;
            case "corn" :
                this.currentImg=corn;
                break;
            case "kol" :
                this.currentImg=kol;
                break;
            case "labu" :
                this.currentImg=labu;
                break;
            
        }

    }

	@Override
	public void paint(Graphics g) {
		g.drawImage(this.currentImg, (this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX()), (this.getLokasi().getY()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY()), null);
		//g.setColor(Color.BLUE);
		//g.fillRect((this.getLokasi().getX()*Game.size + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedX()), (this.getLokasi().getY()*Game.size  + ((Pemain) this.getEntityManager().getList().get(0)).distanceDisplayedY()), this.getWidth()*Game.size, this.getHeight()*Game.size);
	}

	@Override
	public void action(int i) {
		// TODO Auto-generated method stub

	}

}
