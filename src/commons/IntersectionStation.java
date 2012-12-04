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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_lineColorList == null) ? 0 : _lineColorList.hashCode());
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
		IntersectionStation other = (IntersectionStation) obj;
		if (_lineColorList == null) {
			if (other._lineColorList != null)
				return false;
		} else if (!_lineColorList.equals(other._lineColorList))
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
	
	
}