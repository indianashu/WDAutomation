package configurablePricing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClassPackage.BaseClasses;
import configurablePricing.PricingPage;
import utilPackages.PropertyValExtractors;

public class CRUDPricingTest {

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

		createPricingPage.enterLoginID();
		createPricingPage.enterPassword();
		createPricingPage.selectCompany();
		createPricingPage.clickLoginButton();
		
		createPricingPage.clickPricingTab();
		createPricingPage.clickAddNewButton();
		createPricingPage.enterPricingName(0);
		createPricingPage.selectTierRadioButton();
		createPricingPage.fillTierData();
		createPricingPage.clickSaveChangesButton();
		createPricingPage.verifyConfirmationMsg("Pricing Saved Successfully");
		createPricingPage.verifyPricingName(0);
		createPricingPage.clickEditButton();
		createPricingPage.editPricingName();
		createPricingPage.clickSaveChangesButton();
		createPricingPage.verifyConfirmationMsg("Pricing Edited Successfully");
		createPricingPage.clickDeleteButton();
		createPricingPage.clickYesPopup();
		createPricingPage.verifyConfirmationMsg("Pricing Deleted Successfully");
	}
}
