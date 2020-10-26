package com.ed.configDataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	protected static Properties properties;
	protected static final String propertyFilePath = "config//Configuration.properties";

	public ConfigFileReader() {
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
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	
	public String getAppUrl() {
		String url = properties.getProperty("appUrl");
		if (url != null) {
			return url;
		}

		else
			throw new RuntimeException("driverPath not specified in the configuration.properties file");
	}

	public String getOS() {
		String os = properties.getProperty("OS");
		if (os != null) {
			return os;
		}

		else
			throw new RuntimeException("driverPath not specified in the configuration.properties file");
	}

	

	public long getImplicitWait() {
		String implicitWait = properties.getProperty("implicitWait");
		if (implicitWait != null) {
			return Long.parseLong(implicitWait);
		} else
			throw new RuntimeException("Implicit not specified in the configuration.properties file.");

	}

	public String getBrowserType() {
		String browserType = properties.getProperty("browserType");

		if (browserType != null) {
			return browserType;
		}

		else
			throw new RuntimeException("browserType not specified in the configuration.properties file");

	}
}
