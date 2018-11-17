package specificPricing;

import baseClassPackage.BaseClasses;
import specificPricing.CreateCustomerPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateCustomerTest {
	
	CreateCustomerPage customerPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		customerPage = CreateCustomerPage.getPage(driver, CreateCustomerPage.class);
	}

	@Test(groups = { "Specific Pricing Feature" }, description = "Create Customer")
	public void userSignin() throws Exception {
		
		/*customerPage.enterLoginID();
		customerPage.enterPassword();
		customerPage.selectCompany();
		customerPage.clickLoginButton();*/
		
		customerPage.clickCustomerTab();
		customerPage.createCustomer();
	}
}
