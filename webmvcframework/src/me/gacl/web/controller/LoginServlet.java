package me.gacl.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.gacl.domain.User;
import me.gacl.service.IUserService;
import me.gacl.service.impl.UserServiceImpl;

/**
 * 处理用户登录的servlet
 * @author gacl
 *
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取用户填写的登录用户名
		String username = request.getParameter("username");
		//获取用户填写的登录密码
		String password = request.getParameter("password");
		
		IUserService service = new UserServiceImpl();
		//用户登录
		User user = service.loginUser(username, password);
		if(user==null){
			String message = String.format(
					"对不起，用户名或密码有误！！请重新登录！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url=%s'", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//登录成功后，就将用户存储到session中
		request.getSession().setAttribute("user", user);
		String message = String.format(
				"恭喜：%s,登陆成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'", 
				user.getUserName(),
				request.getContextPath()+"/index.jsp");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
