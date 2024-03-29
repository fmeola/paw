<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Hoteles</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
	</head>
	<body>
	<%@ include file="header.jsp" %>
		<div class="container">
			<h1>Hoteles</h1></br>
			<table class="table table-striped">
				<tr>
					<td><b>Código</b></td>
					<td><b>Nombre</b></td>
					<td><b>Descripción</b></td>
				</tr>
				<c:forEach var="h" items="${hoteles}">
				<tr>
					<td><c:out value="${h.code}"/></td>
					<td><a href="viewHotel?code=${h.code}"><c:out value="${h.name}"/></a></td>
					<td><c:out value="${h.description}"/></td>
				</tr>
				</c:forEach>
			</table>
			<a href="logout" class="btn btn-default">Cerrar Sesión</a>
			<a href="addHotel" class="btn btn-primary">Agregar un Hotel</a>
		</div>
	<%@ include file="footer.jsp" %>
	</body>
</html>