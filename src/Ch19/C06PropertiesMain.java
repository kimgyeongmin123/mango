package Ch19;

import java.io.FileInputStream;
import java.util.Properties;

public class C06PropertiesMain {
	
	public static void main(String[] args) {
		
		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream("application.properties");
			properties.load(in);
			
			properties.getProperty("url");
			System.out.println("URL : "+url);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
