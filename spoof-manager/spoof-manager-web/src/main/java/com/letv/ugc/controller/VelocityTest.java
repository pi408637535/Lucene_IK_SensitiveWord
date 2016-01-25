package com.letv.ugc.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;

import com.letv.ugc.pojo.Spoofnews;



@Controller
public class VelocityTest {
	
	/*@Test
	public void testOne() throws Exception{
		Spoofnews information = new Spoofnews();
		information.setContent("打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发,打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发。 打发打发打发的大幅度发，打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发，打发打发打发的大幅度发打发打发打发的大幅度发。 打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发，打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发。 打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发,打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发.");
		String []contents = information.getContent().split(" ");
		information.setComment("哈哈,真是牛逼啊 呵呵 哈哈,真是牛逼啊 呵呵 呵呵呵呵 哈哈,真是牛逼啊 呵呵,呵呵哈哈啦啦呵呵");
		String []comments = information.getComment().split(" ");
		//初始化模板引擎
		Velocity.init("D:\\Git Repository\\Lucene_IK_SensitiveWord\\spoof-manager\\spoof-manager-web\\src\\main\\resources\\properties\\velocity.properties");
		//获取VelocityContext
		VelocityContext context = new VelocityContext();
		//为Context设置变量
		context.put("title", "HelloWorld");
		context.put("informationTitle", "vxcvcxvcxvcx");
		
		context.put("contents", contents);	
		context.put("comments", comments);
		
		File dest = new File("D:\\TestDirectory\\VM\\hello.html");
		FileUtils.writeStringToFile( dest, contents.toString(), "UTF-8" );
		
		//获取模板文件
		Template template = Velocity.getTemplate("information.vm");
		PrintWriter pw=new PrintWriter("D:\\TestDirectory\\VM\\hello.html");
		//使用模板文件的merge函数合并模板和context提供的变量，输出到StringWriter中
		template.merge(context, pw);
		pw.flush();
		pw.close();
	}*/
	
	@Autowired
	private VelocityConfigurer velocityConfigurer;
	@RequestMapping("/saticPage")
	@ResponseBody
	public String testTwo() throws Exception{
		VelocityEngine ve = velocityConfigurer.createVelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");	
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	/*	ve.setProperty("input.encoding", "UTF-8");
		ve.setProperty("output.encoding", "UTF-8");*/
		ve.init();
		//设置静态模板所在
		Template actionTpt = ve.getTemplate("information.vm");
		//PrintWriter pw=new PrintWriter("D:\\TestDirectory\\VM\\hello.html");
		//将模板生成到指定位置
		String path = "D:\\TestDirectory\\VM\\hello.html";
		//将获得的对象放入Velocity的环境上下文中方便取用 
		VelocityContext ctx = new VelocityContext();
		
		Spoofnews information = new Spoofnews();
		information.setContent("打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发,打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发。 打发打发打发的大幅度发，打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发，打发打发打发的大幅度发打发打发打发的大幅度发。 打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发，打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发。 打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发,打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发.");
		String []contents = information.getContent().split(" ");
		information.setComment("哈哈,真是牛逼啊 呵呵 哈哈,真是牛逼啊 呵呵 呵呵呵呵 哈哈,真是牛逼啊 呵呵,呵呵哈哈啦啦呵呵");
		String []comments = information.getComment().split(" ");
		//初始化模板引擎
		//Velocity.init("D:\\Git Repository\\Lucene_IK_SensitiveWord\\spoof-manager\\spoof-manager-web\\src\\main\\resources\\properties\\velocity.properties");
		//获取VelocityContext
		//VelocityContext context = new VelocityContext();
		//为Context设置变量
		ctx.put("title", "HelloWorld");
		ctx.put("informationTitle", "vxcvcxvcxvcx");
		
		ctx.put("contents", contents);	
		ctx.put("comments", comments);
		
		this.merge(actionTpt, ctx, path);
		return "aaaa";
		/*//获取模板文件
		Template template = Velocity.getTemplate("information.vm");
		PrintWriter pw=new PrintWriter("D:\\TestDirectory\\VM\\hello.html");
		//使用模板文件的merge函数合并模板和context提供的变量，输出到StringWriter中
		template.merge(context, pw);
		pw.flush();
		pw.close();*/
	}
	
	/*@Resource
	VelocityEngineFactoryBean velocityEngine;
	@RequestMapping("/saticPageTwo")
	@ResponseBody
	public String testThree() throws Exception{
		Template actionTpt = velocityEngine.createVelocityEngine().getTemplate("velocity/information.vm","utf-8"); 
		VelocityEngine ve = velocityConfigurer.createVelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");	
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.setProperty("input.encoding", "UTF-8");
		ve.setProperty("output.encoding", "UTF-8");
//		ve.init();
		//设置静态模板所在
//		Template actionTpt = ve.getTemplate("information.vm");
		//PrintWriter pw=new PrintWriter("D:\\TestDirectory\\VM\\hello.html");
		//将模板生成到指定位置
		String path = "D:\\TestDirectory\\VM\\hello.html";
		//将获得的对象放入Velocity的环境上下文中方便取用 
		VelocityContext ctx = new VelocityContext();
		
		Spoofnews information = new Spoofnews();
		information.setContent("打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发,打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发。 打发打发打发的大幅度发，打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发，打发打发打发的大幅度发打发打发打发的大幅度发。 打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发，打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发。 打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发,打发打发打发的大幅度发打发打发打发的大幅度发打发打发打发的大幅度发.");
		String []contents = information.getContent().split(" ");
		information.setComment("哈哈,真是牛逼啊 呵呵 哈哈,真是牛逼啊 呵呵 呵呵呵呵 哈哈,真是牛逼啊 呵呵,呵呵哈哈啦啦呵呵");
		String []comments = information.getComment().split(" ");
		//初始化模板引擎
		//Velocity.init("D:\\Git Repository\\Lucene_IK_SensitiveWord\\spoof-manager\\spoof-manager-web\\src\\main\\resources\\properties\\velocity.properties");
		//获取VelocityContext
		//VelocityContext context = new VelocityContext();
		//为Context设置变量
		ctx.put("title", "HelloWorld");
		ctx.put("informationTitle", "vxcvcxvcxvcx");
		
		ctx.put("contents", contents);	
		ctx.put("comments", comments);
		
		this.merge(actionTpt, ctx, path);
		return "aaaa";
		//获取模板文件
		Template template = Velocity.getTemplate("information.vm");
		PrintWriter pw=new PrintWriter("D:\\TestDirectory\\VM\\hello.html");
		//使用模板文件的merge函数合并模板和context提供的变量，输出到StringWriter中
		template.merge(context, pw);
		pw.flush();
		pw.close();
	}*/
	
	private static void merge(Template template, VelocityContext ctx, String path) {
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
}
