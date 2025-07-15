package com.learning.helper;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesReader {

	private static final Properties URL_PROPERTIES = load("url-strings.properties");
	private static final Properties WP_PROPERTIES = load("wp-login.properties");
	
	private static Properties load(String nameString ) {
		Properties props = new Properties();
		
		try {
			Path path = Paths.get(ClassLoader.getSystemResource(nameString).toURI());
			props.load(new FileInputStream(path.toFile()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return props;
	}
	
	public static String getUrl(String key) {
		return URL_PROPERTIES.getProperty(key);
	}
	
	public static String getWpProp(String key) {
		return WP_PROPERTIES.getProperty(key);
	}
	
}
