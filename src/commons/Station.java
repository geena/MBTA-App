package commons;

import java.util.List;

public class Station
{
	private String _stopID;
	private String _stopName;
	private boolean _isIntersection;
	private List<LineColor> _lineColorList;
	
	public Station(String stopID, String stopName, List<LineColor> lineColorList)
	{
		_stopID = stopID;
		_stopName = stopName;
		_lineColorList = lineColorList;
		if(lineColorList.size() > 1)
		{
			_isIntersection = true;
		}else
		{
			_isIntersection = false;
		}
	}

	public String getStopID() {
		return _stopID;
	}

	public void setStopID(String stopID) {
		stopID = _stopID;
	}

	public String getStopName() {
		return _stopName;
	}

	public void setStopName(String stopName) {
		stopName = _stopName;
	}

	public List<LineColor> getLineColorList() {
		return _lineColorList;
	}

	public void setLineColor(List<LineColor> lineColorList) {
		_lineColorList = lineColorList;
	}
	
	public boolean isIntersection()
	{
		return _isIntersection;
	}
}