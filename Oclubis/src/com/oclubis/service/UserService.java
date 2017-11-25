package com.oclubis.service;

import java.sql.Connection;

import com.oclubis.dao.UserDao;
import com.oclubis.exception.IdOverlapException;
import com.oclubis.vo.UserVO;

public class UserService extends AbstractService {
	public UserVO signin(UserVO user) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			UserVO vo = dao.searchUser(user);
			
			return vo;
		} finally {
			// TODO: handle finally clause
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void signup(UserVO user) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			boolean check = dao.searchId(user.getId());
			if (!check) {
				throw new IdOverlapException("중복되는 id가 존재합니다.");
			}
			
			dao.insertUser(user);
			
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
