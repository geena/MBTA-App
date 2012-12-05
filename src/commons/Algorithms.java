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
	List<IStation> ashmontIStations;
	List<IStation> braintreeIStations;

	IntersectionStation stateStreet;
	IntersectionStation	dxing;

	public Algorithms(List<TripList> allTrainsList, 
			List<IStation> redLine, List<IStation> blueLine, List<IStation> orangeLine)
	{
		this.allTrainsList = allTrainsList;
		this.redLine = redLine;
		this.blueLine = blueLine;
		this.orangeLine = orangeLine;

		ashmontIStations = new ArrayList<IStation>();
		braintreeIStations = new ArrayList<IStation>();

		populateAshmontAndBraintreeStations();

		List<LineColor> stateColList = new ArrayList<LineColor>();
		stateColList.add(LineColor.BLUE);
		stateColList.add(LineColor.ORANGE);

		stateStreet = new IntersectionStation("70042", "70043" , "State Street", stateColList);

		List<LineColor> dxingColList = new ArrayList<LineColor>();
		dxingColList.add(LineColor.RED);
		dxingColList.add(LineColor.ORANGE);

		dxing = new IntersectionStation("70077", "70078" , "Downtown Crossing", dxingColList);
	}



	private void populateAshmontAndBraintreeStations() 
	{
		for(IStation station : redLine)
		{
			if(isAshmontStation(station))
			{
				ashmontIStations.add(station);
			}else if(isBraintreeStation(station))
			{
				braintreeIStations.add(station);
			}
		}
	}

	private boolean isAshmontStation(IStation station) 
	{
		String name = station.getStopName();
		return (name.equalsIgnoreCase("Cedar Grove") ||
				name.equalsIgnoreCase("Butler") ||
				name.equalsIgnoreCase("Milton") ||
				name.equalsIgnoreCase("Central Ave") ||
				name.equalsIgnoreCase("Valley Road") ||
				name.equalsIgnoreCase("Capen Street") ||
				name.equalsIgnoreCase("Mattapan")||
				name.equalsIgnoreCase("Savin Hill")||
				name.equalsIgnoreCase("Fields Corner")||
				name.equalsIgnoreCase("Shawmut")||
				name.equalsIgnoreCase("Ashmont"));
	}

	private boolean isBraintreeStation(IStation station) 
	{
		String name = station.getStopName();
		return (name.equalsIgnoreCase("North Quincy") ||
				name.equalsIgnoreCase("Wollaston") ||
				name.equalsIgnoreCase("Quincy Center") ||
				name.equalsIgnoreCase("Quincy Adams") ||
				name.equalsIgnoreCase("Braintree"));
	}

	/**
	 * 
	 * returns a list of a list of directions
	 * if the user wants only one ordered list of directions it will only contain one list of directions
	 * if the user wants unordered stops the result will be a list of size n! chosen routes using all permutations of traversal
	 */
	public List<List<Direction>> executeTask(){

		List<StopButton> stopList = new ArrayList<StopButton>(UserOptions.stopList);

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
				IStation station = stat.station;
				int seconds = 0;
				
				if(Integer.parseInt(station.getStopIDa())%2 != 0)
					seconds = station.getSecondsLista().get(0);
				else
					seconds = station.getSecondsListb().get(0); 
				
				System.out.println(stat.instruction + "\t" + stat.station.getStopName() + "\t" + seconds);
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
					if (ashmontIStations.contains(previous))
					{
						IStation jfkStation = null;
						for(IStation station : redLine)
						{
							if(station.getStopIDa().equals("70085"))
							{
								jfkStation = station;
							}
						}
						result.add(new Direction(jfkStation, "TRANSFER"));
						result.add(new Direction(current,"ARRIVE"));
					} else {
						IStation jfkStation = null;
						for(IStation station : redLine)
						{
							if(station.getStopIDa().equals("70095"))
							{
								jfkStation = station;
							}
						}
						result.add(new Direction(jfkStation, "TRANSFER"));
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