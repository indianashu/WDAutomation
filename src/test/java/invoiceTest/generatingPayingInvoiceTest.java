package invoiceTest;

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
import invoice.GeneratingPayingInvoicePage;


public class generatingPayingInvoiceTest {
	GeneratingPayingInvoicePage generatingPayingInvoicePage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        generatingPayingInvoicePage=GeneratingPayingInvoicePage.getPage(driver, GeneratingPayingInvoicePage.class);

    }

    @Test(groups={"Sanity"},description="Generating and Paying Invoice")
    public void userSignin() throws IOException{

    	/*generatingPayingInvoicePage.enterLoginID();
    	generatingPayingInvoicePage.enterPassword();
    	generatingPayingInvoicePage.selectCompany();
    	generatingPayingInvoicePage.clickLoginButton();*/

    	generatingPayingInvoicePage.clickCustomerTab();
    	generatingPayingInvoicePage.clickCustomerName();
    	generatingPayingInvoicePage.clickCreateOrderButton();
    	generatingPayingInvoicePage.selectPeriod();
    	generatingPayingInvoicePage.selectOrderType();
    	generatingPayingInvoicePage.clickProductSubTab();
    	generatingPayingInvoicePage.selectProduct();
    	generatingPayingInvoicePage.clickCheckboxToChangeName();
    	generatingPayingInvoicePage.changeProductDescription();
    	generatingPayingInvoicePage.clickUpdateButton();
    	generatingPayingInvoicePage.clickSaveChangesButton();
    	generatingPayingInvoicePage.verifyConfirmationMsg();
    	generatingPayingInvoicePage.clickCustomerTab();
    	generatingPayingInvoicePage.clickCustomerName();
    	generatingPayingInvoicePage.clickCreateOrderButton();
    	generatingPayingInvoicePage.clickProductSubTab();
    	generatingPayingInvoicePage.selectProduct1();
    	generatingPayingInvoicePage.clickCheckboxToChangeName();
    	generatingPayingInvoicePage.changeProductDescription1();
    	generatingPayingInvoicePage.clickUpdateButton();
    	generatingPayingInvoicePage.clickSaveChangesButton();
    	generatingPayingInvoicePage.verifyConfirmationMsg();
    	generatingPayingInvoicePage.clickOrdersTab();
    	generatingPayingInvoicePage.selectMonthlyOrder();
    	generatingPayingInvoicePage.clickGenerateInvoiceButton();
    	generatingPayingInvoicePage.clickOrdersTab();
    	generatingPayingInvoicePage.selectOneTimeOrder();
    	generatingPayingInvoicePage.clickApplyToInvoiceButton();
    	generatingPayingInvoicePage.clickInvoiceRadioButton();
    	generatingPayingInvoicePage.clickApplyButton();
    	generatingPayingInvoicePage.clickInvoicesTab();
    	generatingPayingInvoicePage.clickInvoiceCreated();
    	generatingPayingInvoicePage.clickPayInvoiceButton();
    	generatingPayingInvoicePage.clickProcessRealTimeCheckbox();
    	generatingPayingInvoicePage.enterProcessOrder();
    	generatingPayingInvoicePage.clickReviewPaymentButton();
    	generatingPayingInvoicePage.clickMakePaymentButton();
    	generatingPayingInvoicePage.verifyPaymentSuccessfulMsg();
    	
    	
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
