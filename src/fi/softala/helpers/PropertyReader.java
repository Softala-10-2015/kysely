package fi.softala.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	public static final String FILE_NAME = "senderAccount";
	private static PropertyReader instance;
	private Properties properties;

	private PropertyReader() throws IOException{
		//Luetaan property tiedosto
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(FILE_NAME);
		properties = new Properties();
		properties.load(inputStream);
	}

	public String getProperty(String name){
		//Palautetaan haluttu property
		return this.properties.getProperty(name);
	}

	public static PropertyReader getInstance() throws IOException{
		if (instance == null){
			instance = new PropertyReader();
		}
		return instance;
	}
}