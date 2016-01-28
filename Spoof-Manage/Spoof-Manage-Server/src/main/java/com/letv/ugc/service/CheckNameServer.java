package com.letv.ugc.service;



import com.letv.ugc.analyzer.common.exception.InvalidParamException;
import com.letv.ugc.common.model.ApiCommonJsonResponse;

public interface CheckNameServer {
	/*
	 * errCode 
	 * 0 输入户姓名含有隐蔽词
	 * 1 输入姓名多长
	 * 2 输入姓名正确
	 * */
	public int nameCheck(String replaceName) throws InvalidParamException;
	
	/*
	 * 若成功返回的 url在Map中
	 * Map<String,Information>
			targetInfo 
			Spoofnews 中的targetURL是有值的 
	 * */
	public ApiCommonJsonResponse nameCheck(long id,String replaceName);
}
