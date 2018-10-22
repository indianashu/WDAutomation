package specificPricing;

import baseClassPackage.BaseClasses;
import productDependency.CreateOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateTestScenario1Test {

	CreateTestScenario1Page createOrderPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		createOrderPage = CreateTestScenario1Page.getPage(driver, CreateTestScenario1Page.class);
	}

	@Test(groups = { "Specific Pricing Feature" }, description = "Create Order")
	public void userSignin() throws Exception {

		/*createOrderPage.enterLoginID();
		createOrderPage.enterPassword();
		createOrderPage.selectCompany();
		createOrderPage.clickLoginButton();*/

		createOrderPage.clickCustomerTab();
		createOrderPage.selectCustomer();
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod();
		createOrderPage.selectOrderType();
		
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectProduct();
		createOrderPage.clickUpdateButton();
		createOrderPage.clickSaveChangesButton();
		
		createOrderPage.verifyAmount();
	}
}
