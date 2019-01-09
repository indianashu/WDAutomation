package peakNonPeak;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;
import utilPackages.TestMethodListener;

@Listeners(TestMethodListener.class) 
public class CompanyLevelPeakNonPeakTest {
	PeakNonPeakScenarioPage peakScenarioPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        peakScenarioPage=PeakNonPeakScenarioPage.getPage(driver, PeakNonPeakScenarioPage.class);

    }

    @Test(groups={"Peak Non-Peak Feature"},description="Company Level Peak Non Peak Interval Scenario")
    public void userSignin() throws Exception{

    	/*peakScenarioPage.enterLoginID();
    	peakScenarioPage.enterPassword();
    	peakScenarioPage.selectCompany();
    	peakScenarioPage.clickLoginButton();*/
    	
    	
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(2);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(2);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(0);
    	peakScenarioPage.selectProduct(5,1);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Order Saved Successfully");
    	
    	//WEEKLY BASED
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(2);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(2);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(0);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,2);
    	peakScenarioPage.enterQuantity(11,0);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(12,0);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Weekly Based Order Saved Successfully");
    	
    	//SPECIAL DAY
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(2);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(2);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(4);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,2);
    	peakScenarioPage.enterQuantity(11,1);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(12,1);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Special Day Based Order Saved Successfully");
    	
    	//HOLIDAY
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(2);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(2);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(2);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,2);
    	peakScenarioPage.enterQuantity(11,2);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(12,2);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Holiday Based Order Saved Successfully");
    	
    	//TIME BASED
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(2);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(2);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(1);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,2);
    	peakScenarioPage.enterQuantity(11,3);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(12,3);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Time Based Order Saved Successfully");
    	
    	
    }
}
