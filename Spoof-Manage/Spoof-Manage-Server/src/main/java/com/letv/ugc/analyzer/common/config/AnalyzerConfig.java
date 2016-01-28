package com.letv.ugc.analyzer.common.config;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnalyzerConfig {
	private static Set<String> stopSet = null;
	private static BufferedReader reader  = null;
	private static Lock instanceLock = new ReentrantLock();
	private static Logger logger = LoggerFactory.getLogger(AnalyzerConfig.class);
	
	 /**
     * 加载analyzer 文件流
     */
    static {
        InputStream in = AnalyzerConfig.class.getResourceAsStream("/mydic.dic");
        InputStreamReader isr = new InputStreamReader(in);
        reader = new BufferedReader(isr);
    }
    
    public static Set<String> getStopSet(){
    	if(stopSet == null){
    		instanceLock.lock();
    		try{
    			
    			if(stopSet == null){
    				AnalyzerConfig.createStopSet();
    				String tempString = null;
    	            while ((tempString = reader.readLine()) != null) {
    	               // System.out.println("line " + line + ": " + tempString);
    	            	stopSet.add(tempString);
    	            }
    			}
    			
    		}catch(IOException e){
    			logger.error("[api err, /readFileByLines]", e);
    		}finally{  			
    			try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.error("[api err, /readFileByLines]", e);
				}
    			instanceLock.unlock();  
    		}
    	}
    	return stopSet;
    }
    
    public static void createStopSet(){
    	stopSet = new HashSet<String>();
    	//return stopSet;
    }
    
    
}
