<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualização do Produto</title>
</head>
<body>
	<h2>Struts 2 Create, Read, Update and Delete (CRUD) Example using
		JDBC</h2>
	<br />
	<br />
	<form action="updateProductAction" method="post">
		<pre>
		
		<input type="hidden" name="idproduct"
				value='<s:property value="idproduct"/>'>
				
<b>Nome do Produto: </b><input type="text" name="nmproduct"
				value='<s:property value="nmproduct"/>'>
		
<b>Valor do Produto R$: </b><input type="number" name="vlpriceproduct"
				value='<s:property value="vlpriceproduct"/>'>
		
<b>Marca do Produto: </b><input type="text" name="nmbrandproduct"
				value='<s:property value="nmbrandproduct"/>'>
		
		
<b>Quantidade do Produto: </b><input type="number" name="qtdproduct"
				value='<s:property value="qtdproduct"/>'>
		
		<button type="submit" name="submitType">Atualizar Produto</button>
		</pre>
	</form>

	<s:if test="isUpdate > 0">
		<s:actionmessage cssStyle="color: green;" />
	</s:if>

	<s:else>
		<s:actionmessage cssStyle="color: red;" />
	</s:else>
</body>
</html>