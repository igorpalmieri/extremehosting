<%-- 
    Document   : approval
    Created on : Jul 1, 2017, 4:23:22 PM
    Author     : igan
--%>

<%@page import="Model.Stay"%>
<%@page import="Model.User"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Stay> stays = (List<Stay>)request.getAttribute("stays");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <title>Extreme Hosting</title>
    </head>
    <body>
        <jsp:include page="/header.jsp" />
        <% if(stays == null || stays.isEmpty()) { %>
                    <h2 style="color:red;text-align:center">Não há solicitação</h2> 
        <% } else {  %>
        <table>
                <tr>
                    <th>Dono</th>
                    <th>Data de Início</th>
                    <th>Data de Fim</th>
                    <th>Quantidade</th>
                    <th>Status</th>
                    <th>Casa</th>
                    <th>Cidade</th>
                    <th>Ações</th>
                </tr>

                <% for(Stay stay : stays) { %>
                    <tr>
                        
                        <td><a href="${pageContext.request.contextPath}/main?id=<%=stay.getHouse().getOwner().getId()%>"><%=stay.getHouse().getOwner().getName()%></a></td>
                        <td><%=stay.getStartdate()%></td>
                        <td><%=stay.getEnddate()%></td>
                        <td><%=(stay.getExtraGuests() + 1)%></td>
                        <td><%=stay.getStatus().toString()%></td>
                        <td><%=stay.getHouse().getAddress()%></td>
                        <td><%=stay.getHouse().getCity()%></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/request" method="POST">
                                <input type="hidden" name="StayId" value="<%=stay.getId()%>" />
                                <input type="submit" name="Action" value="Cancelar"></input>
                            </form>
                        </td>
                    </tr>
                <%}}%>
            </table>
    </body>
</html>
