import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MapWindow extends JPanel implements ActionListener{
	String MAPFILE= "src/map_mbta.gif"; //the file name of the map background
	private BufferedImage background; // the Buffered image to hold map image information
	private JButton button = new JButton();
	
	
	public MapWindow(){
		try {
			background = ImageIO.read(new File(MAPFILE));
			
			this.add(button);
			button.getModel().setPressed(true);
			button.setBackground(new Color(10, 130, 100));
			button.addActionListener(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block//
			e.printStackTrace();
			
			System.out.println("didn't work");
		}
		
	}
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);     
        g.drawOval(200, 200, 20, 20);
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		button.setBackground(Color.yellow);
		
	}
	
	
	
	
}





