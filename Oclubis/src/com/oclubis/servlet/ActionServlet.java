package com.oclubis.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.oclubis.action.*;

import sun.applet.Main;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, IAction> actions = new HashMap<String, IAction>();

	public ActionServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		actions.put("signin", new SigninAction());
		actions.put("signup", new SignupAction());
		actions.put("signout", new SignoutAction());
		actions.put("main", new MainAction());
		actions.put("write", new WriteAction());
		actions.put("category", new CategoryAction());
		actions.put("search", new SearchAction());
		actions.put("delete", new DeleteAction());
		actions.put("update", new UpdateAction());
		actions.put("searchclub", new SearchclubAction());
		actions.put("club", new ClubAction());
		actions.put("like", new LikeAction());
		actions.put("comment", new CommentAction());
		actions.put("user", new UserAction());
		actions.put("updateuser", new UpdateuserAction());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String url = request.getRequestURL().toString();
			int head = url.lastIndexOf("/") + 1;
			int tail = url.lastIndexOf(".");
			String actionName = url.substring(head, tail);
			System.out.println(actionName);
			IAction action = actions.get(actionName);

			if (action == null) {
				throw new Exception("요청하신 페이지를 찾을 수 없습니다.");
			}
			
			action.excute(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/error.jsp");
			rd.forward(request, response);
		}

	}

}
