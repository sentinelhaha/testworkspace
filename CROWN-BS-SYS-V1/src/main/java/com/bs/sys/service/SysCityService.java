package com.bs.sys.service;

import java.util.List;
import com.bs.common.vo.PageObject;
import com.bs.sys.entity.SysCity;

public interface SysCityService {
	List<SysCity> doFindCityObjects(String cityname);
	
	
	
	 PageObject<SysCity> findPageObjects(String city_name,
				Integer pageCurrent);
	
}




