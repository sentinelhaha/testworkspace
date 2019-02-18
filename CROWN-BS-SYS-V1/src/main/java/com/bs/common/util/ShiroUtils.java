package com.bs.common.util;

import org.apache.shiro.SecurityUtils;

import com.bs.sys.entity.SysUser;

public class ShiroUtils {
	public static SysUser getPrincipal(){
		return (SysUser) SecurityUtils.getSubject();
	}
}