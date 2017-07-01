/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Model.House;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author igan
 */
@WebServlet(name = "Search", urlPatterns = {"/search"})
public class Search extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        RequestDispatcher rd = request.getRequestDispatcher("host/search.jsp");
        
        String country = (String)request.getParameter("country");
        String city = (String)request.getParameter("city");
        String qty = request.getParameter("qty");
        if(country != null && city != null && qty != null)         
            request.setAttribute("houses",House.getAvailableHouses(country, city, Integer.parseInt(qty)));  
        rd.include(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String country = request.getParameter("country");
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        if (country != null) {
            out.print("{\"cityList\":[\"--Cidade--\"");
            House.getCities(country).forEach(c -> out.print(",\""+c+"\""));
            out.print("]}");
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
