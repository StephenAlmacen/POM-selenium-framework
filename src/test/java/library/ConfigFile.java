package library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
	private Properties properties;
	private final String propertyFilePath= "configs//Config.properties";
	
	public ConfigFile(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getBrowserType(){
		String browser = properties.getProperty("browser");
		if(browser!= null) return browser;
		else throw new RuntimeException("browser not specified in the Config.properties file.");		
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Config.properties file.");		
	}
	
	public String getURL(){
		String url = properties.getProperty("url");
		if(url!= null) return url;
		else throw new RuntimeException("url not specified in the Config.properties file.");		
	}
	
	public String getDataRepositoryPath(){
		String dataRepositoryPath = properties.getProperty("dataRepositoryPath");
		if(dataRepositoryPath!= null) return dataRepositoryPath;
		else throw new RuntimeException("dataRepositoryPath not specified in the Config.properties file.");		
	}
	
	public String getDriverType(){
		String driverType = properties.getProperty("driverType");
		if(driverType!= null) return driverType;
		else throw new RuntimeException("driverType not specified in the Config.properties file.");		
	}
	
	public long getWaitDuration(){
		String waitDuration = properties.getProperty("waitDuration");
		if(waitDuration != null) return Long.parseLong(waitDuration);
		else throw new RuntimeException("waitDuration not specified in the Config.properties file.");		
	}

}
