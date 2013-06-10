<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	if ('${loginbean.isValid()}') {
	} else {
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
			<table class="table table-striped table-bordered">
				<caption>Your salaries</caption>
				<thead>
					<tr>
						<th>id</th>
						<th>town</th>
						<th>item</th>
						<th>date</th>
						<th>quantity</th>
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

</body>
</html>