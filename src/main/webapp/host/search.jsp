<%-- 
    Document   : search
    Created on : Jun 28, 2017, 8:20:39 PM
    Author     : igan
--%>

<%@page import="Model.House"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%   
    List<House> availableHouses = (List<House>)request.getAttribute("houses");
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
        <div class="search">
        <form  action="${pageContext.request.contextPath}/search" method="get">
            <h2>Busca de Hospedagem</h2>
            <select id="countries" name="country">
                <option value="">--País--</option>
                <% for(String country : House.getCountries()) { %>
                <option value="<%=country%>"><%=country%></option>
                <% } %>
            </select>
            <select id="cities" name="city">
                <option value="--Cidade--">--Cidade--</option>
            </select>
            <input type="text" name="start" placeholder="Data de Início"/>
            <input type="text" name="end" placeholder="Data de Fim"/>
            <select name="qty">
                <option value="0">--Quantidade de Pessoas--</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            
            <input type="submit" value="BUSCAR" />
        </form>
        
        <% if(availableHouses != null){ %>
            <% if(availableHouses.isEmpty()){ %>
            <h2 style="color:red;text-align:center">Não há casa disponível</h2>
            <%}
            else{%>
            <table>
                <tr>
                    <th>País</th>
                    <th>Cidade</th>
                    <th>Bairro</th>
                    <th>Endereço</th>
                    <th>Vagas</th>
                    <th>Dono</th>
                    <th>Ações</th>
                </tr>
                <% for(House house : availableHouses) { %>
                    <tr>
                        <td><%=house.getCountry()%></td>
                        <td><%=house.getCity()%></td>
                        <td><%=house.getRegion()%></td>
                        <td><%=house.getAddress()%></td>
                        <td><%=house.getVacancy()%></td>
                        <td><a href="${pageContext.request.contextPath}/main?id=<%=house.getOwner().getId()%>"><%=house.getOwner().getName()%></a></td>
                        <td><input type="button" onclick="location.href = '${pageContext.request.contextPath}/house?id=<%=house.getId()%>'"value="Ver Detalhes" /></td>
                    </tr>
                <%}%>
            </table>
            <%}%>
        <%}%>
        </div>
            <script type="text/javascript">
                
            $('#countries').change(function () {
                var selectedValue = $(this).prop('value');
                console.log(selectedValue);
                if (selectedValue === '') {
                    $('#cities').empty();
                    $('#cities').append($('<option/>', {
                                value : '--Cidade--',
                                text : '--Cidade--'
                            }));
                } else {
                    $.post('${pageContext.request.contextPath}/search',{country : selectedValue}, function(data) {
                        var cityList = data.cityList;
                        $('#cities').empty();
                        $.each(cityList, function(key, value) {
                            $('#cities').append($('<option/>', {
                                value : value,
                                text : value
                            }));
                        });
                    }, 'json');
                }
            });
            </script>
    </body>
</html>
