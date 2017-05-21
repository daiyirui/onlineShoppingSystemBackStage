package com.jxust.service;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxust.dao.OrderoManager;
import com.jxust.dao.ProductManager;
import com.jxust.dao.Impl.OrderoManagerImpl;
import com.jxust.dao.Impl.ProductManagerImpl;
import com.jxust.entity.Product;


public class ProductServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProductServlet() {
		super();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if("showallproduct".equals(action)){
			showallproduct(req, resp);
		}else if ("addProduct".equals(action)) {
			addProduct(req,resp);
		}else if ("deleteproduct".equals(action)) {
			deleteproduct(req, resp);
		}else if("doUpdate".equals(action)){
			doUpdate(req, resp);
		}else if ("update".equals(action)) {
			findProduct(req, resp);
		}
	}
	
	public void showallproduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		ProductManager pm = new ProductManagerImpl();
		List<Product> products = pm.findAllProduct();
		req.setAttribute("products", products);
		req.getRequestDispatcher("./showAllProduct.jsp").forward(req, resp);
	}
	
	public void addProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String productname = req.getParameter("productname");
		String classid = req.getParameter("classid");
		String price = req.getParameter("price");
		String number = req.getParameter("number");
		String picture = req.getParameter("picture");
		String remark = req.getParameter("remark");
		String discount = req.getParameter("discount");
		String tradenumber = req.getParameter("tradenumber");
		String evaluatenumber = req.getParameter("evaluatenumber");
		Product product = new Product();
		product.setProductname(productname);
		product.setPrice(Double.parseDouble(price));
		product.setNumber(Integer.parseInt(number));
		product.setPicture(picture);
		product.setClassid(Integer.parseInt(classid));
		product.setRemark(remark);
		product.setDiscount(discount);
		product.setTradenumber(Integer.parseInt(tradenumber));
		product.setEvaluatenumber(Integer.parseInt(evaluatenumber));
		ProductManager pm = new ProductManagerImpl();
		pm.addProduct(product);
		showallproduct(req, resp);
	}
	
	public void deleteproduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String productid = req.getParameter("productid");
		
		//删除与product关联的ordero
		OrderoManager orderoManager = new OrderoManagerImpl();
		orderoManager.deleteOrderoByProductId(productid);
		
		ProductManager pm = new ProductManagerImpl();
		pm.deleteProductById(Integer.parseInt(productid));
		
		showallproduct(req, resp);
	}
	
	public void doUpdate(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String productid = req.getParameter("productid");
		String productname=req.getParameter("productname");
		String classid=req.getParameter("classid");
		String price=req.getParameter("price");
		String number=req.getParameter("number");
		String picture=req.getParameter("picture");
		String remark=req.getParameter("remark");
		String discount = req.getParameter("discount");
		String tradenumber = req.getParameter("tradenumber");
		String evaluatenumber = req.getParameter("evaluatenumber");
		Product product=new Product();
		product.setProductid(Integer.parseInt(productid));
		product.setProductname(productname);
		product.setClassid(Integer.parseInt(classid));
		product.setPrice(Double.parseDouble(price));
		product.setNumber(Integer.parseInt(number));
		product.setPicture(picture);
		product.setRemark(remark);
		product.setDiscount(discount);
		product.setTradenumber(Integer.parseInt(tradenumber));
		product.setEvaluatenumber(Integer.parseInt(evaluatenumber));
		ProductManager pm=new ProductManagerImpl();
		pm.updateProduct(product);
		showallproduct(req, resp);
	}

	public void findProduct(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productid=req.getParameter("productid");
		Product product =new Product();
		ProductManager pm=new ProductManagerImpl();
		product=pm.findProductById(Integer.parseInt(productid));
		
		req.setAttribute("product", product);
		req.getRequestDispatcher("./updateProduct.jsp").forward(req, resp);
		
	}
}
