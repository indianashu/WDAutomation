package peakNonPeak;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;
import utilPackages.TestMethodListener;

@Listeners(TestMethodListener.class) 
public class PriorityCompanyLevelPeakNonPeakTest {
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

    @Test(groups={"Peak Non-Peak Feature"},description="Priority Wise Company Peak Non Peak Interval Scenario")
    public void userSignin() throws Exception{

    	/*peakScenarioPage.enterLoginID();
    	peakScenarioPage.enterPassword();
    	peakScenarioPage.selectCompany();
    	peakScenarioPage.clickLoginButton();*/
    	 
    	//Betsy Klompus Company Level
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(5);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(5);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(0);
    	peakScenarioPage.selectProduct(5,4);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Subscription Order Saved Successfully For Betsy Klompus At Priority Company Level");
    	   	
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(5);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(5);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(0);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,4);
    	peakScenarioPage.enterQuantity(13,1);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(12,5);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Order Saved Successfully For Betsy Klompus At Priority Company Level");
    	
    	//Warren Drummond Company Level
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(7);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(7);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(0);
    	peakScenarioPage.selectProduct(5,5);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Subscription Order Saved Successfully For Warren Drummond At Priority Company Level");
    	   	
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(7);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(7);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(4);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,5);
    	peakScenarioPage.enterQuantity(13,2);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(12,6);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Order Saved Successfully For Warren Drummond At Priority Company Level");
    }
}
