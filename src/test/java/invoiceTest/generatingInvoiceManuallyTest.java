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
import invoice.GeneratingInvoicePage;


public class generatingInvoiceManuallyTest {
	GeneratingInvoicePage generatingInvoicePage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        generatingInvoicePage=GeneratingInvoicePage.getPage(driver, GeneratingInvoicePage.class);

    }

    @Test(groups={"Sanity"},description="Generating an Invoice Manually")
    public void userSignin() throws IOException{

    	/*generatingInvoicePage.enterLoginID();
    	generatingInvoicePage.enterPassword();
    	generatingInvoicePage.selectCompany();
    	generatingInvoicePage.clickLoginButton();*/

    	generatingInvoicePage.clickCustomerTab();
    	generatingInvoicePage.enterCustomerNameFilter();
    	generatingInvoicePage.applyFilter();
    	generatingInvoicePage.clickCustomerName();
    	generatingInvoicePage.clickCreateOrderButton();
    	generatingInvoicePage.selectPeriod();
    	generatingInvoicePage.selectOrderType();
    	generatingInvoicePage.clickProductSubTab();
    	generatingInvoicePage.selectCategory();
    	generatingInvoicePage.selectProduct();
    	generatingInvoicePage.clickUpdateButton();
    	generatingInvoicePage.clickSaveChangesButton();
    	generatingInvoicePage.verifyConfirmationMsg("Saved Order Successfully");
    	generatingInvoicePage.clickOrdersTab();
    	generatingInvoicePage.clickCustomerName();
    	generatingInvoicePage.clickGenerateInvoiceButton();
    	generatingInvoicePage.verifyConfirmationMsg("Invoice Generated Successfully");
    }
    
    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }

}
