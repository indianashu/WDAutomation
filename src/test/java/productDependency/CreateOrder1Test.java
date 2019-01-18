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

		/*createOrderPage.enterLoginID();
		createOrderPage.enterPassword();
		createOrderPage.selectCompany();
		createOrderPage.clickLoginButton();*/

		// Create order for customer Leo Holder
		createOrderPage.clickCustomerTab();
		createOrderPage.enterCustomerNameFilter(0);
		createOrderPage.applyFilter();
		createOrderPage.clickCustomerName(0);
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod(0);
		createOrderPage.selectOrderType(0);
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct(0);
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct(0);
		createOrderPage.clickCurrentOrderButton();
		createOrderPage.enterOrderQuantity("2","5");
		createOrderPage.clickUpdateButton();
		createOrderPage.verifyUpdationMsg();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg("Saved Order Successfully For Customer Leo");

		String orderId = createOrderPage.extractOrderId();
		System.out.println(orderId);

		String productName = createOrderPage.verifyOrderLinesLeo();
		System.out.println(productName);

		createOrderPage.clickGenerateInvoiceButton(orderId);
		String invoiceId = createOrderPage.extractInvoiceId();
		createOrderPage.verifyAmountofInvoice(invoiceId);
		System.out.println(invoiceId);

	}
}
