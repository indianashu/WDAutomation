package paymentManualTest;

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
import customer.MakePaymentPage;


public class makingPaymentOnBillingProcessGeneratedInvoiceTest {
	MakePaymentPage makePaymentPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        makePaymentPage=MakePaymentPage.getPage(driver, MakePaymentPage.class);

    }

    @Test(groups={"Sanity"},description="Making Payment (manually) on Billing Process Generated Invoice.")
    public void userSignin() throws IOException{

    	/*makePaymentPage.enterLoginID();
    	makePaymentPage.enterPassword();
    	makePaymentPage.selectCompany();
    	makePaymentPage.clickLoginButton();*/

    	makePaymentPage.clickInvoicesTab();
    	makePaymentPage.clickCustomerName();
    	makePaymentPage.clickPayInvoiceButton();
    	makePaymentPage.selectInvoice();
		makePaymentPage.checkPaymentProcessRealTime();
    	makePaymentPage.enterProcessingOrder();
    	makePaymentPage.clickReviewPaymentButton();
    	makePaymentPage.clickMakePaymentButton();
    	makePaymentPage.verifyConfirmationMsg();
    	makePaymentPage.verifyCustomerName();
    	makePaymentPage.verifyPaymentAmount();

    }

    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
}

