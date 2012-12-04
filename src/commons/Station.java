package commons;

import java.util.List;

import UI.StopButton;


public class Station extends IStation
{
	private LineColor _lineColor;
	
	public Station(String stopIDa, String stopIDb, String stopName, LineColor lineColor)
	{
		super(stopIDa, stopIDb, stopName);
		_lineColor = lineColor;
	}
	
	public Station(StopButton button, LineColor lineColor)
	{
		super(button);
		_lineColor = lineColor;
	}

	public LineColor getLineColor() {
		return _lineColor;
	}

	public void setLineColor(LineColor lineColor) {
		_lineColor = lineColor;
	}

	@Override
	public boolean isIntersection() {
		return false;
	}

	@Override
	public List<LineColor> getLineColorList() {
		return null;
	}
}