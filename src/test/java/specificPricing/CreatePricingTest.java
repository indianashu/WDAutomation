package specificPricing;

import baseClassPackage.BaseClasses;
import productDependency.CreateOrderPeriodPage;
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
		
		pricingPage.enterPricingName();
		pricingPage.enterPricingType();
		pricingPage.enterRateCard();
		pricingPage.enterRateCardColumn();
		pricingPage.enterPricingFieldName();
		pricingPage.clickMadatoryMatch();
		pricingPage.clickPlusIcon();
		pricingPage.clickSaveChangesButton();
		
		pricingPage.clickPricingTab();
		pricingPage.clickAddNewButton();
		pricingPage.enterPricingName1();
		pricingPage.enterPricingType();
		pricingPage.enterRateCard1();
		pricingPage.enterRateCardColumn();
		pricingPage.enterPricingFieldName();
		pricingPage.clickMadatoryMatch();
		pricingPage.clickPlusIcon();
		pricingPage.clickSaveChangesButton();
		
		
		
	}
	}