package com.bs.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.common.vo.JsonResult;
import com.bs.common.vo.PageObject;
import com.bs.sys.entity.SysCity;
import com.bs.sys.entity.SysTravel;
import com.bs.sys.service.SysCityService;

@Controller
@RequestMapping("/city/")
public class SysCityController {
	@Autowired
	private SysCityService sysCityService;
	
	@RequestMapping("doCityUI")
	public String doCityUI(){
		
		return "city_list";
	}
	
	@RequestMapping("doFindCityObjects")
	@ResponseBody
	public JsonResult doFindCityObjects (String cityname){
		
		return new JsonResult(sysCityService.doFindCityObjects(cityname));
	}
	@RequestMapping("findPageObjects")
	@ResponseBody
	public JsonResult findPageObjects(String city_name,Integer pageCurrent){
		//模拟耗时操作
		//try{Thread.sleep(5000)};
		//catch(Exception e){e.printStackTrace();}
		PageObject<SysCity> data =sysCityService.
		findPageObjects(city_name,pageCurrent);
		return new JsonResult(data);
	}
	
}
