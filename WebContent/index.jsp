<!DOCTYPE html>
<html lang="en">
<head>

<title>Commission</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" type="text/css">

</head>

<body>

	<div class="container">
		<form class="form-signin" action="LoginServlet">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="text" name="email" class="input-block-level"
				placeholder="Username"> <input type="password" name="pass"
				class="input-block-level" placeholder="Password">
			<button class="btn btn-large btn-primary" type="submit">Sign
				in</button>
			<p class="text-error">${message}</p>
		</form>
	</div>

</body>

</html>

