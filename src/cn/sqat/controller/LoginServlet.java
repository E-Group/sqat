package cn.sqat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.sqat.model.ItemBean;
import cn.sqat.model.LoginBean;
import cn.sqat.model.LoginDao;
import cn.sqat.model.QueryDao;
import cn.sqat.model.TownBean;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void logout(){
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			System.out.println("In the Login Servlet");
			LoginBean user = new LoginBean();
			user.setUserName(request.getParameter("email"));
			user.setPassword(request.getParameter("pass"));
			user = LoginDao.login(user);
			if(user.isValid())
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user.getUsername());
				session.setAttribute("id", user.getId());
				session.setAttribute("loginbean", user);
				
				
				List<TownBean> townlist = QueryDao.queryTowns("SELECT * FROM town;");  
				session.setAttribute("townlist", townlist);
				
				List<ItemBean> itemlist = QueryDao.queryItems("SELECT * FROM item;");  
				session.setAttribute("itemlist", itemlist);				
				
//				List<TownBean> gunsmith = QueryDao.queryTowns("SELECT * FROM gunsmith WHERE id;");  
//				session.setAttribute("gunsmith", gunsmith);
				
				request.getRequestDispatcher("/add_sale.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "Unknown username or password, try again");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
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