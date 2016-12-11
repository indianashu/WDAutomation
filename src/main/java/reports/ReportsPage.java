package reports;

import baseClassPackage.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utilPackages.JavaScriptExec;
import utilPackages.PropertyValExtractors;
import utilPackages.WaitClass;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class ReportsPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public ReportsPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(ReportsPage.class);
    ReportsPage reportsPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("Reports");
		
		Iterator<Row> row=sheet.iterator();
		//System.out.println();
		while(row.hasNext()){
			Iterator<Cell> cell=row.next().iterator();
			int i=0;
			
			while(cell.hasNext()){
					
				Cell c1=cell.next();
				c1.setCellType(c1.CELL_TYPE_STRING);
				String sample=c1.getStringCellValue();
				//log.info("***************************"+sample+"********************");
				
		rl.add(sample);
		
			}
			System.out.println(rl);
		}
		
		return rl;
    }
    

    @FindBy(how=How.XPATH,using="//input[@name='j_username']")
    private WebElement enterLoginID;
    /**
     * Method to enter login ID.
     * @throws IOException 
     */
    public void enterLoginID() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
    	
        log.info("Verifying the Login ID is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterLoginID);
        Assert.assertTrue(enterLoginID.isDisplayed());
        enterLoginID.sendKeys(sp.ExcelRead().get(0));
    }

    @FindBy(how=How.XPATH,using="//input[@name='j_password']")
    private WebElement enterPassword;
    /**
     * Method to enter Password.
     * @throws IOException 
     */
    public void enterPassword() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Verifying the First Name is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
        Assert.assertTrue(enterPassword.isDisplayed());
        enterPassword.sendKeys(sp.ExcelRead().get(1));

    }

    private WebElement selectCompany;
    /**
     * Method to select Comapny.
     * @throws IOException 
     */
    public void selectCompany() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(sp.ExcelRead().get(2));

    }

    @FindBy(how=How.XPATH,using="//a[@class='submit save']")
    private WebElement clickLoginButton;
    /**
     * Method to Click on  Save Changes Button
     */
    public void clickLoginButton(){
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//a[.='Customers']")
    private WebElement clickCustomerTab;
    /**
     * Method to click on Customer tab after successful login.
     * @throws IOException 
     */
    public void clickCustomerTab() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Customer Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomerTab);
        Assert.assertTrue(clickCustomerTab.isDisplayed());
        clickCustomerTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on Add New Button.
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Add New Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewButton);
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        
    }
    
    
    private WebElement selectUserCompany;
    /**
     * Method to select user company.
     * @throws IOException 
     */
    public void selectUserCompany() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        WebElement Usercompanyelement = driver.findElement(By.xpath("//select[@name='user.entityId']"));
        Select se = new Select(Usercompanyelement);
        se.selectByVisibleText(sp.ExcelRead().get(3));

    }
    
    private WebElement selectAccountType;
    /**
     * Method to select account type.
     * @throws IOException 
     */
    public void selectAccountType() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        WebElement AccountTypeelement = driver.findElement(By.xpath("//select[@name='accountTypeId']"));
        Select se = new Select(AccountTypeelement);
        se.selectByVisibleText(sp.ExcelRead().get(4));

    }    

    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Select']")
    private WebElement clickSelectButton;
    /**
     * Method to click on select Button.
     * @throws IOException 
     */
    public void clickSelectButton() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on select Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSelectButton);
        Assert.assertTrue(clickSelectButton.isDisplayed());
        clickSelectButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='user.userName']")
    private WebElement enterLoginName;
    /**
     * Method to Enter Login Name.
     * @throws IOException 
     */
    public void enterLoginName() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Enter Login Name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterLoginName);
        Assert.assertTrue(enterLoginName.isDisplayed());
        enterLoginName.sendKeys(sp.ExcelRead().get(5));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Use Company Billing Cycle']")
    private WebElement clickUseCompanyBillingCycleButton;
    /**
     * Method to Click Use Company Billing Cycle Button.
     * @throws IOException 
     */
    public void clickUseCompanyBillingCycleButton() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click Use Company Billing Cycle Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickUseCompanyBillingCycleButton);
        Assert.assertTrue(clickUseCompanyBillingCycleButton.isDisplayed());
        clickUseCompanyBillingCycleButton.click();
        
    }
    
    private WebElement selectBillingCycleUnit;
    /**
     * Method to select billing cycle unit.
     * @throws IOException 
     */
    public void selectBillingCycleUnit() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        WebElement BCUelement = driver.findElement(By.xpath("//select[@name='mainSubscription.periodId']"));
        Select se = new Select(BCUelement);
        se.selectByVisibleText(sp.ExcelRead().get(6));

    }

    private WebElement selectBillingCycleDay;
    /**
     * Method to select billing cycle day.
     * @throws IOException 
     */
    public void selectBillingCycleDay() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        WebElement BCDelement = driver.findElement(By.xpath("//select[@name='mainSubscription.nextInvoiceDayOfPeriod']"));
        Select se = new Select(BCDelement);
        se.selectByVisibleText(sp.ExcelRead().get(7));

    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSaveChangesButton);
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']//*[text()='Done']")
    private WebElement verifyConfirmationMsg;
    /**
     * Method to verify Account Type is created Successfully.
     * @throws IOException 
     */
    public void verifyConfirmationMsg() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='TestCustomer3']")
    private WebElement selectCustomer;
    /**
     * Method to select a customer - TestCustomer3.
     * @throws IOException 
     */
    public void selectCustomer() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("select a customer - TestCustomer3");
        WaitClass.sleep(10000);
        String CustomerName = sp.ExcelRead().get(5);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CustomerName+"']")).click();
        
    }    

    @FindBy(how=How.XPATH, using="//a[@class='submit order']//*[text()='Create Order']")
    private WebElement clickCreateOrderButton;
    /**
     * Method to click on create order button.
     * @throws IOException 
     */
    public void clickCreateOrderButton() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on create order button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCreateOrderButton);
        Assert.assertTrue(clickCreateOrderButton.isDisplayed());
        clickCreateOrderButton.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//*[@id='ui-id-8']")
    private WebElement clickProductsSubTab;
    /**
     * Method to click on Products sub tab.
     * @throws IOException 
     */
    public void clickProductsSubTab() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Products sub tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickProductsSubTab);
        Assert.assertTrue(clickProductsSubTab.isDisplayed());
        clickProductsSubTab.click();
        
    }    
    
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Commission Product']")
    private WebElement selectProduct;
    /**
     * Method to click on a product from the list.
     * @throws IOException 
     */
    public void selectProduct() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on a product from the list");
        WaitClass.sleep(10000);
        String ProductName = sp.ExcelRead().get(16);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Update']")
    private WebElement clickUpdateButton;
    /**
     * Method to click on a update button.
     * @throws IOException 
     */
    public void clickUpdateButton() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on a update button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickUpdateButton);
        Assert.assertTrue(clickUpdateButton.isDisplayed());
        clickUpdateButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit order']//*[text()='Generate Invoice']")
    private WebElement clickGenerateReportButton;
    /**
     * Method to click on a generate report button.
     * @throws IOException 
     */
    public void clickGenerateReportButton() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on a generate report button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickGenerateReportButton);
        Assert.assertTrue(clickGenerateReportButton.isDisplayed());
        clickGenerateReportButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit payment']//*[text()='Make Payment']")
    private WebElement clickMakePaymentButton;
    /**
     * Method to click on a make payment button.
     * @throws IOException 
     */
    public void clickMakePaymentButton() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on a make payment button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickMakePaymentButton);
        Assert.assertTrue(clickMakePaymentButton.isDisplayed());
        clickMakePaymentButton.click();
        
    }
    

    @FindBy(how=How.XPATH, using="//input[@name='invoiceId']")
    private WebElement clickInvoice;
    /**
     * Method to click on a Invoice.
     * @throws IOException 
     */
    public void clickInvoice() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on a Invoice from the list");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickInvoice);
        Assert.assertTrue(clickInvoice.isDisplayed());
        clickInvoice.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='invoiceId']")
    private WebElement enterProcessingOrder;
    /**
     * Method to Enter Processing Order.
     * @throws IOException 
     */
    public void enterProcessingOrder() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Enter Processing Order");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProcessingOrder);
        Assert.assertTrue(enterProcessingOrder.isDisplayed());
        enterProcessingOrder.sendKeys(sp.ExcelRead().get(6));
        
    }
    
  
    
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_86.value']")
    private WebElement enterCardHolderName;
    /**
     * Method to Enter card holder name.
     * @throws IOException 
     */
    public void enterCardHolderName() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Enter card holder name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCardHolderName);
        Assert.assertTrue(enterCardHolderName.isDisplayed());
        enterCardHolderName.sendKeys(sp.ExcelRead().get(7));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_85.value']")
    private WebElement enterCardNumber;
    /**
     * Method to Enter card number.
     * @throws IOException 
     */
    public void enterCardNumber() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Enter card number");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCardNumber);
        Assert.assertTrue(enterCardNumber.isDisplayed());
        enterCardNumber.sendKeys(sp.ExcelRead().get(8));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_83.value']")
    private WebElement enterCardExpiry;
    /**
     * Method to Enter card expiry date.
     * @throws IOException 
     */
    public void enterCardExpiry() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Enter card number");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCardExpiry);
        Assert.assertTrue(enterCardExpiry.isDisplayed());
        enterCardExpiry.sendKeys(sp.ExcelRead().get(9));
        
    }
    
  
    
    @FindBy(how=How.XPATH, using="//a[@class='submit payment']//*[text()='Review Payment']")
    private WebElement clickReviewPaymentButton;
    /**
     * Method to Click on Review Payment Button.
     * @throws IOException 
     */
    public void clickReviewPaymentButton() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Review Payment Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickReviewPaymentButton);
        Assert.assertTrue(clickReviewPaymentButton.isDisplayed());
        clickReviewPaymentButton.click();
        
    }

    @FindBy(how=How.XPATH, using="//div[@class='msg-box info']//*[text()='Info:']")
    private WebElement verifyConfirmationMsgInfo;
    /**
     * Method to verify message - info .
     * @throws IOException 
     */
    public void verifyConfirmationMsgInfo() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("verify message - info");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsgInfo);
        Assert.assertTrue(verifyConfirmationMsgInfo.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
  
    @FindBy(how=How.XPATH, using="//a[.='Reports']")
    private WebElement clickReportsTab;
    /**
     * Method to Click on Reports Tab.
     * @throws IOException 
     */
    public void clickReportsTab() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Reports Tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickReportsTab);
        Assert.assertTrue(clickReportsTab.isDisplayed());
        clickReportsTab.click();
        
    } 
    
  

    @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Invoice Reports']")
    private WebElement clickInvoiceReports;
    /**
     * Method to Click on Invoice Reports.
     * @throws IOException 
     */
    public void clickInvoiceReports() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Invoice Reports");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickInvoiceReports);
        Assert.assertTrue(clickInvoiceReports.isDisplayed());
        clickInvoiceReports.click();
        
    } 
    
  
    
    @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Total Amount Invoiced']")
    private WebElement clickTotalAmountInvoiced;
    /**
     * Method to Click on Total Amount Invoiced Report.
     * @throws IOException 
     */
    public void clickTotalAmountInvoiced() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Total Amount Invoiced Report");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickTotalAmountInvoiced);
        Assert.assertTrue(clickTotalAmountInvoiced.isDisplayed());
        clickTotalAmountInvoiced.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='start_date']")
    private WebElement selectStartDate;
    /**
     * Method to select start date for the report.
     * @throws IOException 
     */
    public void selectStartDate() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Select Start date for the report");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, selectStartDate);
        Assert.assertTrue(selectStartDate.isDisplayed());
        selectStartDate.sendKeys(sp.ExcelRead().get(10));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='end_date']")
    private WebElement selectEndDate;
    /**
     * Method to select end date for the report.
     * @throws IOException 
     */
    public void selectEndDate() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Select End date for the report");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, selectEndDate);
        Assert.assertTrue(selectEndDate.isDisplayed());
        selectEndDate.sendKeys(sp.ExcelRead().get(11));
        
    }
    
    private WebElement selectPeriodBreakDown;
    /**
     * Method to select period break down.
     * @throws IOException 
     */
    public void selectPeriodBreakDown() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        WebElement Periodelement = driver.findElement(By.xpath("//select[@name='period']"));
        Select se = new Select(Periodelement);
        se.selectByVisibleText(sp.ExcelRead().get(12));

    }

    private WebElement selectViewFormat;
    /**
     * Method to select view format.
     * @throws IOException 
     */
    public void selectViewFormat() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        WebElement Formatelement = driver.findElement(By.xpath("//select[@name='format']"));
        Select se = new Select(Formatelement);
        se.selectByVisibleText(sp.ExcelRead().get(13));

    }
    
  
    
    @FindBy(how=How.XPATH, using="//a[@class='submit edit']//*[text()='Run Report']")
    private WebElement clickRunReportButton;
    /**
     * Method to click run report button.
     * @throws IOException 
     */
    public void clickRunReportButton() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click Run Report Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickRunReportButton);
        Assert.assertTrue(clickRunReportButton.isDisplayed());
        clickRunReportButton.click();
        
    }
    
    private WebElement selectViewFormatPDF;
    /**
     * Method to select view format.
     * @throws IOException 
     */
    public void selectViewFormatPDF() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        WebElement Formatelement = driver.findElement(By.xpath("//select[@name='format']"));
        Select se = new Select(Formatelement);
        se.selectByVisibleText(sp.ExcelRead().get(14));

    }
    
    private WebElement selectViewFormatExcel;
    /**
     * Method to select view format.
     * @throws IOException 
     */
    public void selectViewFormatExcel() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        WebElement Formatelement = driver.findElement(By.xpath("//select[@name='format']"));
        Select se = new Select(Formatelement);
        se.selectByVisibleText(sp.ExcelRead().get(15));

    }
    
    private WebElement clickSaveReport;
    /**
     * Method to Save the report as Excel or PDF.
     * @throws IOException 
     */
    public void clickSaveReport() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("to Save the report as Excel or PDF");
        WaitClass.sleep(10000);
//        WaitClass.WaitForElementisDisplay(driver, 10, clickSaveReport);
//        Assert.assertTrue(clickSaveReport.isDisplayed());
//        clickSaveReport.click();
        Alert myalert = driver.switchTo().alert();
        myalert.accept();
        
    }
    
    
    
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}

