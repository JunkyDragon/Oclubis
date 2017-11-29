package com.oclubis.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oclubis.service.UserService;

public class UpdateuserAction implements IAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String act = request.getParameter("button");
			String userid = request.getParameter("check");
			UserService service = new UserService();
			if ("delete".equals(act)) {
				service.deleteUser(userid);
			}
			if ("change".equals(act)) {
				int value = Integer.parseInt(request.getParameter("permissionvalue"));
				service.updatePermission(userid, value);
			}
			RequestDispatcher rd = request.getRequestDispatcher("user.do");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
			rd.forward(request, response);
		}
	}

}
