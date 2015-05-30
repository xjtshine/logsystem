package org.woa.logsystem.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static Properties properties = new Properties();
	
	private PropertiesUtil(){
		InputStream in = null;
		try {
			
			in = PropertiesUtil.class.getResourceAsStream("/config.properties");
			properties.load(in);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (in != null)
			{
				try {
					in.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}


}
