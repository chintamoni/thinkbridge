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

public class Workflow extends DefinitionPage{
	
	static void loginToFacebook()
	{
		getTitle();
		enterUserName();
		enterPassword();
		clickLogin();
	}
	
	static void postStatusMessage()
	{
		clickfbPostArea();
		enterfbPost();
		postSubmit();
	}
	
	static void validateStatusMessage()
	{
		verifyAddedPost();
	}
	
	static void createWalletHubUserAccount()
	{
		loadWalletHubURL();
		enterWHEmail();
		enterWHPassword();
		enterWHConfirmPassword();
		uncheckCreditReport();
		clickWHSubmit();
	}
	
	static void loginWalletHub()
	{
		loadWalletHubURL();
		clickLoginTab();
		enterWHEmail();
		enterWHPassword();
		clickWHSubmit();
	}
	
	static void walletHubScenario()
	{
		mouseOverStars(4,2);
		clickOnRatings(5);
		selectPolicy();
		enterReviewComment();
		submitReview();
	}
	
	public static void afterTest() {
		/*Closing all Browser Sessions*/
		closeDriver();
	}
}
