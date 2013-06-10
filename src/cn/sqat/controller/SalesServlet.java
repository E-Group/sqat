package cn.sqat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sqat.model.LoginBean;
import cn.sqat.model.QueryDao;
import cn.sqat.model.SaleBean;

public class SalesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
//			System.out.println("In the Sales Servlet");
			HttpSession session = request.getSession();

			LoginBean user = (LoginBean) session.getAttribute("loginbean");
			
			if(user.isGunner()){
				String salesperson = request.getParameter("salespersons");
				String date = request.getParameter("date");
				
				List<SaleBean> list = QueryDao.querySales("SELECT * FROM sale,town,item WHERE " +
						"salesperson='"+salesperson+"' AND " +
						"town.id=sale.town AND item.id=sale.item AND date LIKE '"+date+"%' ORDER BY date DESC;");			
				request.setAttribute("list", list);
				request.setAttribute("selectedsales", salesperson);
				request.setAttribute("selecteddate", date);
				request.getRequestDispatcher("/gunner.jsp").forward(request, response);
			}
			
			else {
				List<SaleBean> list = QueryDao.querySales("SELECT * FROM sale,town,item WHERE " +
						"salesperson='"+session.getAttribute("id")+"' AND " +
						"town.id=sale.town AND item.id=sale.item ORDER BY date DESC;");			
				request.setAttribute("list", list);
				request.getRequestDispatcher("/sales.jsp").forward(request, response);
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
