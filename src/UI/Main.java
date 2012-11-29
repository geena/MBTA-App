package UI;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;




public class Main extends JFrame implements MouseListener{
	//orange line button placement
	StopButton oforesthills = new StopButton(53, 119, "7001", "7001", Color.orange, true);
	StopButton ogreenst = new StopButton(85, 121, "7003", "7002", Color.orange, false);
	StopButton ostonybrook = new StopButton(118, 121, "7005", "7004", Color.orange, false);
	StopButton ojacksonsquare = new StopButton(153, 121, "7007", "7006", Color.orange, false);
	StopButton oroxburycrossing = new StopButton(190, 121, "7009", "7008", Color.orange, false);
	StopButton oruggles = new StopButton(228, 121, "7011", "7010", Color.orange, false);
	StopButton omassave = new StopButton(265, 121, "7013", "7012", Color.orange, false);
	StopButton obackbay = new StopButton(305, 121, "7015", "7014", Color.orange, false);
	StopButton otuftsmedical = new StopButton(345, 121, "7017", "7016", Color.orange, false);
	StopButton ochinatown = new StopButton(385, 121, "7019", "7018", Color.orange, false);
	StopButton odowntowncrossing = new StopButton(425, 121, "7021", "7020", Color.orange, false);
	StopButton ostate = new StopButton(464, 121, "7023", "7022", Color.orange, false);
	StopButton ohaymarket = new StopButton(504, 121, "7025", "7024", Color.orange, false);
	StopButton onorthstation = new StopButton(543, 121, "7027", "7026", Color.orange, false);
	StopButton ocommunitycollege = new StopButton(583, 121, "7029", "7028", Color.orange, false);
	StopButton osullivansquare = new StopButton(622, 121, "7031", "7030", Color.orange, false);
	StopButton owellington = new StopButton(661, 121, "7033", "7032", Color.orange, false);
	StopButton omalden = new StopButton(701, 121, "7035", "7034", Color.orange, false);
	StopButton ooakgrove = new StopButton(733, 120, "7036", "7036", Color.orange, true);	
	
	//red line button placement
	StopButton ralewife = new StopButton(49, 311, "7061", "7061", Color.red, true);
	StopButton rdavis = new StopButton(76, 312, "7063", "7064", Color.red, false);
	StopButton rporter = new StopButton(103, 312, "7065", "7066", Color.red, false);
	StopButton rharvard = new StopButton(131, 312, "7067", "7068", Color.red, false);
	StopButton rcentral = new StopButton(159, 312, "7069", "7070", Color.red, false);
	StopButton rkendall = new StopButton(185, 312, "7071", "7072", Color.red, false);
	StopButton rcharles = new StopButton(214, 312, "7073", "7074", Color.red, false);
	StopButton rparkst = new StopButton(241, 312, "7075", "7076", Color.red, false);
	StopButton rdowntown = new StopButton(271, 312, "7077", "7078", Color.red, false);
	StopButton rsouthstation = new StopButton(301, 312, "7079", "7080", Color.red, false);
	StopButton rbroadway = new StopButton(333, 312, "7081", "7082", Color.red, false);
	StopButton randrew = new StopButton(366, 312, "7083", "7084", Color.red, false);
	StopButton rjfkAshmont = new StopButton(398, 312, "7085", "7086", Color.red, false);
	StopButton rsavinhill = new StopButton(431, 312, "7087", "7088", Color.red, false);
	StopButton rfieldscorner = new StopButton(451, 290, "7089", "7090", Color.red, false);
	StopButton rshawmut = new StopButton(470, 268, "7091", "7092", Color.red, false);
	StopButton rashmont = new StopButton(491, 244, "7093", "7094", Color.red, false);
	StopButton rjfkBraintree = new StopButton(398, 312, "7095", "7096", Color.red, false);
	StopButton rnorthquincy = new StopButton(578, 312, "7097", "7098", Color.red, false);
	StopButton rwollaston = new StopButton(614, 312, "7099", "70100", Color.red, false);
	StopButton rquincycenter = new StopButton(654, 312, "70101", "70102", Color.red, false);
	StopButton rquincyadams = new StopButton(692, 312, "70103", "70104", Color.red, false);
	StopButton rbraintree = new StopButton(730, 311, "70103", "70104", Color.red, true);
	StopButton rcedargrove = new StopButton(518, 244, "70105", "70106", Color.red, false);
	StopButton rbutler = new StopButton(547, 244, "7097", "7098", Color.red, false);
	StopButton rmilton = new StopButton(578, 244, "7099", "70100", Color.red, false);
	StopButton rcentralave = new StopButton(608, 244, "70101", "70102", Color.red, false);
	StopButton rvalleyrd = new StopButton(641, 244, "70103", "70104", Color.red, false);
	StopButton rcapenst = new StopButton(671, 244, "70105", "70106", Color.red, false);
	StopButton rmattapan = new StopButton(699, 243, "70107", "70108", Color.red, true);
	
	//blue line button placement
	StopButton bbowdoin = new StopButton(50, 517, "7039", "7039", Color.blue, true);
	StopButton bgovctr = new StopButton(99, 518, "7040", "7041", Color.blue, false);
	StopButton bstate = new StopButton(160, 518, "7042", "7043", Color.blue, false);
	StopButton baquarium = new StopButton(221, 518, "7044", "7045", Color.blue, false);
	StopButton bmaverick = new StopButton(284, 518, "7046", "7047", Color.blue, false);
	StopButton bairport = new StopButton(347, 518, "7048", "7049", Color.blue, false);
	StopButton bwoodisland = new StopButton(417, 518, "7050", "7051", Color.blue, false);
	StopButton borientheights = new StopButton(485, 518, "7052", "7053", Color.blue, false);
	StopButton bsuffolkdowns = new StopButton(552, 518, "7054", "7055", Color.blue, false);
	StopButton bbeachmont = new StopButton(616, 518, "7056", "7057", Color.blue, false);
	StopButton breverebeach = new StopButton(679, 518, "7058", "7059", Color.blue, false);
	StopButton bwonderland = new StopButton(728, 516, "7060", "7060", Color.blue, true);
			
	List<StopButton> oLine = new ArrayList<StopButton>();
	List<StopButton> rLine = new ArrayList<StopButton>();
	List<StopButton> bLine = new ArrayList<StopButton>();
	
	public Main(){
		
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
		
		MapWindow window = new MapWindow();
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
  		this.add(window);
  		
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

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		StopButton button = (StopButton)e.getSource();
		if(e.getClickCount() == 2){
			System.out.println("double click");
			JFrame frame = new JFrame();
			OrangeStopWindow stop = new OrangeStopWindow();
			frame.setSize(800,600);
			frame.add(stop);
			frame.setVisible(true);
		}else{
			System.out.println("single click");
			button.singleClicked();
		}
		
		
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