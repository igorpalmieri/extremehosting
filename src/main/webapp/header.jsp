<%-- 
    Document   : header
    Created on : Apr 6, 2017, 10:09:49 PM
    Author     : Igor-Surface
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

<div class="header">
    <ul>
        <li><b><a href="${pageContext.request.contextPath}/main">Extreme Hosting</a></b></li>
        <li><a href="${pageContext.request.contextPath}/search">Busca de Hospedagem</a></li>
        <li><a href="${pageContext.request.contextPath}/sport/search.jsp">Busca de Prática de Esporte</a></li>
        <% if(session.getAttribute("user") != null) {%>
        <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
        <%}%>
    </ul>
</div>



