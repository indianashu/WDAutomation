package billingProcessTest;

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
import billingProcess.CreateCustomerPage;


public class createCustomersBillingProcessTest {
	CreateCustomerPage createCustomerPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        createCustomerPage=CreateCustomerPage.getPage(driver, CreateCustomerPage.class);

    }

    @Test(groups={"Sanity"},description="Create Two Customers for Billing Process.")
    public void userSignin() throws IOException{
/*
    	createCustomerPage.enterLoginID();
    	createCustomerPage.enterPassword();
    	createCustomerPage.selectCompany();
    	createCustomerPage.clickLoginButton();
*/
    	createCustomerPage.clickCustomerTab();
    	createCustomerPage.clickAddNewButton();
    	createCustomerPage.selectUserCompany();
    	createCustomerPage.selectAccountType();
    	createCustomerPage.clickSelectButton();
    	createCustomerPage.enterLoginName();
    	createCustomerPage.selectBillingCycleUnit();
    	createCustomerPage.selectBillingCycleDay();
    	createCustomerPage.enterProcessingOrder();
		createCustomerPage.selectPaymentMethodType();
    	createCustomerPage.enterCardHolderName();
    	createCustomerPage.enterCardNumber();
    	createCustomerPage.enterCardExpiry();
		createCustomerPage.navigateBottom();
    	createCustomerPage.clickSaveChangesButton();
    	createCustomerPage.verifyConfirmationMsg();
    	createCustomerPage.clickCustomer1();
    	createCustomerPage.clickEditButton();
    	createCustomerPage.enterNextInvoiceDate();
		createCustomerPage.navigateBottom();
    	createCustomerPage.clickSaveChangesButton();
    	createCustomerPage.verifyConfirmationMsg();
    	createCustomerPage.clickCustomerTab();
    	createCustomerPage.clickAddNewButton();
    	createCustomerPage.selectUserCompany();
    	createCustomerPage.selectAccountType();
    	createCustomerPage.clickSelectButton();
    	createCustomerPage.enterLoginName1();
    	createCustomerPage.selectBillingCycleUnit();
    	createCustomerPage.selectBillingCycleDay();
    	createCustomerPage.enterProcessingOrder();
		createCustomerPage.selectPaymentMethodType();
    	createCustomerPage.enterCardHolderName1();
    	createCustomerPage.enterCardNumber();
    	createCustomerPage.enterCardExpiry();
		createCustomerPage.navigateBottom();
    	createCustomerPage.clickSaveChangesButton();
    	createCustomerPage.verifyConfirmationMsg();
    	createCustomerPage.clickCustomer2();
    	createCustomerPage.clickEditButton();
    	createCustomerPage.enterNextInvoiceDate1();
    	createCustomerPage.enterDueDateDays();
		createCustomerPage.navigateBottom();
    	createCustomerPage.clickSaveChangesButton();
    	createCustomerPage.verifyConfirmationMsg();
    	
    }

    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
}

