package services;

import java.io.IOException;

import models.MBTAResponse;
import requests.AbstractMBTARequest;
import requests.Closure;
import requests.GetBlueLineTrainsRequest;
import requests.GetOrangeLineTrainsRequest;
import requests.GetRedLineTrainsRequest;

public class MBTAService
{
	public void getTestRedLineTrains(Closure<Void, AbstractMBTARequest, MBTAResponse> successClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> errorClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> cancelClosure) throws IOException
	{
		GetRedLineTrainsRequest request = new GetRedLineTrainsRequest(successClosure, errorClosure, cancelClosure);
		request.doTestRequest();
		
	}
	
	public void getRedLineTrains(Closure<Void, AbstractMBTARequest, MBTAResponse> successClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> errorClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> cancelClosure)
	{
		GetRedLineTrainsRequest request = new GetRedLineTrainsRequest(successClosure, errorClosure, cancelClosure);
		request.doRequest();
	}
	
	public void getTestBlueLineTrains(Closure<Void, AbstractMBTARequest, MBTAResponse> successClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> errorClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> cancelClosure) throws IOException
	{
		GetBlueLineTrainsRequest request = new GetBlueLineTrainsRequest(successClosure, errorClosure, cancelClosure);
		request.doTestRequest();
	}
	
	public void getBlueLineTrains(Closure<Void, AbstractMBTARequest, MBTAResponse> successClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> errorClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> cancelClosure)
	{
		GetBlueLineTrainsRequest request = new GetBlueLineTrainsRequest(successClosure, errorClosure, cancelClosure);
		request.doRequest();
	}
	
	public void getTestOrangeLineTrains(Closure<Void, AbstractMBTARequest, MBTAResponse> successClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> errorClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> cancelClosure) throws IOException
	{
		GetOrangeLineTrainsRequest request = new GetOrangeLineTrainsRequest(successClosure, errorClosure, cancelClosure);
		request.doTestRequest();
	}
	
	public void getOrangeLineTrains(Closure<Void, AbstractMBTARequest, MBTAResponse> successClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> errorClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> cancelClosure)
	{
		GetOrangeLineTrainsRequest request = new GetOrangeLineTrainsRequest(successClosure, errorClosure, cancelClosure);
		request.doRequest();
	}
}