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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_lineColor == null) ? 0 : _lineColor.hashCode());
		result = prime * result
				+ ((_stopIDa == null) ? 0 : _stopIDa.hashCode());
		result = prime * result
				+ ((_stopIDb == null) ? 0 : _stopIDb.hashCode());
		result = prime * result
				+ ((_stopName == null) ? 0 : _stopName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (_lineColor != other._lineColor)
			return false;
		if (_stopIDa == null) {
			if (other._stopIDa != null)
				return false;
		} else if (!_stopIDa.equals(other._stopIDa))
			return false;
		if (_stopIDb == null) {
			if (other._stopIDb != null)
				return false;
		} else if (!_stopIDb.equals(other._stopIDb))
			return false;
		if (_stopName == null) {
			if (other._stopName != null)
				return false;
		} else if (!_stopName.equals(other._stopName))
			return false;
		return true;
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