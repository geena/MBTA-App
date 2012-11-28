package mvc;

public abstract class DefaultController implements ViewEventListener
{
	
	protected void setUpMVC(DefaultController controller, DefaultView view, DefaultModel model)
	{
		view.addViewEventListener(controller);
		model.addModelEventListener(view);
	}
}