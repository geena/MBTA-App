package requests;

import models.MBTAResponse;

public class GetOrangeLineTrainsRequest extends AbstractMBTARequest
{
	public GetOrangeLineTrainsRequest(
			Closure<Void, AbstractMBTARequest, MBTAResponse> successClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> errorClosure,
			Closure<Void, AbstractMBTARequest, MBTAResponse> cancelClosure) {
		super(successClosure, errorClosure, cancelClosure);
	}

	@Override
	public String getAPIName()
	{
		return "orange.json";
	}
}