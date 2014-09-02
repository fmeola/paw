<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Modificar un Hotel</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
	</head>
	<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		<h1>Modificar un Hotel</h1>
		<form role="form" action="modifyHotel" method="post">
		<div>
			<div class="form-group"><label>Código: ${hotel.code} </label><input type="hidden" name="codigo" value="${hotel.code}"/></div>
			<div class="form-group"><label>Nombre </label><input type="text" class="form-control" name="nombre" value="${hotel.name}" placeholder="Nombre"></div>
			<div class="form-group"><label>Descripción </label><textarea name="descripcion" class="form-control">${hotel.description}</textarea></div>
			<button type="submit" class="btn btn-success">Enviar</button>
			<button type="reset" class="btn btn-default">Limpiar</button>
		</div>
		</form>
		</br>
		<a href="listHotels" class="btn btn-default">Volver</a>
	</div>
	<%@ include file="footer.jsp" %>
	</body>
</html>