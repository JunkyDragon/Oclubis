package com.oclubis.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.oclubis.service.PostService;
import com.oclubis.vo.PostVO;
import com.oclubis.vo.UserVO;

public class DeleteAction implements IAction {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			int number = Integer.parseInt(request.getParameter("number"));
			PostService service = new PostService();
			service.deletePost(number);
			
			RequestDispatcher rd = request.getRequestDispatcher("main.do");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/write.jsp");
			rd.forward(request, response);
		}
	}
	
}
