package com.bs.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.common.exception.ServiceException;
import com.bs.common.vo.PageObject;
import com.bs.sys.dao.SysCityDao;
import com.bs.sys.entity.SysCity;

@Service
public class SysCityServiceImpl implements SysCityService{
	@Autowired
	SysCityDao sysCityDao;
	@Override
	public SysCity doFindCityObjectById(Integer id) {
		/*if(id==null || id==0)
		throw new ServiceException("城市不能为空");*/
		SysCity cityObject = sysCityDao.doFindCityObjectById(id);
		return cityObject;
	}
	 
	@Override
	public PageObject<SysCity> findPageObjects(String sheng_name,
			Integer pageCurrent) {
		//1.验证参数合法性(pageCurrent)
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值无效");
		//2.按照条件查询总记录数并进行校验
		int rowCount= sysCityDao.getRowCount(sheng_name);
		if(rowCount == 0)
		throw new ServiceException("没有对应记录");
		//3.按照条件查询当前页记录
		int pageSize =6;
		int startIndex = (pageCurrent-1)*pageSize;
		List<SysCity> records = sysCityDao.findPageObjects(
				sheng_name,startIndex,pageSize);
		for (int i = 0; i < records.size(); i++) {
		SysCity	row = records.get(i);
		String imgs = row.getCity_img();
		String[] pictures = imgs.split("\\|");
		String picture =pictures[0];
		row.setCity_img(picture);
		}
		//4.封装查询结果并返回
		PageObject<SysCity> pageObject = new PageObject<SysCity>();
		pageObject.setRecords(records);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		int pageCount = (rowCount-1)/pageSize+1;
		pageObject.setPageCount(pageCount);
		return pageObject;
	}


	
	
	
}
