package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.CreateEUROParentOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrderEUROParentTest {

	CreateEUROParentOrderPage createEUROParentOrderPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		createEUROParentOrderPage = CreateEUROParentOrderPage.getPage(driver, CreateEUROParentOrderPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Order for the Parent Company & USD Customer")
	public void userSignin() throws Exception {

		/*createEUROParentOrderPage.enterLoginID();
		createEUROParentOrderPage.enterPassword();
		createEUROParentOrderPage.selectCompany();
		createEUROParentOrderPage.clickLoginButton();*/

		// ActiveSince=Past date
		createEUROParentOrderPage.clickCustomerTab();
		createEUROParentOrderPage.addCompanyFilter();
		createEUROParentOrderPage.enterCustomerNameFilter();
		createEUROParentOrderPage.applyFilter();
		createEUROParentOrderPage.selectCustomer();
		createEUROParentOrderPage.clickCreateOrder();
		createEUROParentOrderPage.selectActiveSincePast();
		createEUROParentOrderPage.clickProductSubTab();
		createEUROParentOrderPage.selectCategory();
		createEUROParentOrderPage.selectProduct1();
		createEUROParentOrderPage.selectProduct2();
		createEUROParentOrderPage.selectProduct3();
		createEUROParentOrderPage.clickUpdateButton();
		createEUROParentOrderPage.expectedAmount1();
		createEUROParentOrderPage.clickSave();

		// ActiveSince=Between Past and Present date
		createEUROParentOrderPage.clickCustomerTab();
		createEUROParentOrderPage.addCompanyFilter();
		createEUROParentOrderPage.enterCustomerNameFilter();
		createEUROParentOrderPage.applyFilter();
		createEUROParentOrderPage.selectCustomer();
		createEUROParentOrderPage.clickCreateOrder();
		createEUROParentOrderPage.selectActiveSinceBetweenPastPresent();
		createEUROParentOrderPage.clickProductSubTab();
		createEUROParentOrderPage.selectCategory();
		createEUROParentOrderPage.selectProduct1();
		createEUROParentOrderPage.selectProduct2();
		createEUROParentOrderPage.selectProduct3();
		createEUROParentOrderPage.clickUpdateButton();
		createEUROParentOrderPage.expectedAmount2();
		createEUROParentOrderPage.clickSave();

		// ActiveSince=Between Present and Future Date
		createEUROParentOrderPage.clickCustomerTab();
		createEUROParentOrderPage.addCompanyFilter();
		createEUROParentOrderPage.enterCustomerNameFilter();
		createEUROParentOrderPage.applyFilter();
		createEUROParentOrderPage.selectCustomer();
		createEUROParentOrderPage.clickCreateOrder();
		createEUROParentOrderPage.selectActiveSinceBetweenPresentFuture();
		createEUROParentOrderPage.clickProductSubTab();
		createEUROParentOrderPage.selectCategory();
		createEUROParentOrderPage.selectProduct1();
		createEUROParentOrderPage.selectProduct2();
		createEUROParentOrderPage.selectProduct3();
		createEUROParentOrderPage.clickUpdateButton();
		createEUROParentOrderPage.expectedAmount3();
		createEUROParentOrderPage.clickSave();

		// ActiveSince=Future Date
		createEUROParentOrderPage.clickCustomerTab();
		createEUROParentOrderPage.addCompanyFilter();
		createEUROParentOrderPage.enterCustomerNameFilter();
		createEUROParentOrderPage.applyFilter();
		createEUROParentOrderPage.selectCustomer();
		createEUROParentOrderPage.clickCreateOrder();
		createEUROParentOrderPage.selectActiveSinceFuture();
		createEUROParentOrderPage.clickProductSubTab();
		createEUROParentOrderPage.selectCategory();
		createEUROParentOrderPage.selectProduct1();
		createEUROParentOrderPage.checkApplyNow();
		createEUROParentOrderPage.clickUpdateButton1();
		
		createEUROParentOrderPage.selectProduct2();
		createEUROParentOrderPage.checkApplyNow2();
		createEUROParentOrderPage.clickUpdateButton2();
		
		createEUROParentOrderPage.selectProduct3();
		createEUROParentOrderPage.checkApplyNow3();
		createEUROParentOrderPage.clickUpdateButton();
		
		
		createEUROParentOrderPage.expectedAmount4();
		createEUROParentOrderPage.clickSave();

	}

}
