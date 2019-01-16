package productHistoricalTest;

import baseClassPackage.BaseClasses;
import productHistorical.HistoricalScenarioPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreateOrderCADParentTest {

	HistoricalScenarioPage historicalScenarioPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		// WaitClass.waitForUrl(driver, url, 10);
		historicalScenarioPage = HistoricalScenarioPage.getPage(driver, HistoricalScenarioPage.class);

	}

	@Test(groups = { "Product Historical Feature" }, description = "Create Order for the Parent Company & USD Customer")
	public void userSignin() throws Exception {

		/*historicalScenarioPage.enterLoginID();
		historicalScenarioPage.enterPassword();
		historicalScenarioPage.selectCompany();
		historicalScenarioPage.clickLoginButton();*/

		// ActiveSince=Past date
		historicalScenarioPage.clickCustomerTab();
		historicalScenarioPage.addCompanyFilter();
		historicalScenarioPage.enterCustomerNameFilter(1);
		historicalScenarioPage.applyFilter();
		historicalScenarioPage.selectCustomer(1);
		historicalScenarioPage.clickCreateOrder();
		historicalScenarioPage.activeSince(0);
		historicalScenarioPage.clickProductSubTab();
		historicalScenarioPage.selectCategory();
		historicalScenarioPage.selectProduct(0);
		historicalScenarioPage.selectProduct(1);
		historicalScenarioPage.selectProduct(3);
		historicalScenarioPage.clickUpdateButton();
		historicalScenarioPage.expectedAmount(9, 0);
		historicalScenarioPage.clickSaveChanges();

		// ActiveSince=Between Past and Present date
		historicalScenarioPage.clickCustomerTab();
		historicalScenarioPage.addCompanyFilter();
		historicalScenarioPage.enterCustomerNameFilter(1);
		historicalScenarioPage.applyFilter();
		historicalScenarioPage.selectCustomer(1);
		historicalScenarioPage.clickCreateOrder();
		historicalScenarioPage.activeSince(1);
		historicalScenarioPage.clickProductSubTab();
		historicalScenarioPage.selectCategory();
		historicalScenarioPage.selectProduct(0);
		historicalScenarioPage.selectProduct(1);
		historicalScenarioPage.selectProduct(3);
		historicalScenarioPage.clickUpdateButton();
		historicalScenarioPage.expectedAmount(9, 1);
		historicalScenarioPage.clickSaveChanges();

		// ActiveSince=Between Present and Future Date
		historicalScenarioPage.clickCustomerTab();
		historicalScenarioPage.addCompanyFilter();
		historicalScenarioPage.enterCustomerNameFilter(1);
		historicalScenarioPage.applyFilter();
		historicalScenarioPage.selectCustomer(1);
		historicalScenarioPage.clickCreateOrder();
		historicalScenarioPage.activeSince(2);
		historicalScenarioPage.clickProductSubTab();
		historicalScenarioPage.selectCategory();
		historicalScenarioPage.selectProduct(0);
		historicalScenarioPage.selectProduct(1);
		historicalScenarioPage.selectProduct(3);
		historicalScenarioPage.clickUpdateButton();
		historicalScenarioPage.expectedAmount(9, 2);
		historicalScenarioPage.clickSaveChanges();

		// ActiveSince=Future Date
		historicalScenarioPage.clickCustomerTab();
		historicalScenarioPage.addCompanyFilter();
		historicalScenarioPage.enterCustomerNameFilter(1);
		historicalScenarioPage.applyFilter();
		historicalScenarioPage.selectCustomer(1);
		historicalScenarioPage.clickCreateOrder();
		historicalScenarioPage.activeSince(3);
		historicalScenarioPage.clickProductSubTab();
		historicalScenarioPage.selectCategory();
		
		historicalScenarioPage.selectProduct(0);
		historicalScenarioPage.checkApplyNow();
		historicalScenarioPage.clickUpdateButton1();
		
		historicalScenarioPage.selectProduct(1);
		historicalScenarioPage.checkApplyNow2();
		historicalScenarioPage.clickUpdateButton2();
		
		historicalScenarioPage.selectProduct(3);
		historicalScenarioPage.checkApplyNow3();
		historicalScenarioPage.clickUpdateButton();
		
		historicalScenarioPage.expectedAmount(9, 3);
		historicalScenarioPage.clickSaveChanges();
	}

}
