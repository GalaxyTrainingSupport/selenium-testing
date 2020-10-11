package pe.edu.galaxy.objectrepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

import pe.edu.galaxy.properties.PropertyBrowser;

public class PropertiesFile {

	static Properties prop = new Properties();
	static String path = System.getProperty("user.dir");

	public static void main(String[] args) {
		getProperties();
		setProperties();

	}

	public static void getProperties() {

		try {
			FileInputStream input = new FileInputStream(path + "/data/application.properties");
			prop.load(input);
			PropertyBrowser.WebBrowser = prop.getProperty("browser");
			System.out.println("Browser -->" + prop.getProperty("browser"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		}

	}

	public static void setProperties() {
		try {
			FileOutputStream output = new FileOutputStream(path + "/data/application.properties");
			prop.setProperty("result", "Past Test");
			prop.store(output, null);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		}

	}
}
