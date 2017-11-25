package com.oclubis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommonDao {

	private Connection conn;
	
	public CommonDao() {}
	
	public CommonDao(Connection conn) {
		this.conn = conn;
	}
	
	public List<String> getClubList() throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT CLUBNAME FROM CLUBLIST";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<String> list = new ArrayList<>();
			while (rs.next()) {
				list.add(rs.getString(1));
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
	
}
