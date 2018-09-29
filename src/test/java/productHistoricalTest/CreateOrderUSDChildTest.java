package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.CreateUSDChildOrderPage;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrderUSDChildTest {

	CreateUSDChildOrderPage createUSDChildOrderPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		createUSDChildOrderPage = CreateUSDChildOrderPage.getPage(driver, CreateUSDChildOrderPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Order for the Child Company & USD Customer")
	public void userSignin() throws Exception {

		createUSDChildOrderPage.enterLoginID();
		createUSDChildOrderPage.enterPassword();
		createUSDChildOrderPage.selectCompany();
		createUSDChildOrderPage.clickLoginButton();
		
		createUSDChildOrderPage.clickImpersonate();
		createUSDChildOrderPage.selectChildCompany();
		createUSDChildOrderPage.clickOKButton();

		// ActiveSince=Past date
		createUSDChildOrderPage.clickCustomerTab();
		createUSDChildOrderPage.selectCustomer();
		createUSDChildOrderPage.clickCreateOrder();
		createUSDChildOrderPage.selectActiveSincePast();
		createUSDChildOrderPage.clickProductSubTab();
		createUSDChildOrderPage.selectCategory();
		createUSDChildOrderPage.selectProduct1();
		createUSDChildOrderPage.selectProduct2();
		createUSDChildOrderPage.selectProduct3();
		createUSDChildOrderPage.clickUpdateButton();
		createUSDChildOrderPage.expectedAmount1();
		createUSDChildOrderPage.clickSave();

		// ActiveSince=Between Past and Present date
		createUSDChildOrderPage.clickCustomerTab();
		createUSDChildOrderPage.selectCustomer();
		createUSDChildOrderPage.clickCreateOrder();
		createUSDChildOrderPage.selectActiveSinceBetweenPastPresent();
		createUSDChildOrderPage.clickProductSubTab();
		createUSDChildOrderPage.selectCategory();
		createUSDChildOrderPage.selectProduct1();
		createUSDChildOrderPage.selectProduct2();
		createUSDChildOrderPage.selectProduct3();
		createUSDChildOrderPage.clickUpdateButton();
		createUSDChildOrderPage.expectedAmount2();
		createUSDChildOrderPage.clickSave();

		// ActiveSince=Between Present and Future Date
		createUSDChildOrderPage.clickCustomerTab();
		createUSDChildOrderPage.selectCustomer();
		createUSDChildOrderPage.clickCreateOrder();
		createUSDChildOrderPage.selectActiveSinceBetweenPresentFuture();
		createUSDChildOrderPage.clickProductSubTab();
		createUSDChildOrderPage.selectCategory();
		createUSDChildOrderPage.selectProduct1();
		createUSDChildOrderPage.selectProduct2();
		createUSDChildOrderPage.selectProduct3();
		createUSDChildOrderPage.clickUpdateButton();
		createUSDChildOrderPage.expectedAmount3();
		createUSDChildOrderPage.clickSave();

		// ActiveSince=Future Date
		createUSDChildOrderPage.clickCustomerTab();
		createUSDChildOrderPage.selectCustomer();
		createUSDChildOrderPage.clickCreateOrder();
		createUSDChildOrderPage.selectActiveSinceFuture();
		createUSDChildOrderPage.clickProductSubTab();
		createUSDChildOrderPage.selectCategory();
		createUSDChildOrderPage.selectProduct1();
		createUSDChildOrderPage.checkApplyNow();
		createUSDChildOrderPage.clickUpdateButton1();
		
		createUSDChildOrderPage.selectProduct2();
		createUSDChildOrderPage.checkApplyNow2();
		createUSDChildOrderPage.clickUpdateButton2();
		
		createUSDChildOrderPage.selectProduct3();
		createUSDChildOrderPage.checkApplyNow3();
		createUSDChildOrderPage.clickUpdateButton();
		
		createUSDChildOrderPage.clickUpdateButton();
		createUSDChildOrderPage.expectedAmount4();
		createUSDChildOrderPage.clickSave();

	}

}
