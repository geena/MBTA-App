package models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Predictions
{
	private String 	_stopID;
	private String 	_stopName;
	private int		_seconds;
	
	@JsonProperty("StopID")
	public void setStopID(String stopID)
	{
		_stopID = stopID;
	}
	
	public String getStopID()
	{
		return _stopID;
	}
	
	@JsonProperty("Stop")
	public void setStopName(String stopName)
	{
		_stopName = stopName;
	}
	
	public String getStopName()
	{
		return _stopName;
	}
	
	@JsonProperty("Seconds")
	public void setSeconds(int seconds)
	{
		_seconds = seconds;
	}
	
	public int getSeconds()
	{
		return _seconds;
	}
}