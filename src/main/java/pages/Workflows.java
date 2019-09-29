package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Utils;

public class Workflows extends DefinitionPage{
	public static void openBrowser(String URL)
	{
		new DefinitionPage();
		launchBrowser(URL);
	} 
	
	public static void isSearchFieldExists()
	{
		isSearchFieldPresent();
	}
	
	public static void isHomePageDisplayed()
	
	{
		verfiyHomePage();
	}
	
	public static void specifySearchText(String searchText)
	{
		enterSearchText(searchText);
	}
	
	public static void specifyAutoSearchText(String searchText)
	{
		enterAutoSearchText(searchText);
	}
	
	public static void performSearch()
	{
		clickSearch();	
	}
	
	public static String getUrlTitle()
	{
		return getTitle();
	}
	
	public static void validateAutoSuggstOptions()
	{
		verifyAutoSuggesstedOptions();
	}
	
	public static void clickFirstAutoSuggstOption()
	{
		clickAutoSuggesstedSearchText();
	}

	public static void openFirstWebSearchResult()
	{
		clickFirstMatchingRecord();
	}
	
	public static void waitBrowser(int time)
	{
		waitTillSeconds(time);
	}
	
	public static void assertBookPage()
	{
		validateBookPage();
	}
	
	public static void stopExecution()
	{
		closeDriver();
	}
}
