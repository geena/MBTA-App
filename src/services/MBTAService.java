package services;

import models.MBTAResponse;
import requests.AbstractMBTARequest;
import requests.Closure;
import requests.GetBlueLineTrainsRequest;
import requests.GetOrangeLineTrainsRequest;
import requests.GetRedLineTrainsRequest;

public class MBTAService
{
	public void getTestRedLineTrains(Closure<Void, Void, MBTAResponse> successClosure,
			Closure<Void, Void, MBTAResponse> errorClosure,
			Closure<Void, Void, MBTAResponse> cancelClosure)
	{
		//TODO do something with json and readfile
		
	}
	
	public void getRedLineTrains(Closure<Void, AbstractMBTARequest, MBTAResponse> successClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> errorClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> cancelClosure)
	{
		GetRedLineTrainsRequest request = new GetRedLineTrainsRequest(successClosure, errorClosure, cancelClosure);
		request.doRequest();
	}
	
	public void getTestBlueLineTrains(Closure<Void, Void, MBTAResponse> successClosure,
			Closure<Void, Void, MBTAResponse> errorClosure,
			Closure<Void, Void, MBTAResponse> cancelClosure)
	{
		//TODO do something with json
		
	}
	
	public void getBlueLineTrains(Closure<Void, AbstractMBTARequest, MBTAResponse> successClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> errorClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> cancelClosure)
	{
		GetBlueLineTrainsRequest request = new GetBlueLineTrainsRequest(successClosure, errorClosure, cancelClosure);
		request.doRequest();
	}
	
	public void getTestOrangeLineTrains(Closure<Void, Void, MBTAResponse> successClosure,
			Closure<Void, Void, MBTAResponse> errorClosure,
			Closure<Void, Void, MBTAResponse> cancelClosure)
	{
		//TODO do something with json
		
	}
	
	public void getOrangeLineTrains(Closure<Void, AbstractMBTARequest, MBTAResponse> successClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> errorClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> cancelClosure)
	{
		GetOrangeLineTrainsRequest request = new GetOrangeLineTrainsRequest(successClosure, errorClosure, cancelClosure);
		request.doRequest();
	}
}