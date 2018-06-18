package customerTest;

import baseClassPackage.BaseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import customer.CustomerPage;


public class addNewCustomerTest {
	CustomerPage customerPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        customerPage=CustomerPage.getPage(driver, CustomerPage.class);

    }

    @Test(groups={"Sanity"},description="Add New Customer")
    public void userSignin() throws IOException{
    	/*customerPage.enterLoginID();
    	customerPage.enterPassword();
    	customerPage.selectCompany();
    	customerPage.clickLoginButton();*/

        customerPage.clickCustomerTab();
    	customerPage.clickAddNewButton();
    	customerPage.selectAccountType();
    	customerPage.clickSelectButton();
    	customerPage.enterLoginName();
		customerPage.clickUseCompanyBillingCycleButton();
		customerPage.selectBillingCycleUnit();
		customerPage.selectBillingCycleDay();
		customerPage.navigateBottom();
		customerPage.enterEmail();
    	customerPage.selectPaymentMethodType();
    	customerPage.enterCCCardholderName();
    	customerPage.enterCCNumber();
    	customerPage.enterCCExpiryDate();
    	customerPage.clickSaveChangesButton();
    	customerPage.verifyConfirmationMsg();

    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
