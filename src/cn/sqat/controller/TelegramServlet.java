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
	private StringBuilder sb;
	private static final String ERROR_LOCKS = "Sold locks should be a number between 1 and 70. \n ";
	private static final String ERROR_STOCKS = "Sold stocks should be a number between 1 and 80. \n";
	private static final String ERROR_BARRELS = "Sold barrels should be a number between 1 and 90. \n";
	
	private void checkInput(String str, int lower, int upper) {
			int value = Integer.parseInt(str);
			if(value < lower || value > upper){
				throw new NumberFormatException();
			}
	}
	
	private String validate(HttpServletRequest request){
		sb = new StringBuilder();
		
		String locks = request.getParameter("locks");
		String stocks = request.getParameter("stocks");
		String barrels = request.getParameter("barrels");
		String saledate = request.getParameter("saledate");
		
		try{
			System.out.println("Locks value: " +locks);
		checkInput(locks,1,70);
		} catch(NumberFormatException e){
			sb.append(ERROR_LOCKS);
		}
		
		try{
		checkInput(stocks,1,80);
		} catch(NumberFormatException e){
			sb.append(ERROR_STOCKS);
		}
		
		try{
		checkInput(barrels,1,90);
		} catch(NumberFormatException e){
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
				request.setAttribute("telegrambean", tele);
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