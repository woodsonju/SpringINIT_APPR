<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" context="/springmvc"/>">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/admin/users/add" context="/springmvc" var="urladd" />
	<!-- modelAttribut :Les données que je vais saisir ici, seront stockés 
						dans cette  formuser. 
						Les données qui s'affiche dans le formulaire correspond à 
						cet objet product qui represente un product
						
		f:label ==> On affiche le label Prénom 
		f:input  ==> On affiche un champs de saisie
		path  : La données qui va être saisie, correspond à un attribut de la classe	
		path="prenom" fait appel au getter(getPrenom())		
	-->
	<f:form method="post" action="${urladd}" modelAttribute="formuser">
		<div class="form-group">
			<div class="offset-md-2 col-md-8 mt-2">
				<f:label path="prenom">Prénom</f:label>
				<f:input path="prenom" class="form-control"/>
				<f:errors class="small text-danger" path="prenom"/>
			</div>
		</div>
		<div class="form-group">
			<div class="offset-md-2 col-md-8 mt-2">
				<f:label path="nom">Nom</f:label>
				<f:input path="nom" class="form-control"/>
				<f:errors class="small text-danger" path="nom"/>
			</div>
		</div>
		<div class="form-group">
			<div class="offset-md-2 col-md-8 mt-2">
				<f:label path="email">Email</f:label>
				<f:input path="email" class="form-control"/>
				<f:errors class="small text-danger" path="email"/>
			</div>
		</div>
		<div class="form-group">
			<div class="offset-md-2 col-md-8 mt-2">
				<f:label path="password">Mot de passe</f:label>
				<f:input path="password" class="form-control"/>
				<f:errors class="small text-danger" path="password"/>
			</div>
		</div>
		
		<div class="offset-md-2 col-md-8 mt-2">
			<button type="submit" class="btn btn-success btn-lg btn-block" style="margin-top: 20px" >Ajouter</button>
		</div>
	</f:form>
</body>
</html>