package UI;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import models.MBTAResponse;
import models.TripList;
import requests.AbstractMBTARequest;
import requests.Closure;
import services.MBTAService;



public class MapWindow extends JPanel{
	private String MAPFILE= "src/UI/Map.jpg"; //the file name of the map background
	private String ICONFILE= "src/UI/icon2.png"; //file name of the train icon
	private String UPSIDEDOWICONFILE= "src/UI/iconReverse2.png"; //file name of the upside down train icon
	private String UPHILLICONFILE= "src/UI/iconUphill2.png"; //file name of the train icon
	
	private BufferedImage background; // the Buffered image to hold map image information
	private BufferedImage trainIcon; // the Buffered image to hold map image information
	private BufferedImage upsidedown;
	private BufferedImage uphill;
	//private Train.TripList;
	private final MBTAService _mbtaService;
	private List<TripList> _allTrainsList;
	ActionListener listener;
	
	
	public MapWindow(){
		setLayout(null);
		_mbtaService = new MBTAService();
		_allTrainsList = new ArrayList<TripList>();
		try {
			background = ImageIO.read(new File(MAPFILE));
			trainIcon = ImageIO.read(new File(ICONFILE));	
			upsidedown = ImageIO.read(new File(UPSIDEDOWICONFILE));
			uphill = ImageIO.read(new File(UPHILLICONFILE));
		} catch (IOException e) {
			// TODO Auto-generated catch block//
			e.printStackTrace();	
		}
		
		
	}
	
	
	
	
	//updates Trip List and then paints trains
	private void paintTrains(Graphics g){
		
		this.getTrainLocations();
		paintRedTrains(g);
		paintOrangeTrains(g);
		paintBlueTrains(g);
		
	}
	
	//places the train icons on the orange line
	private void paintOrangeTrains(Graphics g){
		for(int i = 0; i < _allTrainsList.get(2).getTrips().size(); i++){
			
			
			Point point = new Point(-100,0);
			//if the train is Oak Grove Bound****************************
			if(_allTrainsList.get(2).getTrips().get(i).getDestination().compareTo("Oak Grove") == 0){
				point.setLocation(point.x, 62);
				
				if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Oak Grove")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(705, point.y);
					}else{
						point.setLocation(685, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Malden Center")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(670, point.y);
					}else{
						point.setLocation(643, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Wellington")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(630, point.y);
					}else{
						point.setLocation(610, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Sullivan")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(592, point.y);
					}else{
						point.setLocation(572, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Community College")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(553, point.y);
					}else{
						point.setLocation(533, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("North Station")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(513, point.y);
					}else{
						point.setLocation(493, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Haymarket")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(473, point.y);
					}else{
						point.setLocation(453, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("State Street")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(433, point.y);
					}else{
						point.setLocation(413, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Downtown Crossing")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(393, point.y);
					}else{
						point.setLocation(373, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Chinatown")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(353, point.y);
					}else{
						point.setLocation(333, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Tufts Medical")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(313, point.y);
					}else{
						point.setLocation(293, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Back Bay")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(273, point.y);
					}else{
						point.setLocation(253, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Mass Ave")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(235, point.y);
					}else{
						point.setLocation(216, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Ruggles")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(195, point.y);
					}else{
						point.setLocation(180, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Roxbury Crossing")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(160, point.y);
					}else{
						point.setLocation(142, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Jackson Square")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(123, point.y);
					}else{
						point.setLocation(105, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Stony Brook")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(88, point.y);
					}else{
						point.setLocation(72, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Green Street")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(55, point.y);
					}else{
						point.setLocation(45, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Forest Hills")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(23, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}
					
				}
				
				
			}
			//if the train is Forest Hills Bound****************************
			if(_allTrainsList.get(2).getTrips().get(i).getDestination().compareTo("Forest Hills") == 0){
				
				point.setLocation(-100, 110);
				
				if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Oak Grove")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(698, point.y);
						g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
					}
					
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Malden Center")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(667, point.y);
					}else{
						point.setLocation(647, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Wellington")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(623, point.y);
					}else{
						point.setLocation(605, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Sullivan")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(584, point.y);
					}else{
						point.setLocation(565, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Community College")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(546, point.y);
					}else{
						point.setLocation(526, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("North Station")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(505, point.y);
					}else{
						point.setLocation(487, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Haymarket")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(465, point.y);
					}else{
						point.setLocation(445, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("State Street")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(427, point.y);
					}else{
						point.setLocation(407, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Downtown Crossing")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(387, point.y);
					}else{
						point.setLocation(367, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Chinatown")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(347, point.y);
					}else{
						point.setLocation(327, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Tufts Medical")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(307, point.y);
					}else{
						point.setLocation(288, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Back Bay")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(267, point.y);
					}else{
						point.setLocation(249, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Mass Ave")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(225, point.y);
					}else{
						point.setLocation(210, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Ruggles")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(192, point.y);
					}else{
						point.setLocation(172, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Roxbury Crossing")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(152, point.y);
					}else{
						point.setLocation(135, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Jackson Square")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(115, point.y);
					}else{
						point.setLocation(97, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Stony Brook")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(81, point.y);
					}else{
						point.setLocation(65, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Green Street")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(47, point.y);
					}else{
						point.setLocation(33, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Forest Hills")==0){
					if(_allTrainsList.get(2).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(16, point.y);
						g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
					}
					
				}
				
			}	
		}	
	}
	
	
	//places the train icons on the orange line
	private void paintRedTrains(Graphics g){
		
		for(int i = 0; i < _allTrainsList.get(0).getTrips().size(); i++){
			Point point = new Point(-100,0);
			//if the train is Ashmont Bound****************************
			if(_allTrainsList.get(0).getTrips().get(i).getDestination().compareTo("Ashmont") == 0){
				
				point.setLocation(point.x, 250);
				
				if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Ashmont")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(430, 200);
						g.drawImage(uphill, point.x, point.y, 100, 100, null);
					}else{
						point.setLocation(458, 182);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}
					//point = new Point(-100, 250);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Shawmut")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(420, 210);
					}else{
						point.setLocation(412, 220);
					}
					g.drawImage(uphill, point.x, point.y, 100, 100, null);
					//point = new Point(-100, 250);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Fields Corner")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(402, 229);
					}else{
						point.setLocation(392, 239);
					}
					g.drawImage(uphill, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Savin Hill")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(386, 245);
						g.drawImage(uphill, point.x, point.y, 100, 100, null);
					}else{
						point.setLocation(382, 250);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}	
				}
				
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("JFK/UMass")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(368, point.y);
					}else{
						point.setLocation(350, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Andrew")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(334, point.y);
					}else{
						point.setLocation(316, point.y);	
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Broadway")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(302, point.y);
					}else{
						point.setLocation(286, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("South Station")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(268, point.y);
					}else{
						point.setLocation(260, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Downtown Crossing")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(240, point.y);
					}else{
						point.setLocation(225, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Park Street")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(211, point.y);
					}else{
						point.setLocation(191, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Charles/MGH")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(183, point.y);
					}else{
						point.setLocation(170, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Kendall/MIT")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(155, point.y);
					}else{
						point.setLocation(142, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Central Square")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(129, point.y);
					}else{
						point.setLocation(114, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Harvard Square")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(100, point.y);
					}else{
						point.setLocation(87, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Porter Square")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(73, point.y);
					}else{
						point.setLocation(60, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Davis")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(46, point.y);
					}else{
						point.setLocation(34, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Alewife")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(22, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				
			}
			
			if(_allTrainsList.get(0).getTrips().get(i).getDestination().compareTo("Alewife") == 0){
				
				point.setLocation(point.x * -1, 182);
				
				if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Cedar Grove")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(487, point.y);
					}else{
						point.setLocation(473, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Butler")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(516, point.y);
					}else{
						point.setLocation(503, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Milton")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(548, point.y);
					}else{
						point.setLocation(532, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Central Ave")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(579, point.y);
					}else{
						point.setLocation(563, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
			}
			if(_allTrainsList.get(0).getTrips().get(i).getDestination().compareTo("Alewife") == 0){
				
				point.setLocation(-100, 302);
				
				if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Alewife")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(13, point.y);
					}else{
						point.setLocation(25, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Davis")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(38, point.y);
					}else{
						point.setLocation(51, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Porter Square")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(64, point.y);
					}else{
						point.setLocation(78, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Harvard Square")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(92, point.y);
					}else{
						point.setLocation(106, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Central Square")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(121, point.y);
					}else{
						point.setLocation(134, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Kendall/MIT")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(148, point.y);
					}else{
						point.setLocation(162, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Charles/MGH")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(175, point.y);
					}else{
						point.setLocation(189, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Park Street")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(203, point.y);
					}else{
						point.setLocation(219, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Downtown Crossing")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(232, point.y);
					}else{
						point.setLocation(246, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("South Station")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(264, point.y);
					}else{
						point.setLocation(278, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Broadway")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(295, point.y);
					}else{
						point.setLocation(312, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Andrew")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(327, point.y);
					}else{
						point.setLocation(342, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("JFK/UMass")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(360, point.y);
					}else{
						point.setLocation(375, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Savin Hill")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(393, point.y);
					}else{
						point.setLocation(410, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("North Quincy")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(540, point.y);
					}else{
						point.setLocation(555, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Wollaston")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(570, point.y);
					}else{
						point.setLocation(595, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Quincy Center")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(615, point.y);
					}else{
						point.setLocation(625, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Quincy Adams")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(636, point.y);
					}else{
						point.setLocation(654, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Braintree")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(670, point.y);
					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
			}
			if(_allTrainsList.get(0).getTrips().get(i).getDestination().compareTo("Braintree") == 0){
				
				point.setLocation(point.x, 250);
				if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Savin Hill")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(386, 245);
						g.drawImage(uphill, point.x, point.y, 100, 100, null);
					}else{
						point.setLocation(382, 250);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}	
				}
				
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("JFK/UMass")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(368, point.y);
					}else{
						point.setLocation(350, point.y);
					}
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Andrew")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(334, point.y);
					}else{
						point.setLocation(316, point.y);	
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Broadway")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(302, point.y);
					}else{
						point.setLocation(286, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("South Station")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(268, point.y);
					}else{
						point.setLocation(260, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Downtown Crossing")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(240, point.y);
					}else{
						point.setLocation(225, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Park Street")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(211, point.y);
					}else{
						point.setLocation(191, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Charles/MGH")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(183, point.y);
					}else{
						point.setLocation(170, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Kendall/MIT")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(155, point.y);
					}else{
						point.setLocation(142, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Central Square")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(129, point.y);
					}else{
						point.setLocation(114, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Harvard Square")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(100, point.y);
					}else{
						point.setLocation(87, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Porter Square")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(73, point.y);
					}else{
						point.setLocation(60, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Davis")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(46, point.y);
					}else{
						point.setLocation(34, point.y);
					}	
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Alewife")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(22, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}	
					
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("North Quincy")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(548, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}else{
						point.setLocation(500, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}	
					
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Wollaston")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(584, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}else{
						point.setLocation(568, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}	
					
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Quincy Center")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(624, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}else{
						point.setLocation(604, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}	
					
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Quincy Adams")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(662, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}else{
						point.setLocation(644, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}	
					
				}
				else if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Braintree")==0){
					if(_allTrainsList.get(0).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(702, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}
					
				}
			}
		}
		
	}
	private void paintBlueTrains(Graphics g){
		for(int i = 0; i < _allTrainsList.get(1).getTrips().size(); i++){
			
			
			Point point = new Point(-100,0);
			//if the train is Oak Grove Bound****************************
			if(_allTrainsList.get(1).getTrips().get(i).getDestination().compareTo("Wonderland") == 0){
				point.setLocation(point.x, 460);
				
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Bowdoin")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(18, point.y);
						g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
					}
					
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Government Center")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(70, point.y);
					}else{
						point.setLocation(50, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("State Street")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(130, point.y);
					}else{
						point.setLocation(100, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Aquarium")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(190, point.y);
					}else{
						point.setLocation(160, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Maverick")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(253, point.y);
					}else{
						point.setLocation(220, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Airport")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(316, point.y);
					}else{
						point.setLocation(283, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Wood Island")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(385, point.y);
					}else{
						point.setLocation(346, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Orient Heights")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(455, point.y);
					}else{
						point.setLocation(415, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Suffolk Downs")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(522, point.y);
					}else{
						point.setLocation(485, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Beachmont")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(586, point.y);
					}else{
						point.setLocation(552, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Revere Beach")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(648, point.y);
					}else{
						point.setLocation(616, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Wonderland")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(703, point.y);
					}else{
						point.setLocation(672, point.y);
					}
					
					g.drawImage(trainIcon, point.x, point.y, 100, 100, null);
				}
			}
			if(_allTrainsList.get(1).getTrips().get(i).getDestination().compareTo("Bowdoin") == 0){
				point.setLocation(point.x, 510);
				
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Bowdoin")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(13, point.y);
					}else{
						point.setLocation(31, point.y);
					}
					
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Government Center")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(61, point.y);
					}else{
						point.setLocation(91, point.y);
					}
					
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("State Street")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(123, point.y);
					}else{
						point.setLocation(153, point.y);
					}
					
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Aquarium")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(185, point.y);
					}else{
						point.setLocation(215, point.y);
					}
					
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Maverick")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(245, point.y);
					}else{
						point.setLocation(281, point.y);
					}
					
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Airport")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(310, point.y);
					}else{
						point.setLocation(340, point.y);
					}
					
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Wood Island")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(380, point.y);
					}else{
						point.setLocation(407, point.y);
					}
					
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Orient Heights")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(448, point.y);
					}else{
						point.setLocation(475, point.y);
					}
					
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Suffolk Downs")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(514, point.y);
					}else{
						point.setLocation(543, point.y);
					}
					
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Beachmont")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(580, point.y);
					}else{
						point.setLocation(610, point.y);
					}
					
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Revere Beach")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(642, point.y);
					}else{
						point.setLocation(667, point.y);
					}
					
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
				if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getStopName().compareTo("Wonderland")==0){
					if(_allTrainsList.get(1).getTrips().get(i).getPredictions().get(0).getSeconds() < 20){
						point.setLocation(693, point.y);
						g.drawImage(upsidedown, point.x, point.y, 100, 100, null);

					}
					g.drawImage(upsidedown, point.x, point.y, 100, 100, null);
				}
					
				
			}
		}
	}
	
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null); 
        this.paintTrains(g);
    }

	
	private void getTrainLocations()
	{
		getRedLineTrains();
	}
	
	private void getOrangeLineTrains()
	{
		GetOrangeTrainsSuccessClosure successClosure = new GetOrangeTrainsSuccessClosure();
		GetOrangeTrainsErrorClosure errorClosure = new GetOrangeTrainsErrorClosure();
		GetOrangeTrainsCancelClosure cancelClosure = new GetOrangeTrainsCancelClosure();
		
		_mbtaService.getOrangeLineTrains(successClosure, errorClosure, cancelClosure);
	}
	
	private void getBlueLineTrains()
	{
		GetBlueTrainsSuccessClosure successClosure = new GetBlueTrainsSuccessClosure();
		GetBlueTrainsErrorClosure errorClosure = new GetBlueTrainsErrorClosure();
		GetBlueTrainsCancelClosure cancelClosure = new GetBlueTrainsCancelClosure();
		
		_mbtaService.getBlueLineTrains(successClosure, errorClosure, cancelClosure);
	}
	
	private void getRedLineTrains()
	{
		GetRedTrainsSuccessClosure successClosure = new GetRedTrainsSuccessClosure();
		GetRedTrainsErrorClosure errorClosure = new GetRedTrainsErrorClosure();
		GetRedTrainsCancelClosure cancelClosure = new GetRedTrainsCancelClosure();
		
		_mbtaService.getRedLineTrains(successClosure, errorClosure, cancelClosure);
	}
	
	private class GetRedTrainsCancelClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			return null;
		}
	}

	private class GetRedTrainsErrorClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			Exception exception = data.getException();
			System.out.println("ERROR: " + exception.getMessage());

			return null;
		}
	}

	private class GetRedTrainsSuccessClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			TripList tripList = data.getTripList();
			_allTrainsList.add(tripList);
			getBlueLineTrains();
			return null;
		}
	}
	
	private class GetBlueTrainsCancelClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			return null;
		}
	}

	private class GetBlueTrainsErrorClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			Exception exception = data.getException();
			System.out.println("ERROR: " + exception.getMessage());

			return null;
		}
	}

	private class GetBlueTrainsSuccessClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			TripList tripList = data.getTripList();
			_allTrainsList.add(tripList);
			getOrangeLineTrains();
			return null;
		}
	}
	
	private class GetOrangeTrainsCancelClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			return null;
		}
	}

	private class GetOrangeTrainsErrorClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			Exception exception = data.getException();
			System.out.println("ERROR: " + exception.getMessage());

			return null;
		}
	}

	private class GetOrangeTrainsSuccessClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			TripList tripList = data.getTripList();
			_allTrainsList.add(tripList);
			
			return null;
		}
	}
	
	private void clearAllButtons(){
		for(int i = 0; i<this.getComponents().length; i++){
			System.out.println(this.getComponents()[i]);
		}
	}

	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource());
		
		if(e.getSource() instanceof MapWindow == false)
		clearAllButtons();
		repaint();
	}



	
	
	
	
	
}





