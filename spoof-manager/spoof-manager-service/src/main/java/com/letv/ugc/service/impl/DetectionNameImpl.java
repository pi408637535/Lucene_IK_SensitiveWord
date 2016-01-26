package com.letv.ugc.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.letv.ugc.common.model.ApiCommonJsonResponse;
import com.letv.ugc.common.model.ApiCommonJsonResponseErrCodes;
import com.letv.ugc.common.utils.SeparatorUtils;
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
	
	@Resource
	private VelocityConfigurer velocityConfigurer;

	private static Set<String> set = null;
	
	
	/*
	 * 字符长度可以放在配置文件中
	 * Spring进行扫描
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
		
		
		String targetURL = null;
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
				
				//临时的url
				newSpoof.setTargeturl(" ");
				
				
				newSpoof.setTitle(oldSpoof.getTitle());
				newSpoof.setContent(" ");			
				newSpoof.setComment(oldSpoof.getComment());
				newSpoof.setSummary(oldSpoof.getSummary());
				newSpoof.setParentTitile(oldSpoof.getParentTitile());
				newSpoof.setParentId((long)-1);
				newSpoof.setIsParent(0);
				
				
				
				spoofnewsMapper.insert(newSpoof);
				targetURL = this.generatorStaticPage(newSpoof);
			}
			//ApiCommonJsonResponse response = ApiCommonJsonResponse.newErrorResponse(ApiCommonJsonResponseErrCodes.CORRECT,"可以使用");
			
			return ApiCommonJsonResponse.newNormalResponse("targetURL", targetURL);
			
		}
		
	}
	
	@Value("${SERVER_BASE_URL}")
	private String SERVER_BASE_URL;
	@Value("${SERVER_FILE_PATH}")
	private String SERVER_FILE_PATH;
	
	
	/*
	 * 生成资源页面
	 * ①需要一个SpoofNews类用于填充静态模板
	 * ②将生成的html返回URL. URL格式 wodetoutiao+ date + 文章id
	 * */
	public String generatorStaticPage(Spoofnews spoofnews){
		//String url = "wodetoutiao";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
		String date = df.format(new Date());
		
		SpoofnewsExample example = new SpoofnewsExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(spoofnews.getId());
		String targetURL = SERVER_FILE_PATH +SeparatorUtils.getFileSeparator()  + date 
			 +SeparatorUtils.getFileSeparator() + spoofnews.getId();
		
		spoofnews.setTargeturl(targetURL+".html");
		spoofnewsMapper.updateByExample(spoofnews, example);
		
		
		
		VelocityEngine ve = null;
		try {
			ve = velocityConfigurer.createVelocityEngine();
		} catch (VelocityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");	
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	
		/*	ve.setProperty("input.encoding", "UTF-8");
		ve.setProperty("output.encoding", "UTF-8");*/
		ve.init();
		//设置静态模板所在
		Template actionTpt = ve.getTemplate("information.vm");
		//PrintWriter pw=new PrintWriter("D:\\TestDirectory\\VM\\hello.html");
		//将模板生成到指定位置
		String path =  targetURL + ".html";
		//将获得的对象放入Velocity的环境上下文中方便取用 
		VelocityContext ctx = new VelocityContext();
		
		//Spoofnews information = new Spoofnews();
		
		//内容
		//information.setContent(spoofnews.getTargetcontent());
		//String []contents = information.getContent().split(" ");
		String []contents = spoofnews.getTargetcontent().split(" ");
		//评论
		//information.setComment(spoofnews.getComment());
		//String []comments = information.getComment().split(" ");
		String []comments = spoofnews.getComment().split(" ");
		
		//初始化模板引擎
		//Velocity.init("D:\\Git Repository\\Lucene_IK_SensitiveWord\\spoof-manager\\spoof-manager-web\\src\\main\\resources\\properties\\velocity.properties");
		//获取VelocityContext
		//VelocityContext context = new VelocityContext();
		//为Context设置变量
		ctx.put("parentTitle", spoofnews.getParentTitile());
		ctx.put("title", spoofnews.getTitle());

		SimpleDateFormat dfNow = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
		String dateNow = dfNow.format(new Date());
		ctx.put("date", dateNow);
		
		ctx.put("contents", contents);	
		ctx.put("comments", comments);
		
		this.merge(actionTpt, ctx, path);
		return spoofnews.getTargeturl();
	}
	
	private void merge(Template template, VelocityContext ctx, String path) {
	 PrintWriter writer = null;
	 try {
		 writer = new PrintWriter(path);
		 template.merge(ctx, writer);
		 writer.flush();
	 	} catch (FileNotFoundException e) {
	 		e.printStackTrace();
	 	} finally {
	 		writer.close();
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
