package com.oclubis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource;

import com.oclubis.vo.UserVO;
import com.sun.org.apache.regexp.internal.recompile;

public class UserDao {
	private Connection conn;

	public UserDao(Connection conn) {
		this.conn = conn;
	}

	public UserVO searchUser(UserVO vo) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USER WHERE ID=? AND PWD=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());

			rs = pstmt.executeQuery();
			UserVO user = null;
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString(1));
				user.setName(rs.getString(3));
				user.setClub(rs.getString(4));
				user.setPermission(rs.getInt(5));
			}

			return user;
		} finally {
			// TODO: handle finally clause
		}
	}

	public boolean searchId(String id) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID FROM USER WHERE ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs != null) {
				return true;
			} else {
				return false;
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	public void insertUser(UserVO user) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO USER VALUES(?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getClub());
			pstmt.setInt(5, 0);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 등록 시에 오류가 발생하였습니다");
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	public List<UserVO> getUserList() throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USER";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<UserVO> list = new ArrayList<>();
			UserVO vo = null;
			while (rs.next()) {
				vo = new UserVO();
				vo.setClub(rs.getString(4));
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(3));
				vo.setPermission(rs.getInt(5));
				list.add(vo);
			}
			return list;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	public void updateUserPermission(String userid, int value) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "UPDATE USER SET PERMISSION=? WHERE ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, value);
			pstmt.setString(2, userid);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 등록 시에 오류가 발생하였습니다");
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	public void deleteUser(String userid) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM USER WHERE ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 탈퇴시에 오류가 발생하였습니다");
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
}
