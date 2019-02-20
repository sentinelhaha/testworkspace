package com.bs.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bs.sys.entity.SysSpot;

public interface SysSpotDao {
	
	SysSpot doFindSpotObjectById(Integer id);
	
	
	List<SysSpot> findPageObjects(
			@Param("startIndex")int startIndex,
			@Param("pageSize")int pageSize);
	
	int getRowCount();
	
	SysSpot findSpot();
	
	
	
	
}








