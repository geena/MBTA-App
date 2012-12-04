package commons;

import java.util.ArrayList;
import java.util.List;

import UI.StopButton;

public abstract class IStation
{
	private String _stopIDa;
	private String _stopIDb;
	private String _stopName;
	private List<Integer> _secondsLista;
	private List<Integer> _secondsListb;
	
	public IStation(String stopIDa, String stopIDb, String stopName)
	{
		_stopIDa = stopIDa;
		_stopIDb = stopIDb;
		_stopName = stopName;
		_secondsLista = null;
		_secondsListb = null;
	}
	
	public IStation(StopButton button)
	{
		_stopIDa = button.stopIDa;
		_stopIDb = button.stopIDb;
		_stopName = button.sName;
		_secondsLista = null;
		_secondsListb = null;
	}
	
	public abstract boolean isIntersection();
	
	public String getStopIDa()
	{
		return _stopIDa;
	}
	
	public void setStopIDa(String stopIDa)
	{
		_stopIDa = stopIDa;
	}
	
	public String getStopIDb()
	{
		return _stopIDb;
	}
	
	public void setStopIDb(String stopIDb)
	{
		_stopIDb = stopIDb;
	}
	
	public String getStopName()
	{
		return _stopName;
	}
	
	public void setStopName(String stopName)
	{
		_stopName = stopName;
	}
	
	public List<Integer> getSecondsLista()
	{
		return _secondsLista;
	}
	
	public void setSecondsLista(List<Integer> secondsLista)
	{
		_secondsLista = secondsLista;
	}
	
	public List<Integer> getSecondsListb()
	{
		return _secondsListb;
	}
	
	public void setSecondsListb(List<Integer> secondsListb)
	{
		_secondsListb = secondsListb;
	}
	
	public abstract LineColor getLineColor();
	
	public abstract List<LineColor> getLineColorList();
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		IStation other = (IStation) obj;
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
	public String toString() {
		return _stopName;
	}



	public static class Utils
	{	
		public static IStation findTransferStation(LineColor prevCol, LineColor curCol, List<IStation> redLine, List<IStation> blueLine, List<IStation> orangeLine)
		{
			List<IStation> allStations = new ArrayList<IStation>(redLine);
			allStations.addAll(blueLine);
			allStations.addAll(orangeLine);
			
			for(IStation station : allStations)
			{
				if(station.isIntersection())
				{
					List<LineColor> colorList = station.getLineColorList();
					if(!prevCol.equals(curCol) && 
							(colorList.contains(prevCol)) &&
							(colorList.contains(curCol)))
					{
						return station;
					}
				}
			}
			
			//should not be reachable
			return null;
		}
	}
}