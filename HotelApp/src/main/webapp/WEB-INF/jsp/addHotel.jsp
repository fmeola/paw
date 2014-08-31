<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Agregar un Hotel</title>
		<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	</head>
	<body>
	<div class="container">
		<h1>Agregue un Hotel</h1>
		<form role="form" action="addHotel" method="post">
		<div>
			<div class="form-group"><label>Código </label><input type="text" class="form-control" name="codigo" placeholder="Código"></div>
			<div class="form-group"><label>Nombre </label><input type="text" class="form-control" name="nombre" placeholder="Nombre"></div>
			<div class="form-group"><label>Descripción </label><textarea name="descripcion" class="form-control" placeholder="Descripcion"></textarea></div>
			<button type="submit" class="btn btn-success">Enviar</button>
			<button type="reset" class="btn btn-default">Limpiar</button>
		</div>
		</form>
		</br>
		<a href="listHotels" class="btn btn-default">Volver</a>
	</div>
	</body>
</html>