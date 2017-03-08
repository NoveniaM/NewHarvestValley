import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

public class StageMenu extends Stage implements Serializable{
	JFrame frame;
	Game game;
	
	JLabel background;
	JButton newbutton, loadbutton, exitbutton, nextbutton;
	JTextField inputNama;
	GridBagLayout gridBagLayout = new GridBagLayout();
	CardLayout backgroundLayout = new CardLayout();
	
	//Method
	public void restartMenu(){
		Game.waktu.setFlow(false);
		background.setVisible(true);
		backgroundLayout.first(background);
		newbutton.setVisible(true);
		loadbutton.setVisible(true);
		exitbutton.setVisible(true);
		new Sound();
	}
	
	public StageMenu(StageManager stageManager, String nama, Game game){
		super(stageManager, nama);
		
		game.setLayout(gridBagLayout);
		
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.weighty = 1;               // allow vertical dispersion
		gbc1.weightx = 1;
		
		Icon backgroundIcon = new ImageIcon("./res/hv2.jpg");
		background = new JLabel(backgroundIcon);
		game.add(background, gbc1);
		background.setLayout(backgroundLayout);
		
		JLabel startPage = new JLabel(backgroundIcon), 
				inputPage = new JLabel(backgroundIcon);
		
		startPage.setLayout(new GridBagLayout());
		inputPage.setLayout(new GridBagLayout());
		
		background.add(startPage);
		background.add(inputPage);
		
		Icon newIcon = new ImageIcon("./res/NEW.png");
        newbutton = new JButton(newIcon);
        newbutton.setBorderPainted(false);
        newbutton.setContentAreaFilled(false); 
        newbutton.setFocusPainted(false); 
        newbutton.setOpaque(false);
        newbutton.setBorder(null);
        newbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	game.requestFocusInWindow();
                backgroundLayout.next(background);
            }
        });
        startPage.add(newbutton, gbc1);
        
        Icon LoadIcon = new ImageIcon("./res/LOAD.png");
        loadbutton = new JButton(LoadIcon);
        loadbutton.setBorderPainted(false);
        loadbutton.setContentAreaFilled(false); 
        loadbutton.setFocusPainted(false); 
        loadbutton.setOpaque(false);
        loadbutton.setBorder(null);
        loadbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Game.waktu.setFlow(true);
            	game.requestFocusInWindow();
            	

            	Sound.stop();
                
                MainSound mains = new MainSound();
            	
            	for (Iterator<Entity> iterator = Game.stageManager.getList().get(3).getEntityManager().getList().iterator(); iterator.hasNext();) {
                    Entity hewan = iterator.next();
                    if (hewan instanceof Hewan) {
                        iterator.remove();
                    }
                }
            	
            	for (Iterator<Entity> iterator = Game.stageManager.getList().get(4).getEntityManager().getList().iterator(); iterator.hasNext();) {
                    Entity hewan = iterator.next();
                    if (hewan instanceof Hewan) {
                        iterator.remove();
                    }
                }
            	
            	//Method load
                try (BufferedReader inputStream = new BufferedReader(new FileReader("testfile.txt"))){
                    int dari=0;
                    String line=inputStream.readLine();
                    int sampe=0;
                    
                    //setStage
                    while (line.charAt(sampe)!='/'){
                        sampe++;
                    }
                    Game.setFocusedStage(Game.stageManager.getStageWithPemain());
                    switch(Integer.parseInt(line.substring(dari,sampe))){
                    case 1:
                    	Game.getPemain().t11.start();
                    	break;
                    case 2:
                    	Game.getPemain().t12.start();
                    	break;
                    case 3:
                    	Game.getPemain().t13.start();
                    	break;
                    case 4:
                    	Game.getPemain().t14.start();
                    	break;
                    case 5:
                    	Game.getPemain().t15.start();
                    	break;
                    case 6:
                    	Game.getPemain().t16.start();
                    	break;
                    }
                    
        			//nama Pemain
			        dari=sampe;
			        dari++;
			        sampe++;
			        while (line.charAt(sampe)!='/'){
			            sampe++;
			        } 
			        Game.getPemain().setName(line.substring(dari,sampe));
       
			      //X pemain
			        dari=sampe;
			        dari++;
			        sampe++;
			        while (line.charAt(sampe)!='/'){
			            sampe++;
			        } 
			        Game.getPemain().setX(Integer.parseInt(line.substring(dari,sampe)));
       
			      //Y pemain
			        dari=sampe;
			        dari++;
			        sampe++;
			        while (line.charAt(sampe)!='/'){
			            sampe++;
			        } 
			        Game.getPemain().setY(Integer.parseInt(line.substring(dari,sampe)));
       
			      //arah hadap
			        dari=sampe;
			        dari++;
			        sampe++;
			        while (line.charAt(sampe)!='/'){
			            sampe++;
			        } 
			        Game.getPemain().setArahHadap(Integer.parseInt(line.substring(dari,sampe)));
			        
			        switch(Game.getPemain().getArahHadap()){
			        case 0:
			        	Game.getPemain().getSpriteManager().setCurrentImage(13);
						break;
					case 1:
						Game.getPemain().getSpriteManager().setCurrentImage(9);
						break;
					case 2:
						Game.getPemain().getSpriteManager().setCurrentImage(1);
						break;
					case 3:
						Game.getPemain().getSpriteManager().setCurrentImage(5);
						break;
			        }
       

			      //Gold pemain
			        dari=sampe;
			        dari++;
			        sampe++;
			        while (line.charAt(sampe)!='/'){
			            sampe++;
			        } 
			        Game.getPemain().getGold().setGold(Integer.parseInt(line.substring(dari,sampe)));
       
		        
        
                    //no Hari
                    dari=sampe;
                    dari++;
                    sampe++;
                    while (line.charAt(sampe)!='/'){
                        sampe++;
                    } 
                    Game.waktu.setNoHari(Integer.parseInt(line.substring(dari,sampe)));
                    
                    //Ayam
                    dari=sampe;
                    dari++;
                    sampe++;
                    while (line.charAt(sampe)!='/'){
                        sampe++;
                    } 
                    int jumlahAyam = Integer.parseInt(line.substring(dari,sampe));
                    for (int i=0; i<jumlahAyam; i++){
                        new Ayam(Game.stageManager.getList().get(3), "Ayam", 5, 4) {};
                    }
                    
                    //Domba
                    dari=sampe;
                    dari++;
                    sampe++;
                    while (line.charAt(sampe)!='/'){
                        sampe++;
                    } 
                    int jumlahDomba = Integer.parseInt(line.substring(dari,sampe));
                    for (int i=0; i<jumlahDomba; i++){
                        new Domba(Game.stageManager.getList().get(4), "Domba", 5, 4) {};
                    }
                    
                    //Sapi
                    dari=sampe;
                    dari++;
                    sampe++;
                    while (line.charAt(sampe)!='/'){
                        sampe++;
                    } 
                    int jumlahSapi = Integer.parseInt(line.substring(dari,sampe));
                    for (int i=0; i<jumlahSapi; i++){
                        new Sapi(Game.stageManager.getList().get(4), "Sapi", 5, 4) {};
                    }
                    
                    Tanaman tanaman;
                    
                    while((line = inputStream.readLine()) != null) {
                    	dari=0;
                    	sampe=0;
                    	while (line.charAt(sampe)!='/'){
    			            sampe++;
    			        } 
                    	switch (line.substring(dari,sampe)){
                    	case "Lobak" :
                    		tanaman = new Lobak(Game.stageManager.getList().get(1), "Lobak", new Point (0,0));
                    		dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            switch(line.substring(dari,sampe)){
                            case "Biji" :
                            	tanaman.fase = Tanaman.Fase.Biji;
                        		tanaman.getSpriteManager().setCurrentImage(1);
                            	break;
                            case "Tunas" :
                            	tanaman.fase = Tanaman.Fase.Tunas;
                        		tanaman.getSpriteManager().setCurrentImage(3);
                            	break;
                            case "Tumbuhan" :
                            	tanaman.fase = Tanaman.Fase.Tumbuhan;
                        		tanaman.getSpriteManager().setCurrentImage(4);
                            	break;
                            case "Tumbuhan2" :
                            	tanaman.fase = Tanaman.Fase.Tumbuhan2;
                        		tanaman.getSpriteManager().setCurrentImage(5);
                            	break;
                            case "Panen" :
                            	tanaman.fase = Tanaman.Fase.Panen;
                            	tanaman.getSpriteManager().setCurrentImage(6);
                            	break;
                            case "SudahDipanen" :
                            	tanaman.fase = Tanaman.Fase.SudahDipanen;
                            	break;
                            }
                            dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            tanaman.setX(Integer.parseInt(line.substring(dari,sampe)));
                            dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            tanaman.setY(Integer.parseInt(line.substring(dari,sampe)));
                            for (Entity plotladang : Game.stageManager.getList().get(1).getEntityManager().getList()){
                            	if (plotladang instanceof PlotLadang){
                            		if (plotladang.getX() == tanaman.getX()){
                            			if (plotladang.getY() == tanaman.getY()){
                            				tanaman.plot = (PlotLadang) plotladang;
                            				((PlotLadang) plotladang).setPlantable(true);
                            			}
                            		}
                            	}
                            }
                            break;
                    	case "Kol" :
                    		tanaman = new Kol(Game.stageManager.getList().get(1), "Kol", new Point (0,0));
                    		dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            switch(line.substring(dari,sampe)){
                            case "Biji" :
                            	tanaman.fase = Tanaman.Fase.Biji;
                        		tanaman.getSpriteManager().setCurrentImage(1);
                            	break;
                            case "Tunas" :
                            	tanaman.fase = Tanaman.Fase.Tunas;
                        		tanaman.getSpriteManager().setCurrentImage(3);
                            	break;
                            case "Tumbuhan" :
                            	tanaman.fase = Tanaman.Fase.Tumbuhan;
                        		tanaman.getSpriteManager().setCurrentImage(4);
                            	break;
                            case "Tumbuhan2" :
                            	tanaman.fase = Tanaman.Fase.Tumbuhan2;
                        		tanaman.getSpriteManager().setCurrentImage(5);
                            	break;
                            case "Panen" :
                            	tanaman.fase = Tanaman.Fase.Panen;
                            	tanaman.getSpriteManager().setCurrentImage(6);
                            	break;
                            case "SudahDipanen" :
                            	tanaman.fase = Tanaman.Fase.SudahDipanen;
                            	break;
                            }
                            dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            tanaman.setX(Integer.parseInt(line.substring(dari,sampe)));
                            dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            tanaman.setY(Integer.parseInt(line.substring(dari,sampe)));
                            for (Entity plotladang : Game.stageManager.getList().get(1).getEntityManager().getList()){
                            	if (plotladang instanceof PlotLadang){
                            		if (plotladang.getX() == tanaman.getX()){
                            			if (plotladang.getY() == tanaman.getY()){
                            				tanaman.plot = (PlotLadang) plotladang;
                            				((PlotLadang) plotladang).setPlantable(true);
                            			}
                            		}
                            	}
                            }
                            break;
                    	case "Jagung" :
                    		tanaman = new Jagung(Game.stageManager.getList().get(1), "Jagung", new Point (0,0));
                    		dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            switch(line.substring(dari,sampe)){
                            case "Biji" :
                            	tanaman.fase = Tanaman.Fase.Biji;
                        		tanaman.getSpriteManager().setCurrentImage(1);
                            	break;
                            case "Tunas" :
                            	tanaman.fase = Tanaman.Fase.Tunas;
                        		tanaman.getSpriteManager().setCurrentImage(3);
                            	break;
                            case "Tumbuhan" :
                            	tanaman.fase = Tanaman.Fase.Tumbuhan;
                        		tanaman.getSpriteManager().setCurrentImage(4);
                            	break;
                            case "Tumbuhan2" :
                            	tanaman.fase = Tanaman.Fase.Tumbuhan2;
                        		tanaman.getSpriteManager().setCurrentImage(5);
                            	break;
                            case "Panen" :
                            	tanaman.fase = Tanaman.Fase.Panen;
                            	tanaman.getSpriteManager().setCurrentImage(6);
                            	break;
                            case "SudahDipanen" :
                            	tanaman.fase = Tanaman.Fase.SudahDipanen;
                            	tanaman.getSpriteManager().setCurrentImage(6);
                            	break;
                            }
                            dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            tanaman.setX(Integer.parseInt(line.substring(dari,sampe)));
                            dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            tanaman.setY(Integer.parseInt(line.substring(dari,sampe)));
                            for (Entity plotladang : Game.stageManager.getList().get(1).getEntityManager().getList()){
                            	if (plotladang instanceof PlotLadang){
                            		if (plotladang.getX() == tanaman.getX()){
                            			if (plotladang.getY() == tanaman.getY()){
                            				tanaman.plot = (PlotLadang) plotladang;
                            				((PlotLadang) plotladang).setPlantable(true);
                            			}
                            		}
                            	}
                            }
                            break;
                    	case "Labu" :
                    		tanaman = new Labu(Game.stageManager.getList().get(1), "Labu", new Point (0,0));
                    		dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            switch(line.substring(dari,sampe)){
                            case "Biji" :
                            	tanaman.fase = Tanaman.Fase.Biji;
                        		tanaman.getSpriteManager().setCurrentImage(1);
                            	break;
                            case "Tunas" :
                            	tanaman.fase = Tanaman.Fase.Tunas;
                        		tanaman.getSpriteManager().setCurrentImage(3);
                            	break;
                            case "Tumbuhan" :
                            	tanaman.fase = Tanaman.Fase.Tumbuhan;
                        		tanaman.getSpriteManager().setCurrentImage(4);
                            	break;
                            case "Tumbuhan2" :
                            	tanaman.fase = Tanaman.Fase.Tumbuhan2;
                        		tanaman.getSpriteManager().setCurrentImage(5);
                            	break;
                            case "Panen" :
                            	tanaman.fase = Tanaman.Fase.Panen;
                            	tanaman.getSpriteManager().setCurrentImage(6);
                            	break;
                            case "SudahDipanen" :
                            	tanaman.fase = Tanaman.Fase.SudahDipanen;
                            	break;
                            }
                            dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            tanaman.setX(Integer.parseInt(line.substring(dari,sampe)));
                            dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            tanaman.setY(Integer.parseInt(line.substring(dari,sampe)));
                            for (Entity plotladang : Game.stageManager.getList().get(1).getEntityManager().getList()){
                            	if (plotladang instanceof PlotLadang){
                            		if (plotladang.getX() == tanaman.getX()){
                            			if (plotladang.getY() == tanaman.getY()){
                            				tanaman.plot = (PlotLadang) plotladang;
                            				((PlotLadang) plotladang).setPlantable(true);
                            			}
                            		}
                            	}
                            }
                            break;
                    	case "Stroberi" :
                    		tanaman = new Stroberi(Game.stageManager.getList().get(1), "Stroberi", new Point (0,0));
                    		dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            switch(line.substring(dari,sampe)){
                            case "Biji" :
                            	tanaman.fase = Tanaman.Fase.Biji;
                        		tanaman.getSpriteManager().setCurrentImage(1);
                            	break;
                            case "Tunas" :
                            	tanaman.fase = Tanaman.Fase.Tunas;
                        		tanaman.getSpriteManager().setCurrentImage(3);
                            	break;
                            case "Tumbuhan" :
                            	tanaman.fase = Tanaman.Fase.Tumbuhan;
                        		tanaman.getSpriteManager().setCurrentImage(4);
                            	break;
                            case "Tumbuhan2" :
                            	tanaman.fase = Tanaman.Fase.Tumbuhan2;
                        		tanaman.getSpriteManager().setCurrentImage(5);
                            	break;
                            case "Panen" :
                            	tanaman.fase = Tanaman.Fase.Panen;
                            	tanaman.getSpriteManager().setCurrentImage(6);
                            	break;
                            case "SudahDipanen" :
                            	tanaman.fase = Tanaman.Fase.SudahDipanen;
                            	tanaman.getSpriteManager().setCurrentImage(6);
                            	break;
                            }
                            dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            tanaman.setX(Integer.parseInt(line.substring(dari,sampe)));
                            dari=sampe;
                            dari++;
                            sampe++;
                            while (line.charAt(sampe)!='/'){
                                sampe++;
                            } 
                            tanaman.setY(Integer.parseInt(line.substring(dari,sampe)));
                            for (Entity plotladang : Game.stageManager.getList().get(1).getEntityManager().getList()){
                            	if (plotladang instanceof PlotLadang){
                            		if (plotladang.getX() == tanaman.getX()){
                            			if (plotladang.getY() == tanaman.getY()){
                            				tanaman.plot = (PlotLadang) plotladang;
                            				((PlotLadang) plotladang).setPlantable(true);
                            			}
                            		}
                            	}
                            }
                            break;
                    	}
                    	
                    }                    
                    
                    
                } 
                catch (IOException ex) {
                }
        		catch(Exception exc){
        			exc.printStackTrace(); // If there was an error, print the info.
        		}
            	Game.state = Game.State.Game;
            	
            	background.setVisible(false);
            }
        });
        startPage.add(loadbutton, gbc1);
        
        Icon exitIcon = new ImageIcon("./res/EXIT.png");
        exitbutton = new JButton(exitIcon);
        exitbutton.setBorderPainted(false);
        exitbutton.setContentAreaFilled(false); 
        exitbutton.setFocusPainted(false); 
        exitbutton.setOpaque(false);
        exitbutton.setBorder(null);
        exitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
        startPage.add(exitbutton, gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.weighty = 0;               // allow vertical dispersion
		gbc2.weightx = 0; 
        
        inputNama = new JTextField(10);
        inputPage.add(inputNama, gbc2);
        
        Icon nextIcon = new ImageIcon("./res/START.png");
        nextbutton = new JButton(nextIcon);
        nextbutton.setBorderPainted(false);
        nextbutton.setContentAreaFilled(false); 
        nextbutton.setFocusPainted(false); 
        nextbutton.setOpaque(false);
        nextbutton.setBorder(null);
        nextbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	game.requestFocusInWindow();
            	Game.setFocusedStage(Game.stageManager.getList().get(1));
            	Game.getPemain().setName(inputNama.getText());
            	Game.state = Game.State.Game;
            	background.setVisible(false);
            	game.setLayout(null);
            	inputNama.setText("");
            	Game.waktu.setFlow(true);
            	Game.getPemain().setLokasi(5, 5);
            	Game.getPemain().setGold(new Gold());
            	Game.getPemain().setArahHadap(2);
            	Game.getPemain().getSpriteManager().setCurrentImage(1);
            	
            	Sound.stop();
                
                MainSound mains= new MainSound();
            }
        });
        inputPage.add(nextbutton, gbc2);
        
        game.validate();
        game.repaint();
	}
}