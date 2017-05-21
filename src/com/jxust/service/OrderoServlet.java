package com.jxust.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jxust.dao.OrderoManager;
import com.jxust.dao.Impl.OrderoManagerImpl;
import com.jxust.entity.Ordero;

public class OrderoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderoServlet() {
		super();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if("showallordero".equals(action)){
			showallordero(req, resp);
		
		}else if ("deleteordero".equals(action)) {
			deleteordero(req, resp);
		}else if ("findOrder".equals(action)) {
			findOrder(req, resp);
		}else if ("delete".equals(action)) {
			delete(req, resp);
		}
	}
	
	public void showallordero(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		OrderoManager om = new OrderoManagerImpl();
		List<Ordero> orderos = om.findAllOrdero();
		req.setAttribute("orderos", orderos);
		req.getRequestDispatcher("./showAllOrdero.jsp").forward(req, resp);
	}
	
	public void findOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		OrderoManager om = new OrderoManagerImpl();
		String d1 = req.getParameter("d1");
		String d2 = req.getParameter("d2");
		if(d1!=""&&d2!=""){
			Date date1 = Date.valueOf(d1);
			Date date2 = Date.valueOf(d2);
			HttpSession session = req.getSession(); 
			session.setAttribute("date1",date1);
			session.setAttribute("date2",date2);
			List<Ordero> orderos = om.findOrderByDate(date1, date2);
			req.setAttribute("orderos", orderos);
			req.getRequestDispatcher("./findOrders.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("./err.jsp");
		}
	}
//	public void addOrdero(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException{
//		String ordername = req.getParameter("ordername");
//		String productid= req.getParameter("productid");
//		String number = req.getParameter("number");
//		String userid = req.getParameter("userid");
//		String userjudge = req.getParameter("userjudge");
//		String createtime = req.getParameter("createtime");
//		String isdelorder = req.getParameter("isdelorder");
//		String remark = req.getParameter("remark");
//		Ordero ordero = new Ordero();
//		ordero.setOrdername(ordername);
//		ordero.setProductid(Integer.parseInt(productid));
//		ordero.setNumber(Integer.parseInt(number));
//		ordero.setUserid(Integer.parseInt(userid));
//		ordero.setUserjudge(userjudge);
//		ordero.setCreatetime(Date.valueOf(createtime));
//		ordero.setIsdelorder(Integer.parseInt(isdelorder));
//		ordero.setRemark(remark);
//		OrderoManager om = new OrderoManagerImpl();
//		om.addOrdero(ordero);
//		showallordero(req, resp);
//	}
	
	public void deleteordero(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String orderid = req.getParameter("orderid");
		OrderoManager om = new OrderoManagerImpl();
		om.deleteOrderoById(Integer.parseInt(orderid));
		showallordero(req, resp);
	}
	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String orderid = req.getParameter("orderid");
		OrderoManager om = new OrderoManagerImpl();
		om.deleteOrderoById(Integer.parseInt(orderid));
		HttpSession session = req.getSession(); 
		 Date date1 = (Date) session.getAttribute("date1");
		 Date date2 = (Date) session.getAttribute("date2");
		 List<Ordero> orderos = om.findOrderByDate(date1, date2);
			req.setAttribute("orderos", orderos);
			req.getRequestDispatcher("./findOrders.jsp").forward(req, resp);
	}
}
