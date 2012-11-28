package UI.map;

import models.MBTAResponse;
import mvc.DefaultController;
import requests.AbstractMBTARequest;
import requests.Closure;
import services.MBTAService;

public class MapController extends DefaultController
{
	private MapModel _model;
	private MapView _view;
	private final MBTAService _mbtaService;

	public MapController()
	{
		_mbtaService = new MBTAService();
		_model = new MapModel();
		_view = new MapView(_model);
		setUpMVC(this, _view, _model);
	}
	
	public MapView getView()
	{
		return _view;
	}
	
	@Override
	public void processViewEvent(String event) 
	{
		if(event.equals(MapModel.GET_RED_LINE_TRAINS))
		{
			getRedLineTrains();	
		}else if(event.equals(MapModel.GET_ORANGE_LINE_TRAINS))
		{
			getOrangeLineTrains();
		}else if(event.equals(MapModel.GET_BLUE_LINE_TRAINS))
		{
			getBlueLineTrains();
		}
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
			_model.setRedLineTrains(data.getTripList());
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
			_model.setBlueLineTrains(data.getTripList());
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
			_model.setOrangeLineTrains(data.getTripList());
			return null;
		}
	}

	
}