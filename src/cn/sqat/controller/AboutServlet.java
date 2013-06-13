package cn.sqat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sqat.model.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			System.out.println("In the About Servlet");
			
			HttpSession session = request.getSession();
			LoginBean user = (LoginBean) session.getAttribute("loginbean");
			String redirect = "/WEB-INF/about.jsp";
			if(user == null){
				// TODO: köra den första redirect? byter inte adress i adressfältet?
				// TODO: göra såhär på alla sidor... egentligen flytta till någon Authentication class?
				redirect = "index.jsp";
			}
			else if(user.isGunner()){
				// TODO: göra likadant med .active för navbaren
				request.setAttribute("navbar", "nav_gunner.jsp");
			}else{
				request.setAttribute("navbar", "nav_sales.jsp");
			}
			request.getRequestDispatcher(redirect).forward(request, response);
			
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