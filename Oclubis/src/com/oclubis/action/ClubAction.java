package com.oclubis.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oclubis.service.ClubService;
import com.oclubis.vo.ClubVO;

public class ClubAction implements IAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			String clubname = request.getParameter("club");
			System.out.println("caction " + clubname);
			ClubService service = new ClubService();
			ClubVO cv = null;
			cv = service.getClubIntro(clubname);
			request.setAttribute("club", cv);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/clubpage.jsp");
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
