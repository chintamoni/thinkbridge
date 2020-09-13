package pages;

import org.junit.Assert;

public class Workflows extends DefinitionPage{
	public static void openBrowser(String URL)
	{
		new DefinitionPage();
		launchBrowser(URL);
	} 
	
	
	public static void clickLanguageDropdown()
	{
		if(isLanguageDdnPresent())
		{
		clickLanguageDdn();
		}
		}
	
	public static void isLanguageOptionPresent(String lang1, String lang2)
	
	{
		Assert.assertTrue(verifyLanguages(lang1));
		Assert.assertTrue(verifyLanguages(lang2));
	}
	
public static void selectAnyLanguage(String lang1)
	
	{
	selectLanguage(lang1);
	}

public static void enterUsername(String uname)

{
	enterName(uname);
}

public static void enterOrgname(String oname)

{
	enterOrg(oname);
}

public static void enterUserEmail(String uemail)

{
	enterEmail(uemail);
}

public static void selectTermsAndCondition(String tc)

{
	selectAgreement(tc);
}

public static void clickOnSignUpButton()

{
	if(isSubmitButtonEnabled())
	{
		clickSubmit();
	}
}
	
	public static void waitBrowser(int time)
	{
		waitTillSeconds(time);
	}
	
	public static void stopExecution()
	{
		closeDriver();
	}
}
