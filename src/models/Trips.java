package models;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trips
{
	private String _tripID;
	private String _destination;
	private String _note;
	private Position _position;
	private List<Predictions> _predictions;
	
	@JsonProperty("TripID")
	public void setTripID(String tripID)
	{
		_tripID = tripID;
	}
	
	public String getTripID()
	{
		return _tripID;
	}
	
	@JsonProperty("Destination")
	public void setDestination(String destination)
	{
		_destination = destination;
	}
	
	public String getDestination()
	{
		return _destination;
	}
	
	@JsonProperty("Note")
	public void setNote(String note)
	{
		_note = note;
	}
	
	public String getNote()
	{
		return _note;
	}
	
	@JsonProperty("Position")
	public void setPosition(Position position)
	{
		_position = position;
	}
	
	public Position getPosition()
	{
		return _position;
	}
	
	@JsonProperty("Predictions")
	public void setPredictions(List<Predictions> predictions)
	{
		_predictions = predictions;
	}
	
	public List<Predictions> getPredictions()
	{
		return _predictions;
	}
}