<%-- 
    Document   : Error
    Created on : May 1, 2017, 3:32:36 PM
    Author     : Igor-Surface
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jssor.slider-23.1.3.min.js" type="text/javascript"></script>
        <script src="js/imageslider.js" type="text/javascript"></script>
    <title>Extreme Hosting</title>
    </head>
    <body>
        <jsp:include page='header.jsp' />

            
            <div class="form">
                <img src="img/logo.png" />
                
                <h1>Error</h1>
                <p><%=request.getAttribute("error")%></p>
            </div>
    </body>
</html>