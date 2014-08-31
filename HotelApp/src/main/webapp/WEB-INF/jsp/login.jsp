<%@ page contentType="text/html" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	</head>
	<body>
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
	</body>
</html>