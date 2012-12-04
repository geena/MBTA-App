package commons;

import java.util.List;

public interface IStation
{
	public boolean isIntersection();
	
	public String getStopIDa();
	
	public String getStopIDb();
	
	public String getStopName();
	
	public LineColor getLineColor();
	
	public List<LineColor> getLineColorList();
}