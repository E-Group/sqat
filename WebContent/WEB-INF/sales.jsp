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
			<h2 class="form-heading">Sales</h2>
				<div class="btn-grp">
					<form action="sales">
						<div class="input-append date" id="datepicker" data-date="2013-06">
							<input name="date" class="span1" size="16" type="text"
								value="${selecteddate}" readonly> <span class="add-on"><i
								class="icon-calendar" required></i></span>


							<button name="filter" class="btn btn-info" type="submit"
								style="vertical-align: top;">Filter Months</button>

							<button name="showall" class="btn btn-info" type="submit"
								style="vertical-align: top;">Show all</button>
						</div>
					</form>
				</div>
				<div class="btn-grp">
					<form method="POST" action="report">
						<button name="report" class="btn btn-warning ${filtered} report"
							type="submit" value="${selecteddate}"
							style="vertical-align: top;">Send
							report</button>
					</form>
				</div>
			<p class="text-success">${message}</p>
			<c:remove var="message" scope="session" />
			<p class="text-error">${error}</p>
			<c:remove var="error" scope="session" />
			<table class="table table-striped table-bordered">
				<caption>Your sales</caption>
				<thead>
					<tr>
						<th>Sale id</th>
						<th>Town</th>
						<th>Item</th>
						<th>Date</th>
						<th>Quantity</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="element">
						<tr>
							<td>${element.id}</td>
							<td>${element.town}</td>
							<td>${element.item}</td>
							<td>${element.date}</td>
							<td>${element.quantity}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<!-- JS -->
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		$("#datepicker").datepicker({
			format : "yyyy-mm",
			viewMode : "months",
			minViewMode : "months"
		});
	</script>
</body>
</html>