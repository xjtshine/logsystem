package org.woa.logsystem.persistence;

import java.util.List;

import org.woa.logsystem.model.LogBean;

public interface LogMapper {
	/**
	 * 保存日志
	 * @param logBean
	 */
	public void saveLog(LogBean logBean);
	
	/**
	 * 批量保存日志
	 * @param logList
	 */
	public void saveLogBatch(List<LogBean> logList);
	
	/**
	 * 查询当天的下载总次数
	 * @return 查询结果
	 */
	public LogBean queryTotalDownloadTimes();
	
	/**
	 * 查询当天每个代理商的下载总次数
	 * @param agentId 代理商ID
	 * @return 查询结果
	 */
	public List<LogBean> queryAgentDownloadTimes();
	
	/**
	 * 当天不重复客户端ID的激活总次数
	 * @return 查询结果
	 */
	public LogBean queryClientActivationTimes();
	
	/**
	 * 当天不重复客户端ID分每个代理商的激活总次数
	 * @return 查询结果
	 */
	public List<LogBean> queryClientAgentActivationTimes();
	
	/**
	 * 当天总付费金额
	 * @return 查询结果
	 */
	public LogBean queryPaymentTotal();
	
	/**
	 * 当天每个代理商的付费金额
	 * @return 查询结果
	 */
	public List<LogBean> queryAgentPaymentTotal();
	
	/**
	 * 系统付费率：当天付费客户端ID数除以当天有过登录操作的客户端ID数
	 * @return 查询结果
	 */
	public LogBean queryPaymentRate();
	
}
