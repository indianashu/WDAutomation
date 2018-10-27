package specificPricing;

import baseClassPackage.BaseClasses;
import specificPricing.SpecificPricingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class CustomerSpecificPricingTest {
	
	SpecificPricingPage specificPricingPage;
	WebDriver driver, driver2;

	@BeforeClass(alwaysRun = true)
	public void setup() {
		driver = BaseClasses.setup("User1");
		PropertyValExtractors p = new PropertyValExtractors();
		p.getPropertyFile("test", "configuration.properties");
		String url = p.getVal("url1");
		driver.get(url);
		specificPricingPage = SpecificPricingPage.getPage(driver, SpecificPricingPage.class);
	}
	@Test(groups = { "Specific Pricing Feature" }, description = "Create Order")
	public void userSignin() throws Exception {

		/*specificPricingPage.enterLoginID();
		specificPricingPage.enterPassword();
		specificPricingPage.selectCompany();
		specificPricingPage.clickLoginButton();*/
		
		specificPricingPage.clickCustomerTab();
		specificPricingPage.selectCustomer(2);
		specificPricingPage.clickCustomerInspectIcon();
		
		specificPricingPage.clickPlanComponentPricesSection();
		
		specificPricingPage.enterPlanProduct();
    	specificPricingPage.enterPricing();
    	specificPricingPage.clickOnAddPrice();
    	specificPricingPage.clickSaveChangesButton();
        specificPricingPage.verifyConfirmationMsg();
        
        specificPricingPage.clickMediationLink();
		specificPricingPage.selectMediation();
		specificPricingPage.uploadMediationCSVFile();
		specificPricingPage.clickTriggerConfigButton();
		
		specificPricingPage.clickMediationsTab();
		specificPricingPage.verifyNumberOrders();
    	specificPricingPage.clickMediationName();
    	specificPricingPage.clickShowOrder();
    	specificPricingPage.clickOrder();
    	specificPricingPage.navigateBottom();
    	specificPricingPage.clickViewEvents();
	}

}
