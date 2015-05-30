package org.woa.logsystem.service;

import java.util.List;

import org.woa.logsystem.model.LogBean;

public interface LogService {

	/**
	 * 添加日志到队列中
	 * @param log
	 */
	public void addToQueue(LogBean log);
	
	/**
	 * 保存日志
	 * @param log
	 */
	public void saveLog(LogBean log);
	
	/**
	 * 日志查询
	 * @param queryType
	 * @param agentId
	 * @return 根据不同的查询类型，返回查询结果
	 */
	public List<LogBean> queryLog(int queryType);
	
}
