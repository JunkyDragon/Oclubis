package com.oclubis.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.oclubis.service.UserService;
import com.oclubis.vo.UserVO;

public class SigninAction implements IAction{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			validate(id, pwd);
			UserVO user = new UserVO(id, pwd);
			UserService service = new UserService();
			UserVO result = service.signin(user);
			request.setAttribute("user", result);
			request.getSession().setAttribute("user", result);
			RequestDispatcher rd = request.getRequestDispatcher("main.do");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/signin.jsp");
			rd.forward(request, response);
		}
	}
	
	private void validate(String id, String pwd) throws Exception {
		if (StringUtils.isBlank(id))
			throw new Exception("id에 공백이 포함되어있습니다.");
		if (StringUtils.isBlank(pwd))
			throw new Exception("비밀번호에 공백이 포함되어 있습니다.");
	}

}
