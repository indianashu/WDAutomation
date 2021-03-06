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

		
		 /* createOrderPage.enterLoginID(); 
		  createOrderPage.enterPassword();
		  createOrderPage.selectCompany(); 
		  createOrderPage.clickLoginButton();*/
		 

		// Create order for customer Isabella
		createOrderPage.clickCustomerTab();
		createOrderPage.enterCustomerNameFilter(3);
		createOrderPage.applyFilter();
		createOrderPage.clickCustomerName(3);
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod(0);
		createOrderPage.selectOrderType(0);
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct(3);
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct(0);
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.enterOrderQuantity("2","6");
		createOrderPage.clickSubOrderUpdateButton();
		createOrderPage.verifyErrorMsg();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct(1);
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.clickSubOrderUpdateButton();
		createOrderPage.verifyErrorMsg();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct(2);
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.enterOrderQuantity("4","12");
		createOrderPage.clickSubOrderUpdateButton();
		createOrderPage.verifyUpdationMsg();
		createOrderPage.clickSaveChangesButton();
		createOrderPage.verifyConfirmationMsg("Saved Order Successfully For Isabella");

		String orderid = createOrderPage.extractOrderId();
		System.out.println(orderid);

		createOrderPage.verifySubOrders(orderid);

		createOrderPage.showOrder(orderid);

		String product = createOrderPage.verifyOrderLineIsabella();
		System.out.println(product);

		createOrderPage.clickGenerateInvoiceButton(orderid);
		String invoiceid = createOrderPage.extractInvoiceId();

		System.out.println(invoiceid);
		createOrderPage.verifyAmountofInvoice(invoiceid);
	}
}
