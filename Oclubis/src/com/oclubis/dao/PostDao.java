package com.oclubis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.spec.PSource;

import com.oclubis.vo.PostVO;

public class PostDao {
	Connection conn = null;

	public PostDao(Connection conn) {
		this.conn = conn;
	}

	public List<PostVO> getPostList() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM POST";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<PostVO> list = new ArrayList<>();
			PostVO pv = null;
			while (rs.next()) {
				pv = new PostVO();
				pv.setNumber(rs.getInt(1));
				pv.setTheme(rs.getString(2));
				pv.setContent(rs.getString(3));
				pv.setWriter(rs.getString(4));
				pv.setDate(rs.getString(5));
				pv.setCategory(rs.getInt(6));
				list.add(pv);
			}
			return list;
		} catch (Exception e) {
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

	public int getNumber() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int check = 0;
		String sql = "SELECT number FROM post WHERE number=(SELECT MAX(number) FROM post);";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				check = rs.getInt(1);
			}
			System.out.println(check);
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("사용자 조회시 오류가 발생하였습니다");
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	public void insertPost(PostVO post) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO POST VALUES(?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post.getNumber());
			pstmt.setString(2, post.getTheme());
			pstmt.setString(3, post.getContent());
			pstmt.setString(4, post.getWriter());
			pstmt.setString(5, post.getDate());
			pstmt.setInt(6, post.getCategory());
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

	public List<PostVO> getPostListByCategory(int category) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM POST WHERE CATEGORY=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
			rs = pstmt.executeQuery();
			List<PostVO> list = new ArrayList<>();
			PostVO pv = null;
			while (rs.next()) {
				pv = new PostVO();
				pv.setNumber(rs.getInt(1));
				pv.setTheme(rs.getString(2));
				pv.setContent(rs.getString(3));
				pv.setWriter(rs.getString(4));
				pv.setDate(rs.getString(5));
				pv.setCategory(rs.getInt(6));
				list.add(pv);
			}
			return list;
		} catch (Exception e) {
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

	public List<PostVO> searchPost(String condition, String search) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		if (condition.equals("theme")) {
			sql = "SELECT * FROM POST WHERE THEME LIKE ?";
		} else {
			sql = "SELECT * FROM POST WHERE WRITER LIKE ?";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			List<PostVO> list = new ArrayList<>();
			PostVO pv = null;
			while (rs.next()) {
				pv = new PostVO();
				pv.setNumber(rs.getInt(1));
				pv.setTheme(rs.getString(2));
				pv.setContent(rs.getString(3));
				pv.setWriter(rs.getString(4));
				pv.setDate(rs.getString(5));
				pv.setCategory(rs.getInt(6));
				list.add(pv);
			}
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

	public void deletePost(int number) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM POST WHERE NUMBER=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
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
	public void addLike(int number, String writer) throws Exception {
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO POSTLIKE VALUES(?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, writer);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("좋아요 시에 오류가 발생하였습니다");
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	public Map<Integer, List<String>> getLikeList() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM POSTLIKE";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int check = 0;
			Map<Integer, List<String>> map = new HashMap<>();
			List<String> list = null;
			while (rs.next()) {
				if (rs.getInt(1) > check) {	
					map.put(check, list);
					list = new ArrayList<>();
					check = rs.getInt(1);
					System.out.println(map);
				}
				if (rs.getInt(1) == check) {
					list.add(rs.getString(2));
				}
			}
			map.put(check, list);
			System.out.println(map);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 등록 시에 오류가 발생하였습니다");
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	public void deleteLike(int num, String name) throws Exception {
		// TODO Auto-generated method stub
PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM POSTLIKE WHERE LIKERNAME=? AND POSTNUMBER=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("좋아요 시에 오류가 발생하였습니다");
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

}
