<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.container {
	padding: 50px;
}

.form {
	max-width: 350px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/datepicker.less" rel="stylesheet" type="text/css" />
<link href="css/datepicker.css" rel="stylesheet">
<script type="text/javascript" src="js/bootstrap-datepicker.js">
$(function() {
	  $('#datepicker').datepicker();
	});
</script>
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

							/* Fixar stor första bokstav av någon anledning...*/
							String first = user.substring(0, 1);
							first = first.toUpperCase();
							String last = user.substring(1);
							user = first + last;
							out.println(user);
						%>
					</td>
				</tr>
				<tr>
					<td>Date</td>
					<td>

						<div class="input-append date" id="datepicker" data-date="2013-01-01"
							data-date-format="yyyy-mm-dd" data-datepicker="datepicker">
							<input name="saledate" class="span2" size="16" type="text"
								value="2013-01-01"> <span class="add-on"><i
								class="icon-th"></i></span>
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
					<td><INPUT TYPE=text NAME=date></td>
					<!-- add date picker from http://www.eyecon.ro/bootstrap-datepicker/ ? -->
				</tr>
					<td><P>
							<INPUT class="btn btn-primary" TYPE=SUBMIT VALUE='Send telegram'>
						</P></td>
				</tr>
			</table>
		</FORM>
	</div>
</body>
</html>