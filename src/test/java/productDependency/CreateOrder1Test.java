package productDependency;

import baseClassPackage.BaseClasses;
import productDependency.CreateOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrder1Test {
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

		createOrderPage.enterLoginID();
		createOrderPage.enterPassword();
		createOrderPage.selectCompany();
		createOrderPage.clickLoginButton();

		// Create order for customer Leo Holder
		createOrderPage.clickCustomerTab();
		createOrderPage.selectCustomer();
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod();
		createOrderPage.selectOrderType();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct();
		createOrderPage.clickCurrentOrderButton();
		createOrderPage.enterQuantity();
		createOrderPage.clickUpdateButton();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg();
		String orderid = createOrderPage.extractOrderId();
		System.out.println(orderid);

		String product1 = createOrderPage.verifyOrderLines();
		System.out.println(product1);

		createOrderPage.clickGenerateInvoiceButton(orderid);
		String invoiceid = createOrderPage.extractInvoiceId();
		createOrderPage.verifyAmount();
		System.out.println(invoiceid);

		createOrderPage.verifyAmount();

	}
}
