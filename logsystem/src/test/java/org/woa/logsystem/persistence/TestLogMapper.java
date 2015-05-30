package org.woa.logsystem.persistence;

import org.junit.Test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.woa.logsystem.basecase.TestBase;
import org.woa.logsystem.model.LogBean;
import org.woa.logsystem.persistence.LogMapper;

public class TestLogMapper extends TestBase{

@Autowired LogMapper logMapper;
	
	@Test
	public void testQueryAgentDownloadTimes(){
		
		List<LogBean> list = logMapper.queryAgentDownloadTimes();
		
		for(LogBean logBean : list)
		{
			System.err.println(logBean.getAgentId() + ":  " + logBean.getDownLoadTimes());
		}
		
	}

}
