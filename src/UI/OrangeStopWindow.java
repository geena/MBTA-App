package UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.Predictions;



public class OrangeStopWindow extends StopWindow{
	private String BACKGROUND = "src/UI/OrangeStopWindow.png";
	List<Predictions> oakgrove;
	List<Predictions> foresthills;
	BufferedImage bg;
	public OrangeStopWindow(String name, MapWindow panel){
		super(name, panel);
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

	@Override
	void generateLabels() {
		// TODO Auto-generated method stub
		JLabel nameLabel = new JLabel(stopName);
		nameLabel.setBackground(null);
		nameLabel.setFont(font);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(200, this.getHeight()/2+100, 400, 400);
		add(nameLabel);
		oakgrove = ((MapWindow) parent).getOrangePredictions(stopName, "Oak Grove");
		foresthills = ((MapWindow) parent).getOrangePredictions(stopName, "Forest Hills");
		fillLabels();
		
		directionA.get(0).setFont(fontPrediction);
		directionA.get(0).setBounds(200, this.getHeight()/2-40, 400, 400);
		directionA.get(0).setHorizontalAlignment(SwingConstants.CENTER);
		add(directionA.get(0));
		
		directionA.get(1).setFont(fontPrediction);
		directionA.get(1).setBounds(200, this.getHeight()/2-80, 400, 400);
		directionA.get(1).setHorizontalAlignment(SwingConstants.CENTER);
		add(directionA.get(1));
		
		directionA.get(2).setFont(fontPrediction);
		directionA.get(2).setBounds(200, this.getHeight()/2-120, 400, 400);
		directionA.get(2).setHorizontalAlignment(SwingConstants.CENTER);
		add(directionA.get(2));
		
		directionB.get(0).setFont(fontPrediction);
		directionB.get(0).setBounds(200, this.getHeight()/2+240, 400, 400);
		directionB.get(0).setHorizontalAlignment(SwingConstants.CENTER);
		add(directionB.get(0));
		
		directionB.get(1).setFont(fontPrediction);
		directionB.get(1).setBounds(200, this.getHeight()/2+280, 400, 400);
		directionB.get(1).setHorizontalAlignment(SwingConstants.CENTER);
		add(directionB.get(1));
		
		directionB.get(2).setFont(fontPrediction);
		directionB.get(2).setBounds(200, this.getHeight()/2+320, 400, 400);
		directionB.get(2).setHorizontalAlignment(SwingConstants.CENTER);
		add(directionB.get(2));
	}
	
	private void fillLabels(){
		int smallestInt = 0;
		List<Integer> indexVisitedA = new ArrayList<Integer>();
		List<Integer> indexVisitedB = new ArrayList<Integer>();
		for(int j = 0; j < 3; j++){
			smallestInt = -1;
			
			for(int i = 0; i < oakgrove.size(); i++){
				if((oakgrove.get(i).getSeconds()< smallestInt 
						&& indexVisitedA.indexOf(oakgrove.get(i).getSeconds()) == -1)
						|| smallestInt == -1){
					smallestInt = oakgrove.get(i).getSeconds();
					indexVisitedA.add(smallestInt);
				}
			}
			directionA.add(new JLabel(((Integer)smallestInt).toString()));	
			smallestInt = -1;
			for(int i = 0; i < foresthills.size(); i++){
				if((foresthills.get(i).getSeconds()< smallestInt 
						&& indexVisitedB.indexOf(foresthills.get(i).getSeconds()) == -1)
						|| smallestInt == -1){
					smallestInt = foresthills.get(i).getSeconds();
					indexVisitedB.add(smallestInt);
				}
			}
			directionB.add(new JLabel(((Integer)smallestInt).toString()));

		}
		
		
		messages();
		
		
	}
	
}