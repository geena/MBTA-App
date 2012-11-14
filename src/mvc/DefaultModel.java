package mvc;

import java.util.HashMap;
import java.util.Map;

public abstract class DefaultModel{
	
	protected final Map<Object, Object> _data = new HashMap<Object, Object>();
	
	public <T> T getValue(String key, T defaultValue)
	{
		T value = (T) _data.get(key);
		if (value == null)
		{
			value = defaultValue;
		}
		return value;
	}
}