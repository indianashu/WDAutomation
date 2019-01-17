package reportsTest;

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
import reports.ReportsPage;


public class invoiceReportTotalAmountInvoicedTest {
	ReportsPage reportsPage;
    WebDriver driver,driver2;

    @BeforeClass(alwaysRun=true)
    public void setup(){
        driver= BaseClasses.setup( "User1");
        PropertyValExtractors p=new PropertyValExtractors();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1");
        driver.get(url);
        //WaitClass.waitForUrl(driver, url, 10);
        reportsPage=ReportsPage.getPage(driver, ReportsPage.class);

    }

    @Test(groups={"Sanity"},description="Invoice Reports: Total Amount Invoiced.")
    public void userSignin() throws IOException{

    	/*reportsPage.enterLoginID();
    	reportsPage.enterPassword();
    	reportsPage.selectCompany();
    	reportsPage.clickLoginButton();*/

    	reportsPage.clickCustomerTab();
    	reportsPage.navigateBottom();
    	reportsPage.clickAddNewButton();
    	reportsPage.selectAccountType();
    	reportsPage.clickSelectButton();
    	reportsPage.enterLoginName();
    	reportsPage.selectCurrency();
    	reportsPage.enterProcessingOrder();
		reportsPage.selectPaymentMethodType();
    	reportsPage.enterCardHolderName();
    	reportsPage.enterCardNumber();
    	reportsPage.enterCardExpiry();
    	reportsPage.clickSaveChangesButton();
    	reportsPage.verifyConfirmationMsg("Saved Customer Successfully");
    	reportsPage.navigateBottom();
    	reportsPage.clickCreateOrderButton();
    	reportsPage.clickProductsSubTab();
    	reportsPage.selectCategory();
    	reportsPage.selectProduct();
    	reportsPage.clickUpdateButton();
    	reportsPage.clickSaveChangesButton();
		reportsPage.navigateBottom();
    	reportsPage.clickGenerateReportButton();
    	reportsPage.clickCustomerTab();
    	reportsPage.enterCustomerNameFilter();
    	reportsPage.applyFilter();
    	reportsPage.selectCustomer();
    	reportsPage.clickMakePaymentButton();
    	reportsPage.clickInvoice();
		reportsPage.clickProcessRealTimeCheckbox();
		reportsPage.navigateBottom();
    	reportsPage.clickReviewPaymentButton();
    	reportsPage.clickMakePaymentButton();
    	reportsPage.verifyConfirmationMsgInfo();
    	reportsPage.clickReportsTab();
    	reportsPage.clickInvoiceReports();
    	reportsPage.clickTotalAmountInvoiced();
    	reportsPage.selectPeriodBreakDown();
    	reportsPage.selectViewFormatHTML();
    	reportsPage.clickRunReportButton();
		reportsPage.closeWindow();
    	//reportsPage.clickReportsTab();
    	//reportsPage.clickInvoiceReports();
    	//reportsPage.clickTotalAmountInvoiced();
    	//reportsPage.selectPeriodBreakDown();
    	reportsPage.selectViewFormatPDF();
    	reportsPage.clickRunReportButton();
    	//reportsPage.clickSaveReport();
    	//reportsPage.clickReportsTab();
    	//reportsPage.clickInvoiceReports();
    	//reportsPage.clickTotalAmountInvoiced();
    	//reportsPage.selectPeriodBreakDown();
    	reportsPage.selectViewFormatExcel();
    	reportsPage.clickRunReportButton();
    	//reportsPage.clickSaveReport();
    	    	
    }

    @AfterClass(alwaysRun=false)
    public void tearDown(){
     BaseClasses.closeDriver("User1");
    }
}

