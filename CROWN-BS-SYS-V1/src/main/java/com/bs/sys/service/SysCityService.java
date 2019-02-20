package com.bs.sys.service;

import com.bs.common.vo.PageObject;
import com.bs.sys.entity.SysCity;

public interface SysCityService {
	SysCity doFindCityObjectById(Integer id);
	
	
	
	 PageObject<SysCity> findPageObjects(String sheng_name,
				Integer pageCurrent);
	
}




