package UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class RedStopWindowAshmont extends StopWindow{
	private String BACKGROUND = "src/UI/RedStopWindowAshmont.png";
	BufferedImage bg;
	public RedStopWindowAshmont(String name){
		super(name);
		try {
			bg = ImageIO.read(new File(BACKGROUND));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, null); 
    }
}