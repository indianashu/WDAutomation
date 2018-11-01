package peakNonPeak;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import peakNonPeak.PeakNonPeakScenarioPage;
import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class CustomerLevelOrderTest {
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

    @Test(groups={"Sanity"},description="Customer Level Peak Non Peak Interval Scenario")
    public void userSignin() throws Exception{

    	peakScenarioPage.enterLoginID();
    	peakScenarioPage.enterPassword();
    	peakScenarioPage.selectCompany();
    	peakScenarioPage.clickLoginButton();
    	
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.selectCustomer(0);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(0);
    	peakScenarioPage.selectProduct(5,0);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg();
    	
    	for (int rowNum= 0; rowNum<4; rowNum++) {
    	peakScenarioPage.clickCustomerTab();
    	peakScenarioPage.selectCustomer(0);
    	peakScenarioPage.clickCreateOrder();
    	peakScenarioPage.enterActiveSince(rowNum);
    	peakScenarioPage.clickProductsSubTab();
    	peakScenarioPage.selectCategory(1);
    	peakScenarioPage.selectProduct(4,0);
    	peakScenarioPage.enterQuantity(rowNum);
    	peakScenarioPage.clickUpdateButton();
    	peakScenarioPage.verifyTotalAmount(rowNum);
    	peakScenarioPage.clickSaveChangesButton();
    	peakScenarioPage.verifyConfirmationMsg();
    	}
    	
    }
}
