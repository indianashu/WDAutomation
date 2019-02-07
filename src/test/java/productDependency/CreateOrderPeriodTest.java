package productDependency;

import baseClassPackage.BaseClasses;
import productDependency.CreateOrderPeriodPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrderPeriodTest {
	
	CreateOrderPeriodPage orderperiodPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		orderperiodPage = CreateOrderPeriodPage.getPage(driver, CreateOrderPeriodPage.class);

	}

	@Test(groups = { "Product Dependency Feature" }, description = "Create OrderPeriod for the  Parent Company")
	public void userSignin() throws Exception {

		orderperiodPage.enterLoginID();
		orderperiodPage.enterPassword();
		orderperiodPage.selectCompany();
		orderperiodPage.clickLoginButton();
		orderperiodPage.clickOrderPeriods();

		boolean isPresent = orderperiodPage.checkSemiMonthlyisPresent();
		System.out.println(isPresent);
		if (isPresent == true) {
			orderperiodPage.clickAddNewButton();
			orderperiodPage.enterDescription();
			orderperiodPage.selectUnit();
			orderperiodPage.enterValue();
			orderperiodPage.clickSaveChangesButton();
			orderperiodPage.verifyConfirmationMsg("Order Period Saved Successfully");
		}
	}
}
