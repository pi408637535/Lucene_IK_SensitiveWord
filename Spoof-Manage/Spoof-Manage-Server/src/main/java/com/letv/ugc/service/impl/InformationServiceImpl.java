package com.letv.ugc.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.letv.ugc.common.model.Information;
import com.letv.ugc.mapper.SpoofnewsMapper;
import com.letv.ugc.mapper.VersionMapper;
import com.letv.ugc.pojo.Spoofnews;
import com.letv.ugc.pojo.SpoofnewsExample;
import com.letv.ugc.pojo.SpoofnewsExample.Criteria;
import com.letv.ugc.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService{
	
	@Resource
	SpoofnewsMapper spoofnewsMapper;
	@Resource
	VersionMapper versioinMapper;
	
	
	/*
	 * 将spoofnews类替换成information 减少流量传输
	 * */
	/*
	public ApiCommonJsonResponse getItemInformationList() {
		//调用递归方法查询商品分类列表
		Map<String,List<Spoofnews>> map = getItemList(0l);
		//返回结果
		return ApiCommonJsonResponse.newNormalResponse("informations",map);

	}*/
	
	public Map<String,List<Information>> getItemInformationList() {
		
		
		//调用递归方法查询商品分类列表
		return getItemList(0l);
		//返回结果
		//ApiCommonJsonResponse response = ApiCommonJsonResponse.newNormalResponse("informations",map);
		//response.setVersion("" + version);
		//return response;
	}
	
	/*
	public Map<String,List<Spoofnews>> getItemList(long parentId){
		SpoofnewsExample spoofnewsExample = new SpoofnewsExample();
		Criteria criteria = spoofnewsExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//criteria.andIsParentEqualTo(parentId);
		List<Spoofnews> list = spoofnewsMapper.selectByExample(spoofnewsExample);
		Map<String,List<Spoofnews>> map = new HashMap<String,List<Spoofnews>>();
		
		for(Spoofnews spoofItem:list){
			if(1 == spoofItem.getIsParent()){
				map.put(spoofItem.getTitle(), getItem(spoofItem.getId()));
			}
		}
		
		return map;
	}*/
	
	
	
	public Map<String,List<Information>> getItemList(long parentId){
		SpoofnewsExample spoofnewsExample = new SpoofnewsExample();
		Criteria criteria = spoofnewsExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//criteria.andIsParentEqualTo(parentId);
		List<Spoofnews> list = spoofnewsMapper.selectByExample(spoofnewsExample);
		Map<String,List<Information>> map = new HashMap<String,List<Information>>();
		
		for(Spoofnews spoofItem:list){
			if(1 == spoofItem.getIsParent()){
				map.put(spoofItem.getTitle(), getItem(spoofItem.getId()));
			}
		}
		
		return map;
	}
	
	/*
	public List<Spoofnews> getItem(long parentId){
		SpoofnewsExample spoofnewsExample = new SpoofnewsExample();
		Criteria criteria = spoofnewsExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//criteria.andIsParentEqualTo(parentId);
		List<Spoofnews> listSpoof = spoofnewsMapper.selectByExample(spoofnewsExample);
		return listSpoof;
	}*/
	
	
	
	
	
	public List<Information> getItem(long parentId){
		SpoofnewsExample spoofnewsExample = new SpoofnewsExample();
		Criteria criteria = spoofnewsExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//criteria.andIsParentEqualTo(parentId);
		List<Spoofnews> listSpoof = spoofnewsMapper.selectByExample(spoofnewsExample);
		
		List<Information> listInformation = new ArrayList<Information>();
		Information information = null;
		for(Spoofnews spoof:listSpoof){
			information = new Information();
			information.setContent(spoof.getContent());
			
			//System.out.println(spoof.getImageurl());
			
			information.setImageurl(spoof.getImageurl());
			information.setSummary(spoof.getSummary());
			information.setTitle(spoof.getTitle());			
			information.setId(spoof.getId());
			
			listInformation.add(information);
		}
		
		return listInformation;
	}

	@Override
	public void updateInformations() {
		versioinMapper.insertVersion();
	}

	@Override
	public long getVersionInformation() {
		return versioinMapper.getVersionMax();	
	}

	   

}
