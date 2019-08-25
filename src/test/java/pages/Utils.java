package pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utils {

	public static void waitUntilPageLoad(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public static void mouseHoverElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void mouseHoverElementClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).build().perform();
		waitUntilPageLoad(driver,100);
	}

	public static void clickByJavaScript(WebDriver driver, WebElement element) {
		final JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public static void sendTextByJavaScript(WebDriver driver, WebElement element, String num) {
		final JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[1].value = arguments[0]; ", num, element);
	}

	public static void jsScrllDown(WebDriver driver) {
		final JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void jsScrllDownPartial(WebDriver driver) {
		final JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("scroll(0, 600);");
	}

	public static void jsScrollUp(WebDriver driver) {
		final JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
	
}