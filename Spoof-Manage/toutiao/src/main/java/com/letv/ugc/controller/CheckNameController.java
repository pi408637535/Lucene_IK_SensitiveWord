package com.letv.ugc.controller;


import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letv.ugc.common.model.ApiCommonJsonResponse;
import com.letv.ugc.service.CheckNameServer;

@Controller
public class CheckNameController {
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(CheckNameController.class);
	
	@Resource
	CheckNameServer checknameService;

	@RequestMapping("/repleceOnlyName")
	@ResponseBody
	public ApiCommonJsonResponse detectOnlyName(String replaceName){
		
		return checknameService.nameCheck(replaceName);
	}
	
	@RequestMapping("/publishSpoofNews")
	@ResponseBody
	public ApiCommonJsonResponse detectOnlyName(String id,String replaceName){
		
		/*String mydicPath = null;
		try {
			 java.net.URL urls =this.getClass().getResource("");
			 //str会得到这个函数所在类的路径
			 String str = urls.toString();
			//截去file：/
			str = str.substring(6, str.length());
			str = str.replaceAll("%20", " ");
			int num = str.indexOf("classes");
		    str = str.substring(0, num + "classes".length());
		    mydicPath = str+File.separator+ "mydic.dic";
		    System.out.println("mydicPath："+mydicPath);
		   // System.out.println(str+File.separator+ "mydic.dic");
		} catch (Exception e) {
			logger.error("[api err, /publishSpoofNews]", e);
			return ApiCommonJsonResponse.newErrorResponse();
		}*/
		
		/*
		 * 客户端传的id类型是String防止恶意空值
		 * */	
		long convertId;
		try{
			convertId = Long.valueOf(id).longValue();
		}catch (Exception e) {
			logger.error("[api err, /publishSpoofNews]", e);
			return ApiCommonJsonResponse.newErrorResponse();
		}
		return checknameService.nameCheck( convertId, replaceName);
	}
	
}
