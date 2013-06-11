<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	if ('${loginbean.isValid()}') {
	} else {
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
			<h2 class="form-heading">Gunner view</h2>
			<div style="max-width: 400px;">
				<%-- 				<form action="SalesServlet">
					<div class="input-append date" id="datepicker" data-date="2013-06">
						<input name="date" class="span1" size="16" type="text"
							value="${selecteddate}" readonly> <span class="add-on"><i
							class="icon-calendar"></i></span>
					</div>
					<select class="sale-dropdown" name="salespersons">
						<c:forEach items="${salespersonlist}" var="element">
							<option value="${element.id}"
								${element.id == selectedsales ? 'selected="selected"' : ''}>${element.name}</option>
						</c:forEach>
					</select>
					<button class="btn btn-info" type="submit"">View sales</button>
				</form> --%>
				<form action="SalesServlet">
					<span><i> <select class="sale-dropdown"
							name="salespersons">
								<c:forEach items="${salespersonlist}" var="element">
									<option value="${element.id}"
										${element.id == selectedsales ? 'selected="selected"' : ''}>${element.name}</option>
								</c:forEach>
						</select></i></span>
					<div class="input-append date" id="datepicker" data-date="2013-06">
						<input name="date" class="span1" size="16" type="text"
							value="${selecteddate}" readonly> <span class="add-on"><i
							class="icon-calendar"></i></span>
						<button name="filter" class="btn btn-info" type="submit">Filter
						</button>
						<span><i>
								<button name="showall" class="btn btn-info" type="submit">Show
									all</button>
						</i> </span>
					</div>
				</form>
			</div>
			<table class="table table-striped table-bordered">
				<h4>Sales for period ${selecteddate}</h4>
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