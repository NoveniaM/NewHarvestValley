public class Gold {
    int myGold;
    
    public Gold(){
        this.myGold = 1000;
    }
    
    public int getGold(){
        return myGold;
    }
    
    public void setGold(int jumlah){
        myGold = jumlah;
    }
    public void kurangiGold(int cost){
        this.myGold -= cost;
    }
    
    public void tambahGold(int price){
        this.myGold += price;
    }
    
    public void printGold(){
        System.out.println("Gold: "+myGold);
    }
}
