package UI;


import javax.swing.JPanel;
import javax.swing.JLabel;

import models.Predictions;



import java.awt.Font;
import java.util.ArrayList;
import java.util.List;




public abstract class StopWindow extends JPanel{
	Font font = new Font("Myriad Pro", Font.PLAIN, 56);
	Font fontPrediction = new Font("Myriad Pro", Font.PLAIN, 36);
	String stopName;
	JPanel parent;
	List<JLabel> directionA;
	List<JLabel> directionB;
	public StopWindow(String name, MapWindow panel){
		directionA = new ArrayList<JLabel>();
		directionB = new ArrayList<JLabel>();
		stopName = name;
		parent = panel;
		this.setLayout(null);
		generateLabels();
		
	}
	
	abstract void generateLabels();
	
	protected void messages(){
		Integer seconds = 0;
		Integer minutes = 0;
		for(int i = 0; i < directionA.size(); i++){
			seconds = Integer.parseInt(directionA.get(i).getText());
			System.out.println(seconds);
			if(seconds > 60){
				minutes = seconds/60;
				seconds = seconds - (minutes * 60);
				directionA.get(i).setText(minutes + " minutes " + seconds + " seconds");
			}else{
				directionA.get(i).setText(seconds + " seconds");
			}
			
		}
		for(int i = 0; i < directionB.size(); i++){
			seconds = Integer.parseInt(directionB.get(i).getText());
			if(seconds > 60){
				minutes = seconds/60;
				seconds = seconds - (minutes * 60);
				directionB.get(i).setText(minutes + " minutes " + seconds + " seconds");
			}else{
				directionB.get(i).setText(seconds + " seconds");
			}
			
		}
	}
	
}