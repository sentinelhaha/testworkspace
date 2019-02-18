package com.bs.sys.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bs.sys.service.FileService;
import com.bs.sys.vo.PicUploadResult;

@Controller
public class FileController {
	
	/*@Autowired
	private FileService fileService;*/
	
	//实现文件上传入门案例
	@RequestMapping("/file")
	@ResponseBody
	public String file(MultipartFile fileImage) throws IllegalStateException, IOException{
		
		//1.判断文件夹是否存在
		File fileDir = new File("E:/jt-upload");
		if(!fileDir.exists()){
			
			fileDir.mkdirs();//创建文件夹
		}
		//abc.jpg
		String fileName = fileImage.getOriginalFilename();
		
		//实现文件上传
		fileImage.transferTo(new File("E:/jt-upload/"+fileName));
		
		//使用重定向技术
		return "redirect:/404";
		//转发
		//return "forword:/file.jsp";
	}
	
	
	/*//实现文件上传
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PicUploadResult uploadFile(MultipartFile uploadFile){
		
		return fileService.uploadFile(uploadFile);
	}*/
}
	