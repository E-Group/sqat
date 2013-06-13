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
			System.out.println("In Sales Servlet Get Method");
			HttpSession session = request.getSession();
			String query;
			String redirect;
			LoginBean user = (LoginBean) session.getAttribute("loginbean");
			String date = request.getParameter("date");
			
			String filter = request.getParameter("filter");
			System.out.println(filter);
			
			if(user.isGunner()){
				String salesperson = request.getParameter("salespersons");
				if(filter != null){
					query = "SELECT * FROM sale,town,item WHERE " +
							"salesperson='"+salesperson+"' AND " +
							"town.id=sale.town AND item.id=sale.item AND date LIKE '"+date+"%' ORDER BY date DESC;";			

					request.setAttribute("selecteddate", date);

				}
				else {
					query = "SELECT * FROM sale,town,item WHERE " +
							"salesperson='"+salesperson+"' AND " +
							"town.id=sale.town AND item.id=sale.item ORDER BY date DESC;";		
				}
				request.setAttribute("selectedsales", salesperson);
				redirect = "/WEB-INF/gunner.jsp";
			}

			else {
				if(filter != null){	
					query = "SELECT * FROM sale,town,item WHERE " +
							"salesperson='"+user.getId()+"' AND " +
							"town.id=sale.town AND item.id=sale.item AND date LIKE '"+date+"%' ORDER BY date DESC;";		
					request.setAttribute("selecteddate", date);
					request.removeAttribute("filtered");
				}

				else  {
					query = "SELECT * FROM sale,town,item WHERE " +
							"salesperson='"+user.getId()+"' AND " +
							"town.id=sale.town AND item.id=sale.item ORDER BY date DESC;";
					request.setAttribute("filtered","hidden");
				}
				redirect = "/WEB-INF/sales.jsp";
			}
			List<SaleBean> list = QueryDao.querySales(query);	
			request.setAttribute("list", list);
			request.getRequestDispatcher(redirect).forward(request, response);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
