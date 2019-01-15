package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.CreateEUROChildOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrderEUROChildTest {
	CreateEUROChildOrderPage createEUROChildOrderPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		createEUROChildOrderPage = CreateEUROChildOrderPage.getPage(driver, CreateEUROChildOrderPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Order for the Child Company & USD Customer")
	public void userSignin() throws Exception {

		
		  /*createEUROChildOrderPage.enterLoginID();
		  createEUROChildOrderPage.enterPassword();
		  createEUROChildOrderPage.selectCompany();
		  createEUROChildOrderPage.clickLoginButton();*/
		 

		
		  /*createEUROChildOrderPage.clickImpersonate();
		  createEUROChildOrderPage.selectChildCompany();
		  createEUROChildOrderPage.clickOKButton();*/
		 

		// ActiveSince=Past date
		createEUROChildOrderPage.clickCustomerTab();
		createEUROChildOrderPage.selectCustomer();
		createEUROChildOrderPage.clickCreateOrder();
		createEUROChildOrderPage.selectActiveSincePast();
		createEUROChildOrderPage.clickProductSubTab();
		createEUROChildOrderPage.selectCategory();
		createEUROChildOrderPage.selectProduct1();
		createEUROChildOrderPage.selectProduct2();
		createEUROChildOrderPage.selectProduct3();
		createEUROChildOrderPage.clickUpdateButton();
		createEUROChildOrderPage.expectedAmount1();
		createEUROChildOrderPage.clickSave();
		createEUROChildOrderPage.verifyConfirmationMsg("Past Date Order Saved Successfully For EURO Child Customer");

		// ActiveSince=Between Past and Present date
		createEUROChildOrderPage.clickCustomerTab();
		createEUROChildOrderPage.selectCustomer();
		createEUROChildOrderPage.clickCreateOrder();
		createEUROChildOrderPage.selectActiveSinceBetweenPastPresent();
		createEUROChildOrderPage.clickProductSubTab();
		createEUROChildOrderPage.selectCategory();
		createEUROChildOrderPage.selectProduct1();
		createEUROChildOrderPage.selectProduct2();
		createEUROChildOrderPage.selectProduct3();
		createEUROChildOrderPage.clickUpdateButton();
		createEUROChildOrderPage.expectedAmount2();
		createEUROChildOrderPage.clickSave();
		createEUROChildOrderPage.verifyConfirmationMsg("Between Past and Present Date Order Saved Successfully For EURO Child Customer");

		// ActiveSince=Between Present and Future Date
		createEUROChildOrderPage.clickCustomerTab();
		createEUROChildOrderPage.selectCustomer();
		createEUROChildOrderPage.clickCreateOrder();
		createEUROChildOrderPage.selectActiveSinceBetweenPresentFuture();
		createEUROChildOrderPage.clickProductSubTab();
		createEUROChildOrderPage.selectCategory();
		createEUROChildOrderPage.selectProduct1();
		createEUROChildOrderPage.selectProduct2();
		createEUROChildOrderPage.selectProduct3();
		createEUROChildOrderPage.clickUpdateButton();
		createEUROChildOrderPage.expectedAmount3();
		createEUROChildOrderPage.clickSave();
		createEUROChildOrderPage.verifyConfirmationMsg("Between Present and Future Date Order Saved Successfully For EURO Child Customer");

		// ActiveSince=Future Date
		createEUROChildOrderPage.clickCustomerTab();
		createEUROChildOrderPage.selectCustomer();
		createEUROChildOrderPage.clickCreateOrder();
		createEUROChildOrderPage.selectActiveSinceFuture();
		createEUROChildOrderPage.clickProductSubTab();
		createEUROChildOrderPage.selectCategory();
		createEUROChildOrderPage.selectProduct1();
		createEUROChildOrderPage.checkApplyNow();
		createEUROChildOrderPage.clickUpdateButton1();

		createEUROChildOrderPage.selectProduct2();
		createEUROChildOrderPage.checkApplyNow2();
		createEUROChildOrderPage.clickUpdateButton2();

		createEUROChildOrderPage.selectProduct3();
		createEUROChildOrderPage.checkApplyNow3();
		createEUROChildOrderPage.clickUpdateButton();

		createEUROChildOrderPage.expectedAmount4();
		createEUROChildOrderPage.clickSave();
		createEUROChildOrderPage.verifyConfirmationMsg("Future Date Order Saved Successfully For EURO Child Customer");

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		BaseClasses.closeDriver("User1");
	}

}
