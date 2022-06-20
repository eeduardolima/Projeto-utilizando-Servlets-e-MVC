<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/formNovaEmpresa.jsp" var="linkServletFormNovaEmpresa" />
<c:url value="/entrada?acao=ListaEmpresas" var="linkServletListaEmpresas" />

<html>
	<body>
	
	<c:import url="logout-parcial.jsp"></c:import>
	

	Empresa ${empresa} cadastrada com sucesso!

	<form action="${linkServletFormNovaEmpresa}" method="get">
	<br/>
	<input type="submit" value="Cadastrar nova empresa"/>
	</form>

	<form action="${linkServletListaEmpresas}" method="get">
	<input type="submit" value="Empresas Cadastradas"/>
	</form>
	</body>
</html>