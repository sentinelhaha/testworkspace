package com.bs.sys.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.common.exception.ServiceException;
import com.bs.common.vo.PageObject;
import com.bs.sys.dao.SysTravelDao;
import com.bs.sys.entity.SysTravel;


@Service
public class SysTravelServiceImpl implements SysTravelService{
	
	@Autowired
	private SysTravelDao sysTravelDao;
	
	@Override
	public SysTravel doFindTravelObjectById(Integer id) {
		/*if(id==null || id==0)
		throw new ServiceException("城市不能为空");*/
		SysTravel travelObject = sysTravelDao.doFindTravelObjectById(id);
		return travelObject;
	}

	@Override
	public List<Map<String,Object>> findTripObjects() {
		/*List<QYjTable> list = sysTripDao.findTripObjects();*/
		/*String pictureUrl ="http:192.168.2.81:8002";*/
		
		List<Map<String, Object>> list = sysTravelDao.findTripObjects();
		list.size();
		Map<String, Object> map = new HashMap<>();
		map.put("pictureUrl", "http:192.168.2.81:8002");
		list.add(list.size(),map);
		return list;
	}

	@Override
	public PageObject<SysTravel> findPageObjects(
			Integer pageCurrent) {
		if(pageCurrent==null || pageCurrent<1)
		throw new IllegalArgumentException("页码值无效");
		/*int rowCount=sysTravelDao.getRowCount();*/
		/*int rowCount =30348;*/
		int rowCount = 1052;
		if(rowCount==0)
		throw new ServiceException("没有对应记录");
		int pageSize=12;
		int startIndex = (pageCurrent-1)*pageSize;
		List<SysTravel> records = sysTravelDao.
				findPageObjects( startIndex, pageSize);
		
		for (int i = 0; i < records.size(); i++) {
			SysTravel	row = records.get(i);
			String imgs = row.getImgname();
			if(imgs==null||imgs.length()==0){
				row.setPicture("15490825535991557.jpg");
			}else{
				String[] pictures = imgs.split("\\|");
				String picture = pictures[0];
				row.setPicture(picture);
			}
			}
		PageObject<SysTravel> pageObject = new PageObject<SysTravel>();
		pageObject.setRecords(records);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setPageCurrent(pageCurrent);
		int pageCount = (rowCount-1)/pageSize+1;
		pageObject.setPageCount(pageCount);
		return pageObject;
	}
	
	
}














