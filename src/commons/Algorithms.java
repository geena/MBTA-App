package commons;

import UI.StopButton;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import models.TripList;

public class Algorithms
{
	public static ArrayList<StopButton> executeTask(List<TripList> allTrainsList){
		System.out.println("EXECUTE" + UserOptions.stopList.size());
		ArrayList<StopButton> stopList = new ArrayList<StopButton>(UserOptions.stopList);
		stopList.remove(stopList.size()-1);
		
		ArrayList<StopButton> result = null;
        
		for ( StopButton but : stopList)
		{
			String stopName = but.stopIDa;
			System.out.println(stopName);
		}
		
		if(UserOptions.ordered)
			result = getOrdered(stopList);
		
		
		
		
		
		
		return null;
	}
	
	public static ArrayList<StopButton> getOrdered(ArrayList<StopButton> list)
	{
		if(allSameColor(list))
		{
			ArrayList<StopButton> result = new ArrayList<StopButton>();
			result.add(list.get(0));
			result.add(list.get(list.size()-1));
			return result;
		}
		
		
		return null;
	}
	
	public static ArrayList<Integer> findDirectionChanges(ArrayList<StopButton> list)
	{
		int id = Math.abs(Integer.parseInt(list.get(0).stopIDa));
		
		for(StopButton but : list)
		{
			
		}
		
		return null;
	}
	
	public static boolean allSameColor(ArrayList<StopButton> list)
	{
		Color firstColor = list.get(0).lineColor;
		for(int i = 1; i < list.size();i++)
		{
			if(!(list.get(i).lineColor.equals(firstColor)))
				return false;
		}
		return true;
	}
}