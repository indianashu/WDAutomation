package addOnTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import addOn.AddOnTestCase3Page;
import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class AddOnTestCase3 {
	AddOnTestCase3Page testCase3Page;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		testCase3Page = AddOnTestCase3Page.getPage(driver, AddOnTestCase3Page.class);

	}

	@Test(groups = { "Add ON" }, description = "Add ON Order creation")
	public void userSignin() throws Exception {
		/*testCase3Page.enterLoginID();
		testCase3Page.enterPassword();
		testCase3Page.selectCompany();
		testCase3Page.clickLoginButton();*/

		testCase3Page.clickCustomerTab();

		testCase3Page.subscriptionOfPlan();
		testCase3Page.consumptionOfPlan();

	}

	@AfterClass(alwaysRun = false)
	public void tearDown() {
		BaseClasses.closeDriver("User1");
	}

}