<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserção do Produto</title>
<style type="text/css">
.button-register {
	background-color: green;
	color: white;
}

.button-report {
	background-color: #000000;
	color: white;
	margin-left: 30%;
}
</style>
</head>
<body>
	<h2>Struts 2 Create, Read, Update and Delete (CRUD) Example using
		JDBC</h2>
	<br />
	<br />
	<s:form action="insertProductAction" namespace="/registration"
		method="post">
		<s:textfield name="nmproduct" key="label.name.product" />
		<s:textfield name="vlpriceproduct" key="label.price.product" />
		<s:textfield name="nmbrandproduct" key="label.brand.product" />
		<s:textfield name="qtdproduct" key="label.quantity.product" />

		<s:submit cssClass="button-register" key="label.register.product" />
	</s:form>

	<a href="listProductAction"><button class="button-report"
			type="button">Listar Produtos</button></a>

	<s:if test="isInsert > 0">
		<s:actionmessage cssStyle="color: green;" />
	</s:if>

	<s:else>
		<s:actionmessage cssStyle="color: red;" />
	</s:else>
</body>
</html>