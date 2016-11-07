package customer;

import baseClassPackage.BasePage;
import reports.ReportsPage;

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

public class MakePaymentPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public MakePaymentPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(MakePaymentPage.class);
    MakePaymentPage makePaymentPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("MakePayment");
		
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
    	MakePaymentPage sp=new MakePaymentPage(driver);
    	
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
    	MakePaymentPage sp=new MakePaymentPage(driver);
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
    	MakePaymentPage sp=new MakePaymentPage(driver);
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
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[3]/a/span")
    private WebElement clickInvoicesTab;
    /**
     * Method to click on Invoice tab after successful login.
     * @throws IOException 
     */
    public void clickInvoicesTab() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Click on Customer Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickInvoicesTab);
        Assert.assertTrue(clickInvoicesTab.isDisplayed());
        clickInvoicesTab.click();
        
    }
    
   // @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='TestCustomer2']")
    private WebElement clickCustomerName;
    /**
     * Method to click on a customer name.
     * @throws IOException 
     */
    public void clickCustomerName() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
    	String CustomerName = sp.ExcelRead().get(8);
    	driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CustomerName+"']"));
        log.info("Click on customer name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomerName);
        Assert.assertTrue(clickCustomerName.isDisplayed());
        clickCustomerName.click();
        
    }   
    
    @FindBy(how=How.XPATH, using="//a[@class='submit payment']//*[text()='Pay Invoice']")
    private WebElement clickPayInvoiceButton;
    /**
     * Method to click on pay invoice Button.
     * @throws IOException 
     */
    public void clickPayInvoiceButton() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Click on pay invoice Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickPayInvoiceButton);
        Assert.assertTrue(clickPayInvoiceButton.isDisplayed());
        clickPayInvoiceButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='invoiceId']")
    private WebElement selectInvoice;
    /**
     * Method to select an invoice.
     * @throws IOException 
     */
    public void selectInvoice() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Select an Invoice");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, selectInvoice);
        Assert.assertTrue(selectInvoice.isDisplayed());
        selectInvoice.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//input[@name='payment.amountAsDecimal']")
    private WebElement enterPaymentAmount;
    /**
     * Method to Enter Payment Amount.
     * @throws IOException 
     */
    public void enterPaymentAmount() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Enter Login Name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterPaymentAmount);
        Assert.assertTrue(enterPaymentAmount.isDisplayed());
        enterPaymentAmount.sendKeys(sp.ExcelRead().get(3));
        
    }

    
    @FindBy(how=How.XPATH, using="//input[@name='paymentMethod_0.processingOrder']")
    private WebElement enterProcessingOrder;
    /**
     * Method to Enter Processing Order.
     * @throws IOException 
     */
    public void enterProcessingOrder() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProcessingOrder);
        Assert.assertTrue(enterProcessingOrder.isDisplayed());
        enterProcessingOrder.sendKeys(sp.ExcelRead().get(4));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_86.value']")
    private WebElement enterCardHolderName;
    /**
     * Method to Enter card holder name.
     * @throws IOException 
     */
    public void enterCardHolderName() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Enter card holder name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCardHolderName);
        Assert.assertTrue(enterCardHolderName.isDisplayed());
        enterCardHolderName.sendKeys(sp.ExcelRead().get(5));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_85.value']")
    private WebElement enterCardNumber;
    /**
     * Method to Enter card number.
     * @throws IOException 
     */
    public void enterCardNumber() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Enter card number");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCardNumber);
        Assert.assertTrue(enterCardNumber.isDisplayed());
        enterCardNumber.sendKeys(sp.ExcelRead().get(6));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_83.value']")
    private WebElement enterCardExpiry;
    /**
     * Method to Enter card expiry date.
     * @throws IOException 
     */
    public void enterCardExpiry() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Enter card number");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCardExpiry);
        Assert.assertTrue(enterCardExpiry.isDisplayed());
        enterCardExpiry.sendKeys(sp.ExcelRead().get(7));
        
    }
    
  
    
    @FindBy(how=How.XPATH, using="//a[@class='submit payment']//*[text()='Review Payment']")
    private WebElement clickReviewPaymentButton;
    /**
     * Method to Click on Review Payment Button.
     * @throws IOException 
     */
    public void clickReviewPaymentButton() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Click on Review Payment Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickReviewPaymentButton);
        Assert.assertTrue(clickReviewPaymentButton.isDisplayed());
        clickReviewPaymentButton.click();
        
    }
    
  
    
    @FindBy(how=How.XPATH, using="//a[@class='submit payment']//*[text()='Make Payment']")
    private WebElement clickMakePaymentButton;
    /**
     * Method to Click on Make Payment Button.
     * @throws IOException 
     */
    public void clickMakePaymentButton() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Click on Review Payment Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickMakePaymentButton);
        Assert.assertTrue(clickMakePaymentButton.isDisplayed());
        clickMakePaymentButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//div[@class='msg-box info']//*[text()='Info:']")
    private WebElement verifyConfirmationMsg;
    /**
     * Method to verify Account Type is created Successfully.
     * @throws IOException 
     */
    public void verifyConfirmationMsg() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
  
    
    
    @FindBy(how=How.XPATH, using="//*[@id='payment-edit-form']/fieldset/div[2]/div[2]/div[2]/span/span")
    private WebElement verifyCustomerName;
    /**
     * Method to verify customer name
     * @throws IOException 
     */
    public void verifyCustomerName() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Verifying if customer name.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyCustomerName);
        Assert.assertEquals(verifyCustomerName.getText(), sp.ExcelRead().get(8));
        Assert.assertTrue(verifyCustomerName.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
    @FindBy(how=How.XPATH, using="//*[@id='payment-edit-form']/fieldset/div[2]/div[1]/div[3]/span/span")
    private WebElement verifyPaymentAmount;
    /**
     * Method to verify Payment Amount
     * @throws IOException 
     */
    public void verifyPaymentAmount() throws IOException{
    	MakePaymentPage sp=new MakePaymentPage(driver);
        log.info("Verifying if customer name.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyPaymentAmount);
        Assert.assertEquals(verifyPaymentAmount.getText(), sp.ExcelRead().get(9));
        Assert.assertTrue(verifyPaymentAmount.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}

