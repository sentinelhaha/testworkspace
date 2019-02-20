package com.bs.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
