package com.oclubis.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.oclubis.service.UserService;
import com.oclubis.vo.UserVO;

public class SignupAction implements IAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");

			// 1. 입력값 추출
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String club = request.getParameter("club");
			System.out.printf("id : %s, pwd : %s, name : %s, club : %s", id, pwd, name, club);
			UserVO user = new UserVO(id, pwd, name, club);
			// 2. 입력값 검증
			validate(user);

			UserService service = new UserService();
			service.signup(user);
			// 회원가입 처리

			RequestDispatcher rd = request.getRequestDispatcher("jsp/signin.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/signup.jsp");
			rd.forward(request, response);
		}
	}
	
	private void validate(UserVO vo) throws Exception {
		if (StringUtils.isEmpty(vo.getId()))
			throw new Exception("아이디를 입력해주세요");
		if (StringUtils.isEmpty(vo.getPwd()))
			throw new Exception("비밀번호를 입력해주세요");
		if (StringUtils.isEmpty(vo.getName()))
			throw new Exception("이름을 입력해주세요");
		if (StringUtils.isEmpty(vo.getClub()))
			throw new Exception("동아리를 선택해주세요");
	}
}
