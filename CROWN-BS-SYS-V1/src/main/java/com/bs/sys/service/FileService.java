package com.bs.sys.service;

import org.springframework.web.multipart.MultipartFile;

import com.bs.sys.vo.PicUploadResult;

public interface FileService {
	PicUploadResult uploadFile(MultipartFile uploadFile);
}
