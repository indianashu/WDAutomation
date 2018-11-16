package productDependency;

import baseClassPackage.BaseClasses;
import productDependency.CreateOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
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

		/*
		 * createOrderPage.enterLoginID(); 
		 * createOrderPage.enterPassword();
		 * createOrderPage.selectCompany(); 
		 * createOrderPage.clickLoginButton();
		 */

		// Create Order for Jacob
		createOrderPage.clickCustomerTab();
		createOrderPage.selectCustomer5();
		createOrderPage.clickCreateOrder();
		createOrderPage.selectPeriod5();
		createOrderPage.selectOrderType5();
		createOrderPage.clickProductsSubTab();
		createOrderPage.selectCategory();
		createOrderPage.selectProduct5();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct9();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.enterQuantity9();
		createOrderPage.clickUpdateButton2();
		createOrderPage.clickDetailsTab();
		createOrderPage.clickNew();
		createOrderPage.clickParentOrder2();
		createOrderPage.clickPlusdependency();
		createOrderPage.clickDependentProduct10();
		createOrderPage.clickNewSubOrderButton();
		createOrderPage.clickUpdateButton3();
		createOrderPage.enterQuantity10();
		createOrderPage.clickUpdateButton3();
		createOrderPage.clickSaveChangesButton();

		String orderid = createOrderPage.extractOrderId();
		System.out.println(orderid);

		createOrderPage.verifySubOrders4(orderid);

		String orderlineid = createOrderPage.gotourlbar(orderid);
		System.out.println(orderlineid);

		String generateinvoice = createOrderPage.clickGenerateInvoiceButton(orderid);
		String invoiceid = createOrderPage.extractInvoiceId();

		createOrderPage.verifyAmount5();
	}
	
	@AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
}
