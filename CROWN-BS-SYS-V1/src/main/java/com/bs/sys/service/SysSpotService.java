package com.bs.sys.service;



import com.bs.common.vo.PageObject;
import com.bs.sys.entity.SysSpot;

public interface SysSpotService {
	 
	
	
	
	 PageObject<SysSpot> findPageObjects(String spotname,Integer pageCurrent);
	
	
	
}
