package com.letv.ugc.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.letv.ugc.common.model.ApiCommonJsonResponse;
import com.letv.ugc.common.model.ApiCommonJsonResponseErrCodes;
import com.letv.ugc.mapper.SpoofnewsMapper;
import com.letv.ugc.pojo.Spoofnews;
import com.letv.ugc.pojo.SpoofnewsExample;
import com.letv.ugc.pojo.SpoofnewsExample.Criteria;
import com.letv.ugc.service.DetectionName;


@Service
public class DetectionNameImpl implements DetectionName {

	private static Logger logger = org.slf4j.LoggerFactory.getLogger(DetectionNameImpl.class);
	
	@Resource
	SpoofnewsMapper spoofnewsMapper;
	

	private static Set<String> set = null;
	
	
	/*
	 * 字符长度可以放在配置文件中
	 * */
	@Override
	public ApiCommonJsonResponse nameCheck(String replaceName, String filePath) {
		if(set == null)
			set = readFileByLines(filePath);
		
		/*System.out.println(ApiCommonJsonResponseErrCodes.CORRECT.getCode());
		System.out.println(ApiCommonJsonResponseErrCodes.VAGUE.getCode());
		System.out.println(ApiCommonJsonResponseErrCodes.TOOLONG.getCode());
		System.out.println(replaceName);
		System.out.println(replaceName);
		System.out.println("set sieze=" + set.size());
		System.out.println(set.contains(replaceName));*/
		
		
		/*
		if(set.contains(replaceName)){
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.VAGUE,"输入姓名中含有隐蔽词");
		}else if(replaceName.length() > 20){
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.TOOLONG,"输入姓名多长");
		}else{
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.CORRECT,"可以使用");
		}*/
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
	public ApiCommonJsonResponse nameCheck(int id, String replaceName, String filePath) {
		if(set == null)
			set = readFileByLines(filePath);
		
		String url = "ugcpm/wodetoutiao";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());
		/*
		 * 先进行检测对输入的姓名
		 * 当姓名检测合格后对文章进行拷贝其中包含新地址的URL
		 * */
		Spoofnews newSpoof = null;
		
		if(replaceName.length() > 15){
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.TOOLONG,"输入姓名过长");
		}else if(replaceName.length() < 2){
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.TOOShort,"输入姓名过短");
		}else if(Tokenization(replaceName)){
			return ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.VAGUE,"输入姓名中含有隐蔽词");
		}else{
			SpoofnewsExample example = new SpoofnewsExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo((long)id);
			List<Spoofnews> list =  spoofnewsMapper.selectByExample(example);
			if(list.size() > 0){
				/*
				 * 需要确定id值在表中有这条记录
				 * */
				Spoofnews oldSpoof = list.get(0);
					
				newSpoof = new Spoofnews();
				newSpoof.setTargetcontent(oldSpoof.getContent().replace("$姓名$", replaceName));
				newSpoof.setTargetsummary(oldSpoof.getSummary().replace("$姓名$", replaceName));
				
				newSpoof.setTargeturl("www.baidu.com");
				
				
				newSpoof.setTitle(oldSpoof.getTitle());
				newSpoof.setComment(oldSpoof.getComment());				
				newSpoof.setSummary(oldSpoof.getComment());
				
				spoofnewsMapper.insert(newSpoof);
			}
			//ApiCommonJsonResponse response = ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.CORRECT,"可以使用");
			
			return ApiCommonJsonResponse.newNormalResponse("targetURL", newSpoof.getTargeturl());
			
		}
		
	}
	
	static Analyzer analyzer = new IKAnalyzer(true);//IK分词 
	
	public boolean Tokenization(String word) {
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
			
			/*for(Iterator<String> iterator = tokenString.iterator(); iterator.hasNext();){
				String string = iterator.next();
				if(set.contains(string)){
					flag = true;
					return flag;
				}
			}*/
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	/*
	 * 读取文件
	 * */
	public static Set<String> readFileByLines(String fileName) {
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
    }
}
