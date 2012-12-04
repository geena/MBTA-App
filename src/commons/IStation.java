package commons;

import java.util.List;

import UI.StopButton;

public abstract class IStation
{
	private String _stopIDa;
	private String _stopIDb;
	private String _stopName;
	
	public IStation(String stopIDa, String stopIDb, String stopName)
	{
		_stopIDa = stopIDa;
		_stopIDb = stopIDb;
		_stopName = stopName;
	}
	
	public IStation(StopButton button)
	{
		_stopIDa = button.stopIDa;
		_stopIDb = button.stopIDb;
		_stopName = button.sName;
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
	
	public abstract LineColor getLineColor();
	
	public abstract List<LineColor> getLineColorList();
	
	public static class Utils
	{
		public static IStation findTransferStation(LineColor col1, LineColor col2, List<IStation> redLine, List<IStation> blueLine, List<IStation> orangeLine)
		{
			redLine.addAll(blueLine);
			redLine.addAll(orangeLine);
			
			for(IStation station : redLine)
			{
				if(station.isIntersection())
				{
					List<LineColor> colorList = station.getLineColorList();
					if(!col1.equals(col2) && 
							(colorList.contains(col1)) &&
							(colorList.contains(col2)))
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