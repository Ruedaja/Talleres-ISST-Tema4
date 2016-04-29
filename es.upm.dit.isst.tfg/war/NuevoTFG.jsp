<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sistema de Gestion de TFGs</title>
<link rel = "stylesheet" type = "text/css" href = "css/main.css"/>
</head>
<body>

 
Alumno: esta es una solicitud de TFG
	<form action = "/nuevoTFG" method = "post" acceptcharset = "utf8">
	
		<p><input type = "text" name = "autor" id = "autor" maxLength = "255" required size = "20" placeholder = "autor" /></p>
		<p><input type = "text" name = "titulo" id = "titulo" maxLength = "255" requiered size = "20" placeholder = "Titulo" /></p>
		<p><input type = "text" name = "resumen" id = "resumen" maxLength = "255" required size = "20" placeholder = "resumen" />
		<p><input type = "text" name = "tutor" id = "tutor" maxLength = "255" required size = "20" placeholder = "tutor" /></p>
		<p><input type = "text" name = "secretario" id = "secretario" maxLength = "255" required size = "20" placeholder = "Secretario" /></p>
		<p><input type = "text" name = "fichero" id = "fichero" maxLength = "255" required size = "20" placeholder = "fichero" /></p>
		<p><input type = "submit" value = "Enviar" /></p>
		
	</form >



</body>
</html>