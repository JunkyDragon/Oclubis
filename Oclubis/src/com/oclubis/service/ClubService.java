package com.oclubis.service;

import java.sql.Connection;
import java.util.List;

import com.oclubis.dao.ClubDao;
import com.oclubis.vo.ClubVO;
import com.oclubis.vo.PostVO;

public class ClubService extends AbstractService {
	public List<ClubVO> getClubList() throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			ClubDao dao = new ClubDao(conn);
			List<ClubVO> list = dao.getClubList();
			return list;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public List<ClubVO> searchClub(String condition, String search) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			ClubDao dao = new ClubDao(conn);
			StringBuilder sb = new StringBuilder();
			sb.append("%").append(search).append("%");
			System.out.println(sb.toString());
			List<ClubVO> list = dao.searchClub(condition, sb.toString());
			System.out.println(list);
			return list;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public ClubVO getClubIntro(String clubname) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			ClubDao dao = new ClubDao(conn);
			ClubVO cv = dao.getClubIntro(clubname);
			return cv;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
