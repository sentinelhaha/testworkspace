package com.bs.sys.service;

import java.util.List;
import java.util.Map;

import com.bs.common.vo.PageObject;
import com.bs.sys.entity.SysTravel;

public interface SysTravelService {

	List<Map<String, Object>> findTripObjects();
	
	
	/*List<QYjTable> findTripObjects();*/
	
	/**
	 * 通过数据层对象获取所有菜单信息
	 * @return
	 */
	PageObject<SysTravel> findPageObjects (String travelname,Integer pageCurrent);
}
