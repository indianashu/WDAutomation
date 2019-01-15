package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.CreateUSDParentOrderPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrderUSDParentTest {

	CreateUSDParentOrderPage CreateUSDParentOrderPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		CreateUSDParentOrderPage = CreateUSDParentOrderPage.getPage(driver, CreateUSDParentOrderPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Order for the Parent Company & USD Customer")
	public void userSignin() throws Exception {

		/*CreateUSDParentOrderPage.enterLoginID();
		CreateUSDParentOrderPage.enterPassword();
		CreateUSDParentOrderPage.selectCompany();
		CreateUSDParentOrderPage.clickLoginButton();*/

		// ActiveSince=Past date
		CreateUSDParentOrderPage.clickCustomerTab();
		CreateUSDParentOrderPage.addCompanyFilter();
		CreateUSDParentOrderPage.selectCustomer();
		CreateUSDParentOrderPage.clickCreateOrder();
		CreateUSDParentOrderPage.selectActiveSincePast();
		CreateUSDParentOrderPage.clickProductSubTab();
		CreateUSDParentOrderPage.selectCategory();
		CreateUSDParentOrderPage.selectProduct1();
		CreateUSDParentOrderPage.selectProduct2();
		CreateUSDParentOrderPage.selectProduct3();
		CreateUSDParentOrderPage.clickUpdateButton();
		CreateUSDParentOrderPage.expectedAmount1();
		CreateUSDParentOrderPage.clickSave();
		CreateUSDParentOrderPage.verifyConfirmationMsg("Past Date Order Saved Successfully For USD Parent Customer");
		
		// ActiveSince=Between Past and Present date
		CreateUSDParentOrderPage.clickCustomerTab();
		CreateUSDParentOrderPage.addCompanyFilter();
		CreateUSDParentOrderPage.selectCustomer();
		CreateUSDParentOrderPage.clickCreateOrder();
		CreateUSDParentOrderPage.selectActiveSinceBetweenPastPresent();
		CreateUSDParentOrderPage.clickProductSubTab();
		CreateUSDParentOrderPage.selectCategory();
		CreateUSDParentOrderPage.selectProduct1();
		CreateUSDParentOrderPage.selectProduct2();
		CreateUSDParentOrderPage.selectProduct3();
		CreateUSDParentOrderPage.clickUpdateButton();
		CreateUSDParentOrderPage.expectedAmount2();
		CreateUSDParentOrderPage.clickSave();
		CreateUSDParentOrderPage.verifyConfirmationMsg("Between Past and Present Date Order Saved Successfully For USD Parent Customer");

		// ActiveSince=Between Present and Future Date
		CreateUSDParentOrderPage.clickCustomerTab();
		CreateUSDParentOrderPage.addCompanyFilter();
		CreateUSDParentOrderPage.selectCustomer();
		CreateUSDParentOrderPage.clickCreateOrder();
		CreateUSDParentOrderPage.selectActiveSinceBetweenPresentFuture();
		CreateUSDParentOrderPage.clickProductSubTab();
		CreateUSDParentOrderPage.selectCategory();
		CreateUSDParentOrderPage.selectProduct1();
		CreateUSDParentOrderPage.selectProduct2();
		CreateUSDParentOrderPage.selectProduct3();
		CreateUSDParentOrderPage.clickUpdateButton();
		CreateUSDParentOrderPage.expectedAmount3();
		CreateUSDParentOrderPage.clickSave();
		CreateUSDParentOrderPage.verifyConfirmationMsg("Between Present and Future Date Order Saved Successfully For USD Parent Customer");

		// ActiveSince=Future Date
		CreateUSDParentOrderPage.clickCustomerTab();
		CreateUSDParentOrderPage.addCompanyFilter();
		CreateUSDParentOrderPage.selectCustomer();
		CreateUSDParentOrderPage.clickCreateOrder();
		CreateUSDParentOrderPage.selectActiveSinceFuture();
		CreateUSDParentOrderPage.clickProductSubTab();
		CreateUSDParentOrderPage.selectCategory();
		
		CreateUSDParentOrderPage.selectProduct1();
		CreateUSDParentOrderPage.checkApplyNow();
		CreateUSDParentOrderPage.clickUpdateButton1();
		
		CreateUSDParentOrderPage.selectProduct2();
		CreateUSDParentOrderPage.checkApplyNow2();
		CreateUSDParentOrderPage.clickUpdateButton2();
		
		CreateUSDParentOrderPage.selectProduct3();
		CreateUSDParentOrderPage.checkApplyNow3();
		CreateUSDParentOrderPage.clickUpdateButton();
		
		CreateUSDParentOrderPage.expectedAmount4();
		CreateUSDParentOrderPage.clickSave();
		CreateUSDParentOrderPage.verifyConfirmationMsg("Future Date Order Saved Successfully For USD Parent Customer");

	}

}
