package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;


public class DefinitionPage extends BasePage{

	static WebDriver driver=null;
	static Properties prpty=null;
	
	/*Locators relating to azurewebsites*/
	
	@FindBy(xpath="//*[@id='language']")
	static WebElement fieldLanguageDdn;
	
	@FindBy(xpath="//*[@id='language']//ul//a/div")
	static List<WebElement> listLanguages;
	
	@FindBy(css="#name")
	static WebElement fieldName;	
	
	@FindBy(css="#orgName")
	static WebElement fieldOrganization;
	
	@FindBy(css="#singUpEmail")
	static WebElement fieldEmail;
	
	@FindBy(xpath="*//label[@class='ui-checkbox']/span")
	static WebElement chkAgreeTerms;
	
	@FindBy(xpath="*//button")
	static WebElement btnSubmit;
	
	static Logger log = Logger.getLogger(DefinitionPage.class.getName());

	public DefinitionPage() {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\logger.properties");
		BasePage bpage = new BasePage();
		log.info("Loading Properties..");
		prpty=bpage.loadPropertiesValue();
		driver=bpage.getBrowser(prpty.getProperty("tb.tbbrowser"));
		log.info("Initialising browser: " + prpty.getProperty("tb.tbbrowser"));
		log.info("Title of the page is : "+getTitle());
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
	
	public static boolean isLanguageDdnPresent()
	{
		return fieldLanguageDdn.isDisplayed();
	}
	
	public static void clickLanguageDdn()
	{
		fieldLanguageDdn.click();
		 log.info("clicking language dropdown...");
	}
	
	public static boolean verifyLanguages(String lang)
	{
		boolean isExist = false;
		ArrayList<String> al = new ArrayList<>();
		for(WebElement we:listLanguages )
		{
			al.add(we.getText().trim().toUpperCase());
		}
		if(al.contains(lang.toUpperCase()))
		{
			isExist=true;
			log.info("language "+lang+" is found under language dropdown");
		}
		else
		{
			log.info("language "+lang+" is not found under language dropdown");
		}
		return isExist;
	}
	
	
	public static void selectLanguage(String lang)
	{
		for(WebElement we:listLanguages )
		{
			if(we.getText().trim().equalsIgnoreCase(lang))
			{
				we.click();
				log.info("Language is selected as :" +lang );
				break;
			}
			else
			{
				log.info("Unable to select language as "+lang+" please specify correct language");
			}
		}
	}
	
	public static void enterName(String uname)
	{
		fieldName.sendKeys(uname);
		log.info("Entering users name as : " + uname);
	}
	
	public static void enterOrg(String uorg)
	{
		fieldOrganization.sendKeys(uorg);
		log.info("Entering users organization as : " + uorg);
	}
	
	public static void enterEmail(String uemail)
	{
		fieldEmail.sendKeys(uemail);
		log.info("Entering users email as : " + uemail);
	}
	
	public static void selectAgreement(String agree)
	{
		if(agree.equalsIgnoreCase("yes"))
		{
		chkAgreeTerms.click();
		log.info("Selecting Terms and Conditions checkbox...");
		}
		else
		{
			log.info("Please set value for terms and conditions as true for submitting the registration");
		}
	}
	
	
	public static boolean isSubmitButtonEnabled()
	{
		return btnSubmit.isDisplayed();
	}
	
	public static void clickSubmit()
	{
		btnSubmit.submit();
		log.info("Submitting the Form...");
	}
		
	public static boolean verifyMail(String userName, String password, String message) { 
		Folder folder = null; 
		Store store = null; 
		System.out.println("***READING MAILBOX..."); 
		try { 
			Properties props = new Properties(); 
			props.put("mail.store.protocol", "imaps"); 
			Session session = Session.getInstance(props); 
			store = session.getStore("imaps"); 
			store.connect("imap.gmail.com", userName, password); 
			folder = store.getFolder("INBOX"); 
			folder.open(Folder.READ_ONLY); 
			Message[] messages = folder.getMessages(); 
			System.out.println("No of Messages : " + folder.getMessageCount()); 
			System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount()); 
			for (int i = 0; i < messages.length; i++) { 
				System.out.println("Reading MESSAGE # " + (i + 1) + "..."); 
				Message msg = messages[i]; 
				String strMailSubject = "", strMailBody = ""; 
				// Getting mail subject 
				Object subject = msg.getSubject(); 
				// Getting mail body 
				Object content = msg.getContent(); 
				// Casting objects of mail subject and body into String 
				strMailSubject = (String) subject; 
				//---- This is what you want to do------ 
				if (strMailSubject.contains(message)) { 
					log.info(strMailSubject); 
					break; 
				} 
			} 
			return true; 
		} catch (MessagingException messagingException) { 
			messagingException.printStackTrace(); 
		} catch (IOException ioException) { 
			ioException.printStackTrace(); 
		} finally { 
			if (folder != null) { 
				try { 
					folder.close(true); 
				} catch (MessagingException e) { 
					// TODO Auto-generated catch block 
					e.printStackTrace(); 
				} 
			} 
			if (store != null) { 
				try { 
					store.close(); 
				} catch (MessagingException e) { 
					// TODO Auto-generated catch block 
					e.printStackTrace(); 
				} 
			} 
		} 
		return false; 
	}
	
	static String getTitle()
	{
	log.info("Current Page title: " + driver.getTitle());	
	return driver.getTitle();
	}
	
	protected static void waitTillSeconds(int time)
	{
		Utils.waitUntilPageLoad(driver,time);
	}
	
	protected static void closeDriver()
	{
		driver.quit();
		log.info("Closing all current browser sessions");
	}
}
