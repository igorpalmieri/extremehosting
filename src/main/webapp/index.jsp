<%-- 
    Document   : index
    Created on : May 1, 2017, 11:49:07 AM
    Author     : Igor-Surface
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
if(session.getAttribute("authenticated")!=null && session.getAttribute("authenticated").equals(true))
{
   response.sendRedirect("main");
}
%>
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
                <table>
                    <form action="login" method="post">
                    <tr>
                        <td>USERNAME</td>
                        <td><input type="text" name="username"/></td>
                    </tr>
                    <tr>
                        <td>PASSWORD</td>
                        <td><input type="password" name="password"/></td>
                    </tr>         
                    <tr>
                        <td colspan="2"><input type="submit" value="LOGIN" /></td>
                    </tr> 
                    </form>

                    <tr>
                        <td colspan="2"><button type="button">REGISTER</button></td>
                    </tr>  
                </table>
            </div>
    </body>
</html>
