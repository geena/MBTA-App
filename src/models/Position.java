package models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Position
{
	private int _timeStamp;
	private String _trainNumber;
	private Double _lat;
	private Double _long;
	private Double _heading;
	
	@JsonProperty("Timestamp")
	public void setTimeStamp(int timeStamp)
	{
		_timeStamp = timeStamp;
	}
	
	public int getTimeStamp()
	{
		return _timeStamp;
	}
	
	@JsonProperty("Train")
	public void setTrainNumber(String trainNumber)
	{
		_trainNumber = trainNumber;
	}
	
	public String getTrainNumber()
	{
		return _trainNumber;
	}
	
	@JsonProperty("Lat")
	public void setLat(String lat)
	{
		_lat = Double.valueOf(lat);
	}
	
	public Double getLat()
	{
		return _lat;
	}
	
	@JsonProperty("Long")
	public void setLong(String lng)
	{
		_long = Double.valueOf(lng);
	}
	
	public Double getLong()
	{
		return _long;
	}
	
	@JsonProperty("Heading")
	public void setHeading(String heading)
	{
		_heading = Double.valueOf(heading);
	}
	
	public Double getHeading()
	{
		return _heading;
	}
}