package configurablePricing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClassPackage.BaseClasses;
import configurablePricing.CreatePricingPage;
import utilPackages.PropertyValExtractors;

public class CreatePricingTest {

	CreatePricingPage createPricingPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		createPricingPage = CreatePricingPage.getPage(driver, CreatePricingPage.class);

	}

	@Test(groups = { "Configurable Pricing Feature" }, description = "Create Pricing")
	public void userSignin() throws Exception {

		createPricingPage.enterLoginID();
		createPricingPage.enterPassword();
		createPricingPage.selectCompany();
		createPricingPage.clickLoginButton();
		
		createPricingPage.clickPricingTab();
		createPricingPage.clickAddNewButton();
		createPricingPage.enterPricingName();
		createPricingPage.selectTierRadioButton();
		createPricingPage.fillTierData();
		createPricingPage.clickSaveChangesButton();
		createPricingPage.verifyConfirmationMsg();
		createPricingPage.verifyPricingName();
		createPricingPage.selectPricing();
		createPricingPage.clickEditButton();
		createPricingPage.editPricingName();
		createPricingPage.clickSaveChangesButton();
		createPricingPage.verifyConfirmationMsg();
		createPricingPage.clickDeleteButton();
		
	}
}
