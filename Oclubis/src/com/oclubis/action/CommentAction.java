package com.oclubis.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class CommentAction implements IAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int number = Integer.parseInt(request.getParameter("number"));
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			validate(content);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/comment.jsp");
			rd.forward(request, response);
		}
	}

	private void validate(String content) throws Exception {
		// TODO Auto-generated method stub
		if (StringUtils.isBlank(content)) {
			throw new Exception("내용을 입력해주세요");
		}
	}

}
