package productDependency;

import baseClassPackage.BaseClasses;
import productDependency.CreateOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrder6Test {

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

		/*createOrderPage.enterLoginID();
		createOrderPage.enterPassword();
		createOrderPage.selectCompany();
		createOrderPage.clickLoginButton();*/

		// Create Order for Jacob
		createOrderPage.clickCustomerTab();
		createOrderPage.clickCustomerName(5);
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod(2);
		createOrderPage.selectOrderType(1);
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct(5);
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct(1);
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.enterSubOrderQuantity("2");
		createOrderPage.clickSubOrderUpdateButton();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct(2);
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.enterQuantity10();
		createOrderPage.clickSubOrderUpdateButton();
		createOrderPage.clickSaveChangesButton();

		String orderid = createOrderPage.extractOrderId();
		System.out.println(orderid);

		createOrderPage.verifySubOrders(orderid);

		createOrderPage.showOrder(orderid);

		createOrderPage.clickGenerateInvoiceButton(orderid);
		String invoiceid = createOrderPage.extractInvoiceId();

		System.out.println(invoiceid);
		createOrderPage.verifyAmountofInvoice(invoiceid);
	}
}
