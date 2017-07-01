<%-- 
    Document   : approval
    Created on : Jul 1, 2017, 4:23:22 PM
    Author     : igan
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Extreme Hosting</title>
    </head>
    <body>
        <table>
                <tr>
                    <th>Solicitante</th>
                    <th>Data de Início</th>
                    <th>Data de Fim</th>
                    <th>Quantidade</th>
                    <th>Estado</th>
                    <th>Dono</th>
                    <th>Ações</th>
                </tr>
                <% for(Stay stay : availableHouses) { %>
                    <tr>
                        <td><%=house.getCountry()%></td>
                        <td><%=house.getCity()%></td>
                        <td><%=house.getRegion()%></td>
                        <td><%=house.getAddress()%></td>
                        <td><%=house.getVacancy(novo.getStartdate(),novo.getEnddate())%> | <%=house.getCapacity()%></td>
                        <td><a href="${pageContext.request.contextPath}/main?id=<%=house.getOwner().getId()%>"><%=house.getOwner().getName()%></a></td>
                        <td><input type="button" onclick="location.href = '${pageContext.request.contextPath}/viewhouse?id=<%=house.getId()%>'"value="Detalhes" /></td>
                    </tr>
                <%}%>
            </table>
    </body>
</html>
