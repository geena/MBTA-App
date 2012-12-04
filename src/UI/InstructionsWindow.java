package UI;

import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import commons.Algorithms.Direction;



public class InstructionsWindow extends JPanel{
	
	JList list;
	JScrollPane pane;
	List<Direction> info;
	public InstructionsWindow(List<Direction> l){
		info = l;
		list = new JList();
		populate();
		pane = new JScrollPane(list);
		add(pane);
	}
	
	private void populate(){
		String [] temp = new String[info.size()];
		for(int i = 0; i < info.size(); i++){
			temp[i] = info.get(i).getInstruction();
		}
		list = new JList(temp);
	}
}