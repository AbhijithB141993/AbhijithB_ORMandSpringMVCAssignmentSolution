<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Save Customer</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h3>Customer Relationship Management</h3>
		<hr>
		
		<p class = "h4 mb-4">Save Customer</p>
		
		<form action="/CustomerRelationshipManagement/customers/save" method="POST">
			<input type="hidden" name="id" value="${Customer.id}" />
			<div class="form-inline">
			<input type="text"  name="firstName" value="${Customer.firstName}" placeholder="First Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			<input type="text"  name="lastName" value="${Customer.lastName}" placeholder="Last Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			<input type="text"  name="email" value="${Customer.email}" placeholder="Email" class="form-control mb-4 col-4">
			</div>
			<button type="submit" class="btn btn-info col-2">Save</button>
		</form>
		
		<a href="/CustomerRelationshipManagement/customers/list">Back to Customers List</a>
	
	</div>
</body>
</html>