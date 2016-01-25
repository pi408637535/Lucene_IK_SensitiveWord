package com.letv.ugc.controller;

import java.io.File;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letv.ugc.common.model.ApiCommonJsonResponse;
import com.letv.ugc.service.DetectionName;


@Controller
public class DetectionNameController {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(DetectionNameController.class);
	
	@Resource 
	DetectionName detectionName;
	
	
	@RequestMapping("/repleceOnlyName")
	@ResponseBody
	public ApiCommonJsonResponse detectOnlyName(String replaceName){
		
		String mydicPath = null;
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
			logger.error("[api err, /repleceOnlyName]", e);
			return ApiCommonJsonResponse.newErrorResponse();
		}
		
		return detectionName.nameCheck(replaceName,  mydicPath);
	}
	
	@RequestMapping("/publishSpoofNews")
	@ResponseBody
	public ApiCommonJsonResponse detectOnlyName(int id,String replaceName,Model model){
		
		String mydicPath = null;
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
		}
		
		return detectionName.nameCheck(id, replaceName, mydicPath);
	}
}
