<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet" type = "text/css" href = "css/table.css"/>
<title>TFGs</title>
</head>
<body>
<p>Sistema de gestion de TFGs</p>

	<c:if test="${user!=null}">
	
		<c:out value="${user}"></c:out>	
		<c:forEach items="${tfgs}" var="tfg">
		
		<div class="tabletfg" style="width:600px;height:150px;">
			<table>
			<tr>
				<td><c:out value = "${tfg.autor}"/> </td>
				<td><c:out value = "${tfg.titulo}"/> </td>
				<td><c:out value = "${tfg.resumen}"/> </td>
				<td><c:out value = "${tfg.tutor}"/> </td>
			
			</tr>
			</table>
			</div>
		
		</c:forEach>
		
	</c:if>
	

</body>
</html>