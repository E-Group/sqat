<!DOCTYPE html>
<html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sign in &middot; Twitter Bootstrap</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.container {
	padding: 50px;
}

.form-signin {
	max-width: 300px;
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

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<link href="css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form class="form-signin" action="LoginServlet">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="text" name="email" class="input-block-level"
				placeholder="Email address"> <input type="password"
				name="pass" class="input-block-level" placeholder="Password">
			<button class="btn btn-large btn-primary" type="submit">Sign
				in</button>
		</form>
	</div>
	<!-- /container -->

</body>
</html>

