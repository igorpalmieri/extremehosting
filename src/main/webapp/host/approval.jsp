<%-- 
    Document   : approval
    Created on : Jul 1, 2017, 4:23:22 PM
    Author     : igan
--%>

<%@page import="Model.User"%>
<%@page import="DAO.RateDAO"%>
<%@page import="Model.TypeRate"%>
<%@page import="Model.StatusStay"%>
<%@page import="Model.Stay"%>
<%@page import="DAO.StayDAO"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Stay> stays = (List<Stay>)request.getAttribute("stays");
    User user = (User)session.getAttribute("user");
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
        <div class="request">
        <h1 style="text-align:center">Aprovação de Solicitações Pendentes</h1>
        <% if(stays == null || stays.isEmpty()) { %>
                    <h2 style="color:red;text-align:center">Não há solicitação pendente de aprovação</h2> 
        <% } else {  %>    
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
                        <td><%=stay.getStartdateString()%></td>
                        <td><%=stay.getEnddateString()%></td>
                        <td><%=(stay.getExtraGuests() + 1)%></td>
                        <td><%=stay.getStatus().toString()%></td>
                        <td><%=stay.getHouse().getAddress()%></td>
                        <td><%=stay.getHouse().getCity()%></td>
                        <td>
                            <%if (stay.getStatus() == StatusStay.PENDENTE){ %>
                            <form action="${pageContext.request.contextPath}/approve" method="POST">
                                <input type="hidden" name="StayId" value="<%=stay.getId()%>" />
                                <input type="submit" name="Action" value="Aprovar"></input>
                                <input type="submit" name="Action" value="Reprovar"></input>
                            </form>
                                <% } if (stay.getStatus() == StatusStay.APROVADO){ if(!stay.isEvaluated(user)){ %>
                            <form action="${pageContext.request.contextPath}/rateuser" method="POST">
                                <input name="receiver" type="hidden" value="<%= stay.getGuest().getId() %>"/>
                                <input type="hidden" name="stay" value="<%=stay.getId()%>" />
                                <input type="hidden" name="TypeRate" value="HOST" />
                                 <select name="value">
                                    <option value="1">1</option>
                                    <option selected value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                                 <input name="description" type="text"/>
                                <input type="submit" name="Action" value="Avaliar"></input>
                            </form>
                            <%} else {%>AVALIADO<%} }%>
                        </td>
                    </tr>
                <%}}%>
            </table>
            </div>
    </body>
</html>
