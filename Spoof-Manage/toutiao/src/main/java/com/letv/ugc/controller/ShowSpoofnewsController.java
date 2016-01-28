package com.letv.ugc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.letv.ugc.pojo.Material;
import com.letv.ugc.service.ShowSpoofnewsServer;

@Controller
public class ShowSpoofnewsController {
	
	@Resource
	ShowSpoofnewsServer showSpoofnewsServer; 
	
	
	@RequestMapping("/showSpoof")
	public ModelAndView listLatest(long id){
		
		
		ModelAndView model = null;
		
		
		Material material = showSpoofnewsServer.showSpoofnews(id);
		if(material != null){
			model = new ModelAndView("information");
			
			SimpleDateFormat dfNow = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
			String dateNow = dfNow.format(new Date());
			String []contents = material.getContent().split(" ");
			String []comments = material.getComment().split("</p>");
			
			
			
			model.addObject("parenttitle", material.getParentTitle());
			model.addObject("title", material.getTitle());
			
			model.addObject("data", dateNow);
			model.addObject("contents", contents);
			model.addObject("comments", comments);
			
			
			
	        return model;
		}else{
			model = new ModelAndView("error");
			return model;
		}
    }
	
	@RequestMapping("/index")
	public String listLatest(Model model,long id){
		
		model.addAttribute("message", "Hi, I am Velocity");
		model.addAttribute("id", id);
		return "index";  
		
	}
}	
