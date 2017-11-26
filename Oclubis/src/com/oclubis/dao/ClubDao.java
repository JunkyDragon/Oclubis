package com.oclubis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oclubis.vo.ClubVO;
import com.oclubis.vo.PostVO;

public class ClubDao {

	private Connection conn;
	
	public ClubDao() {}
	
	public ClubDao(Connection conn) {
		this.conn = conn;
	}
	
	public List<ClubVO> getClubList() throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT CLUBNAME, PRESIDENT FROM CLUBLIST";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<ClubVO> list = new ArrayList<>();
			ClubVO cv = null;
			while (rs.next()) {
				cv = new ClubVO(rs.getString(1), rs.getString(2));
				
				list.add(cv);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("동아리 목록 조회 중 오류가 발생하였습니다.");
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	public List<ClubVO> searchClub(String condition, String search) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		if (condition.equals("clubname")) {
			sql = "SELECT CLUBNAME, PRESIDENT FROM CLUBLIST WHERE CLUBNAME LIKE ?";
		} else {
			sql = "SELECT CLUBNAME, PRESIDENT FROM CLUBLIST WHERE PRESIDENT LIKE ?";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			List<ClubVO> list = new ArrayList<>();
			ClubVO cv = null;
			while (rs.next()) {
				cv = new ClubVO();
				cv.setName(rs.getString(1));
				System.out.println("aaa" + rs.getString(1));
				cv.setPresident(rs.getString(2));
				list.add(cv);
			}
			System.out.println(list);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("글 조회시 오류가 발생했습니다.");
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	public ClubVO getClubIntro(String clubname) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CLUBLIST WHERE CLUBNAME LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clubname);
			rs = pstmt.executeQuery();
			ClubVO cv = null;
			if (rs.next()) {
				cv = new ClubVO();
				cv.setName(rs.getString(1));
				cv.setPresident(rs.getString(2));
				cv.setIntro(rs.getString(3));
			}	
			return cv;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("글 조회시 오류가 발생했습니다.");
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	
}
