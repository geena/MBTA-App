package models;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TripList
{
	private int 		_currentTime;
	private Line 		_line;
	private List<Trips> _trips;
	
	@JsonProperty("CurrentTime")
	public void setCurrentTime(int currentTime)
	{
		_currentTime = currentTime;
	}
	
	public Integer getCurrentTime()
	{
		return _currentTime;
	}
	
	@JsonProperty("Line")
	public void setLine(String line)
	{
		Line[] allLines = Line.values();
		
		for(int i=0; i < allLines.length; i++)
		{
			Line currentLine = allLines[i];
			if(currentLine.getName().equalsIgnoreCase(line))
			{
				_line = currentLine;
			}
		}
	}
	
	public Line getLine()
	{
		return _line;
	}
	
	@JsonProperty("Trips")
	public void setTrips(List<Trips> trips)
	{
		_trips = trips;
	}
	
	public List<Trips> getTrips()
	{
		return _trips;
	}
}