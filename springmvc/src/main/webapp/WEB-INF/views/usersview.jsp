<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="header.jsp"/>
	<table class= "table table-striped col-xl-6 col-lg-6" style="margin-left:20px">
		<thead class="panel-heading" style="background-color: #C88A7D">
			<tr>
				<th>Prenom</th>
				<th>Nom</th>
				<th>Email</th>
				<th>Role</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<!-- items="${users}" : Cela veut dire qu'on est entrain de demander à JSP d'aller 
		vers le MODEL, et chercher un attribut qui s'appeller users 
		
		${user.prenom} : Il fait appel au getter (getPrenom....)
		-->
		<tbody style="background-color:#F5F6F2">
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.prenom}</td>
					<td>${user.nom}</td>
					<td>${user.email}</td>
					<td>${user.role}</td>
					<td>
					<c:if 
					test='${not empty sessionScope.user && sessionScope.user.role=="ADMIN"}'>
						<c:url value="/admin/users/delete/${user.id}" context="/springmvc" var="urldelete"/>
						<a href="${urldelete}" onclick="return confirm('Are you sure ?')">Delete</a>
						</c:if>
					<td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="footer.jsp" />