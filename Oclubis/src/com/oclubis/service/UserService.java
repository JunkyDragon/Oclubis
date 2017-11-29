package com.oclubis.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

	public List<UserVO> getUserList() throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			List<UserVO> list = dao.getUserList();
			return list;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deleteUser(String userid) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			dao.deleteUser(userid);
			
		} finally {
			// TODO: handle finally clause
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void updatePermission(String userid, int value) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			dao.updateUserPermission(userid, value);
			
		} finally {
			// TODO: handle finally clause
			if (conn != null) {
				conn.close();
			}
		}
	}
}
