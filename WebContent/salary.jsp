<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
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

<jsp:include page="nav_sales.jsp" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Commission</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div class="container">
		<div class="form form-table">
			<h2 class="form-heading">Salary</h2>
			<table class="table table-striped table-bordered">
				<caption>Unconfirmed reported months</caption>
				<thead>
					<tr>
						<th>Month</th>
						<th>Salary</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${unconfirmedList}" var="unconfirmedElement">
						<tr>
							<td>${unconfirmedElement.month}</td>
							<td>${unconfirmedElement.salary}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table class="table table-striped table-bordered">
				<caption>Your salaries</caption>
				<thead>
					<tr>
						<th>Month</th>
						<th>Salary</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="element">
						<tr>
							<td>${element.month}</td>
							<td>${element.salary}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>