package com.oclubis.action;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oclubis.service.PostService;
import com.oclubis.vo.PostVO;

public class MainAction implements IAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");

			PostService service = new PostService();
			List<PostVO> list = new ArrayList<>();
			list = service.getPostList();
			Collections.reverse(list);
			Map<Integer, List<String>> like = service.getLikeList();
			request.setAttribute("list", list);
			request.setAttribute("like", like);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/main.jsp");
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
