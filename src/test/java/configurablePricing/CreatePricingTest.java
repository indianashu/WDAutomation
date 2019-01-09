package configurablePricing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class CreatePricingTest {
	PricingPage createPricingPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		createPricingPage = PricingPage.getPage(driver, PricingPage.class);

	}

	@Test(groups = { "Configurable Pricing Feature" }, description = "Create Pricing")
	public void userSignin() throws Exception {

		/*createPricingPage.enterLoginID();
		createPricingPage.enterPassword();
		createPricingPage.selectCompany();
		createPricingPage.clickLoginButton();*/

		// Tiered Pricing
		createPricingPage.clickPricingTab();
		createPricingPage.clickAddNewButton();
		createPricingPage.enterPricingName(1);
		createPricingPage.selectTierRadioButton();
		createPricingPage.fillTierData();
		createPricingPage.clickSaveChangesButton();
		createPricingPage.verifyConfirmationMsg("Saved Tiered Pricing Successfully");
		createPricingPage.verifyPricingName(1);

		// Volume Pricing
		createPricingPage.clickAddNewButton();
		createPricingPage.enterPricingName(2);
		createPricingPage.selectVolumeRadioButton();
		createPricingPage.fillTierData();
		createPricingPage.clickSaveChangesButton();
		createPricingPage.verifyConfirmationMsg("Saved Volume Pricing Successfully");
		createPricingPage.verifyPricingName(2);

	}
}
