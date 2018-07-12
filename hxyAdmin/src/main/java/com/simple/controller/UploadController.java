package com.simple.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.simple.common.rest.ResultData;
import com.simple.config.FastDFSClientWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@RestController
@Api(description="上传文件")
public class UploadController {
	
	 	@Autowired
	    private FastDFSClientWrapper dfsClient;
	 	
	 	 private Logger logger = Logger.getLogger(UploadController.class);
	 	 
	 	  @Value("${fdfs.webPath}")
	 	  private String webPath;

	    // 上传文件
	    @PostMapping(value = "/upload", consumes="multipart/*"
	    		,headers="content-type=multipart/form-data" )
	    public ResultData upload(@ApiParam(value="文件上传") MultipartFile file) {
	    	ResultData data =new ResultData();
	       try {
	    	   String halfUrl =dfsClient.uploadFile(file);
	    	   String fullUrl =webPath+"/"+halfUrl;
	    	   Map<String,String> map =new HashMap<>();
	    	   map.put("halfUrl", halfUrl);
	    	   map.put("fullUrl", fullUrl);
	    	   map.put("fileName", file.getOriginalFilename());
	    	   data.data=map;
	       }catch(Exception e) {
	    	   logger.error("上传失败", e);
	    	   data = new ResultData(ResultData.ERROR,"上传失败");
	       }
	        return data;

	    }
}
