package com.bs.sys.dao;


import org.apache.ibatis.annotations.Param;

import com.bs.sys.entity.SysUser;



public interface SysUserDao {
	
	/**
	 * 更新用户自身信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysUser entity);
	
	/**
	 * 负责将用户信息写入到数据库
	 */
	int insertObject(SysUser entity);
	
	
	
	/**
	 * 根据用户名查找用户信息
	 * @param username
	 * @return
	 */
	SysUser findUserByUserName(@Param("user")String user);
	
	/**此方法在部门菜单里可以扩展,暂时未用到*/
	int getUserCountByDeptId(@Param("id")Integer id);

	/**
	 * 查询用户以及用户对应的部门信息
	 * @param id 为用户id
	 * @return 查询结果(值对象)
	 */
	
	
	/**
	 * 负责用户状态的禁用和启动操作
	 * @param id 用户id
	 * @param valid 用户状态
	 * @param modifiedUser 修改用户(系统的登录用户)
	 * @return
	 */
	int validById(@Param("id") Integer id,
				  @Param("valid")Integer valid,
				  @Param("modifiedUser")String modifiedUser);
	
	
	
	/**
	 * 基于用户名查询记录总数
	 * @param username
	 * @return
	 */
	int getRowCount(@Param("username") String username);
	/**
	 * 分页查询用户以及对应的部门信息
	 * @param username
	 * @param startIndex
	 * @param pageCurrent
	 * @return
	 */
	
	
	
}












