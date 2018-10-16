package productDependency;

import baseClassPackage.BaseClasses;
import productDependency.CreateOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrder3Test {

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

		// Create order for customer Olivia
		createOrderPage.clickCustomerTab();
		createOrderPage.selectCustomer2();
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod1();
		createOrderPage.selectOrderType1();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct2();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct2();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.clickUpdateButton();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct3();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.clickUpdateButton1();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct4();
		createOrderPage.clickCurrentOrderButton();
		createOrderPage.clickUpdateButton2();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg();
		createOrderPage.clickGenerateInvoiceButton();
	}
}
