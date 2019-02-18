package com.bs.sys.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import com.bs.sys.vo.PicUploadResult;

public class FileServiceImpl implements FileService{
	private String dirPath = "E:/jt-upload/";
	//定义虚拟路径
	private String urlPath = "http://image.jt.com/";
	
	/**
	 *思路:
	 *	1.校验上传的文件是否为图片   jpg|png|gif
	 *  2.判断文件是否为恶意程序   exe/rpm
	 *  3.为了提高检索效率,一般采用分文件存储  层级最好不要超过5级.
	 *  4.为了防止文件名称重复,采用动态的方式获取文件名称.
	 *  ^开始  $结束  .除了/r/n的任意字符   +一个或者多个 * 没有或者多个 ()  组or 或者
	 */
	@Override
	public PicUploadResult uploadFile(MultipartFile uploadFile) {
		PicUploadResult result = new PicUploadResult();
		//1.校验文件的名称     abc.jpg
		String fileName = uploadFile.getOriginalFilename();
		fileName = fileName.toLowerCase();	//将数据转化为小写
		if(!fileName.matches("^.*\\.(jpg|png|gif)$")){
			result.setError(1);
			return result;	//提前返回
		}
		
		//2.判断是否为恶意程序
		try {
			BufferedImage bufferedImage = 
			ImageIO.read(uploadFile.getInputStream());
			
			int width = bufferedImage.getWidth();
			int height = bufferedImage.getHeight();
			
			if( width == 0 || height == 0){
				
				result.setError(1);//表示不是图片
				return result;
			}
			
			/**
			 * 3.为了提高检索效率,采用分文件存储格式 
			 * yyyy/MM/dd
			 */
			String dateDir = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			
			//4.保证文件不重名  UUID + 随机数0-999
			String uuid = UUID.randomUUID().toString()
					.replace("-", "");
			int random = new Random().nextInt(1000);
			String fileType = 
					fileName.substring(fileName.lastIndexOf("."));
			String uuidFileName = uuid + random + fileType;
			
			//定义文件夹路径 E:/jt-upload/2018/11/11
			String fileDirPath = dirPath + dateDir;
			File fileDir = new File(fileDirPath);
			if(!fileDir.exists()){
				fileDir.mkdirs();
			}
			
			//实现文件上传   E:/jt-upload/2018/11/11/abc.jpg
			File realFilePath = new File(fileDirPath + "/" +uuidFileName);
			uploadFile.transferTo(realFilePath);
			
			//设定宽度和高度
			result.setHeight(height+"");
			result.setWidth(width+"");
			
			/*
			 * 为了实现图片页面访问,拼接虚拟路径
			 * http://image.jt.com/2018/11/11/abc.jpg
			 */ 
			String realUrlPath = urlPath + dateDir + "/" + uuidFileName;
			result.setUrl(realUrlPath);
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setError(1);
		}
	
		return result;
	}
	
}
