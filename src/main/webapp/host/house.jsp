<%-- 
    Document   : house
    Created on : Jun 28, 2017, 9:00:07 PM
    Author     : igan
--%>

<%@page import="Model.User"%>
<%@page import="Model.House"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%   
    House house = (House) session.getAttribute("current-house");
    User owner = house.getOwner();
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
        <div class="viewhouse">
            <p><%=house.getAddress()%></p>
            <p><%=house.getRegion()%></p>
            <p><%=house.getCity()%></p>
            <p><%=house.getCountry()%></p>
            <p><%=house.getCapacity()%></p>
            <p><%=owner.getName()%></p>
            <form action="${pageContext.request.contextPath}/viewhouse" method="post">
                <input type="button" id="request" value="Solicitar Hospedagem" />
            </form>
                <p id="message"></p>
        </div>
                <script type="text/javascript">
                    $('#request').click(function(){
                        console.log('funcao submit');
                        $.ajax({
                            type: 'POST',
                            url: '${pageContext.request.contextPath}/viewhouse',
                            success: function(data){
                                var msg = document.getElementById('message');
                                msg.style.color = "green";
                                document.getElementById('message').innerHTML = 'Solicitação submetida com sucesso!';
                            },
                            error: function(data){
                                var msg = document.getElementById('message');
                                msg.style.color = "red";
                                document.getElementById('message').innerHTML = 'Erro ao processar a solicitação';
                            }
                        });
                    });
                </script>
    </body>
</html>
