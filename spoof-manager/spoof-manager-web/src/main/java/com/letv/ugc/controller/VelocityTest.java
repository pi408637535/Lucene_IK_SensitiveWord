package com.letv.ugc.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;
import org.springframework.stereotype.Controller;

//@Controller
public class VelocityTest {
	
	@Test
	public void testOne() throws FileNotFoundException{
		//初始化模板引擎
		Velocity.init("F:\\Eclipse_EE_Mars\\spoof-manager\\spoof-manager-web\\src\\main\\resources\\properties\\velocity.properties");
		//获取VelocityContext
		VelocityContext context = new VelocityContext();
		//为Context设置变量
		context.put("title", "HelloWorld");
		context.put("author", "arthinking");
		VelocityTest velocity = new VelocityTest();
		velocity.setName("fdsfds");
		Student student = new Student();
		student.setAge(10);
		context.put("student", student);
		context.put("velocityTest", velocity);
		
		System.out.println(student.getAge());
		//获取模板文件
		Template template = Velocity.getTemplate("helloworld.vm");
		PrintWriter pw=new PrintWriter("F:\\TestDirectory\\Spoof App\\vm\\hello.html");
		//使用模板文件的merge函数合并模板和context提供的变量，输出到StringWriter中
		template.merge(context, pw);
		pw.flush();

		System.out.println(pw);
	}
}
