<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema Cadastro</title>
</head>
<body>
	<c:import url="/WEB-INF/views/principal/menu.jsp"/>
	<br />
	Alterar dependente: ${cadastro.id}	
	<br />
	<br />
	
	<form action="alterarCadastro" method="post" class="form-horizontal">
	
	<label for="Id">Id</label>
	<input type="text" name="id" value="${cadastro.id}" disabled/><br/>
	
	<label for="DataHora">Data Hora</label>
	<input type="text" name="data_hora" value="<fmt:formatDate value="${cadastro.data_hora.time}" pattern="dd/MM/yyyy HH:MM:SS" />" disabled /><br/>
				
	<label for="Nome">Nome</label>  
	<input type="text" name="nome" value="${cadastro.nome}" > 
	<form:errors path="cadastro.nome" cssStyle="color:#B71C1C"/><br />

	<label for="Sexo">Sexo</label>  
	<input type="text" name="sexo" value="${cadastro.sexo}" >
	<form:errors path="cadastro.sexo" cssStyle="color:#B71C1C"/><br />

	<label for="Descricao">Descri��o</label>  	
	<input type="text" name="descricao" value="${cadastro.descricao}">
	<form:errors path="cadastro.descricao" cssStyle="color:#B71C1C"/><br />
	
	<label for="IdUsuario">Id Usuario</label>  
	<input type="text" name="idCadastroUsuario" value="${cadastro.idCadastroUsuario}" >
	<form:errors path="cadastro.idCadastroUsuario" cssStyle="color:#B71C1C"/><br />
	
	<input type="submit" value="Alterar">
	
	</form>
	
</body>
</html>