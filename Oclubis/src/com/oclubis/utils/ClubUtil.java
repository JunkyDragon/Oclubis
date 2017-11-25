package com.oclubis.utils;

import java.util.List;

import com.oclubis.service.CommonService;

public class ClubUtil {
	public List<String> getClub() throws Exception {
		
		CommonService service = new CommonService();
		
		List<String> list = service.getClubList();
		
		return list;
	}
}
