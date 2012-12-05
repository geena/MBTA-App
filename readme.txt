Software Development Fall 2012

Team Name: The DaVinci Coders

Team Members:
Thomas Meng
Frankie Luizzi
Regina Ranstrom
Luis Llanes

Team Email: tmeng999@gmail.com

How to compile/run on CCIS Linux Machine:
To Compile (Not Necessary Since Jar is included):
Go into root directory and use 'ant' command.

To Run:
Go into root directory and use './runMBTAPlanner' command.

To Run with debug json:
Go into root dir and use './runMBTAPlanner debug.json' 

To see all current location of trains:
Once the application loads, all current location of trains will be shown on start up page.



How to:
The user wants to know where she can go using the T. (Essential)
Run the application, all stations will be listed on the main page.

The user wants to know the current location of all trains. (Essential)
Run the application, all train current locations are displayed on the main page.  Train locations will refresh automatically.

The user wants to know when the next trains get to stop A. (Essential)
Double click on a stop, a new window will appear with the station and information with incoming trains.

The user wants to know her options for getting from stop A to stop B. (Essential)
Click on two stops so that the blue circle appears on top of each stop selected.  On the bottom of the page, click on the button displayed "Plan Trip". Information desired will pop up.

The user wants to know her options for getting to an ordered list of stops. (Desirable)
Click on multiple stops so that the blue circle appears on top of each stop selected. On the bottom of the page,  make sure Ordered is selected then click on the button displayed "Plan Trip". Information desired will pop up.

The user wants to know her options for getting to an unordered list of stops.(Optional)
Click on multiple stops so that the blue circle appears on top of each stop selected. On the bottom of the page,  make sure Unordered is selected then click on the button displayed "Plan Trip". Information desired will pop up.

The user wants to know her options for getting to an unordered list of stops with specified starting and/or ending points. (Optional)
Click on multiple stops so that the blue circle appears on top of each stop selected. On the bottom of the page,  make sure Unordered is selected then click on the button displayed "Plan Trip". Information desired will pop up.

For any trip on the T, the user wants the option to specify departure and/or arrival times. (Desirable)
Select some stops, at the bottom of the page there is an option Departure/Arrival Time, select one.  Select the desired time at the bottom of the page, then click Plan Trip, the information will pop up.

For any trip on the T, the user wants to know the fastest route, the earliest departure, the earliest arrival, and fewest transfers. (Desirable)
Select some stops, at the bottom of the page there is an option Priority, select one.  Click Plan Trip, the information will pop up.

The client wants to test the system with old data. (Essential)
Go into root dir and use './runMBTAPlanner debug.json' 
