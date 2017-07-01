/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.StayDAO;
import Model.Stay;
import Model.User;
import java.io.IOException;
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
@WebServlet(name = "Request", urlPatterns = {"/request"})
public class Request extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setAttribute("stays", StayDAO.getStaysByGuest((User)request.getSession().getAttribute("user")));
        RequestDispatcher rd = request.getRequestDispatcher("host/request.jsp");
        rd.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Stay stay = (Stay) StayDAO.getStayById(Long.parseLong(request.getParameter("StayId")));     
        StayDAO.cancelRequest(stay);
        doGet(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
