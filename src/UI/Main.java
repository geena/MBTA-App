package UI;


import javax.swing.JFrame;




public class Main extends JFrame{
	
	public Main(){
		add(new MapWindow());
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