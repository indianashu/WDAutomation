package peakNonPeak;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;
import utilPackages.TestMethodListener;

@Listeners(TestMethodListener.class) 
public class PriorityProductLevelPeakNonPeakTest {
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

    @Test(groups={"Peak Non-Peak Feature"},description="Priority Wise Product Peak Non Peak Interval Scenario")
    public void userSignin() throws Exception{

    	/*peakScenarioPage.enterLoginID();
    	peakScenarioPage.enterPassword();
    	peakScenarioPage.selectCompany();
    	peakScenarioPage.clickLoginButton();*/
    	
    	//Leo Holder Product Level
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(4);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(4);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(0);
    	peakScenarioPage.selectProduct(5,3);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Subscription Order Saved Successfully For Leo Holder At Priority Product Level");
    	   	
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(4);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(4);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(0);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,3);
    	peakScenarioPage.enterQuantity(13,0);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(12,4);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Order Saved Successfully For Leo Holder At Priority Product Level");
    	
    	//Martin Bernstein Product Level
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(6);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(6);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(0);
    	peakScenarioPage.selectProduct(5,5);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Subscription Order Saved Successfully For Martin Bernstein At Priority Product Level");
    	
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(6);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(6);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(4);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,5);
    	peakScenarioPage.enterQuantity(13,2);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(12,3);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Order Saved Successfully For Martin Bernstein At Priority Product Level");
    }
}
