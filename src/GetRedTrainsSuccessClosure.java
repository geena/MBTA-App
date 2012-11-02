import java.util.ArrayList;

import models.MBTAResponse;
import models.Predictions;
import models.TripList;
import models.Trips;
import requests.AbstractMBTARequest;
import requests.Closure;

class GetRedTrainsSuccessClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
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
		ArrayList<Trips> trips = new ArrayList<Trips>(tripList.getTrips());
		for(Trips trip : trips)
		{
			System.out.println("TRIP_ID: " + trip.getTripID());
			System.out.println("DESTINATION: " + trip.getDestination());
			System.out.println("NOTE: " + trip.getNote());
			
			ArrayList<Predictions> predictions = new ArrayList<Predictions>(trip.getPredictions());
			for(Predictions prediction : predictions)
			{
				System.out.print("PREDICTIONS:\n");
				System.out.println("	STOP_ID: " + prediction.getStopID());
				System.out.println("	STOP_NAME: " + prediction.getStopName());
				System.out.println("	SECONDS: " + prediction.getSeconds());
			}
			
			System.out.println("-------------\n");
		}
		return null;
	}
}


