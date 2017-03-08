import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class SpriteManager {

	int index = 1;
	
	int rows;
	int cols;
	
	transient List<BufferedImage> sprites = new ArrayList<>();

	public SpriteManager(String path){
		try{
			this.sprites.add(0, ImageIO.read(new File(path)));
			this.index = 0;
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public SpriteManager(String path, int rows, int cols){
		
		try{
			this.sprites.add(0, ImageIO.read(new File(path)));
		} catch (IOException e) {
            e.printStackTrace();
        }
		
		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		    	this.sprites.add(sprites.get(0).getSubimage(
			            j * sprites.get(0).getWidth() / cols,
			            i * sprites.get(0).getHeight() / rows,
			            sprites.get(0).getWidth() / cols,
			            sprites.get(0).getHeight() / rows
			        )
		    	);
		    }
		}
	}
	
	public void setCurrentImage(int index){
    	this.index = index;
    }
    
    public BufferedImage getCurrentImage(){
    	return this.sprites.get(this.index);
    }	
}
