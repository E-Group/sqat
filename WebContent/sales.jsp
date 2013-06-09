<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.util.*" %>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
 <!-- TROR ATT DET SKA LÖSA SIG OM VI IMPORTERAR -->
 <!-- NÅGON GREJ TILL PROJEKET, SOM SKA STÖDJA DETTA -->
 <!-- NÅOGOT BIBLITEK TYP -->
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Commission</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

1
<table border="2">
<c:forEach items="${list}" var="element"> 
  <tr>
    <td>${elementid}</td>
    <td>${element.salesperson}</td>
    <td>${element.town}</td>
    <td>${element.date}</td>
    <td>${element.quantity}</td>
  </tr>
</c:forEach>
</table>
2

</body>
</html>