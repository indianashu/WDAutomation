package addOnTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import addOn.AddOnCreateCustomerPage;
import baseClassPackage.BaseClasses;
import utilPackages.PropertyValExtractors;

public class AddOnCreateCustomerTest {

	AddOnCreateCustomerPage addOnCreateCustomerPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        addOnCreateCustomerPage = AddOnCreateCustomerPage.getPage(driver, AddOnCreateCustomerPage.class);

    }
    
    @Test(groups={"Add ON"},description="Add ON Product and Category creation")
    public void userSignin() throws Exception{
    	/*addOnCreateCustomerPage.enterLoginID();
    	addOnCreateCustomerPage.enterPassword();
    	addOnCreateCustomerPage.selectCompany();
    	addOnCreateCustomerPage.clickLoginButton();*/
    	
    	addOnCreateCustomerPage.clickCustomerTab();
    	addOnCreateCustomerPage.createCustomer();
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
}
