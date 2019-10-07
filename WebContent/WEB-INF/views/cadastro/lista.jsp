<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema Cadastro</title>
</head>
<body>
<c:import url="/WEB-INF/views/principal/menu.jsp"/>
	<br />
	<a href="novoCadastro">Cadastrar novo dependente</a>
	<br />
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Data Hora</th>
			<th>Nome</th>
			<th>Sexo</th>
			<th>Descrição</th>
			<th>Usuario</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${cadastro}" var="cadastro">
			<tr>
				<td>${cadastro.id}</td>
				<td><fmt:formatDate value="${cadastro.data_hora.time}" pattern="dd/MM/yyyy HH:MM" /></td>
				<td>${cadastro.nome}</td>
				<td>${cadastro.sexo}</td>				
				<td>${cadastro.descricao}</td>
				<td>${cadastro.idCadastroUsuario}</td>
				<td><a href="editaCadastro?id=${cadastro.id}" title="Editar">Editar</a></td>
				<td><a href="removeCadastro?id=${cadastro.id}" title="Excluir">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>