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
import customer.CustomerParentChildPage;;


public class addNewSubCustomerTest {
	CustomerParentChildPage customerParentChildPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        customerParentChildPage=CustomerParentChildPage.getPage(driver, CustomerParentChildPage.class);

    }

    @Test(groups={"Sanity"},description="Add New Customer and Sub Customer")
    public void userSignin() throws IOException{
/*
    	customerParentChildPage.enterLoginID();
    	customerParentChildPage.enterPassword();
    	customerParentChildPage.selectCompany();
    	customerParentChildPage.clickLoginButton();
*/
    	customerParentChildPage.clickCustomerTab();
		customerParentChildPage.clickAddNewButton();
		customerParentChildPage.selectUserCompany();
		customerParentChildPage.selectAccountType();
		customerParentChildPage.clickSelectButton();
		customerParentChildPage.enterLoginName();
		customerParentChildPage.clickAllowSubAccountCheckbox();
		customerParentChildPage.navigateBottom();
		customerParentChildPage.enterEmail();
		customerParentChildPage.selectPaymentMethodType();
		customerParentChildPage.enterCCCardholderParentName();
		customerParentChildPage.enterCCNumber();
		customerParentChildPage.enterCCExpiryDate();
		customerParentChildPage.clickSaveChangesButton();
		customerParentChildPage.verifyConfirmationMsg();
		customerParentChildPage.clickCustomerTab();
		customerParentChildPage.selectCustomer();
		customerParentChildPage.clickAddSubAccountButton();
		customerParentChildPage.selectUserCompany();
		customerParentChildPage.selectAccountType();
		customerParentChildPage.clickSelectButton();
		customerParentChildPage.enterLoginName1();
		customerParentChildPage.verifyParentID();
		customerParentChildPage.navigateBottom();
		customerParentChildPage.enterEmailID1();
		customerParentChildPage.selectPaymentMethodType();
		customerParentChildPage.enterCCCardholderChildName();
		customerParentChildPage.enterCCNumber();
		customerParentChildPage.enterCCExpiryDate();
		customerParentChildPage.clickSaveChangesButton();
		customerParentChildPage.verifyConfirmationMsg();
/*		customerParentChildPage.selectChildCustomer();
		customerParentChildPage.verifyParentCustomer();
		customerParentChildPage.verifyChildInvoicingText();
		customerParentChildPage.selectCustomer();
		customerParentChildPage.verifyChildCustomer();
    	customerParentChildPage.verifySubAccount();
    	customerParentChildPage.verifyChildImage();
    	customerParentChildPage.verifyParentChildImage();*/
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
