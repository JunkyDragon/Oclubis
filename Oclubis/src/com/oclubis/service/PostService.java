package com.oclubis.service;

import java.sql.Connection;
import java.util.List;

import com.oclubis.dao.PostDao;
import com.oclubis.vo.PostVO;

public class PostService extends AbstractService {

	public List<PostVO> getPostList() throws Exception{
		Connection conn = null;
		try {
			conn = getConnection();
			
			PostDao dao = new PostDao(conn);
			List<PostVO> list = dao.getPostList();
			
			return list;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void addPost(PostVO post) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();
			
			PostDao dao = new PostDao(conn);
			int number = dao.getNumber() + 1;
			if (number == 0) {
				throw new Exception("글 번호 조회 시 오류가 발생했습니다.");
			}
			post.setNumber(number);
			dao.insertPost(post);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public List<PostVO> getPostListByCategory(int category) throws Exception{
		Connection conn = null;
		try {
			conn = getConnection();
			
			PostDao dao = new PostDao(conn);
			List<PostVO> list = dao.getPostListByCategory(category);
			
			return list;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
