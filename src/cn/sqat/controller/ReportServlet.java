package cn.sqat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sqat.model.QueryDao;
import cn.sqat.model.SaleBean;

public class ReportServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
//			System.out.println("In the Salary Servlet");
			HttpSession session = request.getSession();
			request.getAttribute("user");
			// TODO: borde flytta query till querydao
			List<SaleBean> list = QueryDao.queryReports("SELECT * FROM report,salesperson,user WHERE " +
					"salesperson='"+session.getAttribute("id")+"' AND " +
							"town.id=sale.town AND item.id=sale.item ORDER BY date DESC;");			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/sales.jsp").forward(request, response);
			
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
