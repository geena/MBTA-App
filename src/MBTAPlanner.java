import services.MBTAService;

public class MBTAPlanner
{
	public MBTAPlanner() 
	{
	}

	public static void main (String[] args) 
	{
		final MBTAService _mbtaService = new MBTAService();
		final GetRedTrainsSuccessClosure successClosure = new GetRedTrainsSuccessClosure();
		final GetRedTrainsErrorClosure errorClosure = new GetRedTrainsErrorClosure();
		final GetRedTrainsCancelClosure cancelClosure = new GetRedTrainsCancelClosure();

		_mbtaService.getRedLineTrains(successClosure, errorClosure, cancelClosure);
		_mbtaService.getBlueLineTrains(successClosure, errorClosure, cancelClosure);
		_mbtaService.getOrangeLineTrains(successClosure, errorClosure, cancelClosure);
		
		System.out.println("CHANGE");
	}

}