package reports;

import baseClassPackage.BasePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    Actions actions = new Actions(driver);
    String sheetName="Reports";    

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
        enterLoginID.sendKeys(sp.ExcelRead(sheetName).get(0));
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
        enterPassword.sendKeys(sp.ExcelRead(sheetName).get(1));

    }

    private WebElement selectCompany;
    /**
     * Method to select Company.
     * @throws IOException 
     */
    public void selectCompany() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(2));

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

    @FindBy(how=How.XPATH, using="//*[@id='menu.link.customers']/a")
    private WebElement clickCustomerTab;
    /**
     * Method to click on Customer tab after successful login.
     * @throws IOException 
     */
    public void clickCustomerTab() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Customer Tab after successful login");
        JavaScriptExec.sleep();
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
    	JavaScriptExec.scrollToElementOnPage(driver,clickAddNewButton);
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Add New Button");
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        JavaScriptExec.sleep();
        
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
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(3));

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
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(4));

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
        Assert.assertTrue(clickSelectButton.isDisplayed());
        clickSelectButton.click();
        JavaScriptExec.sleep();
        
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
        Assert.assertTrue(enterLoginName.isDisplayed());
        enterLoginName.sendKeys(sp.ExcelRead(sheetName).get(5));
        
    }
    
    @FindBy(how = How.XPATH, using = "//select[@name='user.currencyId']")
	private WebElement selectCurrency;

	/**
	 * Method to Select Currency United State Dollar.
	 * 
	 * @throws IOException
	 */
	public void selectCurrency() throws IOException {
		ReportsPage sp=new ReportsPage(driver);
		log.info("Select Currency United State Dollar");
		Select sel = new Select(selectCurrency);
		sel.selectByVisibleText(sp.ExcelRead(sheetName).get(18));		
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
        JavaScriptExec.sleep();
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
   
    /**
     * Method to select a customer - TestCustomer3.
     * @throws IOException 
     */
    public void selectCustomer() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("select a customer - TestCustomer3");
        String CustomerName = sp.ExcelRead(sheetName).get(5);
        WebElement webElement= driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CustomerName+"']"));
        actions.moveToElement(webElement).click(webElement).perform();
        JavaScriptExec.sleep();
    }    

    @FindBy(how = How.XPATH, using = "//*[@id='filters.CUSTOMER-LIKE_UserName.stringValue']")
	private WebElement enterCustomerNameFilter;

	/**
	 * Method to enter the customer name in the Login name Filter.
	 * 
	 * @throws IOException
	 */
	public void enterCustomerNameFilter() throws IOException {
		ReportsPage sp=new ReportsPage(driver);
		log.info("Enter the name of the Customer in the Filte Login name");
		Assert.assertTrue(enterCustomerNameFilter.isDisplayed());
		enterCustomerNameFilter.sendKeys(sp.ExcelRead(sheetName).get(5));
		JavaScriptExec.sleep();
	}
	
	@FindBy(how = How.XPATH, using = "//*[@class='submit apply']//*[text()='Apply Filters']")
	private WebElement applyFilter;

	/**
	 * Method to Click on the Apply Filter Button.
	 * 
	 * @throws IOException
	 */
	public void applyFilter() throws IOException {
		ReportsPage sp=new ReportsPage(driver);
		log.info("Click on Apply Filter");
		Assert.assertTrue(applyFilter.isDisplayed());
		applyFilter.click();
		JavaScriptExec.sleep();
	}
	
    @FindBy(how=How.XPATH, using="//a[@class='submit order']//*[text()='Create Order']")
    private WebElement clickCreateOrderButton;
    /**
     * Method to Click Create Order Button.
     * @throws IOException 
     */
    public void clickCreateOrderButton() throws IOException{
        JavaScriptExec.scrollToElementOnPage(driver,clickCreateOrderButton);
        ReportsPage sp=new ReportsPage(driver);
        log.info("Click Create Order Button");
        Assert.assertTrue(clickCreateOrderButton.isDisplayed());
        actions.moveToElement(clickCreateOrderButton).click().perform();
        JavaScriptExec.sleep();
        
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
        Assert.assertTrue(clickProductsSubTab.isDisplayed());
        clickProductsSubTab.click();
        JavaScriptExec.sleep();
    }    
    
    private WebElement selectCategory;
    /**
     * Method to select account type.
     * @throws IOException 
     */
    public void selectCategory() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        WebElement categoryElement = driver.findElement(By.xpath("//select[@name='typeId']"));
        Select se = new Select(categoryElement);
        se.selectByVisibleText("New Test category");
    	JavaScriptExec.sleep();

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
        String ProductName = sp.ExcelRead(sheetName).get(16);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ProductName+"']")).click();
        JavaScriptExec.sleep();
        
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
        Assert.assertTrue(clickUpdateButton.isDisplayed());
        clickUpdateButton.click();
        JavaScriptExec.sleep();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit order']//*[text()='Generate Invoice']")
    private WebElement clickGenerateReportButton;
    /**
     * Method to click on a generate report button.
     * @throws IOException 
     */
    public void clickGenerateReportButton() throws IOException{
    	JavaScriptExec.scrollToElementOnPage(driver,clickGenerateReportButton);
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on a generate report button");
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
        JavaScriptExec.scrollToElementOnPage(driver,clickMakePaymentButton);
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on a make payment button");
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
        Assert.assertTrue(clickInvoice.isDisplayed());
        clickInvoice.click();
        
    }

    @FindBy(how=How.XPATH, using="//input[@name='processNow']")
    private WebElement clickProcessRealTimeCheckbox;
    /**
     * Method to Click on Process Payment in Real-Time checkbox.
     * @throws IOException
     */
    public void clickProcessRealTimeCheckbox() throws IOException{
        ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Process Payment in Real-Time checkbox");
        Assert.assertTrue(clickProcessRealTimeCheckbox.isDisplayed());
        Actions actions = new Actions(driver);
        if ( !driver.findElement(By.id("processNow")).isSelected() )
		{
		     driver.findElement(By.id("processNow")).click();
		}
        //actions.moveToElement(clickProcessRealTimeCheckbox).click().perform();

    }
    
    @FindBy(how=How.XPATH, using="//*[@name='paymentMethod_0.processingOrder']")
    private WebElement enterProcessingOrder;
    /**
     * Method to Enter Processing Order.
     * @throws IOException 
     */
    public void enterProcessingOrder() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Enter Processing Order");
        JavaScriptExec.scrolltoBottomofPage(driver);
        Assert.assertTrue(enterProcessingOrder.isDisplayed());
        if ( !driver.findElement(By.name("paymentMethod_0.processingOrder")).isSelected() )
		{
		     driver.findElement(By.name("paymentMethod_0.processingOrder")).sendKeys(sp.ExcelRead(sheetName).get(6));
		}
        
        //enterProcessingOrder.sendKeys(sp.ExcelRead(sheetName).get(6));
        
    }

    private WebElement selectPaymentMethodType;
    /**
     * Method to select payment method type.
     * @throws IOException
     */
    public void selectPaymentMethodType() throws IOException{
        ReportsPage sp=new ReportsPage(driver);
        WebElement PMTelement = driver.findElement(By.xpath("//select[@name='paymentMethod_0.paymentMethodTypeId']"));
        Select se = new Select(PMTelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(17));
        JavaScriptExec.sleep();

    }
    
    @FindBy(how=How.XPATH, using="//label[contains(.,'cc.cardholder.name')]/following::input[1]")
    private WebElement enterCardHolderName;
    /**
     * Method to Enter card holder name.
     * @throws IOException 
     */
    public void enterCardHolderName() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Enter card holder name");
        Assert.assertTrue(enterCardHolderName.isDisplayed());
        enterCardHolderName.sendKeys(sp.ExcelRead(sheetName).get(7));
        
    }
    
    @FindBy(how=How.XPATH, using="//label[contains(.,'cc.number')]/following::input[1]")
    private WebElement enterCardNumber;
    /**
     * Method to Enter card number.
     * @throws IOException 
     */
    public void enterCardNumber() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Enter card number");
        Assert.assertTrue(enterCardNumber.isDisplayed());
        enterCardNumber.sendKeys(sp.ExcelRead(sheetName).get(8));
        
    }
    
    @FindBy(how=How.XPATH, using="//label[contains(.,'cc.expiry.date')]/following::input[1]")
    private WebElement enterCardExpiry;
    /**
     * Method to Enter card expiry date.
     * @throws IOException 
     */
    public void enterCardExpiry() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Enter card number");
        Assert.assertTrue(enterCardExpiry.isDisplayed());
        enterCardExpiry.sendKeys(sp.ExcelRead(sheetName).get(9));
        
    }
    
  
    
    @FindBy(how=How.XPATH, using="//a[@class='submit payment']//*[text()='Review Payment']")
    private WebElement clickReviewPaymentButton;
    /**
     * Method to Click on Review Payment Button.
     * @throws IOException 
     */
    public void clickReviewPaymentButton() throws IOException{
        JavaScriptExec.scrollToElementOnPage(driver,clickReviewPaymentButton);
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Review Payment Button");
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
        log.info("Verifying if payment status is successful.");
        String ExpectedMsg = "Successful";
        String CustomerName = sp.ExcelRead(sheetName).get(5);
        String ActualMsg = driver.findElement(By.xpath("//*[text()='"+CustomerName+"']/following::span[5]")).getText();
        Assert.assertEquals(ActualMsg, ExpectedMsg);
    }
    
  
    @FindBy(how=How.XPATH, using="//*[@id='menu.link.reports']/a")
    private WebElement clickReportsTab;
    /**
     * Method to Click on Reports Tab.
     * @throws IOException 
     */
    public void clickReportsTab() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("Click on Reports Tab");
        JavaScriptExec.sleep();
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
        Assert.assertTrue(clickInvoiceReports.isDisplayed());
        clickInvoiceReports.click();
        JavaScriptExec.sleep();
        
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
        Assert.assertTrue(clickTotalAmountInvoiced.isDisplayed());
        clickTotalAmountInvoiced.click();
        JavaScriptExec.sleep();
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
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, selectStartDate);
        Assert.assertTrue(selectStartDate.isDisplayed());
        selectStartDate.sendKeys(sp.ExcelRead(sheetName).get(10));
        
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
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, selectEndDate);
        Assert.assertTrue(selectEndDate.isDisplayed());
        selectEndDate.sendKeys(sp.ExcelRead(sheetName).get(11));
        
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
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(12));

    }

    private WebElement selectViewFormatHTML;
    /**
     * Method to select view format as HTML.
     * @throws IOException 
     */
    public void selectViewFormatHTML() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        navigateBottom();
        WebElement Formatelement = driver.findElement(By.xpath("//select[@name='format']"));
        Select se = new Select(Formatelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(13));

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
        Assert.assertTrue(clickRunReportButton.isDisplayed());
        Actions actions = new Actions(driver);
        actions.moveToElement(clickRunReportButton).click().perform();
        JavaScriptExec.sleep();
    }

    public void closeWindow() throws IOException{
        JavaScriptExec.sleep();
        log.info("close window");
        String originalHandle = driver.getWindowHandle();

        for(String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(originalHandle);
    }
    
    private WebElement selectViewFormatPDF;
    /**
     * Method to select view format.
     * @throws IOException 
     */
    public void selectViewFormatPDF() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        JavaScriptExec.sleep();
        WebElement Formatelement = driver.findElement(By.xpath("//select[@name='format']"));
        Select se = new Select(Formatelement);
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(14));

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
        se.selectByVisibleText(sp.ExcelRead(sheetName).get(15));

    }
    
    private WebElement clickSaveReport;
    /**
     * Method to Save the report as Excel or PDF.
     * @throws IOException 
     */
    public void clickSaveReport() throws IOException{
    	ReportsPage sp=new ReportsPage(driver);
        log.info("to Save the report as Excel or PDF");
        JavaScriptExec.sleep();
//        WaitClass.WaitForElementisDisplay(driver, 10, clickSaveReport);
//        Assert.assertTrue(clickSaveReport.isDisplayed());
//        clickSaveReport.click();
        Alert myalert = driver.switchTo().alert();
        myalert.accept();
        
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        JavaScriptExec.sleep();
    }

}

