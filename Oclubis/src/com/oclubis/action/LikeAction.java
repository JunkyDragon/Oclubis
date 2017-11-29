package com.oclubis.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oclubis.service.PostService;
import com.oclubis.vo.PostVO;
import com.oclubis.vo.UserVO;

public class LikeAction implements IAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			// TODO Auto-generated method stub
			String like = request.getParameter("like");
			if (like.equals("dislike")) {
				int num = Integer.parseInt(request.getParameter("number"));
				PostService service = new PostService();
				HttpSession session = request.getSession();
				UserVO user = (UserVO) session.getAttribute("user");
				service.deleteLike(num, user.getName());
				response.sendRedirect("main.do");
			}
			if (like.equals("like")) {
				int num = Integer.parseInt(request.getParameter("number"));
				PostService service = new PostService();
				HttpSession session = request.getSession();
				UserVO user = (UserVO) session.getAttribute("user");
				service.addLike(num, user.getName());
				response.sendRedirect("main.do");
			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
			rd.forward(request, response);
		}
	}

}
