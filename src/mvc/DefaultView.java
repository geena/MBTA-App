package mvc;

import java.util.ArrayList;
import java.util.List;

public abstract class DefaultView implements ModelEventListener
{
	private DefaultModel _model;
	private final List<ViewEventListener> _listeners = new ArrayList<ViewEventListener>();
	
	protected void addViewEventListener(ViewEventListener listener)
	{
		_listeners.add(listener);
	}
	
	protected void removeViewEventListener(ViewEventListener listener)
	{
		_listeners.remove(listener);
	}
	
	public void notifyViewEvent(String event)
	{
		for (ViewEventListener listener: _listeners)
		{
			listener.processViewEvent(event);
		}
	}
	
	public abstract void modelChanged(String event);
}