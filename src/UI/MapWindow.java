package UI;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import models.MBTAResponse;
import models.TripList;
import requests.AbstractMBTARequest;
import requests.Closure;
import services.MBTAService;



public class MapWindow extends JPanel implements ActionListener{
	private String MAPFILE= "src/UI/map.jpg"; //the file name of the map background
	private String ICONFILE= "src/UI/icon.png"; //file name of the train icon
	private BufferedImage background; // the Buffered image to hold map image information
	private BufferedImage trainIcon; // the Buffered image to hold map image information
	//private Train.TripList;
	private final MBTAService _mbtaService;
	private List<TripList> _allTrainsList;
	
	public MapWindow(){
		_mbtaService = new MBTAService();
		_allTrainsList = new ArrayList<TripList>();
		try {
			background = ImageIO.read(new File(MAPFILE));
			trainIcon = ImageIO.read(new File(ICONFILE));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block//
			e.printStackTrace();
			
		}
		
	}
	
	//updates Trip List and then paints trains
	private void paintTrains(Graphics g){
		
		this.getTrainLocations();
		paintOrangeTrains(g);
	}
	
	private void paintOrangeTrains(Graphics g){
		
		for(int i = 0; i < _allTrainsList.get(2).getTrips().size(); i++){
			_allTrainsList.get(0).getTrips().get(i);
			Point point = new Point(0,0);
			if(_allTrainsList.get(2).getTrips().get(i).getDestination().compareTo("Oak Grove") == 0){
				point.setLocation(point.x, 62);
			}
			if(_allTrainsList.get(2).getTrips().get(i).getDestination().compareTo("Forest Hills") == 0){
				point.setLocation(point.x, 262);
			}
			g.drawImage(trainIcon, 100, point.y, 100, 100, null);
		}
		System.out.println(_allTrainsList.get(0).getTrips().get(0).getDestination());
		
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null); 
        this.paintTrains(g);
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void getTrainLocations()
	{
		getRedLineTrains();
	}
	
	private void getOrangeLineTrains()
	{
		GetOrangeTrainsSuccessClosure successClosure = new GetOrangeTrainsSuccessClosure();
		GetOrangeTrainsErrorClosure errorClosure = new GetOrangeTrainsErrorClosure();
		GetOrangeTrainsCancelClosure cancelClosure = new GetOrangeTrainsCancelClosure();
		
		_mbtaService.getOrangeLineTrains(successClosure, errorClosure, cancelClosure);
	}
	
	private void getBlueLineTrains()
	{
		GetBlueTrainsSuccessClosure successClosure = new GetBlueTrainsSuccessClosure();
		GetBlueTrainsErrorClosure errorClosure = new GetBlueTrainsErrorClosure();
		GetBlueTrainsCancelClosure cancelClosure = new GetBlueTrainsCancelClosure();
		
		_mbtaService.getBlueLineTrains(successClosure, errorClosure, cancelClosure);
	}
	
	private void getRedLineTrains()
	{
		GetRedTrainsSuccessClosure successClosure = new GetRedTrainsSuccessClosure();
		GetRedTrainsErrorClosure errorClosure = new GetRedTrainsErrorClosure();
		GetRedTrainsCancelClosure cancelClosure = new GetRedTrainsCancelClosure();
		
		_mbtaService.getRedLineTrains(successClosure, errorClosure, cancelClosure);
	}
	
	private class GetRedTrainsCancelClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			return null;
		}
	}

	private class GetRedTrainsErrorClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			Exception exception = data.getException();
			System.out.println("ERROR: " + exception.getMessage());

			return null;
		}
	}

	private class GetRedTrainsSuccessClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			TripList tripList = data.getTripList();
			_allTrainsList.add(tripList);
			getBlueLineTrains();
			return null;
		}
	}
	
	private class GetBlueTrainsCancelClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			return null;
		}
	}

	private class GetBlueTrainsErrorClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			Exception exception = data.getException();
			System.out.println("ERROR: " + exception.getMessage());

			return null;
		}
	}

	private class GetBlueTrainsSuccessClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			TripList tripList = data.getTripList();
			_allTrainsList.add(tripList);
			getOrangeLineTrains();
			return null;
		}
	}
	
	private class GetOrangeTrainsCancelClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			return null;
		}
	}

	private class GetOrangeTrainsErrorClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			Exception exception = data.getException();
			System.out.println("ERROR: " + exception.getMessage());

			return null;
		}
	}

	private class GetOrangeTrainsSuccessClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
	{
		@Override
		public Class<MBTAResponse> getResponseType()
		{
			return null;
		}

		@Override
		public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
		{
			TripList tripList = data.getTripList();
			_allTrainsList.add(tripList);
			
			//Here is where you want to do some stuff with the _allTrainsList
			//System.out.println(_allTrainsList.get(0).getTrips().get(0).getDestination());

			//System.out.println(_allTrainsList.get(0).getTrips().get(0).getPredictions().get(0).getStopName());
			//System.out.println(_allTrainsList.get(0).getTrips().get(0).getPredictions().get(0).getSeconds());
			return null;
		}
	}
	
	
	
	
}





