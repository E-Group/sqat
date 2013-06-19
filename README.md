  ____                          _         _             
 / ___|___  _ __ ___  _ __ ___ (_)___ ___(_) ___  _ __  
| |   / _ \| '_ ` _ \| '_ ` _ \| / __/ __| |/ _ \| '_ \ 
| |__| (_) | | | | | | | | | | | \__ \__ \ | (_) | | | |
 \____\___/|_| |_| |_|_| |_| |_|_|___/___/_|\___/|_| |_|
 				          									Version 1.0 19/06/2013
===================================================================================

## System introcution

# What it is?

Commission is a web application that provides a system that handles producers and salespersons. The producers has items that can be sold by his salespersons. The salespersons enter sales into the system and send a report when he has entered all the sales of a month. The producer can then confirm his salespersons report and calculate his commission for the month.

This program is developed as a project in the Software Testing and Quality Assurance course given at Harbin Institute of Technology 2013 by Liu Shu.

/*
Stocksify is a desktop application for displaying current stock information. It provides a simple user interface for the stocks financial data and graphs. Stocksify also provides recommendations on if the stock is good to buy or not.This program is developed as a project in the Software Reuse Technology course given at Harbin Institute of Technology 2013 by Dr. Shiping Chen.
*/

# How to use Commission

/*
## How to query for stock information
1. Open "Stocksify.jar" in your Stocksify directory
2. Locate the field labeled "Stock Symbol:" in the top right corner.
3. Enter the short symbol for a stock, e.g. "AAPL" for Apple.
4. Enter what range you want the chart to display in the "Range" drop-down.
5. Choose chart type in the "Chart type" drop-down.
6. Press the "Search Button"

## Add a Favorite stock
1. Query a stock (described above)
2. Press the green '+' symbol in the bottom right corner.

## Remove a Favorite stock
1. Select a stock in the Favorite list on the right.
2. Press the red '-' symbol in the bottom right corner.
*/

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



Hand-ins
---------------
System introduction
Installation guide
Report on other sytem, evaluate the two above
