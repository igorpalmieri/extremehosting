<%-- 
    Document   : register
    Created on : Jun 28, 2017, 8:21:32 PM
    Author     : igan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            
            <form action="${pageContext.request.contextPath}/register" method="post">
                <h2>Criar usuário</h2>
                <input name="username" type="text" placeholder="Username" required/>
                <input name="password" type="password" placeholder="Password" required/>
                <input name="name" type="text" placeholder="Nome" required/>
                <input name="city" type="text" placeholder="Cidade" required/>
                <input name="country" type="text" placeholder="Pais" required/>
                <input type="submit" value="Criar"/>
            </form>
        </div>
    </body>
</html>
