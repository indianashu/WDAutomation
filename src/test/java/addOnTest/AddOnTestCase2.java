package addOnTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import addOn.AddOnTestCase2Page;
import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class AddOnTestCase2 {
	AddOnTestCase2Page testCase2Page;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		testCase2Page = AddOnTestCase2Page.getPage(driver, AddOnTestCase2Page.class);

	}

	@Test(groups = { "Add ON" }, description = "Add ON Order creation")
	public void userSignin() throws Exception {
		/*testCase2Page.enterLoginID();
		testCase2Page.enterPassword();
		testCase2Page.selectCompany();
		testCase2Page.clickLoginButton();*/

		testCase2Page.clickCustomerTab();

		testCase2Page.subscriptionOfPlan();
		testCase2Page.consumptionOfPlan();
		

	}
	
	
	}


