package com.oclubis.utils;

import java.util.List;
import java.util.Map;

import com.oclubis.service.ClubService;
import com.oclubis.service.PostService;
import com.oclubis.vo.ClubVO;

public class CommonUtil {
	public List<ClubVO> getClub() throws Exception {

		ClubService service = new ClubService();

		List<ClubVO> list = service.getClubList();

		return list;
	}

	public Map<Integer, List<String>> getLikeList() throws Exception {

		PostService service = new PostService();

		Map<Integer, List<String>> map = service.getLikeList();

		return map;
	}
}
