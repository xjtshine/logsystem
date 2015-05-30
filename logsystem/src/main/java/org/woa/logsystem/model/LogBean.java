package org.woa.logsystem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LogBean implements Serializable{

	private static final long serialVersionUID = -4565729187659558354L;
	
	private String logId;
	
	private String logType;
	
	private String clientId;
	
	private String agentId;
	
	private String username;
	
	private Date timestamp;
	
	private String currency;
	
	private BigDecimal total;
	
	private String downLoadTimes;
	
	private String activationTimes;
	
	private String paymentTotal;
	
	private String agentPaymentTotal;
	
	private String rate;
	

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public String getDownLoadTimes() {
		return downLoadTimes;
	}

	public void setDownLoadTimes(String downLoadTimes) {
		this.downLoadTimes = downLoadTimes;
	}

	public String getActivationTimes() {
		return activationTimes;
	}

	public void setActivationTimes(String activationTimes) {
		this.activationTimes = activationTimes;
	}

	public String getPaymentTotal() {
		return paymentTotal;
	}

	public void setPaymentTotal(String paymentTotal) {
		this.paymentTotal = paymentTotal;
	}

	public String getAgentPaymentTotal() {
		return agentPaymentTotal;
	}

	public void setAgentPaymentTotal(String agentPaymentTotal) {
		this.agentPaymentTotal = agentPaymentTotal;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logId == null) ? 0 : logId.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogBean other = (LogBean) obj;
		if (StringUtils.isBlank(logId)) {
			if (StringUtils.isNotBlank(other.logId))
				return false;
		} else if (!logId.equals(other.logId))
			return false;
		return true;
	}

	public String toString(){
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("logId",logId)
				.append("logType",logType)
				.append("clientId",clientId)
				.append("agentId",agentId)
				.append("operate time",timestamp)
				.append("user",username)
				.append("currency",currency)
				.append("total",total)
				.toString();
	}

}
