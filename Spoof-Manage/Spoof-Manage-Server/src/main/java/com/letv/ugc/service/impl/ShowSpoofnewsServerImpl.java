package com.letv.ugc.service.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.letv.ugc.annotation.NullParamValidation;
import com.letv.ugc.mapper.MaterialMapper;
import com.letv.ugc.pojo.Material;
import com.letv.ugc.pojo.MaterialExample;
import com.letv.ugc.service.ShowSpoofnewsServer;

@Service
public class ShowSpoofnewsServerImpl implements ShowSpoofnewsServer {
	
	@Resource
	MaterialMapper materialMapper;
	
	@Override
	@NullParamValidation(allFieldNames = {"id"})
	public Material showSpoofnews(long id) {
		MaterialExample materiaExample = new MaterialExample();
		com.letv.ugc.pojo.MaterialExample.Criteria criteria = materiaExample.createCriteria();
		criteria.andIdEqualTo(id);
		List<Material> list = materialMapper.selectByExample(materiaExample);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
		
	}

}
