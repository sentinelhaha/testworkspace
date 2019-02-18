package com.bs.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bs.sys.entity.SysSpot;

public interface SysSpotDao {
	List<SysSpot> findPageObjects(
			@Param("jdname")String spotname,
			@Param("startIndex")int startIndex,
			@Param("pageSize")int pageSize);
	
	int getRowCount(@Param("jdname")String spotname);
	
	
	
	
	
	
}








