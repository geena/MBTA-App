package UI;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;




public class Main extends JFrame implements MouseListener{
		//orange line button placement
	StopButton oforesthills = new StopButton(53, 119, "7001", "7001", Color.orange, true);
	StopButton ogreenst = new StopButton(85, 121, "7001", "7001", Color.orange, false);
	StopButton ostonybrook = new StopButton(118, 121, "7001", "7001", Color.orange, false);
	StopButton ojacksonsquare = new StopButton(153, 121, "7001", "7001", Color.orange, false);
	StopButton oroxburycrossing = new StopButton(190, 121, "7001", "7001", Color.orange, false);
	StopButton oruggles = new StopButton(228, 121, "7001", "7001", Color.orange, false);
	StopButton omassave = new StopButton(265, 121, "7001", "7001", Color.orange, false);
	StopButton obackbay = new StopButton(305, 121, "7001", "7001", Color.orange, false);
	StopButton otuftsmedical = new StopButton(345, 121, "7001", "7001", Color.orange, false);
	StopButton ochinatown = new StopButton(385, 121, "7001", "7001", Color.orange, false);
	StopButton odowntowncrossing = new StopButton(425, 121, "7001", "7001", Color.orange, false);
	StopButton ostate = new StopButton(464, 121, "7001", "7001", Color.orange, false);
	StopButton ohaymarket = new StopButton(504, 121, "7001", "7001", Color.orange, false);
	StopButton onorthstation = new StopButton(543, 121, "7001", "7001", Color.orange, false);
	StopButton ocommunitycollege = new StopButton(583, 121, "7001", "7001", Color.orange, false);
	StopButton osullivansquare = new StopButton(622, 121, "7001", "7001", Color.orange, false);
	StopButton owellington = new StopButton(661, 121, "7001", "7001", Color.orange, false);
	StopButton omalden = new StopButton(701, 121, "7001", "7001", Color.orange, false);
	StopButton ooakgrove = new StopButton(733, 120, "7001", "7001", Color.orange, true);
	
	
	//red line button placement
	StopButton ralewife = new StopButton(49, 311, "7001", "7001", Color.orange, true);
	StopButton rdavis = new StopButton(76, 312, "7001", "7001", Color.orange, false);
	StopButton rporter = new StopButton(103, 312, "7001", "7001", Color.orange, false);
	StopButton rharvard = new StopButton(131, 312, "7001", "7001", Color.orange, false);
	StopButton rcentral = new StopButton(159, 312, "7001", "7001", Color.orange, false);
	StopButton rkendall = new StopButton(185, 312, "7001", "7001", Color.orange, false);
	StopButton rcharles = new StopButton(214, 312, "7001", "7001", Color.orange, false);
	StopButton rparkst = new StopButton(241, 312, "7001", "7001", Color.orange, false);
	StopButton rdowntown = new StopButton(271, 312, "7001", "7001", Color.orange, false);
	StopButton rsouthstation = new StopButton(301, 312, "7001", "7001", Color.orange, false);
	StopButton rbroadway = new StopButton(333, 312, "7001", "7001", Color.orange, false);
	StopButton randrew = new StopButton(366, 312, "7001", "7001", Color.orange, false);
	StopButton rjfk = new StopButton(398, 312, "7001", "7001", Color.orange, false);
	StopButton rsavinhill = new StopButton(431, 312, "7001", "7001", Color.orange, false);
	StopButton rfieldscorner = new StopButton(451, 290, "7001", "7001", Color.orange, false);
	StopButton rshawmut = new StopButton(470, 268, "7001", "7001", Color.orange, false);
	StopButton rashmont = new StopButton(491, 244, "7001", "7001", Color.orange, false);
	StopButton rcedargrove = new StopButton(518, 244, "7001", "7001", Color.orange, false);
	StopButton rbutler = new StopButton(547, 244, "7001", "7001", Color.orange, false);
	StopButton rmilton = new StopButton(578, 244, "7001", "7001", Color.orange, false);
	StopButton rcentralave = new StopButton(608, 244, "7001", "7001", Color.orange, false);
	StopButton rvalleyrd = new StopButton(641, 244, "7001", "7001", Color.orange, false);
	StopButton rcapenst = new StopButton(671, 244, "7001", "7001", Color.orange, false);
	StopButton rmattapan = new StopButton(699, 243, "7001", "7001", Color.orange, true);
	StopButton rnorthquincy = new StopButton(578, 312, "7001", "7001", Color.orange, false);
	StopButton rwollaston = new StopButton(614, 312, "7001", "7001", Color.orange, false);
	StopButton rquincycenter = new StopButton(654, 312, "7001", "7001", Color.orange, false);
	StopButton rquincyadams = new StopButton(692, 312, "7001", "7001", Color.orange, false);
	StopButton rbraintree = new StopButton(730, 311, "7001", "7001", Color.orange, true);
	
	
	//blue line button placement
	StopButton bbowdoin = new StopButton(50, 517, "7001", "7001", Color.orange, true);
	StopButton bgovctr = new StopButton(99, 518, "7001", "7001", Color.orange, false);
	StopButton bstate = new StopButton(160, 518, "7001", "7001", Color.orange, false);
	StopButton baquarium = new StopButton(221, 518, "7001", "7001", Color.orange, false);
	StopButton bmaverick = new StopButton(284, 518, "7001", "7001", Color.orange, false);
	StopButton bairport = new StopButton(347, 518, "7001", "7001", Color.orange, false);
	StopButton bwoodisland = new StopButton(417, 518, "7001", "7001", Color.orange, false);
	StopButton borientheights = new StopButton(485, 518, "7001", "7001", Color.orange, false);
	StopButton bsuffolkdowns = new StopButton(552, 518, "7001", "7001", Color.orange, false);
	StopButton bbeachmont = new StopButton(616, 518, "7001", "7001", Color.orange, false);
	StopButton breverebeach = new StopButton(679, 518, "7001", "7001", Color.orange, false);
	StopButton bwonderland = new StopButton(728, 516, "7001", "7001", Color.orange, true);

		//StopButton2 button2 = new StopButton2();
	public Main(){
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
  		rjfk.addMouseListener(this);
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
  		window.add(rjfk);
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