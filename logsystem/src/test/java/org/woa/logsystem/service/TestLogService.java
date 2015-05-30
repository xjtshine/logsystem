package org.woa.logsystem.service;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.woa.logsystem.basecase.TestBase;
import org.woa.logsystem.model.LogBean;


public class TestLogService extends TestBase{

	@Autowired
	private LogService logService;
	
	@Test
	public void testQueryLog(){
		
		List<LogBean> list = logService.queryLog(1);
		
		for(LogBean logBean : list){
			//assertEquals("3", logBean.getDownLoadTimes());
		}
	}
	
	//@Test
	public void testAddLogToQueue(){
		
		LogBean log1 = new LogBean();
		log1.setLogType("1");
		
		logService.addToQueue(log1);
		
		LogBean log2 = new LogBean();
		
		log2.setLogType("2");
		
		logService.addToQueue(log2);
		
		LogBean log3 = new LogBean();
		
		log3.setLogType("3");
		
		logService.addToQueue(log3);
		
		LogBean log4 = new LogBean();
		
		log4.setLogType("4");
		
		logService.addToQueue(log4);
		
		LogBean log5 = new LogBean();
		
		log5.setLogType("1");
		
		logService.addToQueue(log5);
		
		LogBean log6 = new LogBean();
		
		log6.setLogType("2");
		
		logService.addToQueue(log6);
		
	}
}
