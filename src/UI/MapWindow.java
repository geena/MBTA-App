package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;



public class MapWindow extends JPanel implements ActionListener{
	private String MAPFILE= "src/UI/map.jpg"; //the file name of the map background
	private String ICONFILE= "src/UI/icon.png"; //file name of the train icon
	private BufferedImage background; // the Buffered image to hold map image information
	private BufferedImage trainIcon; // the Buffered image to hold map image information
	//private Train.TripList;
	
	
	public MapWindow(){
		try {
			background = ImageIO.read(new File(MAPFILE));
			trainIcon = ImageIO.read(new File(ICONFILE));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block//
			e.printStackTrace();
			
		}
		
	}
	
	//updates Trip List and then paints trains
	private void paintTrains(Graphics g){
		g.drawImage(trainIcon, 100, 60, 100, 100, null);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null); 
        this.paintTrains(g);
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}





