package commons;

import java.util.List;

import UI.StopButton;

public class IntersectionStation implements IStation
{
	private String _stopIDa;
	private String _stopIDb;
	private String _stopName;
	private List<LineColor> _lineColorList;
	
	public IntersectionStation(String stopIDa, String stopIDb, String stopName, List<LineColor> lineColorList)
	{
		_stopIDa = stopIDa;
		_stopIDb = stopIDb;
		_stopName = stopName;
		_lineColorList = lineColorList;
	}
	
	public IntersectionStation(StopButton button, List<LineColor> lineColorList)
	{
		_stopIDa = button.stopIDa;
		_stopIDb = button.stopIDb;
		_stopName = button.sName;
		_lineColorList = lineColorList;
	}
	
	public List<LineColor> getLineColorList()
	{
		return _lineColorList;
	}
	
	public void setLineColorList(List<LineColor> lineColorList)
	{
		_lineColorList = lineColorList;
	}

	@Override
	public boolean isIntersection() {
		return true;
	}

	@Override
	public String getStopIDa() {
		return _stopIDa;
	}
	
	public void setStopIDa(String stopIDa)
	{
		_stopIDa = stopIDa;
	}

	@Override
	public String getStopIDb() {
		return _stopIDb;
	}
	
	public void setStopIDb(String stopIDb)
	{
		_stopIDb = stopIDb;
	}

	@Override
	public String getStopName() {
		return _stopName;
	}
	
	public void setStopName(String stopName)
	{
		_stopName = stopName;
	}

	@Override
	public LineColor getLineColor() {
		return null;
	}
	
}