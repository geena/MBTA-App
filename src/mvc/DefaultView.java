package mvc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public abstract class DefaultView extends JPanel implements ModelEventListener
{
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
	
	public abstract void modelChanged(String property);
}