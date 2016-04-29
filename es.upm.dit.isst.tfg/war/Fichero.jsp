<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>

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
Formulario de subida de la memoria del TFG.

	

	 
	<form action="<%=blobstoreService.createUploadUrl("/upload")%> "method="post" enctype="multipart/form-data">
		
		Fichero: <p><input type="file" name="file" /></p>
		<p><input type="submit" value="Subir memoria" />Subir</p>
		
	</form>

</body>
</html>
