import models.MBTAResponse;
import requests.AbstractMBTARequest;
import requests.Closure;

class GetRedTrainsCancelClosure implements Closure<Void, AbstractMBTARequest, MBTAResponse>
{
	@Override
	public Class<MBTAResponse> getResponseType()
	{
		return null;
	}

	@Override
	public Void invoke(AbstractMBTARequest caller, MBTAResponse data)
	{
		return null;
	}
}