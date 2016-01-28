package com.letv.ugc.service;



import java.util.List;
import java.util.Map;

import com.letv.ugc.common.model.Information;

public interface InformationService {
	public Map<String,List<Information>> getItemInformationList();
	public void updateInformations();
	public long getVersionInformation();
}
