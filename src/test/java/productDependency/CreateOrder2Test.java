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

		
		  /*createOrderPage.enterLoginID(); 
		  createOrderPage.enterPassword();
		  createOrderPage.selectCompany(); 
		  createOrderPage.clickLoginButton();*/
		 

		// Create Order for William
		createOrderPage.clickCustomerTab();
		createOrderPage.enterCustomerNameFilter(1);
		createOrderPage.applyFilter();
		createOrderPage.clickCustomerName(1);
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod(2);
		createOrderPage.selectOrderType(1);
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct(1);
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct(2);
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.enterOrderQuantity("3","6");
		createOrderPage.clickSubOrderUpdateButton();
		createOrderPage.verifyUpdationMsg();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg("Saved Order Successfully For William");

		String orderid = createOrderPage.extractOrderId();
		System.out.println(orderid);

		createOrderPage.verifySubOrders(orderid);
		createOrderPage.showOrder(orderid);

		String product = createOrderPage.verifyOrderLinesWilliam();
		System.out.println(product);

		createOrderPage.clickGenerateInvoiceButton(orderid);
		String invoiceid = createOrderPage.extractInvoiceId();
		System.out.println(invoiceid);
		createOrderPage.verifyAmountofInvoice(invoiceid);

	}
}
