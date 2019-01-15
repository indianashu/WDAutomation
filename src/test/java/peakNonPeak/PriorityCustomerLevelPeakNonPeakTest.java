package peakNonPeak;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;
import utilPackages.TestMethodListener;

@Listeners(TestMethodListener.class) 
public class PriorityCustomerLevelPeakNonPeakTest {
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
    
    @Test(groups={"Peak Non-Peak Feature"},description="Priority Wise Customer Peak Non Peak Interval Scenario")
    public void userSignin() throws Exception{

    	/*peakScenarioPage.enterLoginID();
    	peakScenarioPage.enterPassword();
    	peakScenarioPage.selectCompany();
    	peakScenarioPage.clickLoginButton();*/
    	
    	//Tyler Kim Customer Level
    	for (int rowNum=3; rowNum < 5; rowNum++) {
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(3);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(3);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(0);
    	peakScenarioPage.selectProduct(5,rowNum);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Priority Customer Level Peak Non Peak Subscription Order Saved Successfully For Tyler Kim ");
    	}
    	
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(3);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(3);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(0);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,3);
    	peakScenarioPage.enterQuantity(13,0);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(8,0);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Priority Customer Level Peak Non Peak Order Saved Successfully For Tyler Kim ");
    	
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(3);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(3);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(0);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,4);
    	peakScenarioPage.enterQuantity(13,1);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(8,2);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Priority Customer Level Peak Non Peak Order Saved Successfully For Tyler Kim ");
    }
   
}
