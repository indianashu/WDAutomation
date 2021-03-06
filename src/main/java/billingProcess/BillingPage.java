package billingProcess;

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

public class BillingPage extends BasePage {
	/**
	 * This constructor is used to initialize the webdriver in BasePage class, if
	 * the user does not want to use page factory then this will take care of
	 * initialization of the driver
	 *
	 * @param webdriver
	 */
	public BillingPage(WebDriver webdriver) {
		super(webdriver);
	}

	Logger log = Logger.getLogger(BillingPage.class);
	BillingPage orderPage;
	PropertyValExtractors p = new PropertyValExtractors();
	String sheetName = "Billing";

	@FindBy(how = How.XPATH, using = "//input[@name='j_username']")
	private WebElement enterLoginID;

	/**
	 * Method to enter login ID.
	 * 
	 * @throws IOException
	 */
	public void enterLoginID() throws IOException {
		BillingPage sp = new BillingPage(driver);

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
    	BillingPage sp=new BillingPage(driver);
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
    	BillingPage sp=new BillingPage(driver);
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
    	BillingPage sp=new BillingPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//a[.='Billing Process']")
    private WebElement clickBillingProcessLink;
    /**
     * Method to click on Billing Process Link.
     * @throws IOException 
     */
    public void clickBillingProcessLink() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Add New Button");
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url2") + "/billingconfiguration/index";
        driver.get(url);
        JavaScriptExec.sleep();
    }
   
    
    @FindBy(how=How.XPATH, using="//input[@name='nextRunDate']")
    private WebElement enterNextRunDate;
    /**
     * Method to Enter Next Run Date.
     * @throws IOException 
     */
    public void enterNextRunDate() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Enter Next Run Date");
        Assert.assertTrue(enterNextRunDate.isDisplayed());
        enterNextRunDate.clear();
        enterNextRunDate.sendKeys(sp.ExcelRead(sheetName).get(3));
        
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	JavaScriptExec.scrollToElementOnPage(driver, clickSaveChangesButton);
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Save Changes Button");
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit ']//*[text()='Run Billing']")
    private WebElement clickRunBillingButton;
    /**
     * Method to Click on Run Billing Button.
     * @throws IOException 
     */
    public void clickRunBillingButton() throws IOException{
    	JavaScriptExec.scrollToElementOnPage(driver, clickRunBillingButton);
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Run Billing Button");
        Assert.assertTrue(clickRunBillingButton.isDisplayed());
        clickRunBillingButton.click();
        JavaScriptExec.sleep();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//*[@id='menu.link.billing']/a")
    private WebElement clickBillingTab;
    /**
     * Method to Click on Billing Tab.
     * @throws IOException 
     */
    public void clickBillingTab() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click Billing Tab");
        Assert.assertTrue(clickBillingTab.isDisplayed());
        clickBillingTab.click();
        JavaScriptExec.sleep();
        
    }
    
  
    
    
    //@FindBy(how=How.XPATH, using="//*[@id='process-13']/td[3]/a/span")
    private WebElement verifyOrderNumbers;
    /**
     * Method to Verify order numbers.
     * @throws IOException 
     */
    public void verifyOrderNumbers() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify order numbers");
        String OrderNumber = driver.findElement(By.xpath("//a[@class='cell']/following::span[2]")).getText();
        System.out.println("Number of Orders---->" +OrderNumber);
        JavaScriptExec.sleep();
        String OrderNumberExpected = sp.ExcelRead(sheetName).get(4);
        Assert.assertEquals(OrderNumber, OrderNumberExpected);
        
    }

    //@FindBy(how=How.XPATH, using="//*[@id='process-11']/td[3]/a/span")
    private WebElement verifyOrderNumbersItalics;
    /**
     * Method to Verify order numbers.
     * @throws IOException 
     */
    public void verifyOrderNumbersItalics() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify order numbers");
        String FontStyle = driver.findElement(By.xpath("//a[@class='cell']/following::span[2]")).getCssValue("font-style");
        System.out.println("FontStyle---->" +FontStyle);
        String FontStyleExpected = sp.ExcelRead(sheetName).get(5);
        Assert.assertEquals(FontStyle, FontStyleExpected);
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='cell']//*[text()='2']")
    private WebElement clickBillingReview;
    /**
     * Method to Click on Billing Review.
     * @throws IOException 
     */
    public void clickBillingReview() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click Billing Review");
        Assert.assertTrue(clickBillingReview.isDisplayed());
        clickBillingReview.click();
        JavaScriptExec.sleep();
        
    } 
  
    @FindBy(how=How.XPATH, using="//a[@class='submit apply']//*[text()='Show Orders']")
    private WebElement clickShowOrdersButton;
    /**
     * Method to Click on Show Orders Button.
     * @throws IOException 
     */
    public void clickShowOrdersButton() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Show Orders Button");
        Assert.assertTrue(clickShowOrdersButton.isDisplayed());
        clickShowOrdersButton.click();
        JavaScriptExec.sleep();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit apply']//*[text()='Approve']")
    private WebElement clickApproveButton;
    /**
     * Method to Click on Approve Button.
     * @throws IOException 
     */
    public void clickApproveButton() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Approve Button");
        Assert.assertTrue(clickApproveButton.isDisplayed());
        clickApproveButton.click();
        JavaScriptExec.sleep();
        driver.findElement(By.xpath("//button[text()='Yes']")).click();
        JavaScriptExec.sleep();
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit show']//*[text()='Show Invoices']")
    private WebElement clickShowInvoiceButton;
    /**
     * Method to Click on Show Invoice Button.
     * @throws IOException 
     */
    public void clickShowInvoiceButton() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Show Invoice Button");
        Assert.assertTrue(clickShowInvoiceButton.isDisplayed());
        clickShowInvoiceButton.click();
        JavaScriptExec.sleep();
        
    }
    
    
    private WebElement verifyTableOrders;
    /**
     * Method to Verify number of orders in the table.
     * @throws IOException 
     */
    public void verifyTableOrders() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify number of orders in the table.");
        JavaScriptExec.sleep();
        int rowCount = driver.findElements(By.xpath("//table[@id='orders']/tbody/tr")).size();
        System.out.println("Row Count -------->" +rowCount);
        int OrderCount = 2;
        Assert.assertEquals(rowCount, OrderCount);

        log.info("Verify One-Time and Monthly Prepaid orders.");
        String CustName = sp.ExcelRead(sheetName).get(6);
        driver.findElement(By.xpath("//*[text()='"+CustName+"']/following::strong")).click();
        JavaScriptExec.sleep();
        String Period1 = driver.findElement(By.xpath("//td[text()='Period:']/following::td[1]")).getText();
        String Type1 = driver.findElement(By.xpath("//td[text()='Type:']/following::td[1]")).getText();
        JavaScriptExec.sleep();
        String ActualPeriod1 = sp.ExcelRead(sheetName).get(12);
        String ActualType1 = sp.ExcelRead(sheetName).get(13);
        Assert.assertEquals(Period1, ActualPeriod1);
        Assert.assertEquals(Type1, ActualType1);
        
        driver.findElement(By.xpath("//table[@id='orders']/tbody/tr[2]/td[2]/a")).click();
        JavaScriptExec.sleep();
        String Period2 = driver.findElement(By.xpath("//td[text()='Period:']/following::td[1]")).getText();
        String ActualPeriod2 = sp.ExcelRead(sheetName).get(14);
        Assert.assertEquals(Period2, ActualPeriod2);

    }
    
    
    private WebElement verifyTableInvoices;
    /**
     * Method to Verify number of invoices in the table.
     * @throws IOException 
     */
    public void verifyTableInvoices() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify number of invoices in the table.");
        JavaScriptExec.sleep();
        int rowCount = driver.findElements(By.xpath("//table[@id='invoices']/tbody/tr")).size();
        System.out.println("Row Count -------->" +rowCount);
        int InvoiceCount = 1;
        Assert.assertEquals(rowCount, InvoiceCount);
                
    }
  
    private WebElement verifyInvoiceCustomer;
    /**
     * Method to Verify invoice Customer in the table.
     * @throws IOException 
     */
    public void verifyInvoiceCustomer() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify invoice customer in the table.");
        String BillingCustomerExpected = sp.ExcelRead(sheetName).get(6);
        String BillingCustomerActual = driver.findElement(By.xpath("//a[@class='cell double']")).getText();
        System.out.println("Billing Customer Name is -------->" +BillingCustomerActual);
        Assert.assertEquals(BillingCustomerActual, BillingCustomerExpected);
        driver.findElement(By.xpath("//a[@class='cell double']")).click();
        JavaScriptExec.sleep();
    }
    
  
    //@FindBy(how=How.XPATH, using="//*[@id='main']/div[6]/em[5]/strong")
    private WebElement verifyReviewStatusGenerated;
    /**
     * Method to Verify Review Status is Generated.
     * @throws IOException 
     */
    public void verifyReviewStatusGenerated() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify Review Status is Generated.");
        JavaScriptExec.sleep();
        String ActualStatus = driver.findElement(By.xpath("//*[@id='main']/div[6]/em[5]/strong")).getText();
        String ExpectedStatus = "Generated";
        Assert.assertEquals(ActualStatus, ExpectedStatus);
    } 
    
  
    //@FindBy(how=How.XPATH, using="//*[@id='main']/div[6]/em[5]/strong")
    private WebElement verifyReviewStatusApproved;
    /**
     * Method to Verify Review Status is Approved.
     * @throws IOException 
     */
    public void verifyReviewStatusApproved() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify Review Status is Approved.");
        JavaScriptExec.sleep();
        String ActualStatus = driver.findElement(By.xpath("//*[@id='main']/div[6]/em[5]/strong")).getText();
        String ExpectedStatus = "Approved";
        Assert.assertEquals(ActualStatus, ExpectedStatus);
    }
    
  
    @FindBy(how=How.XPATH, using="//input[@id='generateReport']")
    private WebElement clickGenerateReviewReport;
    /**
     * Method to Uncheck Generate Review Report.
     * @throws IOException 
     */
    public void clickGenerateReviewReport() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Uncheck Generate Review Report.");
        Assert.assertTrue(clickGenerateReviewReport.isDisplayed());
        clickGenerateReviewReport.click();
        
    } 
    
    
  //@FindBy(how=How.XPATH, using="//*[@id='process-11']/td[3]/a/span")
    private WebElement verifyOrderNumbersBold;
    /**
     * Method to Verify order numbers.
     * @throws IOException 
     */
    public void verifyOrderNumbersBold() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify order numbers");
        String FontWeight = driver.findElement(By.xpath("//*[@id='process-13']/td[3]/a/span")).getCssValue("font-weight");
        System.out.println("FontStyle---->" +FontWeight);
        JavaScriptExec.sleep();
        String FontWeightExpected = sp.ExcelRead(sheetName).get(7);
        Assert.assertEquals(FontWeight, FontWeightExpected);
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='cell']//*[text()='2']")
    private WebElement clickLastBillingRun;
    /**
     * Method to Click on last billing run.
     * @throws IOException 
     */
    public void clickLastBillingRun() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on last billing run");
        JavaScriptExec.sleep();
        Assert.assertTrue(clickLastBillingRun.isDisplayed());
        clickLastBillingRun.click();
        
    }

  
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Billing Customer2']")
    private WebElement clickBillingCustomer2;
    /**
     * Method to Click on Billing Customer2.
     * @throws IOException 
     */
    public void clickBillingCustomer2() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Billing Customer2");
        JavaScriptExec.sleep();
        String BillingCustomer= sp.ExcelRead(sheetName).get(6);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+BillingCustomer+"']")).click();
        
    }
    
  
    private WebElement verifyDueDate;
    /**
     * Method to Verify Due Date.
     * @throws IOException 
     */
    public void verifyDueDate() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on last billing run");
        JavaScriptExec.sleep();
        String ExpectedDueDate= sp.ExcelRead(sheetName).get(8);
        String ActualDueDate = driver.findElement(By.xpath("//td[text()='Due Date']/following::td[1]")).getText();
        Assert.assertEquals(ActualDueDate, ExpectedDueDate);
    }
    
    
    @FindBy(how=How.XPATH, using="//input[@name='nextRunDate']")
    private WebElement enterNextRunDate1;
    /**
     * Method to Enter Next Run Date.
     * @throws IOException 
     */
    public void enterNextRunDate1() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Enter Next Run Date");
        Assert.assertTrue(enterNextRunDate1.isDisplayed());
        enterNextRunDate1.clear();
        enterNextRunDate1.sendKeys(sp.ExcelRead(sheetName).get(9));
        
    }
    
  //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Billing Customer1']")
    private WebElement clickBillingCustomer1;
    /**
     * Method to Click on Billing Customer1.
     * @throws IOException 
     */
    public void clickBillingCustomer1() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Billing Customer1");
        String BillingCustomer1= sp.ExcelRead(sheetName).get(10);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+BillingCustomer1+"']")).click();
        JavaScriptExec.sleep();
    }
    
    private WebElement verifyDueDate1;
    /**
     * Method to Verify Due Date.
     * @throws IOException 
     */
    public void verifyDueDate1() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on last billing run");
        JavaScriptExec.sleep();
        String ExpectedDueDate= sp.ExcelRead(sheetName).get(11);
        String ActualDueDate = driver.findElement(By.xpath("//td[text()='Due Date']/following::td[1]")).getText();
        Assert.assertEquals(ActualDueDate, ExpectedDueDate);
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        JavaScriptExec.sleep();
    }

}

