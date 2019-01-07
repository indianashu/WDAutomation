package configurablePricing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class VolumePricingTest {
	ConfigurablePricingPage configurablePricingPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		configurablePricingPage = ConfigurablePricingPage.getPage(driver, ConfigurablePricingPage.class);

	}

	@Test(groups = { "Configurable Pricing Feature" }, description = "Volume Pricing Order")
	public void userSignin() throws Exception {

		/*
		 * configurablePricingPage.enterLoginID();
		 * configurablePricingPage.enterPassword();
		 * configurablePricingPage.selectCompany();
		 * configurablePricingPage.clickLoginButton();
		 */

		// Subscribe the Plan Product
		configurablePricingPage.clickCustomerTab();
		configurablePricingPage.enterCustomerNameFilter(1);
		configurablePricingPage.applyFilter();		
		configurablePricingPage.selectCustomer(1);
		configurablePricingPage.clickCreateOrder();
		configurablePricingPage.clickProductsSubTab();
		configurablePricingPage.selectProduct(3);
		configurablePricingPage.clickUpdateButton();
		configurablePricingPage.clickSaveChangesButton();
		configurablePricingPage.verifyConfirmationMsg();

		// Usage of the Tiered Pricing
		for (int rowNum = 0; rowNum < 5; rowNum++) {
			configurablePricingPage.clickCustomerTab();
			configurablePricingPage.selectCustomer(1);
			configurablePricingPage.clickCreateOrder();
			configurablePricingPage.clickProductsSubTab();
			configurablePricingPage.selectProduct(2);
			configurablePricingPage.enterQuantity(rowNum);
			configurablePricingPage.clickUpdateButton();
			configurablePricingPage.verifyTotalVolumeAmount(rowNum);
			configurablePricingPage.clickSaveChangesButton();
			configurablePricingPage.verifyConfirmationMsg();
		}
	}

	@AfterClass(alwaysRun = false)
	public void tearDown() {
		BaseClasses.closeDriver("User1");
	}

}
