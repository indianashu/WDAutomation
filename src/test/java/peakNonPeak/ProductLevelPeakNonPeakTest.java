package peakNonPeak;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;
import utilPackages.TestMethodListener;

@Listeners(TestMethodListener.class) 
public class ProductLevelPeakNonPeakTest {
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

    @Test(groups={"Peak Non-Peak Feature"},description="Product Level Peak Non Peak Interval Scenario")
    public void userSignin() throws Exception{

    	/*peakScenarioPage.enterLoginID();
    	peakScenarioPage.enterPassword();
    	peakScenarioPage.selectCompany();
    	peakScenarioPage.clickLoginButton();*/
    	
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(1);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(1);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(0);
    	peakScenarioPage.selectProduct(5,1);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Product Level Peak Non Peak Order Saved Successfully");
    	
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(1);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(1);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(0);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,1);
    	peakScenarioPage.enterQuantity(7,0);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(10,0);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Product Level Peak Non Peak Order Saved Successfully");
    	
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.enterCustomerNameFilter(1);
    	peakScenarioPage.applyFilter();
    	peakScenarioPage.selectCustomer(1);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(1);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,1);
    	peakScenarioPage.enterQuantity(7,3);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(10,1);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg("Product Level Peak Non Peak Order Saved Successfully");
    	
    	
    }
}
