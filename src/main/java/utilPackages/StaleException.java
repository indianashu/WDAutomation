package utilPackages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class StaleException {
	public WebDriver driver;
	static Logger log = Logger.getLogger(JavaScriptExec.class);

	public StaleException(WebDriver driver) {
		this.driver = driver;
	}

	public static boolean retryingFindClick(By by, WebDriver driver) throws StaleElementReferenceException{
		boolean result = false;
		int attempts = 0;
		while (attempts < 10) {
			try {
				JavaScriptExec.sleep();
				System.out.println("Trying to find the Element whose path = " + by);
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("In the Stale Element Reference Exception");
				e.printStackTrace();
			}
			attempts++;
		}
		return result;
	}
}
