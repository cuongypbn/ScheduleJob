package vn.cmctelecom.scheduler.contants;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


//@PropertySource(value = "classpath:application-${env}.properties", encoding = "UTF-8")
public class ConfigProperties {
	private static final Properties properties = new Properties();
	
	public static String getConfigProperties(String key, String fileName){
		return getConfigProperties(key, key, fileName);
	}
	public static String getConfigProperties(String key, String dfValue, String fileName){
		String value = dfValue;
		try {
//			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
//			if(properties.containsKey(key)){
//				value = properties.getProperty(key, dfValue);
//			}
			
			InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			properties.load(new InputStreamReader(input, "UTF-8"));
			if(properties.containsKey(key)){
				value = properties.getProperty(key, dfValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}

