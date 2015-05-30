package org.woa.logsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.woa.logsystem.common.Constants;
import org.woa.logsystem.common.LogException;
import org.woa.logsystem.model.LogBean;
import org.woa.logsystem.service.LogService;

@Scope("prototype")
@Controller
public class LogController {

	private Log logger = LogFactory.getLog(LogController.class);
	
	@Autowired
	private LogService logService;
	
	@RequestMapping(value = "/saveLog/", method = RequestMethod.POST)
	public @ResponseBody Object addLog(@RequestBody LogBean log){
		
		JSONObject result = new JSONObject();  
		
		logger.debug("save log: " + log.toString());
		
		try 
		{
			logService.addToQueue(log);
			
			result.put("msg", "success");  
			
		} catch (LogException e) {
			
			result.put("msg", "failed");  
			logger.error(e);
		}catch (Exception e) {
			
			result.put("msg", "failed");  
			logger.error(e);
		}
		
        return result;  
		
	}
	
	@RequestMapping(value="/queryLog/{queryType}", method = RequestMethod.GET)
	public @ResponseBody Object queryLog(@PathVariable(value = "queryType") String queryType){
		
		logger.debug("queryType: " + queryType);
		
		Map<String, String> resultMap = new HashMap<String, String>();
		
		if(!StringUtils.isNumeric(queryType)){
			
			resultMap.put("msg", "queryType must be a valid number");
		}
		
		int type = Integer.parseInt(queryType);
		
		if(!(type == Constants.SYSTEM_DOWNLOAD_TIMES 
				|| type == Constants.AGNET_DOWNLOAD_TIMES
				|| type == Constants.SYSTEM_ACTIVATION_TIMES
				|| type == Constants.AGENT_ACTIVATION_TIMES
				|| type == Constants.SYSTEM_PAYMENT_TOTAL
				|| type == Constants.AGENT_PAYMENT_TOTAL
				|| type == Constants.SYSTEM_PAYMENT_RATE)){
			
			resultMap.put("msg", "please enter a valid query type");
		}
		
		if(!resultMap.isEmpty()){
			
			return resultMap;
		}
		
		try{
			
			List<LogBean> queryResult = logService.queryLog(type);
			
			for(LogBean logBean : queryResult){
				
				if(type == Constants.SYSTEM_DOWNLOAD_TIMES ){
					
					resultMap.put("downLoadTimes", logBean.getDownLoadTimes());
				}
				else if(type == Constants.AGNET_DOWNLOAD_TIMES){
					
					resultMap.put(logBean.getAgentId(), logBean.getDownLoadTimes());
				}
				else if(type == Constants.SYSTEM_ACTIVATION_TIMES){
					
					resultMap.put("activationTimes", logBean.getActivationTimes());
				}
				else if(type == Constants.AGENT_ACTIVATION_TIMES){
					
					resultMap.put(logBean.getAgentId(), logBean.getActivationTimes());
				}
				else if(type == Constants.SYSTEM_PAYMENT_TOTAL){
					
					resultMap.put("peymentTotal", logBean.getPaymentTotal());
				}
				else if(type == Constants.AGENT_PAYMENT_TOTAL){
					
					resultMap.put(logBean.getAgentId(), logBean.getAgentPaymentTotal());
				}
				else if(type == Constants.SYSTEM_PAYMENT_RATE){
					
					resultMap.put("rate", logBean.getRate());
				}
			}
		}
		catch (LogException e) {
			
			logger.error(e);
		}
		
		return resultMap;
	}
	
}
