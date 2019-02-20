package com.bs.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bs.sys.entity.SysCity;

public interface SysCityDao {
	
	SysCity doFindCityObjectById(@Param("id") Integer id);
	
	int getRowCount(@Param("sheng_name") String sheng_name);

	List<SysCity> findPageObjects(
			@Param("sheng_name")String sheng_name,
			@Param("startIndex")int startIndex,
			@Param("pageSize")int pageSize);
}
