package UI;

import javax.swing.JPanel;



public abstract class StopWindow extends JPanel{
	String stopName;
	public StopWindow(String name){
		stopName = name;
	}
}