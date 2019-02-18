package com.bs.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bs.sys.entity.SysTravel;

public interface SysTravelDao {
	
	List<Map<String, Object>> findTripObjects() ;
	
	/**
	 * 查询所有菜单信息
	 * @return 所有的菜单信息，表中的一行菜单记录映射
	 * 为一个map对象，map中的key为表中字段名，map中的值
	 * 为表中字段对应的值
	 */
	List<Map<String, Object>> findObjects();

	
	int getRowCount(@Param("yj_name")String travelname);
	
	List<SysTravel> findPageObjects(
			@Param("yj_name")String travelname,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
}










