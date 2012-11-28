package UI;


import javax.swing.JFrame;

import UI.map.MapController;




public class Main extends JFrame{
	
	public Main(){
		MapController mapController = new MapController();
		add(mapController.getView());
		setLocationRelativeTo(null);
        setTitle("MBTA");
        setSize(800, 800);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new Main();
	}
}