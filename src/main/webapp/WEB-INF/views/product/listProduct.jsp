<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Produtos</title>

<style>
table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 60%;
}

th {
	height: 30px;
}

.button-update {
	background-color: #008CBA;
	color: white;
}

.button-delete {
	background-color: red;
	color: white;
}
</style>
</head>
<body>
	<h2>Struts 2 Create, Read, Update and Delete (CRUD) Example using
		JDBC</h2>
	<div style="margin-top: 40px;">
		<s:if test="noData == true">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>Nome do Produto</th>
						<th>Preço do Produto R$</th>
						<th>Marca do Produto</th>
						<th>Quantidade do Produto</th>
						<th>Ações</th>
					</tr>
				</thead>

				<s:iterator value="listProduct">
					<tr>
						<td><s:property value="nmproduct" /></td>
						<td><s:property value="vlpriceproduct" /></td>
						<td><s:property value="nmbrandproduct" /></td>
						<td><s:property value="qtdproduct" /></td>
						<td><a
							href="updateProductAction.action?submitType=updatedata&idproduct=<s:property value="idproduct"/>">
								<button class="button-update">Atualizar Produto</button>
						</a> <a
							href="deleteProductAction.action?idproduct=<s:property value="idproduct"/>">
								<button class="button-delete">Remover Produto</button>
						</a></td>
					</tr>
				</s:iterator>
			</table>
		</s:if>

		<s:else>
			<div style="color: red;">Nenhum dado encontrado.</div>
		</s:else>
	</div>
</body>
</html>