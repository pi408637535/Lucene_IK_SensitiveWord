package com.letv.ugc.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letv.ugc.common.model.ApiCommonJsonResponse;
import com.letv.ugc.service.InformationService;

@Controller
public class InformationController {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(InformationController.class);
	
	
	@Resource
	InformationService informationService;
	
	@RequestMapping("/informations")
	@ResponseBody
	public ApiCommonJsonResponse getInformation(){
		try{
			return informationService.getItemInformationList();
		}catch(Exception e){
			logger.error("[api err, /repleceOnlyName]", e);
			return ApiCommonJsonResponse.newErrorResponse();
		}
		
	}
	
	
}
