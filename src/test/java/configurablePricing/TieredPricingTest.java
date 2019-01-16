package configurablePricing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class TieredPricingTest {
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

	@Test(groups = { "Configurable Pricing Feature" }, description = "Tiered Pricing Order")
	public void userSignin() throws Exception {

		/*configurablePricingPage.enterLoginID();
		configurablePricingPage.enterPassword();
		configurablePricingPage.selectCompany();
		configurablePricingPage.clickLoginButton();*/

		// Subscribe the Plan Product
		configurablePricingPage.clickCustomerTab();
		configurablePricingPage.enterCustomerNameFilter(0);
		configurablePricingPage.applyFilter();
		configurablePricingPage.selectCustomer(0);
		configurablePricingPage.clickCreateOrder();
		configurablePricingPage.clickProductsSubTab();
		configurablePricingPage.selectProduct(1);
		configurablePricingPage.clickUpdateButton();
		configurablePricingPage.clickSaveChangesButton();
		configurablePricingPage.verifyConfirmationMsg("Subscription Order Saved Successfully For Tiered Pricing");

		// Usage of the Tiered Pricing
		for (int rowNum = 0; rowNum < 5; rowNum++) {
			configurablePricingPage.clickCustomerTab();
			configurablePricingPage.enterCustomerNameFilter(0);
			configurablePricingPage.applyFilter();
			configurablePricingPage.selectCustomer(0);
			configurablePricingPage.clickCreateOrder();
			configurablePricingPage.clickProductsSubTab();
			configurablePricingPage.selectProduct(0);
			configurablePricingPage.enterQuantity(rowNum);
			configurablePricingPage.clickUpdateButton();
			configurablePricingPage.verifyTotalTieredAmount(rowNum);
			configurablePricingPage.clickSaveChangesButton();
			configurablePricingPage.verifyConfirmationMsg("Order Saved  Successfully For Tiered Pricing");
			
		}
	}
}
