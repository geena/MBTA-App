package currentlocation;
import java.util.List;

import models.MBTAResponse;
import models.TripList;
import requests.AbstractMBTARequest;
import requests.Closure;
import services.MBTAService;

public class CurrentLocation
{
	private final MBTAService _mbtaService;
	private List<TripList> _allTrainsList;

	public CurrentLocation() 
	{
		_mbtaService = new MBTAService();
	}

	private void getLocation()
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
			
			return null;
		}
	}

}