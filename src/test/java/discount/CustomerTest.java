package discount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClassPackage.BaseClasses;
import discount.CustomerPage;
import utilPackages.PropertyValExtractors;

public class CustomerTest {
	
	CustomerPage customerPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		customerPage = CustomerPage.getPage(driver, CustomerPage.class);
}
	@Test(groups = { "Discount Feature" }, description = "Create Customers")
	public void userSignin() throws Exception {

		/*customerPage.enterLoginID();
		customerPage.enterPassword();
		customerPage.selectCompany();
		customerPage.clickLoginButton();*/
		
		customerPage.clickCustomerTab();
		customerPage.createCustomer();
	}
}



