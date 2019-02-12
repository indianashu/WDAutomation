package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.CreateCADParentOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrderCADParentTest {

	CreateCADParentOrderPage createCADParentOrderPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		createCADParentOrderPage = CreateCADParentOrderPage.getPage(driver, CreateCADParentOrderPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Order for the Parent Company & USD Customer")
	public void userSignin() throws Exception {

		/*createCADParentOrderPage.enterLoginID();
		createCADParentOrderPage.enterPassword();
		createCADParentOrderPage.selectCompany();
		createCADParentOrderPage.clickLoginButton();*/

		// ActiveSince=Past date
		createCADParentOrderPage.clickCustomerTab();
		createCADParentOrderPage.addCompanyFilter();
		createCADParentOrderPage.enterCustomerNameFilter();
		createCADParentOrderPage.applyFilter();
		createCADParentOrderPage.selectCustomer();
		createCADParentOrderPage.clickCreateOrder();
		createCADParentOrderPage.selectActiveSincePast();
		createCADParentOrderPage.clickProductSubTab();
		createCADParentOrderPage.selectCategory();
		createCADParentOrderPage.selectProduct1();
		createCADParentOrderPage.selectProduct2();
		createCADParentOrderPage.selectProduct3();
		createCADParentOrderPage.clickUpdateButton();
		createCADParentOrderPage.expectedAmount1();
		createCADParentOrderPage.clickSave();

		// ActiveSince=Between Past and Present date
		createCADParentOrderPage.clickCustomerTab();
		createCADParentOrderPage.addCompanyFilter();
		createCADParentOrderPage.enterCustomerNameFilter();
		createCADParentOrderPage.applyFilter();
		createCADParentOrderPage.selectCustomer();
		createCADParentOrderPage.clickCreateOrder();
		createCADParentOrderPage.selectActiveSinceBetweenPastPresent();
		createCADParentOrderPage.clickProductSubTab();
		createCADParentOrderPage.selectCategory();
		createCADParentOrderPage.selectProduct1();
		createCADParentOrderPage.selectProduct2();
		createCADParentOrderPage.selectProduct3();
		createCADParentOrderPage.clickUpdateButton();
		createCADParentOrderPage.expectedAmount2();
		createCADParentOrderPage.clickSave();

		// ActiveSince=Between Present and Future Date
		createCADParentOrderPage.clickCustomerTab();
		createCADParentOrderPage.addCompanyFilter();
		createCADParentOrderPage.enterCustomerNameFilter();
		createCADParentOrderPage.applyFilter();
		createCADParentOrderPage.selectCustomer();
		createCADParentOrderPage.clickCreateOrder();
		createCADParentOrderPage.selectActiveSinceBetweenPresentFuture();
		createCADParentOrderPage.clickProductSubTab();
		createCADParentOrderPage.selectCategory();
		createCADParentOrderPage.selectProduct1();
		createCADParentOrderPage.selectProduct2();
		createCADParentOrderPage.selectProduct3();
		createCADParentOrderPage.clickUpdateButton();
		createCADParentOrderPage.expectedAmount3();
		createCADParentOrderPage.clickSave();

		// ActiveSince=Future Date
		createCADParentOrderPage.clickCustomerTab();
		createCADParentOrderPage.addCompanyFilter();
		createCADParentOrderPage.enterCustomerNameFilter();
		createCADParentOrderPage.applyFilter();
		createCADParentOrderPage.selectCustomer();
		createCADParentOrderPage.clickCreateOrder();
		createCADParentOrderPage.selectActiveSinceFuture();
		createCADParentOrderPage.clickProductSubTab();
		createCADParentOrderPage.selectCategory();
		createCADParentOrderPage.selectProduct1();
		createCADParentOrderPage.checkApplyNow();
		createCADParentOrderPage.clickUpdateButton1();
		
		createCADParentOrderPage.selectProduct2();
		createCADParentOrderPage.checkApplyNow2();
		createCADParentOrderPage.clickUpdateButton2();
		
		createCADParentOrderPage.selectProduct3();
		createCADParentOrderPage.checkApplyNow3();
		createCADParentOrderPage.clickUpdateButton();
		
		
		createCADParentOrderPage.expectedAmount4();
		createCADParentOrderPage.clickSave();

	}

}
