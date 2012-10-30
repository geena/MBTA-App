import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;


public class StationList {
	public LinkedHashSet<String> redLine;
	public LinkedHashSet<String> blueLine;
	public LinkedHashSet<String> orangeLine;
	
	/**
	 * Initializes the station lists from the RealTimeHeavyRailKeys.csv 
	 * in the root folder
	 */
	public StationList()
	{
		//check for rail info file first
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("RealTimeHeavyRailKeys.csv" ));
		} catch (FileNotFoundException e) {
			System.err.println("Could not load rail info from RealTimeHeavyRailKeys.csv !");
			return;
		}
		
		//initialize hashsets
		redLine = new LinkedHashSet<String>();
		orangeLine = new LinkedHashSet<String>();
		blueLine = new LinkedHashSet<String>();
		
		//parse and fill
		try {
			fillMap(reader);
		} catch (IOException e) {
			System.err.println("Error while loading data from RealTimeHeavyRailKeys.csv !");
			return;
		}
		
	}
	
	public void fillMap(BufferedReader reader) throws IOException
	{
		String line = null;
		while((line = reader.readLine()) != null)
		{
			
			String[] split = line.split(",");
			
			//Red line entry
			if(split[0].equals("Red"))
			{
				redLine.add(split[3]);
			}
			if(split[0].equals("Blue"))
			{
				blueLine.add(split[3]);
			}
			if(split[0].equals("Orange"))
			{
				orangeLine.add(split[3]);
			}
		}
		System.out.println("Finished loading train maps!");
	}
	
	public static void main(String args[])
	{
		StationList list = new StationList();
		System.out.println("RED LINE:");
		System.out.println(list.redLine.toString());
		System.out.println("BLUE LINE:");
		System.out.println(list.blueLine.toString());
		System.out.println("ORANGE LINE:");
		System.out.println(list.orangeLine.toString());
	}
	
	
}
