package commons;

import java.util.List;

import UI.StopButton;

public class IntersectionStation extends IStation
{
	private List<LineColor> _lineColorList;
	
	public IntersectionStation(String stopIDa, String stopIDb, String stopName, List<LineColor> lineColorList)
	{
		super(stopIDa, stopIDb, stopName);
		_lineColorList = lineColorList;
	}
	
	public IntersectionStation(StopButton button, List<LineColor> lineColorList)
	{
		super(button);
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
	public LineColor getLineColor() {
		return null;
	}
}