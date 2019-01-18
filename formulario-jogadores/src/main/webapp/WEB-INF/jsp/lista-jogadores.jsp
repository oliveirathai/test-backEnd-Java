<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Jogadores</title>
</head>
<body>
		<table>
		<tr>
		<th>Lista Jogadores</th>
		<th></th>
		<th></th>
		<th></th>
		<th></th>
		</tr>
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Telefone</th>
				<th>Codinome</th>
				<th>Grupo</th>
			</tr>
		<c:forEach items="${jogadores}" var="j">
			<tr>
				<td><c:out value="${j.nome}" /></td>
				<td><c:out value="${j.email}" /></td>
				<td><c:out value="${j.telefone}" /></td>
				<td><c:out value="${j.codinome}" /></td>
				<td><c:out value="${j.time}" /></td>
			</tr>
	</c:forEach>
	</table>
	<p>
	<center>
	<form action="/" method="get">
		<input type="submit" value="Cadastrar novo Jogador" />
	</form>
	</center>
</body>
</html>