<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">


</head>
<body>
	<div class="container">
		Welcome
		<%
		String user = (String) session.getAttribute("user");
		out.println(user);
		%>
		!
		<br> What have you sold?

		<form class="form" ACTION="TelegramServlet">
			<table>
				<tr>
					<td>Town</td>
					<td><select name="town">
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