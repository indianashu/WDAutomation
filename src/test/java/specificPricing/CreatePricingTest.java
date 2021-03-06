package specificPricing;

import baseClassPackage.BaseClasses;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CreatePricingTest {

	CreatePricingPage pricingPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		pricingPage = CreatePricingPage.getPage(driver, CreatePricingPage.class);
	}

	@Test(groups = { "Specific Pricing Feature" }, description = "Create Pricing")
	public void userSignin() throws Exception {

		/*pricingPage.enterLoginID();
		pricingPage.enterPassword();
		pricingPage.selectCompany();
		pricingPage.clickLoginButton();*/

		pricingPage.clickPricingTab();
		pricingPage.clickAddNewButton();

		pricingPage.enterPricingName(0);
		pricingPage.enterPricingType();
		pricingPage.enterRateCard(0);
		pricingPage.enterRateCardColumn();
		pricingPage.enterPricingFieldName();
		pricingPage.clickMadatoryMatch();
		pricingPage.clickPlusIcon();
		pricingPage.clickSaveChangesButton();
		pricingPage.verifyConfirmationMsg("Test Pricing Saved Successfully");
		pricingPage.verifyPricingData(0);

		pricingPage.clickPricingTab();
		pricingPage.clickAddNewButton();
		pricingPage.enterPricingName(1);
		pricingPage.enterPricingType();
		pricingPage.enterRateCard(1);
		pricingPage.enterRateCardColumn();
		pricingPage.enterPricingFieldName();
		pricingPage.clickMadatoryMatch();
		pricingPage.clickPlusIcon();
		pricingPage.clickSaveChangesButton();
		pricingPage.verifyConfirmationMsg("Plan Pricing Saved Successfully");
		pricingPage.verifyPricingData(1);

	}
}