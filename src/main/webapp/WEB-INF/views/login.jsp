<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="A"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Login</title>
</head>
<body>
	
	<b style="color:red;">${msg}</b>

	<div class="container" styel="margin">
		<div class="row"
			style="margin-top: 10%; margin-left: 10%; margin-right: 20% width=150px">
			<div>
				<A:form class="form-horizontal" action="home" method="POST" modelAttribute="ver"
					style='background: #F5F8FB; width: 65%'>
					<fieldset>
						<div id="legend">
							<legend style='background: #EBF1F7;'> Login</legend>
						</div>
						<div class="control-group">
							<!-- Username -->
							<label class="control-label" for="username">Username</label>
							<div class="controls">
								<A:input path="username" />
								<A:errors path="username" cssStyle="color:red" />
							</div>
						</div>
						<div class="control-group">
							<!-- Password-->
							<label class="control-label" for="password">Password</label>
							<div class="controls">
								<A:password path="password" />
								<A:errors path="password" cssStyle="color:red" />

							</div>
						</div>
						<div class="control-group"
							style='background: #EBF1F7; text-align: right; margin-bottom: 0px; padding: 1%'>
							<!-- Button -->
							<div class="controls">
								<input class="btn btn-success" type='submit' value="Login >>" />
							</div>
						</div>
					</fieldset>
				</A:form>
			</div>
		</div>
	</div>



</body>
</html>