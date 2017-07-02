/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.RateDAO;
import DAO.StayDAO;
import DAO.UserDAO;
import java.io.IOException;
import Model.Rate;
import Model.TypeRate;
import Model.User;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.pkcs11.wrapper.Functions;

/**
 *
 * @author Igor
 */
@WebServlet(name = "RateUser", urlPatterns = {"/rateuser"})
public class RateUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Rate r = new Rate();
        HttpSession session = request.getSession();
        r.setDescription(request.getParameter("description"));
        r.setValue(Integer.parseInt(request.getParameter("value")));
        r.setType(TypeRate.valueOf(request.getParameter("TypeRate")));
        if(r.getType() != TypeRate.PERSONAL)
            r.setStay(StayDAO.getStayById(Long.parseLong(request.getParameter("stay"))));
        User receiver = UserDAO.getUser(Long.parseLong(request.getParameter("receiver")));
        r.setReceiver(receiver);
        r.setSender((User)session.getAttribute("user"));
        RateDAO.save(r);
        response.sendRedirect(request.getHeader("referer"));
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
