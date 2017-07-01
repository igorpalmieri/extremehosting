/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.HouseDAO;
import Model.User;
import Model.House;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Igor
 */
@WebServlet(name = "ListHouses", urlPatterns = {"/listhouses"})
public class ListHouses extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession(); 
        User user = (User)session.getAttribute("user");
        List<House> houses = HouseDAO.getHousesByUser(user);
        request.setAttribute("listhouses", houses);
        request.getRequestDispatcher("/host/listhouses.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session=request.getSession(); 
        House house;
        if(id == null){
            house = new House();
            house.setOwner((User)session.getAttribute("user"));
        }
        else{
            house = HouseDAO.getHouse(Long.parseLong(id));
        }
        house.setRegion(request.getParameter("region"));
        house.setCity(request.getParameter("city"));
        house.setCountry(request.getParameter("country"));
        house.setAddress(request.getParameter("address"));
        house.setCapacity(Integer.parseInt(request.getParameter("capacity")));
        HouseDAO.save(house);
        response.sendRedirect("listhouses");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
