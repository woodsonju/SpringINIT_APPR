<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" context="/springmvc"/>">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="UTF-8" />
<title>Gestion des Users</title>
</head>
<body>
	<main class="container">
		<nav class="navbar navbar-expand-lg sticky-top bg-dark bmb-4" style="margin-bottom : 50px">
			<a class="navar-brand" href="/springmvc"> Formation Spring MVC</a>
			<ul class="navbar-nav mr-auto">
				<c:if 
					test='${not empty sessionScope.user && sessionScope.user.role=="ADMIN"}'>
					<li class="nav-item"><c:url value="/admin/users/add"
						context="/springmvc" var="urladminuser" /> 
						<a class="nav-link" href="${urladminuser}">Ajout Utilisateur</a>
					</li>
				</c:if>
			</ul>
			<c:choose>
				<c:when test="${empty sessionScope.isConnected || not sessionScope.isConnected}">
					<c:url value="/login" context="/springmvc" var="urllogin" />
					<a  class="btn btn-success" href="${urllogin}">Login</a>
				</c:when>
				<c:otherwise>
					<c:url value="/logout" context="/springmvc" var="urllogout" />
					<a class="btn btn-primary" href="${urllogout}">Logout</a>
				</c:otherwise>
			</c:choose>
		</nav>
		
		
		
<!-- 	</main>
</body>
</html> -->