package commons;

import UI.StopButton;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


import models.TripList;

public class Algorithms
{
	
	List<TripList> allTrainsList; 
	List<IStation> redLine;
	List<IStation> blueLine;
	List<IStation> orangeLine;
	List<IStation> ashmontIStations = new ArrayList<IStation>();
	List<IStation> braintreeIStations = new ArrayList<IStation>();
	
	IntersectionStation stateStreet;
	IntersectionStation	dxing;
	
	public Algorithms(List<TripList> allTrainsList, 
			List<IStation> redLine, List<IStation> blueLine, List<IStation> orangeLine)
	{
		this.allTrainsList = allTrainsList;
		this.redLine = redLine;
		this.blueLine = blueLine;
		this.orangeLine = orangeLine;
		
		
		
		List<LineColor> stateColList = new ArrayList<LineColor>();
		stateColList.add(LineColor.BLUE);
		stateColList.add(LineColor.ORANGE);
		
		stateStreet = new IntersectionStation("70042", "70043" , "State Street", stateColList);
		
		List<LineColor> dxingColList = new ArrayList<LineColor>();
		dxingColList.add(LineColor.RED);
		dxingColList.add(LineColor.ORANGE);
		
		dxing = new IntersectionStation("70077", "70078" , "Downtown Crossing", dxingColList);
	}
	
	
	
	/**
	 * 
	 * returns a list of a list of directions
	 * if the user wants only one ordered list of directions it will only contain one list of directions
	 * if the user wants unordered stops the result will be a list of size n! chosen routes using all permutations of traversal
	 */
	public List<List<Direction>> executeTask(){
		
		List<StopButton> stopList = new ArrayList<StopButton>(UserOptions.stopList);
		
		//stopList.remove(stopList.size()-1);   //TODO: remove this after luis hooks up button
		
		List<IStation> stationList = new ArrayList<IStation>();
		
		for(StopButton button : stopList)
		{
			if(button.sName.equals("Downtown Crossing"))
			{
				List<LineColor> lineColorList = new ArrayList<LineColor>();
				lineColorList.add(LineColor.RED);
				lineColorList.add(LineColor.ORANGE);
				IntersectionStation newStation = new IntersectionStation(button, lineColorList);
				stationList.add(newStation);
			}
			else if(button.sName.equals("State Street"))
			{
				List<LineColor> lineColorList = new ArrayList<LineColor>();
				lineColorList.add(LineColor.BLUE);
				lineColorList.add(LineColor.ORANGE);
				IntersectionStation newStation = new IntersectionStation(button, lineColorList);
				stationList.add(newStation);
			}else
			{
				LineColor col = null;
				if(button.lineColor.equals(Color.red))
					col = LineColor.RED;
				else if(button.lineColor.equals(Color.orange))
					col = LineColor.ORANGE;
				else
					col = LineColor.BLUE;
				
				Station newStation = new Station(button, col);
				stationList.add(newStation);
			}
		}
		
		
		
		List<List<Direction>> result = new ArrayList<List<Direction>>();
		
		if(UserOptions.ordered)
			result.add(getOrdered(stationList));
		else //else we get unordered
		{
			List<List<IStation>> permutations = findAllPermutations(stationList);
			for(List<IStation> statList : permutations)
			{
				result.add(getOrdered(statList));
			}
		}
		
		
		
		for(List<Direction> res : result)
		{
			for(Direction stat : res)
			{
				System.out.println(stat.instruction + "\t" + stat.station.getStopName());
			}
			System.out.println("----------------------------------------------------");
		}
		
		
		return result;
	}
	
	
	public class Direction{
		public String instruction;
		public IStation station;
		public Direction(IStation station, String instruction)
		{
			this.instruction = instruction;
			this.station = station;
		}
		
		public IStation getStation(){return station;}
		public String getInstruction(){return instruction;}
		
		
	}
	
	
	public List<Direction> getOrdered(List<IStation> list)
	{
		ArrayList<Direction> result = new ArrayList<Direction>();
		result.add(new Direction(list.get(0),"START"));
		
		IStation previous = list.get(0);
		
		
		for(int i = 1; i < list.size();i++)
		{
			IStation current = list.get(i);
			
			if(onSameLine(previous, current))
			{
				if(braintreeAshmontCondition(previous, current))
				{
					StopButton rjfkAshmont = new StopButton("JFK/UMass", 398, 312, "70085", "70086", Color.red, false);
					StopButton rjfkBraintree = new StopButton("JFK/UMass", 398, 312, "70095", "70096", Color.red, false);
					Station rjfkAshmontStation = new Station(rjfkAshmont, LineColor.RED);
					Station rjfkBraintreeStation = new Station(rjfkBraintree, LineColor.RED);
					if (ashmontIStations.contains(previous))
					{
					result.add(new Direction(rjfkAshmontStation, "TRANSFER"));
					result.add(new Direction(current,"ARRIVE"));
					} else {
						result.add(new Direction(rjfkBraintreeStation, "TRANSFER"));
						result.add(new Direction(current,"ARRIVE"));
					}
					
				}else
				{
					result.add(new Direction(list.get(i),"ARRIVE"));
				}
			}
			else
			{
				LineColor curColor = null;
				LineColor prevColor = null;
				List<LineColor> colList = null;
				
				
				if(previous.isIntersection())
				{
					curColor = current.getLineColor();
					colList = previous.getLineColorList();
					for(LineColor col : colList)
					{
						if(!col.equals(prevColor))
							curColor = col;
					}
					
					result.add(new Direction(IStation.Utils.findTransferStation(curColor,prevColor,
							redLine,blueLine,orangeLine), "TRANSFER"));
					
				}
				else if(current.isIntersection())
				{
					prevColor = previous.getLineColor();
					colList = current.getLineColorList();
					for(LineColor col : colList)
					{
						if(!col.equals(prevColor))
							curColor = col;
					}
					
					result.add(new Direction(IStation.Utils.findTransferStation(curColor,prevColor,
							redLine,blueLine,orangeLine), "TRANSFER"));
				}
				else
				{
					prevColor = previous.getLineColor();
					curColor = current.getLineColor();
					
					IStation transferStation = IStation.Utils.findTransferStation(curColor,prevColor,
							redLine,blueLine,orangeLine);
					
					
					if(transferStation == null)  //going from blue->red or red->blue
					{
						if(prevColor.equals(LineColor.BLUE))
						{
							
							result.add(new Direction(stateStreet , "TRANSFER"));
							result.add(new Direction(dxing , "TRANSFER"));
						}
						else
						{
							result.add(new Direction(dxing , "TRANSFER"));
							result.add(new Direction(stateStreet , "TRANSFER"));
						}
						result.add(new Direction(current, "ARRIVE"));
						
					}
					else{
						result.add(new Direction(transferStation, "TRANSFER"));
						result.add(new Direction(current, "ARRIVE"));
					}
				}
			}
			
			previous = current;
		}

		result.add(new Direction(list.get(list.size()-1), "END TRIP"));
		
		return result;
	}

	
	private boolean braintreeAshmontCondition(IStation previous, IStation current)
	{
		List<StopButton> ashmontButtonList = new ArrayList<StopButton>();
		List<StopButton> braintreeButtonList = new ArrayList<StopButton>();
		//Ashmont Stops
		ashmontButtonList.add(new StopButton("Cedar Grove", 518, 244, "700105", "700106", Color.red, false));
		ashmontButtonList.add(new StopButton("Butler", 547, 244, "70097", "70098", Color.red, false));
		ashmontButtonList.add(new StopButton("Milton", 578, 244, "70099", "700100", Color.red, false));
		ashmontButtonList.add(new StopButton("Central Ave", 608, 244, "700101", "700102", Color.red, false));
		ashmontButtonList.add(new StopButton("Valley Road", 641, 244, "700103", "700104", Color.red, false));
		ashmontButtonList.add(new StopButton("Capen Street", 671, 244, "700105", "700106", Color.red, false));
		ashmontButtonList.add(new StopButton("Mattapan", 699, 243, "700107", "700108", Color.red, true));
		ashmontButtonList.add(new StopButton("Savin Hill", 431, 312, "70087", "70088", Color.red, false));
		ashmontButtonList.add(new StopButton("Fields Corner", 451, 290, "70089", "70090", Color.red, false));
		ashmontButtonList.add(new StopButton("Shawmut", 470, 268, "70091", "70092", Color.red, false));
		ashmontButtonList.add(new StopButton("Ashmont", 491, 244, "70093", "70094", Color.red, false));
		//Braintree Stops
		braintreeButtonList.add(new StopButton("North Quincy", 578, 312, "70097", "70098", Color.red, false));
		braintreeButtonList.add(new StopButton("Wollaston", 614, 312, "70099", "700100", Color.red, false));
		braintreeButtonList.add(new StopButton("Quincy Center", 654, 312, "700101", "700102", Color.red, false));
		braintreeButtonList.add(new StopButton("Quincy Adams", 692, 312, "700103", "700104", Color.red, false));
		braintreeButtonList.add(new StopButton("Braintree", 730, 311, "700103", "700104", Color.red, true));
		
		for(StopButton button: ashmontButtonList)
		{
			ashmontIStations.add(new Station(button, LineColor.RED));
		}
		for(StopButton button: braintreeButtonList)
		{
			braintreeIStations.add(new Station(button, LineColor.RED));
		}
		return((ashmontIStations.contains(previous) && braintreeIStations.contains(current)) ||
				(ashmontIStations.contains(current) && braintreeIStations.contains(previous)));
	}


	public static List<List<IStation>> findAllPermutations(List<IStation> list)
	{
		if(list.size() < 3) return null;
		int j = list.size() * 5;
		HashSet<List<IStation>> hashed = new HashSet<List<IStation>>();
		hashed.add(new ArrayList<IStation>(list));
		for(int i = 0; i < j; i++)
		{
			Collections.shuffle(list);
			hashed.add(new ArrayList<IStation>(list));	
		}
		return new ArrayList<List<IStation>>(hashed);
	}
	
	
	public boolean onSameLine(IStation stat1, IStation stat2)
	{
		 return (redLine.contains(stat1) && redLine.contains(stat2)) ||
				 (blueLine.contains(stat1) && blueLine.contains(stat2)) ||
				 (orangeLine.contains(stat1) && orangeLine.contains(stat2));
	}
}