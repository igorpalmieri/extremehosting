/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Model.House;
import Model.Stay;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        
        if(country != null && city != null && qty != null && start != null && end != null &&
                !country.isEmpty() && !city.isEmpty() && !qty.isEmpty() && !start.isEmpty() && !end.isEmpty())  {           
            Stay novo = new Stay();
            novo.setStartdate(new Date(start));
            novo.setEnddate(new Date(end));
            request.setAttribute("new-stay", novo);
            request.setAttribute("houses",House.getAvailableHouses(country, city, Integer.parseInt(qty),novo.getStartdate(),novo.getEnddate()));
        }       
            
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
