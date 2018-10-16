package productDependency;

import baseClassPackage.BaseClasses;
import productDependency.CreateOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrder5Test {

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

		// Create order for customer Sophia
		createOrderPage.clickCustomerTab();
		createOrderPage.selectCustomer4();
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod3();
		createOrderPage.selectOrderType3();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct4();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct8();
		createOrderPage.clickCurrentOrderButton();
		createOrderPage.clickUpdateButton8();
		createOrderPage.enterQuantity7();
		createOrderPage.clickUpdateButton12();
		createOrderPage.clickSaveChangesButton();
		// createOrderPage.clickOrderTab();
		createOrderPage.clickCustomerName1();
		createOrderPage.clickGenerateInvoiceButton();
		// createOrderPage.clickOrderTab();
		createOrderPage.clickCustomerName1();
		createOrderPage.clickEditthisorder();
		createOrderPage.selectOrderType4();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.clickGenerateInvoiceButton();

	}

}
