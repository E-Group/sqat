package cn.sqat.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sqat.model.TelegramBean;
import cn.sqat.model.TelegramDao;

public class TelegramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			System.out.println("In the Telegram Servlet");
			HttpSession userSession = request.getSession();
			TelegramBean tele = new TelegramBean();
			tele.setTown(request.getParameter("town"));
			tele.setLocks(request.getParameter("locks"));
			tele.setStocks(request.getParameter("stocks"));
			tele.setBarrels(request.getParameter("barrels"));
			tele.setId((String)userSession.getAttribute("id"));
			tele.setDate(request.getParameter("saledate"));
			System.out.println("Date: "+tele.getDate());
		
			tele = TelegramDao.submit(tele);
	
			response.sendRedirect("telegram.jsp");
			
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