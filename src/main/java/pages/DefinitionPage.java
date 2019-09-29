package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Properties;
import utilities.Utils;


public class DefinitionPage extends BasePage{

	static WebDriver driver=null;
	static Properties prpty=null;
	
	/*Locators relating to Google Search*/
	
	@FindBy(xpath="//*[@id='tsf']//input[@name='q'][@type='text'][@title='Search']")
	static WebElement txtSearch;
	
	@FindBy(xpath="//*[@id='tsf']//*[@class='FPdoLc VlcLAe']//input[@value='Google Search'][@type='submit']")
	static WebElement btnSearch;
	
	@FindBy(xpath="//*[@id='rso']//*[@class='r']/a//h3/div")
	static List<WebElement> listSearchResults;	
	
	@FindBy(xpath="//*[@id='tsf']//ul/li//span")
	static List<WebElement> listAutoSuggesstionOptions;	
	
	static Logger log = Logger.getLogger(DefinitionPage.class.getName());

	public DefinitionPage() {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\logger.properties");
		BasePage bpage = new BasePage();
		log.info("Loading Properties..");
		prpty=bpage.loadPropertiesValue();
		driver=bpage.getBrowser(prpty.getProperty("mh.mhbrowser"));
		log.info("Initialising browser: " + prpty.getProperty("mh.mhbrowser"));
		log.info("Initialising page factory..");
		PageFactory.initElements(driver, this);
	}
	
	public static void launchBrowser(String URL)
	{
		log.info("Browser is launched");
		driver.get(URL);
		Utils.waitUntilPageLoad(driver, 20);
		log.info("Browser is maximised");
		driver.manage().window().maximize();
		Utils.waitUntilPageLoad(driver, 50);
	} 
	
	public static boolean isSearchFieldPresent()
	{
		log.info("Is search field displayed ? " +txtSearch.isDisplayed() );
		return txtSearch.isDisplayed();
	}
	
	protected static void verfiyHomePage()
	{
		log.info("Validating homepage");
		Utils.waitUntilPageLoad(driver, 50);
		log.info("Aserting page title of homepage");
		Assert.assertTrue(getTitle().toUpperCase().contains(prpty.getProperty("mh.mhtitle")));
	    Assert.assertTrue(isSearchFieldPresent());
	}
	
	public static void enterSearchText(String searchText)
	{
		log.info("Entering search text: " + searchText);
		Utils.sendTextByJavaScript(driver,txtSearch,searchText);
		Utils.waitUntilPageLoad(driver, 50);
	}
	
	public static void enterAutoSearchText(String searchText)
	{
		log.info("Entering one by one characters in auto search");
	    for (int i = 0; i < searchText.length(); i++){
	        char c = searchText.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        txtSearch.sendKeys(s);
	        Utils.waitUntilPageLoad(driver, 20);
	    } 
    	//txtSearch.sendKeys(Keys.SPACE);
    	Utils.waitUntilPageLoad(driver, 20);
	}
	
	protected static void clickSearch()
	{
		log.info("Clicking search button");
		Utils.clickByJavaScript(driver, btnSearch);
		Utils.waitUntilPageLoad(driver, 60);
	}
	
	static String getTitle()
	{
	log.info("Current Page title: " + driver.getTitle());	
	return driver.getTitle();
	}
	
	protected static void verifyAutoSuggesstedOptions()
	{
		try {
			listAutoSuggesstionOptions=driver.findElements(By.xpath("//*[@id='tsf']//ul/li//span"));
			log.info("List of options displayed in auto suggession display are - ");
			for(WebElement suggesstedOptions: listAutoSuggesstionOptions)
			{
				log.info(suggesstedOptions.getText());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected static void clickAutoSuggesstedSearchText()
	{
		try {
			listAutoSuggesstionOptions=driver.findElements(By.xpath("//*[@id='tsf']//ul/li//span"));
			log.info("Clicking first auto suggessted text: " +listAutoSuggesstionOptions.get(1) );
			Utils.mouseHoverElement(driver, listAutoSuggesstionOptions.get(1));
			Utils.clickByJavaScript(driver, listAutoSuggesstionOptions.get(1));
			Utils.waitUntilPageLoad(driver, 40);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected static void clickFirstMatchingRecord()
	{
		try {
			listSearchResults=driver.findElements(By.xpath("//*[@id='rso']//*[@class='r']/a//h3/div"));
			for(WebElement searchResult:listSearchResults )
			{
			if((searchResult.getText().toUpperCase().contains(prpty.getProperty("mh.mhFirstSearchResultName").toUpperCase())) && (searchResult.getText().toUpperCase().contains(prpty.getProperty("mh.mhFirstSearchResultAuthor").toUpperCase())))
			{
				log.info("First Matching Record Found: "+searchResult.getText());
				Utils.clickByJavaScript(driver, searchResult);
				break;
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected static void waitTillSeconds(int time)
	{
		Utils.waitUntilPageLoad(driver,time);
	}
	
	protected static void validateBookPage()
	{
		try {
			List<WebElement> verifyPage = driver.findElements(By.xpath("//*[contains(text(),'"+prpty.getProperty("mh.mhFirstSearchResultName")+"') or contains(text(),'"+prpty.getProperty("mh.mhFirstSearchResultAuthor").toUpperCase()+"') or contains(text(),'Books')]"));
			if(verifyPage.size()>0)
			{
				log.info("The Name of the Wind written by Patrick Rothfuss book's page is displayed");
			}
			log.info("Title of the book page: "+ getTitle());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	protected static void closeDriver()
	{
		driver.quit();
		log.info("Quitting all current browser sessions");
	}
}
