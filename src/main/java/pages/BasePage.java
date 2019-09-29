package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasePage {
	
	ChromeOptions options = new ChromeOptions();
	DesiredCapabilities caps = DesiredCapabilities.chrome();
	private WebDriver driver=null;
	private Properties property=null;
	
	public WebDriver getBrowser(String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("chrome")){
				ChromeOptions options = new ChromeOptions();
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/exes/chromedriver.exe");
				String downloadFilePath = System.getProperty("user.dir")+"/src/main/java/downloads/";
				HashMap<String, Object> chromePref = new HashMap<String, Object>();
				chromePref.put("download.default_directory", downloadFilePath);
				options.setExperimentalOption("prefs", chromePref);
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver(caps);
				System.out.println("Intialising chrome browser");
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
				driver=new FirefoxDriver();
				System.out.println("Intialising firefox browser");
		}
		else if(BrowserName.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();
			System.out.println("Intialising ie browser");
		}
		return driver;
	}
	
	public Properties loadPropertiesValue()
	{
      Properties prop = new Properties();
	  try {
			  InputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/properties/masglobal.properties");
          // load a properties file
          prop.load(input);
      } catch (IOException ex) {
          ex.printStackTrace();
      }
	  return prop;
	}

}
