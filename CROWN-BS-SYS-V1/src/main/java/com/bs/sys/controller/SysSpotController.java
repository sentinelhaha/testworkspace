package com.bs.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.common.vo.JsonResult;
import com.bs.common.vo.PageObject;
import com.bs.sys.entity.SysSpot;
import com.bs.sys.service.SysSpotService;

@Controller
@RequestMapping("/spot/")
public class SysSpotController {
	@Autowired
	private SysSpotService sysSpotService;
	
	
	
	@RequestMapping("doSpotUI")
	public String doSpotUI(){
		return "spot_list";
	}
	@RequestMapping("findPageObjects")
	@ResponseBody
	public JsonResult findPageObjects(String spotname,Integer pageCurrent){
		PageObject<SysSpot> data = sysSpotService.findPageObjects(
				spotname, pageCurrent);
		return new JsonResult(data);
	}
	
	
	
}




