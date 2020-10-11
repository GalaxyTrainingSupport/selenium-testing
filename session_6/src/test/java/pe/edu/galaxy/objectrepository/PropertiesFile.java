package pe.edu.galaxy.objectrepository;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	
	static Properties prop = new Properties();
	static String path  = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		getProperties();

	}

	public static void getProperties() {
		
		try {
			///Users/lruiz/Desktop/selenium-testng/session_6
			InputStream input = new FileInputStream("/Users/lruiz/Desktop/selenium-testng/session_6/data/application.properties");
			prop.load(input);
			System.out.println("Browser -->"+ prop.getProperty("browser"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		}
		
		
		
	}

public static void setProperties() {
		
	}
}
