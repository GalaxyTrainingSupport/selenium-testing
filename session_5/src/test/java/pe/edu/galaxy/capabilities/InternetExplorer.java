package pe.edu.galaxy.capabilities;


import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class InternetExplorer {

	public static void main(String[] args) throws InterruptedException {

		InternetExplorerDriver driver = new InternetExplorerDriver();

		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability("nativeEvents", false);
		cap.setCapability("unexpectedAlertBehaviour", "accept");
		cap.setCapability("ignoreProtectedModeSettings", true);
		cap.setCapability("disable-popup-blocking", true);
		cap.setCapability("enablePersistentHover", true);
		cap.setCapability("ignoreZoomSetting", true);
		
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		
		driver.get("https://cacert.com/");
	
	}

}
