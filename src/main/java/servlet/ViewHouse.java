/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.HouseDAO;
import DAO.StayDAO;
import Model.StatusStay;
import Model.House;
import Model.Stay;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author igan
 */
@WebServlet(name = "ViewHouse", urlPatterns = {"/viewhouse"})
public class ViewHouse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        if(id == null){
            response.sendRedirect("search");
        }
        else{
            request.getSession().setAttribute("current-house", HouseDAO.getHouse(Long.parseLong(id)));
            request.getRequestDispatcher("/host/house.jsp").forward(request, response);
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        House h = (House) request.getSession().getAttribute("current-house");
        Stay s = (Stay) request.getSession().getAttribute("new-stay");
        User u = (User) request.getSession().getAttribute("user");
        s.setHouse(h);
        h.getStays().add(s);
        s.setGuest(u);
        u.getStays().add(s);
        s.setStatus(StatusStay.PENDENTE);
        StayDAO.save(s);
        PrintWriter out = response.getWriter();
        out.print("Solicitacao Enviada com Sucesso!");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
