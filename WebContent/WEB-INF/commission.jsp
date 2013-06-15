<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
	if ('${loginbean.isValid()}')
	{
	}else
	{		
		window.location = "/Commission/index.jsp";
	}
</script>

<jsp:include page="nav_gunner.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Commission</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css">

<style type="text/css">
</style>
</head>

<body>

	<div class="container">
		<div class="form form-table">
			<h2 class="form-heading">Commission</h2>
			<table class="table table-striped table-bordered">
				<h4>Monthly reports from your salesmen</h4>
				<thead>
					<tr>
						<th>Salesperson</th>
						<th>Month</th>
						<th>Locks</th>
						<th>Stocks</th>
						<th>Barrels</th>
						<th>Salary</th>
						<th style="border-left: 0px"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${comlist}" var="element">
						<tr>

							<td>${element.name}</td>
							<td>${element.month}</td>
							<td>${element.locks}</td>
							<td>${element.stocks}</td>
							<td>${element.barrels}</td>
							<td>$ ${element.salary}</td>
							<td style="border-left: 0px">
								<form action="commission" method="post">
									<button name="acceptbtn" class="btn btn-success" type="submit" value="${element.comId}">Accept</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p class="text-info">${message}</p>
			<c:remove var="message" scope="session" />
		</div>
	</div>

</body>
</html>