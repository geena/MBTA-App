package UI;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import commons.Algorithms.Direction;



public class InstructionsWindow extends JPanel{
	Font font = new Font("Myriad Pro", Font.PLAIN, 36);
	JList list;
	JScrollPane pane;
	List<Direction> info;
	public InstructionsWindow(List<Direction> l){
		info = l;
		list = new JList();
		populate();
		pane = new JScrollPane(list);
		pane.setFont(font);
		pane.setPreferredSize(new Dimension(300,400));
		add(pane);
	}
	
	private void populate(){
		String [] temp = new String[info.size()];
		for(int i = 0; i < info.size(); i++){
			temp[i] = info.get(i).getInstruction() + " @ " + info.get(i).getStation();
		}
		list = new JList(temp);
	}
}