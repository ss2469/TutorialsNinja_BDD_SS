package com.tutorialsninja.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public static Properties prop;
	public static FileInputStream ip;

	public static Properties initializeConfigPropertiesFile() throws Exception {
		ip = new FileInputStream("src/test/resources/config/Config.properties");
		prop = new Properties();
		prop.load(ip);

		return prop;
	}

}
