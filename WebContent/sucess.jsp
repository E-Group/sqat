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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Commission</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container">
		<form class="form" ACTION="TelegramServlet">
			<h2 class="form-heading">What have you sold?</h2>
			<table>
				<tr>
					<td>User</td>
					<td>
						<%
							String user = (String) session.getAttribute("user");
							if (user != null) {
								/* Fixar stor första bokstav av någon anledning...*/
								String first = user.substring(0, 1);
								first = first.toUpperCase();
								String last = user.substring(1);
								user = first + last;
								out.println(user);
							}
						%>
					</td>
				</tr>
				<tr>
					<td>Town</td>
					<td><select name="town">
							<!-- populate list exampe: http://stackoverflow.com/questions/3267837/how-to-populate-a-drop-down-list-from-the-database-with-jstl -->
							<option value="1">Phoenix</option>
							<option value="2">Tucson</option>
							<option value="3">Mesa</option>
							<option value="4">Chandler</option>
					</select></td>
				</tr>
				<tr>
					<td>Sold locks</td>
					<td><INPUT TYPE=number NAME=locks></td>
				</tr>
				<tr>
					<td>Sold stocks</td>
					<td><INPUT TYPE=number NAME=stocks></td>
				</tr>
				<tr>
					<td>Sold barrels</td>
					<td><INPUT TYPE=number NAME=barrels></td>
				</tr>
				<tr>
				<tr>
					<td>Date</td>
					<td>
						<div class="input-append date" id="dp3" data-date="2013-01-01"
							data-date-format="yyyy-mm-dd">
							<input name="saledate" class="span2" size="16" type="text"
								value="2013-01-01" readonly> <span class="add-on"><i
								class="icon-calendar"></i></span>
						</div>
				<tr>
					<td><INPUT class="btn 
				btn-primary" TYPE=SUBMIT
						VALUE='Send telegram'></td>
				</tr>
			</table>
		</form>

		<form class="form" action="">
			<input class="btn btn-info" type="submit" value="View Sells">
		</form>

		<form class="form" action="LogoutServlet">
			<input class="btn btn-info" type="submit" value="Log out">
		</form>
	</div>
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		$(document).ready(function() {
			$('#dp3').datepicker();
		});
	</script>
</body>
</html>