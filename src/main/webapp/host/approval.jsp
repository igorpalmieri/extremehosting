<%-- 
    Document   : approval
    Created on : Jul 1, 2017, 4:23:22 PM
    Author     : igan
--%>

<%@page import="Model.Stay"%>
<%@page import="DAO.StayDAO"%>
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
        <p id="message"></p>
        <table>
                <tr>
                    <th>Solicitante</th>
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
                        
                        <td><a href="${pageContext.request.contextPath}/main?id=<%=stay.getGuest().getId()%>"><%=stay.getGuest().getName()%></a></td>
                        <td><%=stay.getStartdate()%></td>
                        <td><%=stay.getEnddate()%></td>
                        <td><%=(stay.getExtraGuests() + 1)%></td>
                        <td><%=stay.getStatus().toString()%></td>
                        <td><%=stay.getHouse().getAddress()%></td>
                        <td><%=stay.getHouse().getCity()%></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/approve" method="POST">
                                <input type="hidden" name="StayId" value="<%=stay.getId()%>" />
                                <input type="submit" name="Action" value="Aprovar"></input>
                                <input type="submit" name="Action" value="Reprovar"></input>
                            </form>
                        </td>
                    </tr>
                <%}%>
            </table>
    </body>
</html>
