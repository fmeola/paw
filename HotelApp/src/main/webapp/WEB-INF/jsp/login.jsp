<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
	</head>
	<body>
	<%@ include file="header.jsp" %>
		<div class="container">
			<h1>Login</h1></br>
			<form role="form" action="login" method="post">
				<div>
					<div class="form-group"><label>Usuario </label><input type="text" class="form-control" name="usuario" placeholder="Usuario"></div>
					<div class="form-group"><label>Contraseña </label><input type="password" class="form-control" name="pass" placeholder="Contraseña"></div>
					<button type="submit" class="btn btn-primary">Iniciar Sesión</button>
					<button type="reset" class="btn btn-default">Limpiar</button>
				</div>
			</form>
		</div>
	<%@ include file="footer.jsp" %>
	</body>
</html>