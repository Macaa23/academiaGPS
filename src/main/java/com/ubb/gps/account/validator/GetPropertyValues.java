package com.ubb.gps.account.validator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyValues {
	String[] result = null;
	InputStream inputStream;
 
	public String[] getPropValues() throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = "user.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			// get the property value and print it out
			String user = prop.getProperty("adminUser");
			String password = prop.getProperty("adminPass");
			
			String[] result = {user,password};
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
}
