<%-- 
    Document   : header
    Created on : Apr 6, 2017, 10:09:49 PM
    Author     : Igor-Surface
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="css/style.css">

<div class="header">
    <ul>
        <li><a href="">Extreme Hosting</a></li>
        <li><a href="${pageContext.request.contextPath}/">Home</a></li>
        <li><a href="#news">News</a></li>
        <li><a href="#contact">Contact</a></li>
        <li><a href="#about">About</a></li>
        <% if(session.getAttribute("authenticated")!=null && session.getAttribute("authenticated").equals(true)) {%>
        <li><a href="logout">Logout</a></li>
        <%}%>
    </ul>
</div>



