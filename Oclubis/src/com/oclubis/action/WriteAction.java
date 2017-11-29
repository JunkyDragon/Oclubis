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

public class WriteAction implements IAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			long time = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월dd일 kk:mm:ss");
			String date = sdf.format(new Date(time));
			HttpSession session = request.getSession();
			String theme = request.getParameter("theme");
			String content = request.getParameter("content");
			System.out.println(content);
			int category = Integer.parseInt(request.getParameter("category"));
			String writer = ((UserVO) session.getAttribute("user")).getName();
			PostVO post = new PostVO(theme, content, writer, date, category);
			validate(post);
			PostService service = new PostService();
			service.addPost(post);
			response.sendRedirect("main.do");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = null;
			int category = Integer.parseInt(request.getParameter("category"));
			if (category == 0) {
				rd = request.getRequestDispatcher("jsp/writeann.jsp");
			} else {
				rd = request.getRequestDispatcher("jsp/write.jsp");
			}
			rd.forward(request, response);
		}
	}

	private void validate(PostVO vo) throws Exception {
		if (StringUtils.isEmpty(vo.getTheme()))
			throw new Exception("제목을 입력해주세요");
		if (StringUtils.isEmpty(vo.getContent()))
			throw new Exception("내용을 입력해주세요");
		if (vo.getCategory() == -1)
			throw new Exception("카테고리를 선택해주세요");
	}

}
