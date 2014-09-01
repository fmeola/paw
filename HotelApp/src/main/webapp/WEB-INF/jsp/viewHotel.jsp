<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><c:out value="Hotel ${hotel.name}"/></title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
	</head>
	<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		<h1><c:out value="Hotel ${hotel.name}"/></h1>
		<h2><c:out value="${hotel.description}"/></h2>
		<h3><c:out value="Codigo: ${hotel.code}"/></h3>
		<c:choose>
			<c:when test="${empty hotel.comments}">
				<div class="alert alert-info" role="alert">No hay comentarios</div>
			</c:when>
			<c:otherwise>
				<table class="table table-striped">
					<tr>
						<td><b>Usuario</b></td>
						<td><b>EMail</b></td>
						<td><b>Comentario</b></td>
					</tr>
					<c:forEach var="c" items="${hotel.comments}">
						<tr>
							<td><c:out value="${c.username}"/></td>
							<td><c:out value="${c.mail}"/></td>
							<td><c:out value="${c.comment}"/></td>
						</tr>
					</c:forEach>
				</table>
    		</c:otherwise>
		</c:choose>
		</br>
		<h3>Deje su comentario aquí</h3>
		<form role="form" action="viewHotel" method="post">
		<div>
			<input type="hidden" name="code" value="${hotel.code}"/>
			<div class="form-group"><label>Comentario </label><textarea name="comentario" class="form-control" placeholder="Comentario"></textarea></div>
			<button type="submit" class="btn btn-primary">Enviar</button>
			<button type="reset" class="btn btn-default">Limpiar</button>
		</div>
		</form>
		</br>
		<a href="modifyHotel?code=${hotel.code}" class="btn btn-primary">Modificar</a>
		<a href="listHotels" class="btn btn-default">Volver</a>
	</div>
	<%@ include file="footer.jsp" %>
	</body>
</html>