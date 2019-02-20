package com.bs.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping("doCityDetail")
	public String doCityDetail(){
		
		return "city_detail";
	}
	/*@RequestMapping("doCityDetail")
	public ModelAndView doCityDetail(Integer id){
		SysCity cityObject = sysCityService.doFindCityObjectById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("cityObject", cityObject);
		mv.setViewName("city_detail");
		return mv;
	}*/
	@RequestMapping("doFindCityObjectById")
	@ResponseBody
	public JsonResult doFindCityObjectById (Integer id){
		
		return new JsonResult(sysCityService.doFindCityObjectById(id));
	}
	@RequestMapping("findPageObjects")
	@ResponseBody
	public JsonResult findPageObjects(String sheng_name,Integer pageCurrent){
		//模拟耗时操作
		//try{Thread.sleep(5000)};
		//catch(Exception e){e.printStackTrace();}
		PageObject<SysCity> data =sysCityService.
		findPageObjects(sheng_name,pageCurrent);
		return new JsonResult(data);
	}
	
}
