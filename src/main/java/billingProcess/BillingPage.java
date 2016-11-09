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

public class BillingPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public BillingPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(BillingPage.class);
    BillingPage orderPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("Billing");
		
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
    	BillingPage sp=new BillingPage(driver);
    	
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
    	BillingPage sp=new BillingPage(driver);
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
    	BillingPage sp=new BillingPage(driver);
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
    	BillingPage sp=new BillingPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[12]/a/span")
    private WebElement clickConfigurationTab;
    /**
     * Method to click on Configuration tab after successful login.
     * @throws IOException 
     */
    public void clickConfigurationTab() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Configuration Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationTab);
        Assert.assertTrue(clickConfigurationTab.isDisplayed());
        clickConfigurationTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='left-column']/div/ul/li[4]/a")
    private WebElement clickBillingProcessLink;
    /**
     * Method to click on Billing Process Link.
     * @throws IOException 
     */
    public void clickBillingProcessLink() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Add New Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickBillingProcessLink);
        Assert.assertTrue(clickBillingProcessLink.isDisplayed());
        clickBillingProcessLink.click();
        
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
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterNextRunDate);
        Assert.assertTrue(enterNextRunDate.isDisplayed());
        enterNextRunDate.sendKeys(sp.ExcelRead().get(3));
        
    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	BillingPage sp=new BillingPage(driver);
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
    	BillingPage sp=new BillingPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
  @FindBy(how=How.XPATH, using="//a[@class='submit ']//*[text()='Run Billing']")
    private WebElement clickRunBillingButton;
    /**
     * Method to Click on Run Billing Button.
     * @throws IOException 
     */
    public void clickRunBillingButton() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Run Billing Button");
        WaitClass.sleep(10000);  
        WaitClass.WaitForElementisDisplay(driver, 10, clickRunBillingButton);
        Assert.assertTrue(clickRunBillingButton.isDisplayed());
        clickRunBillingButton.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[6]/a/span")
    private WebElement clickBillingTab;
    /**
     * Method to Click on Billing Tab.
     * @throws IOException 
     */
    public void clickBillingTab() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click Billing Tab");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickBillingTab);
        Assert.assertTrue(clickBillingTab.isDisplayed());
        clickBillingTab.click();
        
    }
    
    
    //@FindBy(how=How.XPATH, using="//*[@id='process-11']/td[3]/a/span")
    private WebElement verifyOrderNumbers;
    /**
     * Method to Verify order numbers.
     * @throws IOException 
     */
    public void verifyOrderNumbers() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify order numbers");
        String OrderNumber = driver.findElement(By.xpath("//*[@id='process-11']/td[3]/a/span")).getText();
        System.out.println("Number of Orders---->" +OrderNumber);
        WaitClass.sleep(10000);
        String OrderNumberExpected = sp.ExcelRead().get(4);
        Assert.assertEquals(OrderNumber, OrderNumberExpected);
        
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
        String FontWeight = driver.findElement(By.xpath("//*[@id='process-11']/td[3]/a/span")).getCssValue("font-weight");
        System.out.println("Fontweight---->" +FontWeight);
        WaitClass.sleep(10000);
        String FontWeightExpected = sp.ExcelRead().get(5);
        Assert.assertEquals(FontWeight, FontWeightExpected);
        
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
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickBillingReview);
        Assert.assertTrue(clickBillingReview.isDisplayed());
        clickBillingReview.click();
        
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
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickShowOrdersButton);
        Assert.assertTrue(clickShowOrdersButton.isDisplayed());
        clickShowOrdersButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit apply']//*[text()='Approve']")
    private WebElement clickApproveButton;
    /**
     * Method to Click on Approve Button.
     * @throws IOException 
     */
    public void verifyOrders() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Click on Approve Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickApproveButton);
        Assert.assertTrue(clickApproveButton.isDisplayed());
        clickApproveButton.click();
        
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
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickShowInvoiceButton);
        Assert.assertTrue(clickShowInvoiceButton.isDisplayed());
        clickShowInvoiceButton.click();
        
    }
    
    
    private WebElement verifyTableOrders;
    /**
     * Method to Verify number of orders in the table.
     * @throws IOException 
     */
    public void verifyTableOrders() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify number of orders in the table.");
        WaitClass.sleep(10000);
        int rowCount = driver.findElements(By.xpath("//table[@id='orders']/tbody/tr")).size();
        System.out.println("Row Count -------->" +rowCount);
        int OrderCount = 2;
        Assert.assertEquals(rowCount, OrderCount);
                
    }
    
    
    private WebElement verifyTableInvoices;
    /**
     * Method to Verify number of invoices in the table.
     * @throws IOException 
     */
    public void verifyTableInvoices() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify number of invoices in the table.");
        WaitClass.sleep(10000);
        int rowCount = driver.findElements(By.xpath("//table[@id='invoices']/tbody/tr")).size();
        System.out.println("Row Count -------->" +rowCount);
        int OrderCount = 1;
        Assert.assertEquals(rowCount, OrderCount);
                
    }
  
    private WebElement verifyInvoiceCustomer;
    /**
     * Method to Verify invoice Customer in the table.
     * @throws IOException 
     */
    public void verifyInvoiceCustomer() throws IOException{
    	BillingPage sp=new BillingPage(driver);
        log.info("Verify invoice customer in the table.");
        WaitClass.sleep(10000);
        String BillingCustomerExpected = sp.ExcelRead().get(6);
        String BillingCustomerActual = driver.findElement(By.xpath("//a[@class='cell double']")).getText();
        System.out.println("Billing Customer Name is -------->" +BillingCustomerActual);
        Assert.assertEquals(BillingCustomerActual, BillingCustomerExpected);
                
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}

