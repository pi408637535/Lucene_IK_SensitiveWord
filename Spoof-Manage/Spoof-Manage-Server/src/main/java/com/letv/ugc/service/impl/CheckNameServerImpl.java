package com.letv.ugc.service.impl;




import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.letv.ugc.analyzer.common.analyzer.AnalyzerCreate;
import com.letv.ugc.analyzer.common.config.AnalyzerConfig;
import com.letv.ugc.annotation.NullParamValidation;
import com.letv.ugc.common.model.ApiCommonJsonResponse;
import com.letv.ugc.common.model.ApiCommonJsonResponseErrCodes;
import com.letv.ugc.mapper.MaterialMapper;
import com.letv.ugc.mapper.SpoofnewsMapper;
import com.letv.ugc.pojo.Material;
import com.letv.ugc.pojo.Spoofnews;
import com.letv.ugc.pojo.SpoofnewsExample;
import com.letv.ugc.pojo.SpoofnewsExample.Criteria;
import com.letv.ugc.service.CheckNameServer;

@Service
public class CheckNameServerImpl implements CheckNameServer{
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(CheckNameServerImpl.class);

	
	
	@Resource
	MaterialMapper materialMapper;
	@Resource
	SpoofnewsMapper spoofnewsMapper;
	
	@Value("${SERVER_BASE_URL}")
	String SERVER_BASE_URL;
	@Value("${SERVER_CONTROLLER}")
	String SERVER_CONTROLLER;
	
	@Override
	@NullParamValidation(allFieldNames = {"replaceName"})
	public ApiCommonJsonResponse nameCheck(String replaceName) {
		/*if(set == null)
			set = readFileByLines(filePath);*/
		
		if(replaceName.length() > 20){
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.TOOLONG,"输入姓名过长");
		}else if(replaceName.length() < 2){
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.TOOShort,"输入姓名过短");
		}else if(Tokenization(replaceName)){
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.VAGUE,"输入姓名中含有隐蔽词");
		}else{
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.CORRECT,"可以使用");
		}
		
	}


	@Override
	@NullParamValidation(allFieldNames = {"replaceName","id"})
	public ApiCommonJsonResponse nameCheck(long id, String replaceName) {
		/*if(set == null)
			set = readFileByLines(filePath);*/
		
		String targetURL = null;
		
		if(replaceName.length() > 15){
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.TOOLONG,"输入姓名过长");
		}else if(replaceName.length() < 2){
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.TOOShort,"输入姓名过短");
		}else if(Tokenization(replaceName)){
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.VAGUE,"输入姓名中含有隐蔽词");
		}else{
			SpoofnewsExample example = new SpoofnewsExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			List<Spoofnews> list =  spoofnewsMapper.selectByExample(example);
			if(list.size() > 0){
				/*
				 * 需要确定id值在表中有这条记录
				 * */
				Spoofnews spoofnews = list.get(0);
				Material material = new Material();
				material.setParentTitle(spoofnews.getParentTitile());
				material.setComment(spoofnews.getComment());
				material.setContent(spoofnews.getContent());
				material.setImageurl(spoofnews.getImageurl());
				material.setReplacename(replaceName);
				material.setSummary(spoofnews.getSummary());
				material.setTitle(spoofnews.getTitle());
			
				materialMapper.insert(material);
				long materialId = material.getId();
				
				targetURL = SERVER_BASE_URL+"/"+SERVER_CONTROLLER+".do?"+"id="+materialId;

			}
			//ApiCommonJsonResponse response = ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.CORRECT,"可以使用");
			
			return ApiCommonJsonResponse.newNormalResponse("targetURL", targetURL);
			
		}
	}
	
	
	/*
	 * 读取文件
	 * 
	 * 已经用spring来处理流
	 * */
	/*public static Set<String> readFileByLines(String fileName) {
	    java.io.File file = new java.io.File(fileName);
        BufferedReader reader = null;
        Set<String> set = new TreeSet<String>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
               // System.out.println("line " + line + ": " + tempString);
                set.add(tempString);
            }
            reader.close();
        } catch (IOException e) {
        	logger.error("[api err, /readFileByLines]", e);
        } finally {
            if (reader != null){
                try {
                    reader.close();   
                }catch (IOException e) {
                	logger.error("[api err, /readFileByLines]", e);
               }
            }
            
        }
		return set;
    }*/
	
	// 系统单例模式
	//static Analyzer analyzer = new IKAnalyzer(true);//IK分词 
	
	//特殊字符检测
	public boolean Tokenization(String word) {
		Analyzer analyzer = AnalyzerCreate.getAnalyzer();
		Set<String> set = AnalyzerConfig.getStopSet();
		boolean flag = false;		
	
		TokenStream token = null;
		try {
			token = analyzer.tokenStream("a", new StringReader(word));
			token.reset();
			CharTermAttribute term=token.addAttribute(CharTermAttribute.class);//term信息 
			
		//	Set<String> tokenString = new HashSet<>();
			while(token.incrementToken()){ 
				//tokenString.add(term.toString());
				if(set.contains(term.toString())){
					flag = true;
					return flag;
				}
			} 
			
		} catch (IOException e) {
			logger.error("[api err, /Tokenization]", e);
		} finally{
			try {
				if(token != null){
					token.end();
					token.close(); 
				}
			}catch (IOException e){
				logger.error("[api err, /Tokenization]", e);
			} 			
		}
		
		return flag;
	}
	
}
