package com.letv.ugc.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.letv.ugc.common.model.Information;
import com.letv.ugc.dao.InformationDao;
import com.letv.ugc.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService{
	
	private static Map<String,List<Information>> map = null;
	
	@Resource
	InformationDao informationDao;
	
	
	public Map<String,List<Information>> getItemInformationList() {
		
		if(map == null){
			synchronized (InformationServiceImpl.class) {
				if(map == null){
					map = informationDao.getAllInformations();
				}
			}
		}
		
		return map;
	}
	

	@Override
	public void updateInformations() {
		informationDao.updateVersion();
	}

	@Override
	public long getVersionInformation() {
		return informationDao.getVersion();
	}

	   

}
