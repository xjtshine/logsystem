package org.woa.logsystem.common;

public class LogException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public LogException(String message){
		
		super(message);
	}
	
	public LogException(Exception e){
		
		super(e);
	}
	
	public LogException(String message, Exception e){
	
		super(message,e);
	}
	
	public LogException(String message, Throwable cause){
		
		super(message,cause);
	}
	
}
