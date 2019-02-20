package com.bs.sys.service;



import com.bs.common.vo.PageObject;
import com.bs.sys.entity.SysSpot;

public interface SysSpotService {
	 
	SysSpot doFindSpotObjectById(Integer id);
	
	
	 PageObject<SysSpot> findPageObjects(Integer pageCurrent);
	
	 SysSpot findSpot ();
	
}
