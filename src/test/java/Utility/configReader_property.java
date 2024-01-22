package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader_property {
	
	public String Raad_pro_Data(String proTOread) throws IOException {
		
		String path = System.getProperty("user.dir"); //fetch to project path
		
		path = path+"\\src\\test\\resources\\config.properties";
		
		Properties prop =new Properties();
		
		File file =new File(path);
		
		FileInputStream fis =new FileInputStream(file);
		
		prop.load(fis);
		
		String data = prop.getProperty(proTOread);
		
		return data;
		
	}
	
	
}
