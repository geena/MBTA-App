package UI;



import java.awt.Color;
import java.awt.Dimension;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import commons.Algorithms;
import commons.IStation;
import commons.IntersectionStation;
import commons.LineColor;
import commons.Station;
import commons.UserOptions;




public class Main extends JFrame implements MouseListener{
	
	private List<IStation> _redLineStations = new ArrayList<IStation>();
	private List<IStation> _blueLineStations = new ArrayList<IStation>();
	private List<IStation> _orangeLineStations = new ArrayList<IStation>();
	JDialog redSplit;
	final JButton ashmont = new JButton("Ashmont");
	final JButton braintree = new JButton("Braintree");
	
	//orange line button placement
	StopButton oforesthills = new StopButton("Forest Hills", 53, 119, "7001", "7001", Color.orange, true);
	StopButton ogreenst = new StopButton("Green Street",85, 121, "7003", "7002", Color.orange, false);
	StopButton ostonybrook = new StopButton("Stony Brook", 118, 121, "7005", "7004", Color.orange, false);
	StopButton ojacksonsquare = new StopButton("Jackson Square", 153, 121, "7007", "7006", Color.orange, false);
	StopButton oroxburycrossing = new StopButton("Roxbury Crossing", 190, 121, "7009", "7008", Color.orange, false);
	StopButton oruggles = new StopButton("Ruggles", 228, 121, "7011", "7010", Color.orange, false);
	StopButton omassave = new StopButton("Mass Ave", 265, 121, "7013", "7012", Color.orange, false);
	StopButton obackbay = new StopButton("Back Bay", 305, 121, "7015", "7014", Color.orange, false);
	StopButton otuftsmedical = new StopButton("Tufts Medical", 345, 121, "7017", "7016", Color.orange, false);
	StopButton ochinatown = new StopButton("Chinatown", 385, 121, "7019", "7018", Color.orange, false);
	StopButton odowntowncrossing = new StopButton("Downtown Crossing", 425, 121, "7021", "7020", Color.orange, false);
	StopButton ostate = new StopButton("State Street", 464, 121, "7023", "7022", Color.orange, false);
	StopButton ohaymarket = new StopButton("Haymarket", 504, 121, "7025", "7024", Color.orange, false);
	StopButton onorthstation = new StopButton("North Station", 543, 121, "7027", "7026", Color.orange, false);
	StopButton ocommunitycollege = new StopButton("Community College", 583, 121, "7029", "7028", Color.orange, false);
	StopButton osullivansquare = new StopButton("Sullivan", 622, 121, "7031", "7030", Color.orange, false);
	StopButton owellington = new StopButton("Wellington", 661, 121, "7033", "7032", Color.orange, false);
	StopButton omalden = new StopButton("Malden Center", 701, 121, "7035", "7034", Color.orange, false);
	StopButton ooakgrove = new StopButton("Oak Grove", 733, 120, "7036", "7036", Color.orange, true);	
	
	//red line button placement
	StopButton ralewife = new StopButton("Alewife", 49, 311, "7061", "7061", Color.red, true);
	StopButton rdavis = new StopButton("Davis", 76, 312, "7063", "7064", Color.red, false);
	StopButton rporter = new StopButton("Porter Square", 103, 312, "7065", "7066", Color.red, false);
	StopButton rharvard = new StopButton("Harvard Square", 131, 312, "7067", "7068", Color.red, false);
	StopButton rcentral = new StopButton("Central Square", 159, 312, "7069", "7070", Color.red, false);
	StopButton rkendall = new StopButton("Kendall/MIT", 185, 312, "7071", "7072", Color.red, false);
	StopButton rcharles = new StopButton("Charles/MGH",214, 312, "7073", "7074", Color.red, false);
	StopButton rparkst = new StopButton("Park Street", 241, 312, "7075", "7076", Color.red, false);
	StopButton rdowntown = new StopButton("Downtown Crossing", 271, 312, "7077", "7078", Color.red, false);
	StopButton rsouthstation = new StopButton("South Station", 301, 312, "7079", "7080", Color.red, false);
	StopButton rbroadway = new StopButton("Broadway", 333, 312, "7081", "7082", Color.red, false);
	StopButton randrew = new StopButton("Andrew", 366, 312, "7083", "7084", Color.red, false);
	StopButton rjfkAshmont = new StopButton("JFK/UMass", 398, 312, "7085", "7086", Color.red, false);
	StopButton rsavinhill = new StopButton("Savin Hill", 431, 312, "7087", "7088", Color.red, false);
	StopButton rfieldscorner = new StopButton("Fields Corner", 451, 290, "7089", "7090", Color.red, false);
	StopButton rshawmut = new StopButton("Shawmut", 470, 268, "7091", "7092", Color.red, false);
	StopButton rashmont = new StopButton("Ashmont", 491, 244, "7093", "7094", Color.red, false);
	StopButton rjfkBraintree = new StopButton("JFK/UMass", 398, 312, "7095", "7096", Color.red, false);
	StopButton rnorthquincy = new StopButton("North Quincy", 578, 312, "7097", "7098", Color.red, false);
	StopButton rwollaston = new StopButton("Wollaston", 614, 312, "7099", "70100", Color.red, false);
	StopButton rquincycenter = new StopButton("Quincy Center", 654, 312, "70101", "70102", Color.red, false);
	StopButton rquincyadams = new StopButton("Quincy Adams", 692, 312, "70103", "70104", Color.red, false);
	StopButton rbraintree = new StopButton("Braintree", 730, 311, "70103", "70104", Color.red, true);
	StopButton rcedargrove = new StopButton("Cedar Grove", 518, 244, "70105", "70106", Color.red, false);
	StopButton rbutler = new StopButton("Butler", 547, 244, "7097", "7098", Color.red, false);
	StopButton rmilton = new StopButton("Milton", 578, 244, "7099", "70100", Color.red, false);
	StopButton rcentralave = new StopButton("Central Ave", 608, 244, "70101", "70102", Color.red, false);
	StopButton rvalleyrd = new StopButton("Valley Road", 641, 244, "70103", "70104", Color.red, false);
	StopButton rcapenst = new StopButton("Capen Street", 671, 244, "70105", "70106", Color.red, false);
	StopButton rmattapan = new StopButton("Mattapan", 699, 243, "70107", "70108", Color.red, true);
	
	//blue line button placement
	StopButton bbowdoin = new StopButton("Bowdoin", 50, 517, "7039", "7039", Color.blue, true);
	StopButton bgovctr = new StopButton("Government Center", 99, 518, "7040", "7041", Color.blue, false);
	StopButton bstate = new StopButton("State Street", 160, 518, "7042", "7043", Color.blue, false);
	StopButton baquarium = new StopButton("Aquarium", 221, 518, "7044", "7045", Color.blue, false);
	StopButton bmaverick = new StopButton("Maverick", 284, 518, "7046", "7047", Color.blue, false);
	StopButton bairport = new StopButton("Airport", 347, 518, "7048", "7049", Color.blue, false);
	StopButton bwoodisland = new StopButton("Wood Island", 417, 518, "7050", "7051", Color.blue, false);
	StopButton borientheights = new StopButton("Orient Heights", 485, 518, "7052", "7053", Color.blue, false);
	StopButton bsuffolkdowns = new StopButton("Suffolk Downs", 552, 518, "7054", "7055", Color.blue, false);
	StopButton bbeachmont = new StopButton("Beachmont", 616, 518, "7056", "7057", Color.blue, false);
	StopButton breverebeach = new StopButton("Revere Beach", 679, 518, "7058", "7059", Color.blue, false);
	StopButton bwonderland = new StopButton("Wonderland", 728, 516, "7060", "7060", Color.blue, true);
			
	List<StopButton> oLine = new ArrayList<StopButton>();
	List<StopButton> rLine = new ArrayList<StopButton>();
	List<StopButton> bLine = new ArrayList<StopButton>();
	StopButton current;
	
	MapWindow window;
	JPanel subMenu = new JPanel();
	String [] priorityChoices = { "Fastest Route", "Earliest Departure", "Earliest Arrival", "Fewest Transfers"};
	String [] tripChoices = { "Ordered", "Unordered"};
	String [] ampm = { "AM", "PM"};
	String [] departureArrival = { "None","Departure", "Arrival"};
	JComboBox priority = new JComboBox(priorityChoices);
	JComboBox trip = new JComboBox(tripChoices);
	JComboBox departureArrivalBox = new JComboBox(departureArrival);
	SpinnerNumberModel hour = new SpinnerNumberModel(1, 1, 12, 1);
	SpinnerNumberModel minutes = new SpinnerNumberModel(1, 1, 60, 1);
	JSpinner hourSpinner = new JSpinner(hour);
	JSpinner minuteSpinner = new JSpinner(minutes);
	JButton makeTrip = new JButton("Plan Trip");
	JComboBox ampmMenu = new JComboBox(ampm);
	BoxLayout layout;
	JLabel orderedLabel = new JLabel("Ordered/Unordered:");
	JLabel priorityLabel = new JLabel("Priority:");
	JLabel departureTimeLabel = new JLabel("Departure/Arrival Time:");
	
	public Main(){
		
		ashmont.setSize(100, 50);
		braintree.setSize(100, 50);
		ashmont.addMouseListener(this);
		braintree.addMouseListener(this);
		
		
		subMenu.add(orderedLabel);
		subMenu.add(trip);
		subMenu.add(priorityLabel);
		subMenu.add(priority);
		subMenu.add(departureTimeLabel);
		subMenu.add(departureArrivalBox);
		subMenu.add(hourSpinner);
		subMenu.add(minuteSpinner);
		subMenu.add(ampmMenu);
		subMenu.add(makeTrip);
		subMenu.setBorder(BorderFactory.createBevelBorder(1));
		
		trip.addMouseListener(this);
		priority.addMouseListener(this);
		departureArrivalBox.addMouseListener(this);
		hourSpinner.addMouseListener(this);
		minuteSpinner.addMouseListener(this);
		makeTrip.addMouseListener(this);
		
		
		oLine.add(oforesthills);
		oLine.add(ogreenst);
		oLine.add(ostonybrook);
		oLine.add(ojacksonsquare);
		oLine.add(oroxburycrossing);
		oLine.add(oruggles);
		oLine.add(omassave);
		oLine.add(obackbay);
		oLine.add(otuftsmedical);
		oLine.add(ochinatown);
		oLine.add(odowntowncrossing);
		oLine.add(ostate);
		oLine.add(ohaymarket);
		oLine.add(onorthstation);
		oLine.add(ocommunitycollege);
		oLine.add(osullivansquare);
		oLine.add(owellington);
		oLine.add(omalden);
		oLine.add(ooakgrove);
		
		
		
		rLine.add(ralewife);
		rLine.add(rdavis);
		rLine.add(rporter);
		rLine.add(rharvard);
		rLine.add(rcentral);
		rLine.add(rkendall);
		rLine.add(rcharles);
		rLine.add(rparkst);
		rLine.add(rdowntown);
		rLine.add(rsouthstation);
		rLine.add(rbroadway);
		rLine.add(randrew);
		rLine.add(rjfkAshmont);
		rLine.add(rjfkBraintree);
		rLine.add(rsavinhill);
		rLine.add(rfieldscorner);
		rLine.add(rshawmut);
		rLine.add(rashmont);
		rLine.add(rcedargrove);
		rLine.add(rbutler);
		rLine.add(rmilton);
		rLine.add(rcentralave);
		rLine.add(rvalleyrd);
		rLine.add(rcapenst);
		rLine.add(rnorthquincy);
		rLine.add(rwollaston);
		rLine.add(rquincycenter);
		rLine.add(rquincyadams);
		rLine.add(rbraintree);
		rLine.add(rmattapan);

		bLine.add(bbowdoin);
		bLine.add(bgovctr);
		bLine.add(bstate);
		bLine.add(baquarium);
		bLine.add(bmaverick);
		bLine.add(bairport);
		bLine.add(bwoodisland);
		bLine.add(borientheights);
		bLine.add(bsuffolkdowns);
		bLine.add(bbeachmont);
		bLine.add(breverebeach);
		bLine.add(bwonderland);
		
		for(StopButton button : rLine)
		{
			if(button.sName.equals("Downtown Crossing"))
			{
				List<LineColor> lineColorList = new ArrayList<LineColor>();
				lineColorList.add(LineColor.RED);
				lineColorList.add(LineColor.ORANGE);
				IntersectionStation newStation = new IntersectionStation(button, lineColorList);
				_redLineStations.add(newStation);
			}else
			{
				Station newStation = new Station(button, LineColor.RED);
				_redLineStations.add(newStation);
			}
		}
		
		for(StopButton button : oLine)
		{
			if(button.sName.equals("Downtown Crossing"))
			{
				List<LineColor> lineColorList = new ArrayList<LineColor>();
				lineColorList.add(LineColor.RED);
				lineColorList.add(LineColor.ORANGE);
				IntersectionStation newStation = new IntersectionStation(button, lineColorList);
				_redLineStations.add(newStation);
			}else if(button.sName.equals("State Street"))
			{
				List<LineColor> lineColorList = new ArrayList<LineColor>();
				lineColorList.add(LineColor.BLUE);
				lineColorList.add(LineColor.ORANGE);
				IntersectionStation newStation = new IntersectionStation(button, lineColorList);
				_orangeLineStations.add(newStation);
			}else
			{
				Station newStation = new Station(button, LineColor.ORANGE);
				_orangeLineStations.add(newStation);
			}
		}
		
		for(StopButton button : bLine)
		{
			if(button.sName.equals("State Street"))
			{
				List<LineColor> lineColorList = new ArrayList<LineColor>();
				lineColorList.add(LineColor.BLUE);
				lineColorList.add(LineColor.ORANGE);
				IntersectionStation newStation = new IntersectionStation(button, lineColorList);
				_blueLineStations.add(newStation);
			}else
			{
				Station newStation = new Station(button, LineColor.BLUE);
				_blueLineStations.add(newStation);
			}
		}
		
		window = new MapWindow();
		//orange line mouse listeners
		oforesthills.addMouseListener(this);
		ogreenst.addMouseListener(this);
		ostonybrook.addMouseListener(this);
		ojacksonsquare.addMouseListener(this);
		oroxburycrossing.addMouseListener(this);
		oruggles.addMouseListener(this);
		omassave.addMouseListener(this);
		obackbay.addMouseListener(this);
		otuftsmedical.addMouseListener(this);
		ochinatown.addMouseListener(this);
		odowntowncrossing.addMouseListener(this);
		ostate.addMouseListener(this);
		ohaymarket.addMouseListener(this);
		onorthstation.addMouseListener(this);
		ocommunitycollege.addMouseListener(this);
		osullivansquare.addMouseListener(this);
		owellington.addMouseListener(this);
		omalden.addMouseListener(this);
		ooakgrove.addMouseListener(this);
		
        
        
      //adding orange line buttons to panel
  		window.add(oforesthills);
  		window.add(ogreenst);
  		window.add(ostonybrook);
  		window.add(ojacksonsquare);
  		window.add(oroxburycrossing);
  		window.add(oruggles);
  		window.add(omassave);
  		window.add(obackbay);
  		window.add(otuftsmedical);
  		window.add(ochinatown);
  		window.add(odowntowncrossing);
  		window.add(ostate);
  		window.add(ohaymarket);
  		window.add(onorthstation);
  		window.add(ocommunitycollege);
  		window.add(osullivansquare);
  		window.add(owellington);
  		window.add(omalden);
  		window.add(ooakgrove);
  		
  		//red line listener
  		ralewife.addMouseListener(this);
  		rdavis.addMouseListener(this);
  		rporter.addMouseListener(this);
  		rharvard.addMouseListener(this);
  		rcentral.addMouseListener(this);
  		rkendall.addMouseListener(this);
  		rcharles.addMouseListener(this);
  		rparkst.addMouseListener(this);
  		rdowntown.addMouseListener(this);
  		rsouthstation.addMouseListener(this);
  		rbroadway.addMouseListener(this);
  		randrew.addMouseListener(this);
  		rjfkAshmont.addMouseListener(this);
  		rjfkBraintree.addMouseListener(this);
  		rsavinhill.addMouseListener(this);
  		rfieldscorner.addMouseListener(this);
  		rshawmut.addMouseListener(this);
  		rashmont.addMouseListener(this);
  		rcedargrove.addMouseListener(this);
  		rbutler.addMouseListener(this);
  		rmilton.addMouseListener(this);
  		rcentralave.addMouseListener(this);
  		rvalleyrd.addMouseListener(this);
  		rcapenst.addMouseListener(this);
  		rmattapan.addMouseListener(this);
  		rnorthquincy.addMouseListener(this);
  		rwollaston.addMouseListener(this);
  		rquincycenter.addMouseListener(this);
  		rquincyadams.addMouseListener(this);
  		rbraintree.addMouseListener(this);
  		
  		//adding red line buttons to panel
  		window.add(ralewife);
  		window.add(rdavis);
  		window.add(rporter);
  		window.add(rharvard);
  		window.add(rcentral);
  		window.add(rkendall);
  		window.add(rcharles);
  		window.add(rparkst);
  		window.add(rdowntown);
  		window.add(rsouthstation);
  		window.add(rbroadway);
  		window.add(randrew);
  		window.add(rjfkAshmont);
  		window.add(rjfkBraintree);
  		window.add(rsavinhill);
  		window.add(rfieldscorner);
  		window.add(rshawmut);
  		window.add(rashmont);
  		window.add(rcedargrove);
  		window.add(rbutler);
  		window.add(rmilton);
  		window.add(rcentralave);
  		window.add(rvalleyrd);
  		window.add(rcapenst);
  		window.add(rmattapan);
  		window.add(rnorthquincy);
  		window.add(rwollaston);
  		window.add(rquincycenter);
  		window.add(rquincyadams);
  		window.add(rbraintree);
  		
  		//
  		bbowdoin.addMouseListener(this);
  		bgovctr.addMouseListener(this);
  		bstate.addMouseListener(this);
  		baquarium.addMouseListener(this);
  		bmaverick.addMouseListener(this);
  		bairport.addMouseListener(this);
  		bwoodisland.addMouseListener(this);
  		borientheights.addMouseListener(this);
  		bsuffolkdowns.addMouseListener(this);
  		bbeachmont.addMouseListener(this);
  		breverebeach.addMouseListener(this);
  		bwonderland.addMouseListener(this);
  		
  		//adding blue line buttons to panel
  		window.add(bbowdoin);
  		window.add(bgovctr);
  		window.add(bstate);
  		window.add(baquarium);
  		window.add(bmaverick);
  		window.add(bairport);
  		window.add(bwoodisland);
  		window.add(borientheights);
  		window.add(bsuffolkdowns);
  		window.add(bbeachmont);
  		window.add(breverebeach);
  		window.add(bwonderland);
  		//window.setSize(800, 600);
  		window.setPreferredSize(new Dimension(800, 500));
  		layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
  		setLayout(layout);
  		this.add(window);
  		
  		
  		
  		setLocationRelativeTo(null);
        setTitle("MBTA");
        setSize(800, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
           
            
	}
	
	private void updateOptions(){
		if(trip.getSelectedIndex() == 0){
			UserOptions.ordered = true;
		}else{
			UserOptions.ordered = false;
		}
		
		if(priority.getSelectedIndex() == 0){
			UserOptions.earliestDeparture = false;
			UserOptions.fastestRoute = true;
			UserOptions.earliestArrival = false;
			UserOptions.fewestTransfers = false;
		}else if(priority.getSelectedIndex() == 1){
			UserOptions.earliestDeparture = true;
			UserOptions.fastestRoute = false;
			UserOptions.earliestArrival = false;
			UserOptions.fewestTransfers = false;
		}else if(priority.getSelectedIndex() == 2){
			UserOptions.earliestDeparture = false;
			UserOptions.fastestRoute = false;
			UserOptions.earliestArrival = true;
			UserOptions.fewestTransfers = false;
		}else if(priority.getSelectedIndex() == 3){
			UserOptions.earliestDeparture = false;
			UserOptions.fastestRoute = false;
			UserOptions.earliestArrival = false;
			UserOptions.fewestTransfers = true;
		}
		
	}
	
	private void setTime(){
		if(departureArrivalBox.getSelectedIndex() != 0){
			Long time = new Long(0);
			
		}
		
		
		
	}
	
	public static void main(String[] args){
		new Main();
	}

	public List<IStation> getRedLineStations()
	{
		return _redLineStations;
	}
	
	public List<IStation> getBlueLineStations()
	{
		return _blueLineStations;
	}
	
	public List<IStation> getOrangeLineStations()
	{
		return _orangeLineStations;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		StopWindow stop;
		if(e.getSource() instanceof JComboBox){
			updateOptions();
		}
		if(e.getSource() == makeTrip){
			
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			//frame.add(new InstructionsWindow(Algorithms.executeTask().get(0)));
			frame.setVisible(true);
		}
		if(e.getSource() == ashmont){
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(800,600);
			stop = window.openRedWindowAshmont(current);
			frame.add(stop);
			frame.setVisible(true);
		}
		if(e.getSource() == braintree){
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(800,600);
			stop = window.openRedWindowBraintree(current);
			frame.add(stop);
			frame.setVisible(true);
		}
		if(e.getClickCount() == 2 && e.getSource() instanceof StopButton){
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setSize(800,600);
			current = (StopButton)e.getSource();
			if(current.lineColor == Color.orange){
				stop = window.openOrangeWindow(current);
				frame.add(stop);
				frame.setVisible(true);
			}else if(current.lineColor == Color.blue){
				stop = window.openBlueWindow(current);
				frame.add(stop);
				frame.setVisible(true);
			}else{
				redSplit = new JDialog();
				redSplit.setLayout(new GridLayout(1,2));
				redSplit.add(ashmont);
				redSplit.add(braintree);
				redSplit.setSize(300,100);
				redSplit.setVisible(true);
				redSplit.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
				redSplit.setModal(true);
			}
			
			
			
		}else if(e.getSource() instanceof StopButton){
			current = (StopButton)e.getSource();
			current.singleClicked();
			window.processClick(current);
			if(window.stops.size() > 1){
				subMenuActivation();
			}else{
				subMenuDeactivation();
			}
			
		}
		
		
	}
	
	private void subMenuActivation(){
		this.add(subMenu);
		this.setSize(800, 725);
		repaint();
	}
	
	private void subMenuDeactivation(){
		this.remove(subMenu);
		this.setSize(800, 600);
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}