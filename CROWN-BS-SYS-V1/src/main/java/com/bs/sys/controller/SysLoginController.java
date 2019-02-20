package com.bs.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.common.vo.JsonResult;



@Controller
@RequestMapping("/")
public class SysLoginController {

	@RequestMapping("doPageUI")
	public String doPageUI(){
		return "common/page";
	}
	@RequestMapping("doIndexUI")
	public String doIndexUI(){
		return "index";
	}
	
	@RequestMapping(value={"doLoginUI","doLogout"})
	public String doLogout(){
		return "login";
	}
	/**暂时注释,后面用shiro时开放*/
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username,String password){
		//1.对用户身份以及凭证信息进行封装
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		//2.获取shiro框架中的主体对象
		Subject subject = SecurityUtils.getSubject();
		//3.通过主体对象提交用户token信息
		subject.login(token);
		return new JsonResult("login ok");
	}
	
}
