<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkServletFormNovaEmpresa" />



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Empresas</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"></c:import>
	
	Usuário logado: ${usuarioLogado.login }
	<br>
	<br>

    <h3>Lista de empresas: <br /> </h3>
    
    <ul>
    	<c:forEach items="${empresas}" var="empresa">
   	        <li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
	   	       	<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id }"> Editar </a>  
	          	<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id }"> Remover </a>  
   	        </li>
    	</c:forEach>

    </ul>
    
    <form action="${linkServletFormNovaEmpresa}" method="get">
	<br/>
	<input type="submit" value="Cadastrar nova empresa"/>
	<input type="hidden" name="acao" value="NovaEmpresaForm">
	</form>
    
</body>
</html>