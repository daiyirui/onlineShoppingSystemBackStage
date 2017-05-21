package com.jxust.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jxust.dao.UserManager;
import com.jxust.dao.Impl.UserManagerImpl;
import com.jxust.entity.User;


/**
 * @author shymain
 *
 */
public class LoginService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3647750775271245584L;

	
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
		if("login".equals(action)){
			checkLogin(request,response);
		}else if("update".equals(action)){
			findUser(request, response);
		}else if("doUpdate".equals(action)){
			updateUser(request,response);
		}else if ("exit".equals(action)) {
				exit(request, response);
		}
		
	}
	
	
	
	
	/**
	 * 
	 * 检测登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sname =request.getParameter("userName");
		String pwd =request.getParameter("userPwd");
		UserManager stmt =new UserManagerImpl();
		int userid = stmt.checkLogin(sname, pwd);
		if (userid!=0){
			HttpSession session =  request.getSession();
			session.setAttribute("userid",userid);
			response.sendRedirect("./index.jsp");
		}else{
			response.sendRedirect("./login.jsp?tag=1");
		}
		
	}
	
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	
	
	private void findUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		User user =new User();
		UserManager sm=new UserManagerImpl();
		user=sm.findUserById(userid);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("./updateAdmin.jsp").forward(request, response);
	}
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
		
		findAdmin(request, response);
	}
	private void findAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		User user =new User();
		UserManager sm=new UserManagerImpl();
		user=sm.findUserById(userid);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("./showAdmin.jsp").forward(request, response);
	}
	private void exit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("./login.jsp");
		
	}
}
