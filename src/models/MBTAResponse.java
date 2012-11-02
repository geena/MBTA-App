package models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MBTAResponse
{
	private TripList 	_tripList;
	private Exception	_exception;
	
	@JsonProperty("TripList")
	public void setTripList(TripList tripList)
	{
		_tripList = tripList;
	}
	
	public TripList getTripList()
	{
		return _tripList;
	}
	
	public void setException(Exception e)
	{
		_exception = e;
	}
	
	public Exception getException()
	{
		return _exception;
	}
}