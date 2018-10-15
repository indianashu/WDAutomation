package ProductDependency;
import baseClassPackage.BaseClasses;
import ProductDependency.CreateCustomerPage;
import productHistorical.AddProduct1Page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateCustomerTest {
	
	CreateCustomerPage addCustomerPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		addCustomerPage = CreateCustomerPage.getPage(driver, CreateCustomerPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Customer for the Child and Parent Company")
	public void userSignin() throws Exception {
		
		addCustomerPage.enterLoginID();
		addCustomerPage.enterPassword();
		addCustomerPage.selectCompany();
		addCustomerPage.clickLoginButton();
		
		addCustomerPage.clickCustomerTab();
		addCustomerPage.createCustomerForParent();

}
}
