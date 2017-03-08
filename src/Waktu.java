import java.io.Serializable;

public class Waktu implements Runnable, Serializable{
	private int detik;
	private int menit;
	private String hari;
	private static int noHari;
	public static String stringHari = "";
	public static String stringJam = "";
	private boolean flow = true;

	{
		new Thread(this).start();
	}
	
	public void setStringHari(){
		this.hari = this.getHari();
		Waktu.stringHari = this.toStringHari();
	}
	
	public void setStringJam(){
		Waktu.stringJam = this.toStringJam();
	}
	
	//konstruktor awal
	public Waktu(){
		this.menit = 6;
		this.detik = 0;
		this.hari = "Senin";
		noHari = 1;
	}

	public Waktu(int menit, int detik, String hari, int noHari){
		this.menit = menit;
		this.detik = detik;
		this.hari = hari;
		Waktu.noHari = noHari;
	}

	//getter dan setter jam
	public void setDetik(int detik){
		this.detik = detik;
	}

	public void setMenit(int menit){
		this.menit = menit;
	}

	public int getDetik(){
		return detik;
	}

	public int getMenit(){
		return menit;
	}

	//getter dan setter hari
	public void setNoHari(int noHari){
		Waktu.noHari = noHari;
	}
	
	public int getNoHari() {
		return noHari;
	}

	public void tambahHari(){
		noHari++;
	}
	
	public String getHari(){
		if (noHari % 7 == 1){
			hari = ("Senin");
		}
		else if (noHari % 7 == 2){
			hari = ("Selasa");
		}
		else if (noHari % 7 == 3){
			hari = ("Rabu");
		}
		else if (noHari % 7 == 4){
			hari = ("Kamis");
		}
		else if (noHari % 7 == 5){
			hari = ("Jumat");
		}
		else if (noHari % 7 == 6){
			hari = ("Sabtu");
		}
		else if (noHari % 7 == 7){
			hari = ("Minggu");
		}
		return hari;
	}


	public boolean isFlowing() {
		return flow;
	}

	public void setFlow(boolean flow) {
		this.flow = flow;
	}
	
	//method run jam
	public void run(){
		
		while (true){
			
			System.out.print("");
			
			if(this.flow){
				if(Game.state != Game.State.MainMenu){
					try {
						this.setStringHari();
						this.setStringJam();
		                //this.printWaktu();
						Thread.sleep((long) 10 * 100);
						detik = detik + 10;
						//jika detik > 60
						if (detik >= 60){
							menit = menit + 1;
							detik = 0;
							if (menit == 24) {
								menit = 0;
								noHari = noHari + 1;
							}
						}
						if ((menit == 3) && (detik == 0)) { //pukul 3.00 dan belum tidur
							tidurNoGantiHari();
						}
					}
					catch (InterruptedException e) {
						System.out.println("Jam Error");
						// Isi program interrupsi
						return;
					}
				}
				
			}
			
		}
		
	}

	//method untuk memanggil hari dan jam
	public void printWaktu(){
		System.out.println("Hari: " + hari);
		if ((menit < 10) && (detik == 0)) {
			System.out.println("Pukul: 0"+menit+":0"+detik);
		}
		else if ((menit > 10) && (detik == 0)) {
			System.out.println("Pukul: "+menit+":0"+detik);
		}
		else if ((menit <10) && (detik >= 10)) {
			System.out.println("Pukul: 0"+menit+":"+detik);
		}
		else {
			System.out.println("Pukul: "+menit+":"+detik);
		}
	}
	
	public String toStringHari(){
		return ("Hari: " + hari);
	}
	
	public String toStringJam(){
		String temp;
		
		if ((menit < 10) && (detik == 0)) {
			temp = ("Pukul: 0"+menit+":0"+detik);
		}
		else if ((menit >= 10) && (detik == 0)) {
			temp = ("Pukul: "+menit+":0"+detik);
		}
		else if ((menit <10) && (detik >= 10)) {
			temp = ("Pukul: 0"+menit+":"+detik);
		}
		else {
			temp = ("Pukul: "+menit+":"+detik);
		}
		
		return temp;
	}

	//method tidur
	public void tidur(){
		if ((menit >= 0) && (menit < 3)){ // tidur jam 00.00 s.d jam 2.59
			setDetik(0);
			setMenit(6);
		} 
		else {
		tambahHari();
		setDetik(0);
		setMenit(6);
		}
		setStringHari();
		setStringJam();
	}
	
	public void tidurNoGantiHari(){
		this.tidur();
        noHari--;
        Game.getFocusedStage().getEntityManager().getList().get(0).action(12);
	}
}