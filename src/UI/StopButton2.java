package UI;

import java.awt.Insets;

import javax.swing.*;


public class StopButton2 extends JButton{
	private String LITTLEACTIVEICON = "src/UI/LittleActive.png";
	private String BIGACTIVEICON = "src/UI/BigActive.png";
	private String LITTLEINACTIVEICON = "src/UI/LittleInactive.png";
	private String BIGINACTIVEICON = "src/UI/BigInactive.png";
	private ImageIcon bigActive;
	private ImageIcon littleActive;
	private ImageIcon bigInactive;
	private ImageIcon littleInactive;
	public StopButton2(){
		bigActive = new ImageIcon(BIGACTIVEICON);
		littleActive = new ImageIcon(LITTLEACTIVEICON);
		bigInactive = new ImageIcon(BIGINACTIVEICON);
		littleInactive = new ImageIcon(LITTLEINACTIVEICON);
		setIcon(littleActive);
		setMargin(new Insets(0, 0, 0, 0));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);
        setBounds(100, 100, 50, 50);
	}
}