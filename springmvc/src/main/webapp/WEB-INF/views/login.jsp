<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" context="/springmvc"/>">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/login" context="/springmvc" var="urllogin" />

	<f:form method="post" action="${urllogin}" modelAttribute="formlogin">

		<div class="form-group">
			<div class="offset-md-2 col-md-8 mt-2">
				<f:label path="email">Email</f:label>
				<f:input path="email" class="form-control" />
				<f:errors class="small text-danger ml-2" path="email" />
			</div>
		</div>
		<div class="form-group">
			<div class="offset-md-2 col-md-8 mt-2">
				<f:label path="password">Mot de passe</f:label>
				<f:input path="password" class="form-control" />
				<f:errors class="small text-danger ml-2" path="password" />
			</div>
		</div>

		<div class="offset-md-2 col-md-8 mt-2">
			<button type="submit" class="btn btn-success btn-lg btn-block"
				style="margin-top: 20px">Connexion</button>
		</div>
	</f:form>
</body>
</html>