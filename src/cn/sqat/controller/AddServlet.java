package cn.sqat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sqat.model.LoginBean;

public class AddServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			System.out.println("In the Add Servlet");
			
			HttpSession session = request.getSession();
			LoginBean user = (LoginBean) session.getAttribute("loginbean");
			String redirect = "/WEB-INF/add_sale.jsp";
			if(user == null){
				redirect = "index.jsp";
			}
			else if(user.isGunner()){
				redirect = "/sales";
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

