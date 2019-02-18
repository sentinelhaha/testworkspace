package com.bs.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.common.exception.ServiceException;
import com.bs.common.vo.PageObject;
import com.bs.sys.dao.SysSpotDao;
import com.bs.sys.entity.SysSpot;

@Service
public class SysSpotServiceImpl implements SysSpotService{
	
	@Autowired
	private SysSpotDao sysSpotDao;

	

	@Override
	public PageObject<SysSpot> findPageObjects(String spotname, Integer pageCurrent) {
		if(pageCurrent==null || pageCurrent<1)
		throw new IllegalArgumentException("页码值无效");
		int rowCount= sysSpotDao.getRowCount(spotname);
		if(rowCount==0)
		throw new ServiceException("没有对应记录");
		int pageSize=12;
		int indexStart=(pageCurrent-1)*pageSize;
		List<SysSpot> records = sysSpotDao.findPageObjects(
			spotname, indexStart, pageSize);
		PageObject<SysSpot> pageObject = new PageObject<SysSpot>();		
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		pageObject.setRowCount(rowCount);
		int pageCount = (rowCount-1)/pageSize+1;
		pageObject.setPageCount(pageCount);
		return pageObject;
	}
	
	
	
	
	
	
}
