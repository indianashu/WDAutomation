package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.CreateOrderPage;
import productHistorical.CreateOrderPage01;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrderUSDParentTest01 {

	CreateOrderPage01 createOrderPage1;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		createOrderPage1 = CreateOrderPage01.getPage(driver, CreateOrderPage01.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Order for the Parent Company & USD Customer")
	public void userSignin() throws Exception {

		createOrderPage1.enterLoginID();
		createOrderPage1.enterPassword();
		createOrderPage1.selectCompany();
		createOrderPage1.clickLoginButton();

		// ActiveSince=Past date
		createOrderPage1.clickCustomerTab();
		createOrderPage1.addCompanyFilter();
		createOrderPage1.selectCustomerName();
		createOrderPage1.clickCreateOrder();
		createOrderPage1.selectActiveSincePast();
		createOrderPage1.clickProductSubTab();
		createOrderPage1.selectCategory();
		createOrderPage1.selectProduct1();
		createOrderPage1.selectProduct2();
		createOrderPage1.selectProduct3();
		createOrderPage1.clickUpdateButton();
		createOrderPage1.expectedAmount1();
		createOrderPage1.clickSave();

		/*// ActiveSince=Between Past and Present date
		createOrderPage1.clickCustomerTab();
		createOrderPage1.addCompanyFilter();
		createOrderPage1.selectCustomerName();
		createOrderPage1.clickCreateOrder();
		createOrderPage1.selectActiveSinceBetweenPastPresent();
		createOrderPage1.clickProductSubTab();
		createOrderPage1.selectCategory();
		createOrderPage1.selectProduct1();
		createOrderPage1.selectProduct2();
		createOrderPage1.selectProduct3();
		createOrderPage1.clickUpdateButton();
		createOrderPage1.expectedAmount2();
		createOrderPage1.clickSave();

		// ActiveSince=Between Present and Future Date
		createOrderPage1.clickCustomerTab();
		createOrderPage1.addCompanyFilter();
		createOrderPage1.selectCustomerName();
		createOrderPage1.clickCreateOrder();
		createOrderPage1.selectActiveSinceBetweenPresentFuture();
		createOrderPage1.clickProductSubTab();
		createOrderPage1.selectCategory();
		createOrderPage1.selectProduct1();
		createOrderPage1.selectProduct2();
		createOrderPage1.selectProduct3();
		createOrderPage1.clickUpdateButton();
		createOrderPage1.expectedAmount3();
		createOrderPage1.clickSave();

		// ActiveSince=Future Date
		createOrderPage1.clickCustomerTab();
		createOrderPage1.addCompanyFilter();
		createOrderPage1.selectCustomerName();
		createOrderPage1.clickCreateOrder();
		createOrderPage1.selectActiveSinceFuture();
		createOrderPage1.clickProductSubTab();
		createOrderPage1.selectCategory();
		createOrderPage1.selectProduct1();
		createOrderPage1.selectProduct2();
		createOrderPage1.selectProduct3();
		createOrderPage1.clickUpdateButton();
		createOrderPage1.expectedAmount4();
		createOrderPage1.clickSave();*/

	}

}
