<%-- 
    Document   : listhouses
    Created on : Jul 1, 2017, 1:35:02 PM
    Author     : Igor
--%>
<%@page import="Model.User"%>
<%@page import="Model.House"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%   
    List<House> houses = (List<House>)request.getAttribute("listhouses");
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
        <h1>Lista de Casas</h1>
        <form id="edit" action="./listhouses" method="post" >
            <table>
                <tr>
                    <th>Pais</th>
                    <th>Cidade</th>
                    <th>Bairro</th>
                    <th>Endereço</th>
                    <th>Capacidade</th>
                    <th>Usuário</th>
                </tr>
                <tr>
                    
                    <td><input name="country" type="text" value="" required/></td>
                    <td><input name="city" type="text" value="" required/></td>
                    <td><input name="region" type="text" value="" required/></td>
                    <td><input name="address" type="text" value="" required/></td>
                    <td><input name="capacity" type="number" value="" required/></td>
                    <td><%= ((User)session.getAttribute("user")).getName() %></td>
                    <td><input type="submit" value="Salvar"/>  </td>
                </tr>
            </table>
        </form>
        <table>
            <tr>
                <th>Pais</th>
                <th>Cidade</th>
                <th>Bairro</th>
                <th>Endereço</th>
                <th>Capacidade</th>
                <th>Usuário</th>
                <th>Actions <%= houses.size() %></th>
            </tr>
            <%for (House h : houses){
               User user = h.getOwner();
            %>
            <tr>
                <td><%= h.getCountry() %></td>
                <td><%= h.getCity() %></td>
                <td><%= h.getRegion() %></td>
                <td><%= h.getAddress()%></td>
                <td><%= h.getCapacity()%></td>
                <td><%= user.getName() %></td>
                <td>
                    <form onsubmit="return edit(this)">
                        <input name="id" value="<%= h.getId() %>" type="hidden" />
                        <input type="submit" value="Editar" />
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
        <script type="text/javascript">
            function edit(evt) {
                var id = $(evt).find("input[name=id]").val();
                var form = $("form#edit");
                $(evt).parent().parent().find("td:lt(-1)").each(function(index) {
                    var value = $(this).html();
                    $($("form#edit").find("input[type=text],input[type=number]").get(index)).attr("value",value);
                });
                $($("form#edit").find("input[type=submit]")).attr("value","Editar");
                $("form#edit").find("input[type=submit]").parent().append('<input name="id" type="hidden" value="'+id+'">');
                $("form#edit").find("input[type=submit]").parent().append('<button type="button" onClick="window.location.reload();">Limpar</button>');
                
                return false;
            }
        </script>
    </body>
</html>
