<%--
  Created by IntelliJ IDEA.
  User: joaoqueiroga
  Date: 25/01/2021
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=ISO-8859-1"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<c:set var="cep" value="${pageContext.request.getAttribute(\"cep\")}"/>
<c:import url="http://viacep.com.br/ws/${cep}/xml" var="dadosxml"/>
<x:parse doc="${dadosxml}" var="dados"/>
<html>
<head>
    <title>Logradouro</title>
</head>
<body>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXTi0I1nH3dDpogYgTlA0Ato0iBfScL894t2yfIvDwL7cJ3fi3" alt="Correios"><br>
<h2>Mostra Logradouro</h2>
<x:choose>
    <x:when select="$dados/xmlcep/cep = null"></x:when>
    <x:otherwise>
        <span>CEP pesquisado: <x:out select="$dados/xmlcep/cep"/></span><br>
        <span>Logradouro: <x:out select="$dados/xmlcep/logradouro"/></span><br>
        <span>Complemento: <x:out select="$dados/xmlcep/complemento"/></span><br>
        <span>Bairro: <x:out select="$dados/xmlcep/bairro"/></span><br>
        <span>Cidade: <x:out select="$dados/xmlcep/localidade"/></span><br>
        <span>Estado: <x:out select="$dados/xmlcep/uf"/></span>
    </x:otherwise>
</x:choose>
</body>
</html>
