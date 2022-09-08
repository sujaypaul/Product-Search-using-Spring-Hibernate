<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page
	import="com.nagarro.training.advanceJavaAssignment4.model.Tshirt,java.util.List"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="A"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">


<title>Home</title>

</head>

<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>

	<header>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header" style="margin-left: 30%;">
					<h2>T-Shirt search</h2>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<form action="<%=request.getContextPath()%>/">
							<input type="submit" value="logout">
						</form>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<div class="container-fluid" style="width: 60%;">
		<div>
			<A:form action="search" method="POST" modelAttribute="ser">

				<div class="row pb-4">
					<div class="col-sm-4">
						<label for="color">Color</label>
					</div>
					<div class="col">
						<select class="form-select" name="color" id="color" required>
							<option value="BLACK">Black</option>
							<option value="WHITE">White</option>
							<option value="BLUE">Blue</option>
							<option value="PURPLE">Purple</option>
							<option value="GREY">Grey</option>
							<option value="MAROON">Maroon</option>
							<option value="YELLOW">Yellow</option>
						</select>
					</div>
				</div>
				<div class="row pb-4">
					<div class="col-sm-4">
						<label for="size">Size</label>
					</div>
					<div class="col">
						<select class="form-select" name="size" id="size" required>
							<option value="S">S-small</option>
							<option value="M">M-medium</option>
							<option value="L">L-Large</option>
							<option value="XL">XL-extra large</option>
							<option value="XXL">XXL-double extra</option>
						</select>
					</div>
				</div>
				<div class="row pb-4">
					<div class="col-sm-4">
						<label for="gender">Gender</label>
					</div>
					<div class="col form-check">
						<input class="form-check-input" type="radio" name="gender"
							id="gender" value="M" checked> <label
							class="form-check-label" for="gender"> Male </label>
					</div>
					<div class="col form-check">
						<input class="form-check-input" type="radio" name="gender"
							id="gender" value="F"> <label class="form-check-label"
							for="gender"> Female </label>
					</div>

				</div>
				<div class="row pb-4">
					<div class="col-sm-4">
						<label for="outputPreference">Output Preference</label>
					</div>
					<div class="col form-check">
						<input class="form-check-input" type="checkbox"
							name="outputPreference" id="outputPreference" value="PRICE"
							checked /> <label class="form-check-label"
							for="outputPreference"> Price </label>
					</div>
					<div class="col form-check">
						<input class="form-check-input" type="checkbox"
							name="outputPreference" id="outputPreference" value="RATING" />
						<label class="form-check-label" for="outputPreference">
							Rating </label>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-1">
						<input type="submit" value="Search">
					</div>
				</div>
			</A:form>
		</div>
	</div>


	<div class="container mt-5">
		<b style="color: green;">${msg}</b>

		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Color</th>
					<th scope="col">Gender</th>
					<th scope="col">Size</th>
					<th scope="col">Price</th>
					<th scope="col">Rating</th>
					<th scope="col">Availability</th>
				</tr>
			</thead>

			<%
				if (request.getAttribute("list") != null) {
					List<Tshirt> list = (List<Tshirt>) request.getAttribute("list");
			%>

			<%
					if (list.size() != 0) {
						for (Tshirt t : list) {
			%>

			<tr>
				<td><%=t.getId()%></td>
				<td><%=t.getName()%></td>
				<td><%=t.getColor()%></td>
				<td><%=t.getGender()%></td>
				<td><%=t.getSize()%></td>
				<td><%=t.getPrice()%></td>
				<td><%=t.getRating()%></td>
				<td><%=t.getAvalibilty()%></td>

			</tr>

			<%
						}
					}
				}
			%>


		</table>

	</div>


</body>

</html>