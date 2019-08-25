package pages;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;
import java.util.Properties;


import pages.Utils;

public class DefinitionPage extends BasePage{

	static WebDriver driver=null;
	static Properties prpty=null;
	
	/*Locators relating to Facebook*/

	@FindBy(xpath="*//input[@id ='email'][@name='email']")
	static WebElement txtfbUserName;
	
	@FindBy(xpath="*//input[@id ='pass'][@name='pass']")
	static WebElement txtfbPassword;
	
	@FindBy(css="#loginbutton")
	static WebElement btnfbLogin;	
	
	@FindBy(css="#js_br")
	static WebElement txtAreafbPost;
	
	@FindBy(css="#js_br div[id*='placeholder']")
	static WebElement txtfbPost;
	
	@FindBy(xpath="*//div[@id='js_bi']//button/span[contains(text(),'Post')]")
	static WebElement btnfbPostSubmission;
	
	@FindBy(xpath="(*//div[contains(@id,'timeline_story')]/div/div[contains(@id,'tl_unit')]/div[not(contains(@id,'u_ps_fetchstream'))])")
	static List<WebElement> listPosts;
	
	/*Locators relating to WalletHub*/
	
	@FindBy(css="input[name='em']")
	static WebElement txtwhEmail;
	
	@FindBy(css="input[name='pw1']")
	static WebElement txtwhPassword;
	
	@FindBy(css="input[name='pw2']")
	static WebElement txtwhConfirmPassword;	
	
	@FindBy(xpath="*//span[contains(text(),'Get my free credit score & report')]/preceding-sibling::i")
	static WebElement chkFreeCeditReport;	
	
	@FindBy(xpath="//*[@class='btns']//button/span")
	static WebElement btnwhSubmit;	

	@FindBy(xpath="*//li[contains(@ng-class,'login')]/a[contains(text(),'Login')]")
	static WebElement tabLogin;	
	
	@FindBy(xpath="//*[contains(@class,'review-action')]//*[@class='rvs-star-svg']")
	static List<WebElement> starRatings;	
	
	@FindBy(css="write-review > div > ng-dropdown > div > span")
	static WebElement ddnPolicy;
	
	@FindBy(css="write-review > div > ng-dropdown > div > ul > li")
	static List<WebElement> listPolicies;
	
	@FindBy(xpath="//*[@class='android']/textarea")
	static WebElement textAreaReview;
	
	@FindBy(xpath="//*/write-review/sub-navigation//div[contains(text(),'Submit')]")
	static WebElement btnReviewSubmit;
	
	
	public DefinitionPage() {
		BasePage bpage = new BasePage();
		prpty=bpage.loadPropertiesValue();
		driver = bpage.getBrowser(prpty.getProperty("wh.browser"));
		PageFactory.initElements(driver, this);
	}
	
	static void launchBrowser(String URL)
	{
		driver.get(URL);
		Utils.waitUntilPageLoad(driver, 100);
		driver.manage().window().maximize();
		Utils.waitUntilPageLoad(driver, 100);
		System.out.println("Browser is launched");
		Utils.waitUntilPageLoad(driver, 50);
	}
	
	static void enterUserName()
	{
		Utils.sendTextByJavaScript(driver,txtfbUserName,prpty.getProperty("wh.fbuname"));
		Utils.waitUntilPageLoad(driver, 20);
	}
	
	static void enterPassword()
	{
		Utils.sendTextByJavaScript(driver,txtfbPassword,prpty.getProperty("wh.fbpwd"));
		Utils.waitUntilPageLoad(driver, 20);
	}
	
	static void clickLogin()
	{
		Utils.clickByJavaScript(driver, btnfbLogin);
		Utils.waitUntilPageLoad(driver, 300);
	}
	
	static void getTitle()
	{
		launchBrowser(prpty.getProperty("wh.fburl"));
		System.out.println("Page title of Facebook is - " + driver.getTitle());
	}
	
	static void clickfbPostArea()
	{
		Utils.clickByJavaScript(driver, txtAreafbPost);
		Utils.waitUntilPageLoad(driver, 100);
	}
	
	static void enterfbPost()
	{
		Utils.sendTextByJavaScript(driver,txtfbPost,prpty.getProperty("wh.fbstatusmessage"));
		Utils.waitUntilPageLoad(driver, 50);
	}
	
	static void postSubmit()
	{
		Utils.clickByJavaScript(driver, btnfbPostSubmission);
		Utils.waitUntilPageLoad(driver, 500);
	}
	
	static void verifyAddedPost()
	{
		ArrayList<String> statusPosts = new ArrayList<>();
		for(WebElement we: listPosts)
		{
			statusPosts.add(we.findElement(By.xpath("//p")).getText().trim());	
		}
		Assert.assertTrue(statusPosts.contains(prpty.getProperty("wh.fbstatusmessage")));
		Utils.waitUntilPageLoad(driver, 150);
		statusPosts.clear();
	}
	
	static void loadWalletHubURL()
	{
		launchBrowser(prpty.getProperty("wh.whurl"));
		Utils.waitUntilPageLoad(driver, 100);
	}
	
	static void enterWHEmail()
	{
		Utils.sendTextByJavaScript(driver,txtwhEmail,prpty.getProperty("wh.whEmail"));
		Utils.waitUntilPageLoad(driver, 20);
	}
	
	static void enterWHPassword()
	{
		Utils.sendTextByJavaScript(driver,txtwhPassword,prpty.getProperty("wh.whPassword"));
		Utils.waitUntilPageLoad(driver, 20);
	}
	
	static void enterWHConfirmPassword()
	{
		Utils.sendTextByJavaScript(driver,txtwhConfirmPassword,prpty.getProperty("wh.whPassword"));
		Utils.waitUntilPageLoad(driver, 20);
	}
	
	static void uncheckCreditReport()
	{
		Utils.clickByJavaScript(driver,chkFreeCeditReport);
		Utils.waitUntilPageLoad(driver, 20);
	}
	
	static void clickWHSubmit()
	{
		Utils.clickByJavaScript(driver,btnwhSubmit);
		Utils.waitUntilPageLoad(driver, 200);
	}
	
	static void clickLoginTab()
	{
		Utils.clickByJavaScript(driver,tabLogin);
		Utils.waitUntilPageLoad(driver, 100);
	}
	
	static void loginWalletHub()
	{
		launchBrowser(prpty.getProperty("wh.whurl"));
		Utils.waitUntilPageLoad(driver, 100);
		Utils.clickByJavaScript(driver,tabLogin);
		Utils.waitUntilPageLoad(driver, 100);
		Utils.sendTextByJavaScript(driver,txtwhEmail,prpty.getProperty("wh.whEmail"));
		Utils.waitUntilPageLoad(driver, 20);
		Utils.sendTextByJavaScript(driver,txtwhPassword,prpty.getProperty("wh.whPassword"));
		Utils.waitUntilPageLoad(driver, 20);
		Utils.clickByJavaScript(driver,btnwhSubmit);
		Utils.waitUntilPageLoad(driver, 200);
	}
	
	static void mouseOverStars(int rate, int color)
	{
			Utils.mouseHoverElement(driver,starRatings.get(rate));
			Utils.waitUntilPageLoad(driver, 50);
			Assert.assertTrue(driver.findElement(By.xpath("#reviews-section > div.review-stat-box > div.review-action.ng-enter-element > review-star > div > svg:nth-child("+rate+") > g > path:nth-child("+color+")")).getAttribute("stroke").equalsIgnoreCase("#4ae0e1"));
			Utils.waitUntilPageLoad(driver, 50);	
	}
	
	static void clickOnRatings(int rate)
	{
		Utils.mouseHoverElementClick(driver, starRatings.get(rate));
		Utils.waitUntilPageLoad(driver, 250);
	}
	
	static void selectPolicy()
	{
		Utils.clickByJavaScript(driver, ddnPolicy);
		Utils.waitUntilPageLoad(driver, 50);
		for(WebElement we: listPolicies)
		{
			if(we.getText().trim().contains(prpty.getProperty("wh.policy")))
			{
				Utils.clickByJavaScript(driver, we);
				Utils.waitUntilPageLoad(driver, 50);
				break;
			}
		}
	}
	
	static void enterReviewComment()
	{
		Utils.mouseHoverElementClick(driver, textAreaReview);
		Utils.waitUntilPageLoad(driver, 50);
		Utils.sendTextByJavaScript(driver, textAreaReview, prpty.getProperty("wh.reviewComment"));
		Utils.waitUntilPageLoad(driver, 50);
	}
	
	static void submitReview()
	{
		Utils.clickByJavaScript(driver, btnReviewSubmit);
		Utils.waitUntilPageLoad(driver, 50);
	}
	
	static void closeDriver()
	{
		driver.quit();
		System.out.println("Quitting all current browser sessions");
	}
}
