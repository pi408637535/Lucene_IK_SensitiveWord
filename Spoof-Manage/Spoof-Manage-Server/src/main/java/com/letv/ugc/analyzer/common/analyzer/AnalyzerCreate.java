package com.letv.ugc.analyzer.common.analyzer;



import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.lucene.analysis.Analyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.letv.ugc.analyzer.common.config.AnalyzerConfig;

public class AnalyzerCreate {
	private static Analyzer analyzer = null;
	private static Lock instanceLock = new ReentrantLock();
	private static Logger logger = LoggerFactory.getLogger(AnalyzerConfig.class);
	
	public static Analyzer getAnalyzer(){
		if(analyzer == null){
    		instanceLock.lock();
    		try{   			
    			if(analyzer == null){
    				AnalyzerCreate.createStopSet();  //粗粒度分词
    			}
    				
    		} catch(Exception e){
    			logger.error("create Analyzer error, {} ", e.getMessage(), e);
    		}finally{  			    			
    			instanceLock.unlock();  
    		}
    	}
    	return analyzer;
    }
    
    public static void createStopSet(){
    	analyzer = new IKAnalyzer(true);//IK分词 
    	//return stopSet;
    }
}
