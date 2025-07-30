package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLibrary implements FrameworkConstant{
	
	
	static FileInputStream fis;
	
	static FileOutputStream fos;
	
	static Properties property;
	
    public static String fetchData(String key) throws IOException  {
    	
		//1.convert the external file into java understanable
    	try {
             fis = new FileInputStream(propertypath);
             
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}		
		
		Properties property = new Properties();
		property.load(fis);
		
		String s = property.getProperty(key);
		
		return s;

	}

}
