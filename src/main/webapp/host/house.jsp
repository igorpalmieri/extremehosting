<%-- 
    Document   : house
    Created on : Jun 28, 2017, 9:00:07 PM
    Author     : igan
--%>

<%@page import="Model.User"%>
<%@page import="Model.House"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%   
    House house = (House) request.getAttribute("house");
    User owner = house.getOwner();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Extreme Hosting</title>
    </head>
    <body>
        <jsp:include page="/header.jsp" />
        <p><%=house.getAddress()%></p>
        <p><%=house.getRegion()%></p>
        <p><%=house.getCity()%></p>
        <p><%=house.getCountry()%></p>
        <p><%=house.getVacancy()%></p>
        <p><%=owner.getName()%></p>
        <form action="house" method="post">
            <input type="hidden" name="houseid" value="<%=house.getId()%>" />
            <input type="submit" value="Solicitar Hospedagem" />
        </form>
    </body>
</html>
