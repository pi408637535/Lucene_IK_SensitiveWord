package com.letv.ugc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letv.ugc.common.model.ApiCommonJsonResponse;
import com.letv.ugc.service.InformationService;

@Controller
public class InformationController {
	
	//private static String DATAISCHANGED = ""; 
	
	@Resource
	InformationService informationService;
	
	@RequestMapping("/informations")
	@ResponseBody
	public ApiCommonJsonResponse getInformation(){
		return ApiCommonJsonResponse.newNormalResponse("informations",informationService.getItemInformationList());
	}
	
	@RequestMapping("/versionInformain")
	@ResponseBody
	public ApiCommonJsonResponse getVersionInformation(){
		return ApiCommonJsonResponse.newNormalResponse("version",informationService.getVersionInformation());	
	}
	
	
	
	@RequestMapping("/updateInformations")
	@ResponseBody
	public String updateInformation(){
		informationService.updateInformations();
		return "Yes";
	}
	
}
