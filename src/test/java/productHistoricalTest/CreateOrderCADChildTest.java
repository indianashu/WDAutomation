package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.CreateCADChildOrderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrderCADChildTest {
	
	CreateCADChildOrderPage createCADChildOrderPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		createCADChildOrderPage = CreateCADChildOrderPage.getPage(driver, CreateCADChildOrderPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Order for the Child Company & USD Customer")
	public void userSignin() throws Exception {

		/*createCADChildOrderPage.enterLoginID();
		createCADChildOrderPage.enterPassword();
		createCADChildOrderPage.selectCompany();
		createCADChildOrderPage.clickLoginButton();*/
		
		/*createCADChildOrderPage.clickImpersonate();
		createCADChildOrderPage.selectChildCompany();
		createCADChildOrderPage.clickOKButton();*/

		// ActiveSince=Past date
		createCADChildOrderPage.clickCustomerTab();
		createCADChildOrderPage.selectCustomer();
		createCADChildOrderPage.clickCreateOrder();
		createCADChildOrderPage.selectActiveSincePast();
		createCADChildOrderPage.clickProductSubTab();
		createCADChildOrderPage.selectCategory();
		createCADChildOrderPage.selectProduct1();
		createCADChildOrderPage.selectProduct2();
		createCADChildOrderPage.selectProduct3();
		createCADChildOrderPage.clickUpdateButton();
		createCADChildOrderPage.expectedAmount1();
		createCADChildOrderPage.clickSave();
		createCADChildOrderPage.verifyConfirmationMsg("Past Date Order Saved Successfully For CAD Child Customer");

		// ActiveSince=Between Past and Present date
		createCADChildOrderPage.clickCustomerTab();
		createCADChildOrderPage.selectCustomer();
		createCADChildOrderPage.clickCreateOrder();
		createCADChildOrderPage.selectActiveSinceBetweenPastPresent();
		createCADChildOrderPage.clickProductSubTab();
		createCADChildOrderPage.selectCategory();
		createCADChildOrderPage.selectProduct1();
		createCADChildOrderPage.selectProduct2();
		createCADChildOrderPage.selectProduct3();
		createCADChildOrderPage.clickUpdateButton();
		createCADChildOrderPage.expectedAmount2();
		createCADChildOrderPage.clickSave();
		createCADChildOrderPage.verifyConfirmationMsg("Between Past and Present Date Order Saved Successfully For CAD Child Customer");

		// ActiveSince=Between Present and Future Date
		createCADChildOrderPage.clickCustomerTab();
		createCADChildOrderPage.selectCustomer();
		createCADChildOrderPage.clickCreateOrder();
		createCADChildOrderPage.selectActiveSinceBetweenPresentFuture();
		createCADChildOrderPage.clickProductSubTab();
		createCADChildOrderPage.selectCategory();
		createCADChildOrderPage.selectProduct1();
		createCADChildOrderPage.selectProduct2();
		createCADChildOrderPage.selectProduct3();
		createCADChildOrderPage.clickUpdateButton();
		createCADChildOrderPage.expectedAmount3();
		createCADChildOrderPage.clickSave();
		createCADChildOrderPage.verifyConfirmationMsg("Between Present and Future Date Order Saved Successfully For CAD Child Customer");

		// ActiveSince=Future Date
		createCADChildOrderPage.clickCustomerTab();
		createCADChildOrderPage.selectCustomer();
		createCADChildOrderPage.clickCreateOrder();
		createCADChildOrderPage.selectActiveSinceFuture();
		createCADChildOrderPage.clickProductSubTab();
		createCADChildOrderPage.selectCategory();
		createCADChildOrderPage.selectProduct1();
		createCADChildOrderPage.checkApplyNow();
		createCADChildOrderPage.clickUpdateButton1();
		
		createCADChildOrderPage.selectProduct2();
		createCADChildOrderPage.checkApplyNow2();
		createCADChildOrderPage.clickUpdateButton2();
		
		createCADChildOrderPage.selectProduct3();
		createCADChildOrderPage.checkApplyNow3();
		createCADChildOrderPage.clickUpdateButton();
		
		createCADChildOrderPage.expectedAmount4();
		createCADChildOrderPage.clickSave();
		createCADChildOrderPage.verifyConfirmationMsg("Future Date Order Saved Successfully For CAD Child Customer");

	}



		
		
	}



