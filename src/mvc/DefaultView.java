package mvc;

public abstract class DefaultView
{
	private DefaultModel _model;
	protected abstract void processModelChange();
}