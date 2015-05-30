package org.woa.logsystem.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.woa.logsystem.model.LogBean;
import org.woa.logsystem.persistence.LogMapper;
import org.woa.logsystem.service.LogService;

import org.woa.logsystem.common.Constants;
import org.woa.logsystem.common.LogException;
import org.woa.logsystem.common.PropertiesUtil;

public class LogServiceImpl implements LogService{

	@Autowired
	private LogMapper logMapper;
	
	private Log logger = LogFactory.getLog(LogServiceImpl.class);

	List<LogBean> logList = Collections.synchronizedList(new ArrayList<LogBean>());
	
	
	public void addToQueue(LogBean log){
		
		logger.debug("add log to queue: " + log.toString());
		
		log.setLogId(UUID.randomUUID().toString().replaceAll("-", ""));
		
		String queueSize = PropertiesUtil.getProperty("logQueueSize");
		
		if(StringUtils.isBlank(queueSize)){
			
			queueSize = "5";
		}
		
		if(logList.size() >= Integer.parseInt(queueSize)){
			
			saveLog(logList);
		}
		
		logList.add(log);
	}
	
	public void saveLog(List<LogBean> logList) {
		try {
			
			logger.debug("save logs: " + logList.toString());
			
			logMapper.saveLogBatch(logList);
			logList.clear();
		} 
		catch (Exception e) {
			
			logger.error(e);
			throw new LogException(e);
		}
	}
	
	public void saveLog(LogBean log){
		
		log.setLogId(UUID.randomUUID().toString().replaceAll("-", ""));
		
		logger.debug("save log: " + log.toString());
		logMapper.saveLog(log);
	}

	public List<LogBean> queryLog(int queryType) {
		
		List<LogBean> result = new ArrayList<LogBean>();
		
		logger.debug("query log [query type: " + queryType);
		
		try{
			
			if(queryType == Constants.SYSTEM_DOWNLOAD_TIMES){
				
				LogBean logBean = logMapper.queryTotalDownloadTimes();
				if(null != logBean){
					
					result.add(logBean);
				}
				
			}
			else if(queryType == Constants.AGNET_DOWNLOAD_TIMES){
				
				result = logMapper.queryAgentDownloadTimes();
				
			}
			else if(queryType == Constants.SYSTEM_ACTIVATION_TIMES){
				
				LogBean logBean = logMapper.queryClientActivationTimes();
				if(null != logBean){
					
					result.add(logBean);
				}
			}
			else if(queryType == Constants.AGENT_ACTIVATION_TIMES){
						
				result = logMapper.queryClientAgentActivationTimes();
			}
			else if(queryType == Constants.SYSTEM_PAYMENT_TOTAL){
				
				LogBean logBean = logMapper.queryPaymentTotal();
				if(null != logBean){
					
					result.add(logBean);
				}
			}
			else if(queryType == Constants.AGENT_PAYMENT_TOTAL){
				
				result = logMapper.queryAgentPaymentTotal();
			}
			else if(queryType == Constants.SYSTEM_PAYMENT_RATE){
				
				LogBean logBean = logMapper.queryPaymentRate();
				if(null != logBean){
					
					result.add(logBean);
				}
			}
		}
		catch (Exception e) {
			throw new LogException(e);
		}
		
		logger.debug("query result: " + result);
		
		return result;
	}
	
}
