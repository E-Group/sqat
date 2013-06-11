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
import cn.sqat.model.ReportBean;

public class ReportServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			HttpSession session = request.getSession();
			request.getAttribute("user");
			List<ReportBean> list = QueryDao.queryReports(session.getAttribute("id"));			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/salary.jsp").forward(request, response);

		} catch (Throwable exc)
		{
			System.out.println(exc);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			HttpSession userSession = request.getSession();
			LoginBean user = (LoginBean) userSession.getAttribute("loginbean");

			String date = request.getParameter("report");
			String fullDate = date+"-01";
			System.out.println(fullDate);
			
			if(date != null){
				ReportBean report = new ReportBean();
				report.setSalesperson(user.getUsername());
				report.setMonth(fullDate);
				report.setId(Integer.parseInt(user.getId()));
				report = QueryDao.submitReport(report);
				
				request.setAttribute("message", date+" reported.");
				request.getRequestDispatcher("/sales.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "No month selected.");
				request.getRequestDispatcher("/sales.jsp").forward(request, response);
			}
		
		} catch (Throwable exc)
		{
			System.out.println(exc);
		}
	}
}
