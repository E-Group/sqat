<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="sale" class="cn.sqat.model.TelegramBean" scope="session"/>
<jsp:setProperty name="sale" property="*"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>
</head>
<body>

Your telegram has been recorded. You entered<BR>
Town: <%= sale.getTown() %><BR>
Locks: <%= sale.getLocks() %><BR>
Stocks: <%= sale.getStocks() %><BR>
Barrels: <%= sale.getBarrels() %><BR>

<a href="sucess.jsp"><button class="btn btn-success">Continue</button></a>

</body>
</html>