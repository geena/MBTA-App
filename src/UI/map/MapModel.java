package UI.map;

import models.TripList;
import mvc.DefaultModel;

public class MapModel extends DefaultModel
{
	public MapModel()
	{}
	
	//properties
	static final String RED_LINE_TRAINS = "redlinetrains";
	static final String ORANGE_LINE_TRAINS = "orangelinetrains";
	static final String BLUE_LINE_TRAINS = "bluelinetrains";
	
	//events
	static final String GET_RED_LINE_TRAINS = "getredlinetrains";
	static final String GET_ORANGE_LINE_TRAINS = "getorangelinetrains";
	static final String GET_BLUE_LINE_TRAINS = "getbluelinetrains";	
	
	public void setRedLineTrains(TripList tripList)
	{
		setValue(RED_LINE_TRAINS, tripList);
	}
	
	public TripList getRedLineTrains()
	{
		return getValue(RED_LINE_TRAINS, null);
	}
	
	public void setOrangeLineTrains(TripList tripList)
	{
		setValue(ORANGE_LINE_TRAINS, tripList);
	}
	
	public TripList getOrangeLineTrains()
	{
		return getValue(ORANGE_LINE_TRAINS, null);
	}
	
	public void setBlueLineTrains(TripList tripList)
	{
		setValue(BLUE_LINE_TRAINS, tripList);
	}
	
	public TripList getBlueLineTrains()
	{
		return getValue(BLUE_LINE_TRAINS, null);
	}

}