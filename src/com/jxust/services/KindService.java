package com.jxust.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxust.dao.KindManager;
import com.jxust.dao.OrderoManager;
import com.jxust.dao.ProductManager;
import com.jxust.dao.Impl.KindManagerImpl;
import com.jxust.dao.Impl.OrderoManagerImpl;
import com.jxust.dao.Impl.ProductManagerImpl;
import com.jxust.entity.Kind;

/**
 * @author shymain
 *
 */
public class KindService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1163558408031019929L;

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action =request.getParameter("action");
		System.out.println(action);
		if("showAllKind".equals(action)){
			showAllKind(request, response);
		}else if("delete".equals(action)){
			deleteKind(request, response);
		}else if("update".equals(action)){
			findKind(request, response);
		}else if("doUpdate".equals(action)){
			updateKind(request,response);
		}else if("add".equals(action)){
			addKind(request,response);
		}
	}
	
	/**
	 * 查找商品类别信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findKind(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String kindid=request.getParameter("id");
		Kind kind =new Kind();
		KindManager sm=new KindManagerImpl();
		kind=sm.findKindById(Integer.parseInt(kindid));
		
		request.setAttribute("kind", kind);
		request.getRequestDispatcher("./updateKind.jsp").forward(request, response);
		
	}
	
	/**
	 * 更新商品类别信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateKind(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String kindid = request.getParameter("kindid");
		String kindname=request.getParameter("kindname");
		String remark=request.getParameter("remark");

		Kind kind =new Kind();
		kind.setClassid(Integer.parseInt(kindid));
		kind.setClassname(kindname);
		kind.setRemark(remark);
		
		
		KindManager sm=new KindManagerImpl();
		sm.updateKindById(kind);
		
		request.getRequestDispatcher("./KindService?action=showAllKind").forward(request, response);
	}

	/**
	 * 查找所有商品类别
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showAllKind(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		KindManager sm=new KindManagerImpl();
		List<Kind> kinds=sm.findAllKind();
		System.out.println(kinds.size());
		
		request.setAttribute("kinds", kinds);
		request.getRequestDispatcher("./showAllKind.jsp").forward(request, response);
		
	}
	
	/**
	 * 删除商品类别
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void deleteKind(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		
		//删除与product关联的ordero
		OrderoManager orderoManager = new OrderoManagerImpl();
		orderoManager.deleteOrderoByKindId(id);
		
		
		//删除与class关联的Product
		ProductManager productManager = new ProductManagerImpl();
		productManager.deleteProductByKindId(id);
		
		KindManager sm=new KindManagerImpl();
		sm.deleteKindById(Integer.parseInt(id));
		
		
		request.getRequestDispatcher("./KindService?action=showAllKind").forward(request, response);
	}
	
	/**
	 * 添加商品类别
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addKind(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String kindname=request.getParameter("kindname");
		String remark=request.getParameter("remark");
		
		Kind kind=new Kind();
		kind.setClassname(kindname);
		kind.setRemark(remark);
		
		KindManager sm=new KindManagerImpl();
		sm.addKind(kind);
		
		request.getRequestDispatcher("./KindService?action=showAllKind").forward(request, response);
		
	}
	
	
	
	public void init() throws ServletException {
		// Put your code here
	}

}
