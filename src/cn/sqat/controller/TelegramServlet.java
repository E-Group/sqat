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

	private static final String ERROR_LOCKS = "Number of locks should be a number between 1 and 70. \n ";
	private static final String ERROR_STOCKS = "Number of stocks should be a number between 1 and 80. \n";
	private static final String ERROR_BARRELS = "Number of barrels should be a number between 1 and 90. \n";

	protected String validate(HttpServletRequest request){
		StringBuilder sb = new StringBuilder();
		HttpSession userSession = request.getSession();
		String town = request.getParameter("town");
		String locks = request.getParameter("locks");
		String stocks = request.getParameter("stocks");
		String barrels = request.getParameter("barrels");
		String saledate = request.getParameter("saledate");
		int nolock = 0;
		int nostocks = 0;
		int nobarrels = 0;

		try{
			nolock = Integer.parseInt(locks);
		}catch(NumberFormatException e){
			sb.append(ERROR_LOCKS);
		}
		try{
			nostocks = Integer.parseInt(stocks);
		}catch(NumberFormatException e){
			sb.append(ERROR_STOCKS);
		}
		try{
			nobarrels = Integer.parseInt(barrels);
		}catch(NumberFormatException e){
			sb.append(ERROR_BARRELS);
		}

		if(nolock < 1 || nolock >70){
			sb.append(ERROR_LOCKS);
		}
		else if(nostocks < 1 || nostocks > 80){
			sb.append(ERROR_STOCKS);
		}
		if(nobarrels < 1 || nobarrels > 90){
			sb.append(ERROR_BARRELS);
		}

		return sb.toString();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			System.out.println("In the Telegram Servlet");
			HttpSession userSession = request.getSession();
			String error = validate(request);
			if(error.isEmpty()){
				TelegramBean tele = new TelegramBean();
				tele.setId((String)userSession.getAttribute("id"));
				tele.setTown(request.getParameter("town"));
				tele.setLocks(request.getParameter("locks"));
				tele.setStocks(request.getParameter("stocks"));
				tele.setBarrels(request.getParameter("barrels"));
				tele.setDate(request.getParameter("saledate"));

				System.out.println("Date: "+tele.getDate());
				tele = TelegramDao.submit(tele);
				userSession.setAttribute("telegrambean", tele);
				request.getRequestDispatcher("/telegram.jsp").forward(request, response);
			}
			else {
				request.setAttribute("message", error);
				request.getRequestDispatcher("/sucess.jsp").forward(request, response);
			}

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