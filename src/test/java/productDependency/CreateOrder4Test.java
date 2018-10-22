package productDependency;

import baseClassPackage.BaseClasses;
import productDependency.CreateOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrder4Test {

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
		 * createOrderPage.enterLoginID(); createOrderPage.enterPassword();
		 * createOrderPage.selectCompany(); createOrderPage.clickLoginButton();
		 */

		// Create order for customer Isabella
		createOrderPage.clickCustomerTab();
		createOrderPage.selectCustomer3();
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod2();
		createOrderPage.selectOrderType2();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct3();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct5();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.clickUpdateButton();
		createOrderPage.enterQuantity5();
		createOrderPage.clickUpdateButton();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder1();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct6();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.clickUpdateButton();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder1();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct7();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.enterQuantity6();
		createOrderPage.clickUpdateButton();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg();

		String orderid = createOrderPage.extractOrderId();
		System.out.println(orderid);

		createOrderPage.verifySubOrders(orderid);

		createOrderPage.showOrder(orderid);

		String product = createOrderPage.verifyOrderLine3();
		System.out.println(product);

		String generateinvoice = createOrderPage.clickGenerateInvoiceButton(orderid);
		String invoiceid = createOrderPage.extractInvoiceId();

		System.out.println(invoiceid);
		createOrderPage.verifyAmountofInvoice(invoiceid);
	}
}
