package com.oclubis.service;

import java.sql.Connection;
import java.util.List;

import com.oclubis.dao.CommonDao;

public class CommonService extends AbstractService {
	public List<String> getClubList() throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			CommonDao dao = new CommonDao(conn);
			List<String> list = dao.getClubList();
			return list;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
