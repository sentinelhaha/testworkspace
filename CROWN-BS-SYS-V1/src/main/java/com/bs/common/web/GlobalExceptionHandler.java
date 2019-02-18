package com.bs.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
/**
 * @ControllerAdvice注解修饰的类为spring mvc中的全局异常处理类
 */
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.common.vo.JsonResult;


/**
 * @ControllerAdvice 注解修饰的类为全局异常处理类
 * @author ta
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	  /**
	   * @ExceptionHandler 注解描述的方法为一个异常处理
	   * 方法
	   * @param e
	   * @return 封装了异常信息的JsonResult对象
	   */
	  @ExceptionHandler(RuntimeException.class)
	  @ResponseBody
	  public JsonResult doHandleRuntimeException(
			  RuntimeException e){
		  e.printStackTrace();
		  return new JsonResult(e);
	  }//jackson
	  
}

