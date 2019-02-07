package specificPricing;


import baseClassPackage.BaseClasses;
import specificPricing.SpecificPricingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;

public class PlanPricingTest {
	
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

		specificPricingPage.enterLoginID();
		specificPricingPage.enterPassword();
		specificPricingPage.selectCompany();
		specificPricingPage.clickLoginButton();
		
		specificPricingPage.clickCustomerTab();
		specificPricingPage.enterCustomerNameFilter(1);
		specificPricingPage.applyFilter();
		specificPricingPage.selectCustomer(1);
		specificPricingPage.clickCreateOrder();
		specificPricingPage.selectPeriod();
		specificPricingPage.selectOrderType();
		
		specificPricingPage.clickProductsSubTab();
		specificPricingPage.selectProduct(1);
		specificPricingPage.clickUpdateButton();
		specificPricingPage.clickSaveChangesButton();                     
		
		specificPricingPage.clickMediationLink();
		specificPricingPage.selectMediation();
		specificPricingPage.uploadPlanCSVFile();
		specificPricingPage.clickTriggerConfigButton();
		specificPricingPage.verifyConfirmationMsg("Orders Saved Successfully For Plan Pricing");
		specificPricingPage.clickMediationsTab();
		specificPricingPage.verifyNumberOrders();
    	specificPricingPage.clickMediationName();
    	specificPricingPage.clickDoneBillableViewLink();
    	specificPricingPage.verifyCSVData(10);
    	specificPricingPage.clickMediationName();
    	specificPricingPage.clickShowOrder();
    	specificPricingPage.clickOrder(1);
    	specificPricingPage.clickViewEvents();
    	specificPricingPage.verifyPlanPricingData();
	}
}
