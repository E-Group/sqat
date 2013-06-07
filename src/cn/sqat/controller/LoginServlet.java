package cn.sqat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sqat.model.LoginBean;
import cn.sqat.model.LoginDao;
 
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            System.out.println("In the Login Servlet");
            LoginBean user = new LoginBean();
            user.setUserName(request.getParameter("email"));
            user.setPassword(request.getParameter("pass"));
            user = LoginDao.login(user);
            if(user.isValid())
            {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user.getUsername());
//                System.out.println((String)session.getAttribute("user"));
                session.setAttribute("id", user.getId());
                response.sendRedirect("sucess.jsp");
            }else
                response.sendRedirect("error.jsp");
        } catch (Throwable exc)
        {
            System.out.println(exc);
        }
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
 
}