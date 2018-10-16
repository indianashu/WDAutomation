package productDependency;

import baseClassPackage.BaseClasses;
import productDependency.CreateOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrder2Test {

	CreateOrderPage createOrderPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		createOrderPage = CreateOrderPage.getPage(driver, CreateOrderPage.class);

	}

	@Test(groups = { "Product Dependency Feature" }, description = "Create Order for the Parent Company & USD Customer")
	public void userSignin() throws Exception {

		/*
		 * createOrderPage.enterLoginID(); 
		 * createOrderPage.enterPassword();
		 * createOrderPage.selectCompany(); 
		 * createOrderPage.clickLoginButton();
		 */

		// Create Order for William
		createOrderPage.clickCustomerTab();
		createOrderPage.selectCustomer1();
		createOrderPage.clickCreateOrder();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct1();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct1();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.enterQuantity1();
		createOrderPage.clickUpdateButton1();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg();
	}
}
