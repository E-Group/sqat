Commission
==========

## System introcution

# What it is?

Commission is a browser/server application that provides a system that manage producers, who provides items, and salespersons, who sells the items. One producer has many salespersons that sells only his items. The salespersons enter his sales into the system and send a report of a month when all sales for that month is entered. The producer can then confirm the report from the salesperson and approve his calculated commission for the month. Both user types can view their history of data related to themselves.

# Context

This program is developed as a lab in the Software Testing and Quality Assurance course given at Harbin Institute of Technology 2013 by Liu Shu.

The producer is specified as a gunsmith who has the item locks, stocks and barrels who costs 45, 30, 25 respectivly. The gunsmith has multiple salespersons who sells his items in different towns in his area. The salespersons gets their salary based on the sum of sold items during a month.

# How to use Commission

- As a salesperson:
* Log in with your username and password
* In the 'Add sale' tab you can enter a sale
	* A sale can consist of at least one item and max 70 locks, 80 stocks and 90 barrels.
	* Change date of the sale by pressing the calendar icon
	* Submit your sale by pressing the 'Add sale' button
* In the 'Sales' tab you can see the history of all sales made by you
	* To view a specified month, select a month in the calendar field and press 'Filter month'
		* When a month is filtered you can report that month to your gunsmith by pressing 'Send Report'
			* The report is then send to the gunsmith for confirmation of the sales and calculation of your commission
			* Note that no sales can not be added to a month ones a report is sent
			* A month with no sales can not be reported
		* To remove the filter, press 'Show All'
* In the 'Salary' tab you can view your confirmed (with salary) and unconfirmed reports
* Log out by pressing the 'Log out' button

- As a gunsmith:
// TODO

## Installation guide

The program requires:
	- At least Java 1.7
	- At least Apache Tomcat 7.0
	- At least MySQL 5.5.20
The program is developed with the specified version numbers of services, lower version numbers is not tested and not official supported.

The setup guide below is to be executed in a Windows enviroment.

Java setup:
	- Download and install Java from http://java.com/

Apache Tomcat setup:
	- Download Apache Tomcat at http://tomcat.apache.org/
	- Unpack the package at a location of your choice
	- Move the Commission.war file into the folder "<tomcat location>/webapps/"
	- Start the Tomcat server by running "<tomcat location>/bin/startup.bat"
	- Tomcat commands can be found at ?

MySQL setup:
	- Download and install MySQL form http://www.mysql.com/
	- Create a new database
	- Run the attached commission.sql file in the database
	- Make sure the database settings are the same as the settings in "<tomcat location>/webapps/Commission/WEB-INF/classes/config.properties". If you want to change the settings in the file, you need to restart the Tomcat server for the changes to take place. Also make sure that the database user has the right privilegies in the database.
	- Default users are found in the table 'user', these can be modified manually via MySQL

To start the program, simply enter "http://localhost:8080/Commission/" in your browser.

# Dependencies

/*
Stocksify uses the Yahoo! Query Language (YQL) to query for stock information and is totally dependent of Yahoo's web service and the YQL to provide information. The application is also dependent on the fact that the user has an Internet connection in order to be able to connect to Yahoo's web services.
*/

Limitations
-----------


/*
Stocksify can only get information on stocks from the whole world if using the short symbols provided by finance.yahoo.com.

Yahoo supplies the following information on the YQL service. These are the highest level constraints for the Product:

	x YQL has a performance uptime target of over 99.5%.

	x YQL relies on the correct operation of the Web services and content providers it accesses.

	x YQL rate limits are subject to the rate limits of other Yahoo! and 3rd-party Web services, and all rates are subject to change.
*/

Licensing
---------


/*
Stocksify is free to use, change and distribute. Note however that there may be license restrictions in the libraries used within the product. For further information, please refer to the License Agreement of Google Guava (https://code.google.com/p/guava-libraries/, Apache License 2.0), JSON (http://www.json.org/license.html) and/or Apache HttpComponents (http://www.apache.org/licenses/, Apache License 2.0).
*/

Authors
-------
David Buö
Niklas Lavrell

Disclaimer
----------


/*
The development team behind Stocksify takes no responsibility that the information provided is correct or that the recommendation to buy a stock will be a profitable affair.
The developers takes no responsibility or liability in the possible case of damage or loss of property from using this application.
*/


---------------
Hand-ins
---------------
System introduction
Installation guide
Report on other sytem, evaluate the two above