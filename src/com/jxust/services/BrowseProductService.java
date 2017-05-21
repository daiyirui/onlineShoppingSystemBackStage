package com.jxust.services;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jxust.dao.BrowseProductManager;

import com.jxust.dao.Impl.BrowseProductManagerImpl;

import com.jxust.entity.BrowseProduct;


/**
 * @author shymain
 *
 */
public class BrowseProductService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2129589160513134761L;

	
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
		if("showAllBrowseProduct".equals(action)){
			showAllBrowseProduct(request, response);
		}else if("delete".equals(action)){
			deleteBrowseProduct(request, response);
		}else if("update".equals(action)){
			findBrowseProduct(request, response);
		}else if("doUpdate".equals(action)){
			updateBrowseProduct(request,response);
		}else if("add".equals(action)){
			addBrowseProduct(request,response);
		}
		
	}
	
	/**
	 * 更新浏览产品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateBrowseProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String browseproductid=request.getParameter("browseproductid");
		String browseproductname=request.getParameter("browseproductname");
		String productid=request.getParameter("productid");
		String classid=request.getParameter("classid");
		String popularity=request.getParameter("popularity");
		String hotsale=request.getParameter("hotsale");
		String keywords=request.getParameter("keys");
		String picture=request.getParameter("picture");
		String remark=request.getParameter("remark");
		
		BrowseProduct browseProduct =new BrowseProduct();
		browseProduct.setBrowseproductid(Integer.parseInt(browseproductid));
		browseProduct.setBrowseproductname(browseproductname);
		browseProduct.setProductid(Integer.parseInt(productid));
		browseProduct.setClassid(Integer.parseInt(classid));
		browseProduct.setPopularity(Integer.parseInt(popularity));
		browseProduct.setHotsale(Integer.parseInt(hotsale));
		browseProduct.setKeywords(keywords);
		browseProduct.setPicture(picture);
		browseProduct.setRemark(remark);
		
		BrowseProductManager browseProductManager =new BrowseProductManagerImpl();
		browseProductManager.updateBrowseProduct(browseProduct);
		
		
		request.getRequestDispatcher("./BrowseProductService?action=showAllBrowseProduct").forward(request, response);
	}
	
	
	/**
	 * 查找浏览产品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findBrowseProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		BrowseProduct browseProduct =new BrowseProduct();
		BrowseProductManager browseProductManager =new BrowseProductManagerImpl();
		browseProduct=browseProductManager.findBrowseProductById(Integer.parseInt(id));
		
		request.setAttribute("browseProduct", browseProduct);
		request.getRequestDispatcher("./updateBrowseProduct.jsp").forward(request, response);
		
	}
	
	/**
	 * 删除浏览产品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void deleteBrowseProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		BrowseProductManager browseProductManager =new BrowseProductManagerImpl();
		browseProductManager.deleteBrowseProductById(Integer.parseInt(id));
		
		request.getRequestDispatcher("./BrowseProductService?action=showAllBrowseProduct").forward(request, response);
	}
	
	/**
	 * 添加浏览产品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addBrowseProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String browseproductname=request.getParameter("browseproductname");
		String productid=request.getParameter("productid");
		String classid=request.getParameter("classid");
		String popularity=request.getParameter("popularity");
		String hotsale=request.getParameter("hotsale");
		String keywords=request.getParameter("keys");
		String picture=request.getParameter("picture");
		String remark=request.getParameter("remark");
		
		BrowseProduct browseProduct =new BrowseProduct();
		browseProduct.setBrowseproductname(browseproductname);
		browseProduct.setProductid(Integer.parseInt(productid));
		browseProduct.setClassid(Integer.parseInt(classid));
		browseProduct.setPopularity(Integer.parseInt(popularity));
		browseProduct.setHotsale(Integer.parseInt(hotsale));
		browseProduct.setKeywords(keywords);
		browseProduct.setPicture(picture);
		browseProduct.setRemark(remark);
		
		BrowseProductManager browseProductManager =new BrowseProductManagerImpl();
		browseProductManager.addBrowseProduct(browseProduct);
		
		request.getRequestDispatcher("./BrowseProductService?action=showAllBrowseProduct").forward(request, response);;
		
	}


	
	/**
	 * 显示所有浏览产品
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showAllBrowseProduct(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BrowseProductManager sm=new BrowseProductManagerImpl();
		List<BrowseProduct> bpts=sm.findAllBrowseProduct();
		System.out.println(bpts.size());
		
		request.setAttribute("bpts", bpts);
		request.getRequestDispatcher("./showAllBrowseProduct.jsp").forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
