package commons;

import java.util.List;

import UI.StopButton;


public class Station implements IStation
{
	private String _stopIDa;
	private String _stopIDb;
	private String _stopName;
	private LineColor _lineColor;
	
	public Station(String stopIDa, String stopIDb, String stopName, LineColor lineColor)
	{
		_stopIDa = stopIDa;
		_stopIDb = stopIDb;
		_stopName = stopName;
		_lineColor = lineColor;
	}
	
	public Station(StopButton button, LineColor lineColor)
	{
		_stopIDa = button.stopIDa;
		_stopIDb = button.stopIDb;
		_stopName = button.sName;
		_lineColor = lineColor;
	}

	public String getStopIDa() {
		return _stopIDa;
	}

	public void setStopIDa(String stopIDa) {
		stopIDa = _stopIDa;
	}
	
	public String getStopIDb() {
		return _stopIDb;
	}

	public void setStopIDb(String stopIDb) {
		stopIDb = _stopIDb;
	}

	public String getStopName() {
		return _stopName;
	}

	public void setStopName(String stopName) {
		stopName = _stopName;
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