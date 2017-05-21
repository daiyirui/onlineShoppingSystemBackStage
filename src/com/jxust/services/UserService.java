package com.jxust.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jxust.dao.OrderoManager;
import com.jxust.dao.UserManager;
import com.jxust.dao.Impl.OrderoManagerImpl;
import com.jxust.dao.Impl.UserManagerImpl;
import com.jxust.entity.User;

/**
 * @author shymain
 *
 */
public class UserService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6256455096818335191L;

	
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
		if("showAllUser".equals(action)){
			showAllUser(request, response);
		}else if("delete".equals(action)){
			deleteUser(request, response);
		}else if("update".equals(action)){
			findUser(request, response);
		}else if("doUpdate".equals(action)){
			updateUser(request,response);
		}else if("add".equals(action)){
			addUser(request,response);
		}
		
	}
	

	/**
	 * 展示所有会员
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showAllUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserManager sm=new UserManagerImpl();
		List<User> users=sm.findAllUser();
		System.out.println(users.size());
		
		request.setAttribute("users", users);
		request.getRequestDispatcher("./showAllUser.jsp").forward(request, response);
		
	}

	/**
	 * 删除会员
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		
		//删除与user关联的ordero数据
		OrderoManager orderoManager = new OrderoManagerImpl();
		orderoManager.deleteOrderoByUserId(id);
		
		UserManager sm=new UserManagerImpl();
		sm.deleteUserById(Integer.parseInt(id));
		
		request.getRequestDispatcher("./UserService?action=showAllUser").forward(request, response);
	}

	/**
	 * 查找会员信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid=request.getParameter("userid");
		User user =new User();
		UserManager sm=new UserManagerImpl();
		user=sm.findUserById(Integer.parseInt(userid));
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("./updateUser.jsp").forward(request, response);
		
	}
	
	/**
	 * 更新会员信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String password=request.getParameter("password");
		String username=request.getParameter("username");
		String age=request.getParameter("age");
		String email=request.getParameter("email");
		String type=request.getParameter("type");
		String remark=request.getParameter("remark");

		User user=new User();
		user.setUserid(Integer.parseInt(userid));
		user.setUsername(username);
		user.setUserpassword(password);
		user.setAge(Integer.parseInt(age));
		user.setEmail(email);
		user.setType(Integer.parseInt(type));
		user.setRemark(remark);
		
		
		UserManager sm=new UserManagerImpl();
		sm.updateUserById(user);
		
		request.getRequestDispatcher("./UserService?action=showAllUser").forward(request, response);
	}
	
	/**
	 * 添加会员
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String password=request.getParameter("password");
		String username=request.getParameter("username");
		String age=request.getParameter("age");
		String sex=request.getParameter("sex");
		String email=request.getParameter("email");
		String remark=request.getParameter("remark");
		
		User user=new User();
		user.setUsername(username);
		user.setUserpassword(password);
		user.setAge(Integer.parseInt(age));
		user.setSex(sex);
		user.setEmail(email);
		user.setType(0);
		user.setRemark(remark);
		
		UserManager sm=new UserManagerImpl();
		sm.addUser(user);
		
		request.getRequestDispatcher("./UserService?action=showAllUser").forward(request, response);;
		
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
