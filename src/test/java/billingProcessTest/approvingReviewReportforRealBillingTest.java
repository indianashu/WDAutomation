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
import billingProcess.BillingPage;


public class approvingReviewReportforRealBillingTest {
	BillingPage billingPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        WaitClass.waitForUrl(driver, url, 10);
        billingPage=BillingPage.getPage(driver, BillingPage.class);

    }

    @Test(groups={"Sanity"},description="Approving review report for real billing run.")
    public void userSignin() throws IOException{
    	billingPage.enterLoginID();
    	billingPage.enterPassword();
    	billingPage.selectCompany();
    	billingPage.clickLoginButton();
    	billingPage.clickBillingTab();
    	billingPage.verifyOrderNumbers();
    	billingPage.verifyOrderNumbersItalics();
    	billingPage.clickBillingReview();
    	billingPage.clickShowOrdersButton();
    	billingPage.verifyTableOrders();
    	billingPage.clickBillingTab();
    	billingPage.clickBillingReview();
    	billingPage.clickShowInvoiceButton();
    	billingPage.verifyTableInvoices();
    	billingPage.verifyInvoiceCustomer();
    }

    @AfterClass(alwaysRun=true)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
}

