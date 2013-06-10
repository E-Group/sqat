<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	if ('${loginbean.isValid()}') {
	} else {
		window.location = "/Commission/index.jsp";
	}
</script>

<jsp:include page="nav_sales.jsp" />

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="form">
		<h2 class="form-heading">Your telegram has been recorded</h2>
			<div class="well-large">
				You entered<BR> Town:
				${telegrambean.town}<BR> Locks: ${telegrambean.locks}<BR>
				Stocks: ${telegrambean.stocks}<BR> Barrels:
				${telegrambean.barrels}<BR> 
				<a href="sucess.jsp"><button class="btn btn-success">Add new sale</button></a>
				<a href="<%=request.getContextPath()%>/SalesServlet"><button class="btn btn-info">View sales</button></a>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>