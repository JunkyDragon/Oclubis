package com.oclubis.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oclubis.service.PostService;
import com.oclubis.service.UserService;
import com.oclubis.vo.PostVO;
import com.oclubis.vo.UserVO;

public class UserAction implements IAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");

			UserService service = new UserService();
			List<UserVO> list = new ArrayList<>();
			list = service.getUserList();
			Collections.reverse(list);
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/user.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
			rd.forward(request, response);
		}

	}

}
