package com.bs.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.common.vo.JsonResult;
import com.bs.common.vo.PageObject;
import com.bs.sys.entity.SysTravel;
import com.bs.sys.service.SysTravelService;

@Controller
@RequestMapping("/travel/")
public class SysTravelController {

	@Autowired
	private SysTravelService sysTravelService;
	
	@RequestMapping("doTravelUI")
	public String doTravelUI(){
		return "travel_list";
	}
	
	
	@RequestMapping("findTripObjects")
	@ResponseBody
	public JsonResult findTripObjects(){
		
		return new JsonResult(
		sysTravelService.findTripObjects());
	}
	@RequestMapping("findPageObjects")
	@ResponseBody
	public JsonResult findPageObjects(String travelname,Integer pageCurrent){
		PageObject<SysTravel> data = 
	sysTravelService.findPageObjects(travelname, pageCurrent);
		return new JsonResult(data);
	}
}
