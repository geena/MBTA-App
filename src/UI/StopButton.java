package UI;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;





public class StopButton extends JButton{
	boolean selected; // if the stop has been selected
	String sName;
	String stopIDa; //stopID in one direction
	String stopIDb; //stopID in the other direction
	int x;// xcoordinate on the screen
	int y;// xcoordinate on the screen
	private String LITTLEACTIVEICON = "src/UI/LittleActive.png";
	private String BIGACTIVEICON = "src/UI/BigActive.png";
	private String LITTLEINACTIVEICON = "src/UI/LittleInactive.png";
	private String BIGINACTIVEICON = "src/UI/BigInactive.png";
	private ImageIcon bigActive;
	private ImageIcon littleActive;
	private ImageIcon bigInactive;
	private ImageIcon littleInactive;
	Color line;
	Boolean isEnd;
	public StopButton(String name, int x, int y, String ida, String idb, Color l, Boolean end){
		bigActive = new ImageIcon(BIGACTIVEICON);
		littleActive = new ImageIcon(LITTLEACTIVEICON);
		bigInactive = new ImageIcon(BIGINACTIVEICON);
		littleInactive = new ImageIcon(LITTLEINACTIVEICON);
		isEnd = end;
		if(isEnd){
			this.setIcon(bigInactive);
		}else{
			this.setIcon(littleInactive);
		}
		this.setEnabled(true);
		sName = name;
		selected = false;
		this.x = x + 5;
		this.y = y + 5;
		this.setBounds(x,y, 23, 23);
		this.stopIDa = ida;
		this.stopIDb = idb;
		line = l;
		
        setMargin(new Insets(0, 0, 0, 0));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);
		
	}
	//returns x coordinate
	public int getX(){
		return x;
	}
	//returns y coordinate
	public int getY(){
		return y;
	}
	//returns first Stop ID
	public String getStopA(){
		return stopIDa;
	}
	//returns second Stop ID
	public String getStopB(){
		return stopIDb;
	}
	
	public void singleClicked(){
		if(isEnd){
			if(this.selected){
				selected = false;
				this.setIcon(bigInactive);
			}else{
				selected = true;
				this.setIcon(bigActive);
			}
		}else{
			if(this.selected){
				selected = false;
				this.setIcon(littleInactive);
			}else{
				selected = true;
				this.setIcon(littleActive);
			}
		}
		
	}
	
	
	
	
}