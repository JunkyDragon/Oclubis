package com.oclubis.utils;

import java.util.List;

import com.oclubis.service.ClubService;
import com.oclubis.vo.ClubVO;

public class ClubUtil {
	public List<ClubVO> getClub() throws Exception {
		
		ClubService service = new ClubService();
		
		List<ClubVO> list = service.getClubList();
		
		return list;
	}
}
