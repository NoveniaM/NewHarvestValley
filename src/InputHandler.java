import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InputHandler implements KeyListener{

	//Attribute
	
	Game game;
	
	//Method
	
	public InputHandler(Game game){
		this.game = game;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		int c = e.getKeyCode();
		if(Game.state == Game.State.Game){
			if (c == KeyEvent.VK_W){
	        	Game.getPemain().action(0);
	        }
	        if (c == KeyEvent.VK_D){
	        	Game.getPemain().action(1);
	        }
	        if (c == KeyEvent.VK_S){
	        	Game.getPemain().action(2);
	        }
	        if (c == KeyEvent.VK_A){
	        	Game.getPemain().action(3);
	        }
	        if (c == KeyEvent.VK_Q){
	        	Game.getPemain().action(4);
	        }
	        if (c == KeyEvent.VK_E){
	        	Game.getPemain().action(5);
        	}
	        if (c == KeyEvent.VK_F){
            	Game.getPemain().action(6);
	        }
        }
        
        if (c == KeyEvent.VK_B){
        	Game.getPemain().action(7);
        }
        if (c == KeyEvent.VK_M){
        	Game.getPemain().action(8);
        }
        if (c == KeyEvent.VK_G){
        	Game.getPemain().action(10);
        }
        if (c == KeyEvent.VK_1){
            if (Game.state == Game.State.Shop){
             
                Game.getPemain().action(20);
            }
            else if (Game.state == Game.State.Sell){
             
                Game.getPemain().action(25);
            }
            else{
                Game.getPemain().setHeldTool(0);
            }
        }
        if (c == KeyEvent.VK_2){
            if (Game.state == Game.State.Shop){
                Game.getPemain().action(21);
            }
            else if (Game.state == Game.State.Sell){
                Game.getPemain().action(26);
            }
            else {
                Game.getPemain().setHeldTool(1);
            }
        }
        if (c == KeyEvent.VK_3){
            if (Game.state == Game.State.Shop){
                Game.getPemain().action(22);
            }
            else if (Game.state == Game.State.Sell){
                Game.getPemain().action(27);
            }
            else{
                Game.getPemain().setHeldTool(2);
            }
        }
        if (c == KeyEvent.VK_4){
            if (Game.state == Game.State.Shop){
                Game.getPemain().action(23);
            }
            else if (Game.state == Game.State.Sell){
                Game.getPemain().action(28);
            }
            else{
                Game.getPemain().setHeldTool(3);
            }
        }
        if (c == KeyEvent.VK_5){
            if (Game.state == Game.State.Shop){
                Game.getPemain().action(24);
            }
            else if(Game.state == Game.State.Sell){
                Game.getPemain().action(29);
            }
            else{
                Game.getPemain().setHeldTool(4);
            }
        }
        if (c == KeyEvent.VK_6){
        	Game.getPemain().setHeldTool(5);
        }
        if (c == KeyEvent.VK_7){
        	Game.getPemain().setHeldTool(6);
        }
        if (c == KeyEvent.VK_8){
        	Game.getPemain().setHeldTool(7);
        }
        if (c == KeyEvent.VK_9){
        	Game.getPemain().setHeldTool(8);
        }
        if (c == KeyEvent.VK_0){
        	Game.getPemain().setHeldTool(9);
        }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
