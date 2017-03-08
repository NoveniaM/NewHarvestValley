import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Senyuman Hangat Edvin");
    	Game game = new Game();
    	frame.setContentPane(game);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	frame.pack();
    	frame.setLocationRelativeTo(null);
    	
    	while(true){
    		game.repaint();
//    		System.out.print("");
//    		if (Game.state == Game.State.Game) {
//        		game.repaint();
//    		}
    	}
	}
}
