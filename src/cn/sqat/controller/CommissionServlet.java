package cn.sqat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sqat.model.CommissionBean;
import cn.sqat.model.LoginBean;
import cn.sqat.model.QueryDao;
import cn.sqat.model.ReportBean;



public class CommissionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private List<CommissionBean> calculateCommissions(List<CommissionBean> list){
		for(CommissionBean cb : list){
			int summary = 0;
			int commission = 0;

			summary += cb.getLocks() * cb.getLocksPrice();
			summary += cb.getStocks() * cb.getStocksPrice();
			summary += cb.getBarrels() * cb.getBarrelsPrice();
			/*
			 * 	10% on sales up to (and including) $1000, 
			 * 	15% on the next $800, 
			 * 	20% on any sales in excess of $1800. 
			 * 
			 * 	Locks cost $45, stocks cost $30, and barrels cost $25. 
			 */
			if(summary <= 1000){
				commission = (int) (summary * 0.10);
			}
			else if(summary > 1000 && summary <= 1800){
				summary -= 1000;
				commission = (int) (1000 * 0.10);
				commission += (int) (summary * 0.15);
			}
			else{
				summary -= 1000;
				commission = (int) (1000 * 0.10);
				summary -= 800;
				commission += (int) (800 * 0.15);
				commission += (int) (summary * 0.2);
			}
			cb.setSalary(commission);
		}
		return list;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{

			// Hämta salesperson id och månad, skapa bean, returnera skiten
			HttpSession session = request.getSession();
			LoginBean user = (LoginBean) session.getAttribute("loginbean");
			List<CommissionBean> temp = QueryDao.queryCommissions(Integer.parseInt(user.getId()));	
			List<CommissionBean> list = calculateCommissions(temp);
			session.setAttribute("comlist", list);
			
			if(list.isEmpty()){
				request.setAttribute("message", "No unaccepted reports at the moment!");
			}
			
			request.getRequestDispatcher("/commission.jsp").forward(request, response);

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
			System.out.println("In CommissionServlet Post Method");
			HttpSession session = request.getSession();
			LoginBean user = (LoginBean) session.getAttribute("loginbean");

			List<CommissionBean> list = (List<CommissionBean>) session.getAttribute("comlist");
			session.setAttribute("comlist", list);

			String btn = request.getParameter("acceptbtn");

			CommissionBean cb = null;

			for(CommissionBean comm : list){
				if(comm.getComId() == Integer.parseInt(btn)){
					cb = comm;
					list.remove(cb);
					break;
				}
			}

			session.setAttribute("comlist", list);
			cb = QueryDao.submitCommission(cb);

			if(list.isEmpty()){
				request.setAttribute("message", "No unaccepted reports at the moment!");
			}
			request.getRequestDispatcher("/commission.jsp").forward(request, response);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}