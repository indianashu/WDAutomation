package addOnTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import addOn.TestCase1Page;
import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class AddOnTestCase1 {
	TestCase1Page testCase1Page;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        testCase1Page = TestCase1Page.getPage(driver, TestCase1Page.class);

    }
    
    @Test(groups={"Add ON"},description="Add ON Order creation")
    public void userSignin() throws Exception{
    	testCase1Page.enterLoginID();
    	testCase1Page.enterPassword();
    	testCase1Page.selectCompany();
    	testCase1Page.clickLoginButton();
    	
    	testCase1Page.clickCustomerTab();
    	
    	testCase1Page.subscriptionOfPlan();
    	testCase1Page.consumptionOfPlan();
    	
    }
}
