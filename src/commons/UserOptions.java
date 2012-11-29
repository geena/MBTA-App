package commons;

import java.util.ArrayList;
import java.util.List;

public class UserOptions
{
	public static List<String> stopList 	= null;
	public static boolean ordered 			= false;
	public static Long departureTime 		= new Long(0);
	public static Long arrivalTime 			= new Long(0);
	public static boolean earliestDeparture = false;
	public static boolean fastestRoute 		= false;
	public static boolean earliestArrival 	= false;
	public static boolean fewestTransfers 	= false;
	
	public static void reset()
	{
		stopList 			= new ArrayList<String>();
		ordered 			= false;
		departureTime 		= new Long(0);
		arrivalTime 		= new Long(0);
		earliestDeparture 	= false;
		fastestRoute 		= false;
		earliestArrival 	= false;
		fewestTransfers 	= false;
	}
}