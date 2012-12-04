package commons;

public enum LineColor
{
	RED("red"),
	BLUE("blue"),
	ORANGE("orange");
	
	private String _name;
	
	LineColor(String name)
	{
		_name = name;
	}
	
	public String getName()
	{
		return _name;
	}
}