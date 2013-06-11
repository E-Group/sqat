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
			<h2 class="form-heading">Commission</h2>
		</div>
	</div>

</body>
</html>