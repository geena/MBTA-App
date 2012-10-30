package models;

public enum Line
{
	RED("Red"),
	ORANGE("Orange"),
	BLUE("Blue");
	
	private String _name;
	
	private Line(String name)
	{
		_name = name;
	}
	
	public String getName()
	{
		return _name;
	}
}