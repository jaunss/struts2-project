<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Autenticação</title>
</head>
<body>
	<h2>Autenticação</h2>

	<s:actionerror />

	<s:form action="authenticationAction" namespace="/registration"
		method="post">
		<s:textfield name="usernameLogin" key="label.username" />
		<s:password name="passwordLogin" key="label.password" />

		<s:submit key="label.authenticate" />
	</s:form>
</body>
</html>