<%-- 
    Document   : profile
    Created on : Apr 6, 2017, 9:25:56 PM
    Author     : Igor-Surface
--%>

<%@page import="DAO.RateDAO"%>
<%@page import="Model.TypeRate"%>
<%@page import="Model.User"%>
<%@page import="Model.Rate"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    User user = (User) request.getAttribute("user-view"); 
 %>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="js/jssor.slider-23.1.3.min.js" type="text/javascript"></script>
    <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="js/imageslider.js" type="text/javascript"></script>
    <title>Profile - Extreme Hosting</title>
</head>
<body>
    <jsp:include page='header.jsp' />
    <div id="jssor_1">
        <!-- Loading Screen -->
        <div data-u="loading" class="loading">
            <div class="insideloading1"></div>
            <div class="insideloading2"></div>
        </div>
        <div data-u="slides" class="insidejssor">
              <% for(int i = 1; i < 6; i++) { %>
                <div>
                    <img data-u="image" src="img/photo<%=i%>.jpg" />
                    <img data-u="thumb" src="img/photo<%=i%>.jpg" />
                </div>
                <% } %>
        </div>

        <div class="profile">
            <img src="<%=user.getProfileURL()%>" />
            <h1><%=user.getName()%></h1>
            <h2><%=user.getCity()%></h2>

        </div>

        <!-- Arrow Navigator -->
        <span data-u="arrowleft" class="jssora05l" style="top:208px;left:8px;"></span>
        <span data-u="arrowright" class="jssora05r" style="top:208px;right:8px;width:40px;height:40px;"></span>
    </div>
    <script type="text/javascript">jssor_1_slider_init();</script>


    <div class="ratings">
        <ul>
            <li>
                <div class="rating">
                    <p>Personal</p>
                    <%float j=0,media=user.getRateAvg(TypeRate.PERSONAL,true); 
                    while((j++)<5){ 
                        if(j<=media){%>
                        <img src="img/star.png" height="30" width="30"/>
                    <%  }else { %> 
                        <img src="img/star_off.png" height="30" width="30"/> 
                    <%}}%>
                    <div class="comment">
                        <table>
                            
                            <% for(Rate r : user.getRateList(TypeRate.PERSONAL)) { %>
                            <% if(r.isDoubleRated()){%>
                                <tr>
                                    <th><a href="main?id=<%=r.getSender().getId()%>"><img src="<%=r.getSender().getProfileURL()%>" width="50" height="50" /><%=r.getSender().getName(14)%></a></th>
                                    <th><% for(int i=0;i<r.getValue();i++) {%><img src="img/star.png" height="15" width="15"/><%}%></th>
                                </tr>
                                <tr>
                                    <td colspan="2"><%=r.getDescription()%></td>
                                </tr>
                            <% } else {%>
                                <tr>
                                    <th><a href="main?id=<%=r.getSender().getId()%>"><img src="<%=r.getSender().getProfileURL()%>" width="50" height="50" /><%=r.getSender().getName(14)%></a></th>
                                </tr>
                                <tr>
                                    <td colspan="2"><b><i>Necessário avaliar de volta para visualizar</i></b></td>
                                </tr>    
                            <%}} %>
                        </table>
                    </div>
                </div>
            </li>
            <li>
                <div class="rating">
                    <p>Guest</p>
                    <%j=0; media=user.getRateAvg(TypeRate.GUEST,true); 
                    while((j++)<5){ 
                        if(j<=media){%>
                        <img src="img/star.png" height="30" width="30"/>
                    <%  }else { %> 
                        <img src="img/star_off.png" height="30" width="30"/> 
                    <%}}%>
                    <div class="comment">
                        <table>
                            <% for(Rate r : user.getRateList(TypeRate.GUEST)) { %>
                            <% if(r.isDoubleRated()){%>
                                <tr>
                                    <th><a href="main?id=<%=r.getSender().getId()%>"><img src="<%=r.getSender().getProfileURL()%>" width="50" height="50" /><%=r.getSender().getName(14)%></a></th>
                                    <th><% for(int i=0;i<r.getValue();i++) {%><img src="img/star.png" height="15" width="15"/><%}%></th>
                                </tr>
                                <tr>
                                    <td colspan="2"><%=r.getDescription()%></td>
                                </tr>
                            <% } else {%>
                                <tr>
                                    <th><a href="main?id=<%=r.getSender().getId()%>"><img src="<%=r.getSender().getProfileURL()%>" width="50" height="50" /><%=r.getSender().getName(14)%></a></th>
                                </tr>
                                <tr>
                                    <td colspan="2"><b><i>Necessário avaliar de volta para visualizar</i></b></td>
                                </tr>    
                            <%}} %>
                        </table>
                    </div>
                </div>
            </li>

           <li>
                <div class="rating">
                    <p>Host</p>
                    <% j=0; media=user.getRateAvg(TypeRate.HOST,true); 
                    while((j++)<5){ 
                        if(j<=media){%>
                        <img src="img/star.png" height="30" width="30"/>
                    <%  }else { %> 
                        <img src="img/star_off.png" height="30" width="30"/> 
                    <%}}%>
                    <div class="comment">
                        <table>
                            <% for(Rate r : user.getRateList(TypeRate.HOST)) { %>
                            <% if(r.isDoubleRated()){%>    
                            <tr>
                                    <th><a href="main?id=<%=r.getSender().getId()%>"><img src="<%=r.getSender().getProfileURL()%>" width="50" height="50" /><%=r.getSender().getName(14)%></a></th>
                                    <th><% for(int i=0;i<r.getValue();i++) {%><img src="img/star.png" height="15" width="15"/><%}%></th>
                                </tr>
                                <tr>
                                    <td colspan="2"><%=r.getDescription()%></td>
                                </tr>
                                <% } else {%>
                                <tr>
                                    <th><a href="main?id=<%=r.getSender().getId()%>"><img src="<%=r.getSender().getProfileURL()%>" width="50" height="50" /><%=r.getSender().getName(14)%></a></th>
                                </tr>
                                <tr>
                                    <td colspan="2"><b><i>Necessário avaliar de volta para visualizar</i></b></td>
                                </tr>    
                            <%}} %>
                        </table>
                    </div>
                </div>
            </li>
            <li>
                <div class="rating">
                    <p>Sport Host</p>
                    <% j=0; media=user.getRateAvg(TypeRate.SPORTHOST,true); 
                    while((j++)<5){ 
                        if(j<=media){%>
                        <img src="img/star.png" height="30" width="30"/>
                    <%  }else { %> 
                        <img src="img/star_off.png" height="30" width="30"/> 
                    <%}}%>
                    <div class="comment">
                        <table>
                            <% for(Rate r : user.getRateList(TypeRate.SPORTHOST)) { %>
                            <% if(r.isDoubleRated()){%>    
                            <tr>
                                    <th><a href="main?id=<%=r.getSender().getId()%>"><img src="<%=r.getSender().getProfileURL()%>" width="50" height="50" /><%=r.getSender().getName(14)%></a></th>
                                    <th><% for(int i=0;i<r.getValue();i++) {%><img src="img/star.png" height="15" width="15"/><%}%></th>
                                </tr>
                                <tr>
                                    <td colspan="2"><%=r.getDescription()%></td>
                                </tr>
                            <% } else {%>
                                <tr>
                                    <th><a href="main?id=<%=r.getSender().getId()%>"><img src="<%=r.getSender().getProfileURL()%>" width="50" height="50" /><%=r.getSender().getName(14)%></a></th>
                                </tr>
                                <tr>
                                    <td colspan="2"><b><i>Necessário avaliar de volta para visualizar</i></b></td>
                                </tr>    
                            <%}} %>
                        </table>
                    </div>
                </div>
            </li>
            <li>
                <div class="rating">
                    <p>Sport Guest</p>
                    <% j=0; media=user.getRateAvg(TypeRate.SPORTGUEST,true); 
                    while((j++)<5){ 
                        if(j<=media){%>
                        <img src="img/star.png" height="30" width="30"/>
                    <%  }else { %> 
                        <img src="img/star_off.png" height="30" width="30"/> 
                    <%}}%>
                    <div class="comment">
                        <table>
                            <% for(Rate r : user.getRateList(TypeRate.SPORTGUEST)) { %>
                            <% if(r.isDoubleRated()){%>    
                                <tr>
                                    <th><a href="main?id=<%=r.getSender().getId()%>"><img src="<%=r.getSender().getProfileURL()%>" width="50" height="50" /><%=r.getSender().getName(14)%></a></th>
                                    <th><% for(int i=0;i<r.getValue();i++) {%><img src="img/star.png" height="15" width="15"/><%}%></th>
                                </tr>
                                <tr>
                                    <td colspan="2"><%=r.getDescription()%></td>
                                </tr>
                            <% } else {%>
                                <tr>
                                    <th><a href="main?id=<%=r.getSender().getId()%>"><img src="<%=r.getSender().getProfileURL()%>" width="50" height="50" /><%=r.getSender().getName(14)%></a></th>
                                </tr>
                                <tr>
                                    <td colspan="2"><b><i>Necessário avaliar de volta para visualizar</i></b></td>
                                </tr>    
                            <%}} %>
                        </table>
                    </div>
                </div>
            </li>
        </ul>
    </div>
    <% 
    User activeUser = (User) session.getAttribute("user");
    List<Rate> rates = RateDAO.getPersonalRatesByUser(activeUser.getId(), user.getId());
    if(activeUser.getId() != user.getId() && rates.isEmpty()){
    %>                   
    <span class="button-popup">
        <a href="#" id="button-popup">Avaliar</a>
    </span>
    <% 
    }
    %>    
    <div class="window-popup">
        <div class="wp-content">
            <h2>Avaliando <%= user.getName() %></h2>
            <form action="rateuser" method="post">
                <label for="value">Nota: </label>
                <select name="value">
                    <option value="1">1</option>
                    <option selected value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
                <label for="description">Descrição:</label>
                <input name="description" type="text"/>
                <input name="receiver" type="hidden" value="<%= user.getId() %>"/>
                <input name="TypeRate" type="hidden" value="PERSONAL"/>
                <input type="submit" value="Avaliar" />
            </form>
            <a href="#" id="button-close-popup">Close</a>
        </div>
    </div>
    <script type="text/javascript">
       
        
        $(document).ready(function(){
            
        
        
            $("#button-popup").click(function(){
                $(".window-popup").fadeIn(300);
            });
            
            $("#button-close-popup").click(function(){
                $(".window-popup").fadeOut(300);
            });
        });
    </script>
</body>
</html>
