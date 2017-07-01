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
                    <th>Estado</th>
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
                                <input type="button" onclick="approve(<%=stay.getId()%>,true)" value="Aprovar"></input>
                                <input type="button" onclick="approve(<%=stay.getId()%>,false)" value="Reprovar"></input>
                        </td>
                        </form>
                    </tr>
                <%}%>
            </table>
            
            <script type="text/javascript">
                function approve(id,bool){
                  console.log(id);
                  console.log(bool);
                  $.ajax({
                            type: 'POST',
                            url: '${pageContext.request.contextPath}/approve',
                            data: {StayId : id, Action : bool},
                            success: function(data){
                                var msg = document.getElementById('message');
                                msg.style.color = "green";
                                document.getElementById('message').innerHTML = 'Ação submetida com sucesso!';
                            },
                            error: function(data){
                                var msg = document.getElementById('message');
                                msg.style.color = "red";
                                document.getElementById('message').innerHTML = 'Erro ao processar a ação';
                            }
                  });
                };
                  
                </script>
    </body>
</html>
