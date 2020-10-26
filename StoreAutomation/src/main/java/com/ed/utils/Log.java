package com.ed.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {



    synchronized public static Logger getLogData(String className) {
		// TODO Auto-generated method stub
		// String path = new File("").getAbsolutePath();
	        PropertyConfigurator.configure("config/log4j.properties");
	        return Logger.getLogger(className);
	}

}
