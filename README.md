# Commission

## System introcution

### What it is?

Commission is a browser/server application that provides a system that manage producers, who provides items, and salespersons, who sells the items. One producer has many salespersons that sells only his items. The salespersons enter his sales into the system and send a report of a month when all sales for that month is entered. The producer can then confirm the report from the salesperson and approve his calculated commission for the month. Both user types can view their history of data related to themselves.

### Context

This program is developed as a lab in the Software Testing and Quality Assurance course given at Harbin Institute of Technology 2013 by Liu Shu.

The producer is specified as a gunsmith who has the item locks, stocks and barrels who costs $45, $30, $25 respectivly. The gunsmith has multiple salespersons who sells his items in different towns in his area. The salespersons gets their salary based on the sum of sold items during a month.

### How to use Commission

#### As a salesperson:
* Log in with your username and password
* In the 'Add sale' tab you can enter a sale
	* A sale can consist of at least one item.
		* A salesperson can sell a maximum of 70 locks, 80 stocks and 90 barrels each month.
	* Change date of the sale by pressing the calendar icon
	* Submit your sale by pressing the 'Add sale' button
* In the 'Sales' tab you can see the history of all sales made by you
	* To view a specified month, select a month in the calendar field and press 'Filter month'
		* When a month is filtered you can report that month to your gunsmith by pressing 'Send Report'
			* The report is then send to the gunsmith for confirmation of the sales and calculation of your commission
			* Note:
			1) After reporting a month you will not be able to add more sales to that month.
			2) To be able to report a month the salesperson must have sold at least 1 lock, 1 stock and 1 barrel during that month.
		* To remove the filter, press 'Show All'
* In the 'Salary' tab you can view your confirmed (with salary) and unconfirmed reports
* Log out by pressing the 'Log out' button

#### As a gunsmith:
* Log in with your username and password
* In the 'Sales' tab you can show all sales your salespersons has made.
	* You can also filter by salesperson with the dropdown list and 'Filter' button
* In the 'Commission' tab you can see all unconfirmed reports send by your salespersons
	* Each unconfirmed report has a caluculated commission value based on the sum of sales during that month:
		* A lock cost 45, a stock cost 30 and a barrel cost 25.
		* The commission if calculated as follows: 10% on sales up to (and including) $1000, 15% on the next $800, and 20% on any sales in excess of $1800.
	* To confirm a report press 'Confirm'
* Log out by pressing the 'Log out' button

## Installation guide

#### The program requires:
	- At least Java 1.7
	- At least Apache Tomcat 7.0
	- At least MySQL 5.5.20
The program is developed with the specified version numbers of services, lower version numbers is not tested and not official supported.

The setup guide below is to be executed in a Windows enviroment.

#### Java setup:
	- Download and install Java from http://java.com/

#### Apache Tomcat setup:
	- Download Apache Tomcat at http://tomcat.apache.org/
	- Unpack the package at a location of your choice
	- Move the Commission.war file into the folder "<tomcat location>/webapps/"
	- Start the Tomcat server by running "<tomcat location>/bin/startup.bat"
	- Tomcat commands can be found at ?

#### MySQL setup:
	- Download and install MySQL form http://www.mysql.com/
	- Create a new database named 'sqaat'
	- Run the attached sqaat.sql file in the database
	- Make sure the database settings are the same as the settings in "<tomcat location>/webapps/Commission/WEB-INF/classes/config.properties". If you want to change the settings in the file, you need to restart the Tomcat server for the changes to take place. Also make sure that the database user has the right privilegies in the database.
	- Default users are found in the table 'user', these can be modified manually via MySQL

To start the program, simply enter "http://localhost:8080/Commission/" in your browser.

## Disclaimer

The developers takes no responsibility or liability in the possible case of damage or loss of property from using this application.

## Authors

David Buö and Niklas Lavrell