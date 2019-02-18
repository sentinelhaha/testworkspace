package com.bs.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bs.sys.entity.SysCity;
import com.bs.sys.vo.QJdImgTable;

public interface SysCityDao {
	
	List<SysCity> doFindCityObjects(@Param("cityname")String cityname) ;
	
	int getRowCount(@Param("city_name") String city_name);

	List<SysCity> findPageObjects(
			@Param("city_name")String city_name,
			@Param("startIndex")int startIndex,
			@Param("pageSize")int pageSize);
}
