import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class GetLiveJSONFeed {

	public static HashMap<String,Integer> redLiveTrains;
	public static HashMap<String,Integer> blueLiveTrains;
	public static HashMap<String,Integer> orangeLiveTrains;
	
	
	public static void main(String args[]) throws ParseException
	{
		redLiveTrains = new HashMap<String,Integer>();
		blueLiveTrains = new HashMap<String,Integer>();
		orangeLiveTrains = new HashMap<String,Integer>();
		String redLineJSON = getJSON("http://Developer.mbta.com/lib/rthr/red.json",1000);
		
		JSONObject json = (JSONObject)new JSONParser().parse(redLineJSON);
		
		JSONObject tripList = (JSONObject)json.get("TripList");
		JSONArray trips = (JSONArray)tripList.get("Trips");
		for(int i = 0; i < trips.size();i++){
			JSONObject destination = (JSONObject)trips.get(i);
			System.out.println("\n\nDESTINATION: "+(String)destination.get("Destination"));
			JSONArray predictions = (JSONArray)destination.get("Predictions");
			for(int j = 0; j < predictions.size(); j ++)
			{
				JSONObject train = (JSONObject)predictions.get(j);
				String stop = (String)train.get("Stop");
				long seconds = (Long)train.get("Seconds");
				System.out.println(stop + " --> " + seconds + "s");
			}
		}
		
		
		System.out.println("RED LINE JSON:");
		System.out.println();
		
		
	}
	
	public static String getJSON(String url, int timeout) {
	    try {
	        URL u = new URL(url);
	        HttpURLConnection c = (HttpURLConnection) u.openConnection();
	        c.setRequestMethod("GET");
	        c.setRequestProperty("Content-length", "0");
	        c.setUseCaches(false);
	        c.setAllowUserInteraction(false);
	        c.setConnectTimeout(timeout);
	        c.setReadTimeout(timeout);
	        c.connect();
	        int status = c.getResponseCode();

	        switch (status) {
	            case 200:
	            case 201:
	                BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
	                StringBuilder sb = new StringBuilder();
	                String line;
	                while ((line = br.readLine()) != null) {
	                    sb.append(line+"\n");
	                }
	                br.close();
	                return sb.toString();
	        }

	    } catch (Exception ex) {
	    	System.err.println("ERROR PULLING LIVE JSON DATA\n"+ex.getMessage());
	    }
	    return null;
	}
}
