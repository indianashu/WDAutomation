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

		/*createOrderPage.enterLoginID();
		createOrderPage.enterPassword();
		createOrderPage.selectCompany();
		createOrderPage.clickLoginButton();*/

		// Create order for customer Sophia
		createOrderPage.clickCustomerTab();
		createOrderPage.enterCustomerNameFilter(4);
		createOrderPage.applyFilter();
		createOrderPage.clickCustomerName(4);
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod(0);
		createOrderPage.selectOrderType(1);
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct(4);
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct(0);
		createOrderPage.clickCurrentOrderButton();
		createOrderPage.clickUpdateButton();
		createOrderPage.verifyErrorMsg();
		createOrderPage.enterOrderQuantity("3","5");
		createOrderPage.clickUpdateButton();
		createOrderPage.verifyUpdationMsg();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg();

		String orderid = createOrderPage.extractOrderId();
		System.out.println(orderid);

		createOrderPage.showOrder(orderid);

		String product = createOrderPage.verifyOrderLineSophia();
		System.out.println(product);

		createOrderPage.clickGenerateInvoiceButton(orderid);
		createOrderPage.showOrder(orderid);

		createOrderPage.clickEditthisorder();
		createOrderPage.selectOrderType(0);
		createOrderPage.clickSaveChangesButton();
		createOrderPage.clickGenerateInvoiceButton(orderid);
		String invoiceid = createOrderPage.extractInvoiceId();

		System.out.println(invoiceid);
		createOrderPage.verifyAmountofInvoice(invoiceid);

	}

}
