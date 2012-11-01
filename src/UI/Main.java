
import javax.swing.JFrame;
import javax.swing.JPanel;




public class Main extends JFrame{
	
	public Main(){
		add(new MapWindow());
		setLocationRelativeTo(null);
        setTitle("MBTA");
        setSize(800, 800);
        setResizable(false);
        setVisible(true);
	}
	
	public static void main(String[] args){
		new Main();
	}
}