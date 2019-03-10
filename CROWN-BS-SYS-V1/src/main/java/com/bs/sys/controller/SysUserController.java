package com.bs.sys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.common.vo.JsonResult;
import com.bs.sys.entity.Girl;

@Controller
@RequestMapping("/user/")
public class SysUserController {
	
	@RequestMapping("doUserUI.do")
	public String doUserUI(){
		
		return "user_list";
	}
	@RequestMapping("doMytravel")
	public String doMytravel(){
		return "mytravel_list";
	}
	
	@RequestMapping("getImage")
	@ResponseBody
	public JsonResult getString(HttpServletRequest request){
		List<Girl> girls = new ArrayList<Girl>();
		
		for (int j = 1; j < 8; j++) {
			Girl girl = new Girl();
			girl.setId(j);
			girl.setName("girl"+j);
			girl.setImage(request.getContextPath()+"/images/picture2/"+j+".png");
			girls.add(girl);
			
		}
		
		
		return new JsonResult(girls);
		
	}
	
}
