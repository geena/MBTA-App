package mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DefaultModel
{
	protected final Map<Object, Object> _data = new HashMap<Object, Object>();
	
	private final List<ModelEventListener> _listeners = new ArrayList<ModelEventListener>();
	
	protected void addModelEventListener(ModelEventListener listener)
	{
		_listeners.add(listener);
	}
	
	protected void removeModelEventListener(ModelEventListener listener)
	{
		_listeners.remove(listener);
	}
	
	public <T> T getValue(String key, T defaultValue)
	{
		T value = (T) _data.get(key);
		if (value == null)
		{
			value = defaultValue;
		}
		return value;
	}
	
	public <T> void setValue(String key, T value)
	{
		if (value == null)
		{
			_data.remove(key);
		} else {
			_data.put(key, value);
		}
		notifyListeners(key);
	}
	
	public void notifyListeners(String key)
	{
		for (ModelEventListener listener: _listeners)
		{
			listener.modelChanged(key);
		}
	}
}