import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    
    public List<Item> list = new ArrayList<>(10);
    
    private Item[] items = new Item[10];
    private int[] itemJum = new int[10];
    
    public Inventory(){
    }
    
    public void addItem (Item.Nama nama){
            boolean temp = false;
            for (Item item : this.list){
                    if (item.getName() == nama){
                            item.setJumlah(item.getJumlah() + 1);
                            temp = true;
                    }
            }
            if (!temp){
                    if (this.list.size() == 10){
                            // TO DO Inventori penuh
                    } else {
                            this.list.add(new Item(nama));
                    }
            }
    }

    public void remove (Item.Nama nama){
        for (Iterator<Item> iterator = this.list.iterator(); iterator.hasNext();) {
            Item item = iterator.next();
            if (item.getName() == nama){
                iterator.remove();
            }
        }
    }

    public void printList(){
            System.out.println("Item yang dimiliki :");
            for(Item item : this.list){
                    System.out.println(item.getName() + " sebanyak " + item.getJumlah());
            }
    }
    
    public int[] getJumlahItem(){
        int iter=0;
        for(Item item : this.list){
            iter++;
            this.itemJum[iter] = item.getJumlah();
        }
        return itemJum;
    }
    
    public Item[] itemList(){
        int iter=0;
        for(Item item : this.list){
            iter++;
            this.items[iter] = item;
        }
        return this.items;
    }

    public int getSize(){
        return this.list.size();
    }

    public int getJumlahItemIni(Item.Nama nama){
        int jumlah=0;
        for(Item item : this.list){
            if (item.getName() == nama) {
                jumlah = item.getJumlah();
            }
        }
        return jumlah;
    }
    
    public Item getThisItem(Item.Nama nama){
        Item i = null;
        for (Item item : this.list){
            if (item.getName() == nama){
                i = item;
            }
        }
    return i;
    }
}
