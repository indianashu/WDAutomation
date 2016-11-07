package customer;

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

public class DiscountPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public DiscountPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(DiscountPage.class);
    DiscountPage discountPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("Discount");
		
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
    	DiscountPage sp=new DiscountPage(driver);
    	
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
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[7]/a/span")
    private WebElement clickDiscountTab;
    /**
     * Method to click on Discount tab after successful login.
     * @throws IOException 
     */
    public void clickCustomerTab() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on Discount Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDiscountTab);
        Assert.assertTrue(clickDiscountTab.isDisplayed());
        clickDiscountTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on Add New Button.
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click on Add New Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewButton);
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//div[@class='msg-box error']//*[text()='Error']")
    private WebElement verifyErrorMsg;
    /**
     * Method to verify Error message is shown when click on save changes button without entering data.
     * @throws IOException 
     */
    public void verifyErrorMsg() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("verify Error message is shown when click on save changes button without entering data.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyErrorMsg);
        Assert.assertTrue(verifyErrorMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
    private WebElement selectUserCompany;
    /**
     * Method to select user company.
     * @throws IOException 
     */
    public void selectUserCompany() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
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
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='cell double']")
    private WebElement selectCustomer;
    /**
     * Method to select customer.
     * @throws IOException 
     */
    public void selectCustomer() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Select Customer");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, selectCustomer);
        Assert.assertTrue(selectCustomer.isDisplayed());
        selectCustomer.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='cell double']")
    private WebElement clickAddSubAccountButton;
    /**
     * Method to Click Add Sub Account Button.
     * @throws IOException 
     */
    public void clickAddSubAccountButton() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click Add Sub Account Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddSubAccountButton);
        Assert.assertTrue(clickAddSubAccountButton.isDisplayed());
        clickAddSubAccountButton.click();
        
    }
    
    
    @FindBy(how=How.XPATH, using="//input[@name='user.userName']")
    private WebElement enterLoginName1;
    /**
     * Method to Enter Login Name.
     * @throws IOException 
     */
    public void enterLoginName1() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Enter Login Name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterLoginName1);
        Assert.assertTrue(enterLoginName1.isDisplayed());
        enterLoginName1.sendKeys(sp.ExcelRead().get(8));
        
    }
    
    
    @FindBy(how=How.XPATH, using="//*[@id='ait-20']/div[1]/a/span")
    private WebElement expandContactInfo;
    /**
     * Method to Expand Contact Info in add customer page.
     * @throws IOException 
     */
    public void expandContactInfo() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Expand Contact Info in add customer page");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, expandContactInfo);
        Assert.assertTrue(expandContactInfo.isDisplayed());
        expandContactInfo.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='metaField_224.value']")
    private WebElement enterEmailID;
    /**
     * Method to Enter Email ID.
     * @throws IOException 
     */
    public void enterEmailID() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Enter EmailID");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterEmailID);
        Assert.assertTrue(enterEmailID.isDisplayed());
        enterEmailID.sendKeys(sp.ExcelRead().get(9));
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='payment-methods']/div[1]/a/span")
    private WebElement expandPaymentMethod;
    /**
     * Method to Expand Payment Method in add customer page.
     * @throws IOException 
     */
    public void expandPaymentMethod() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Expand Payment Method in add customer page");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, expandPaymentMethod);
        Assert.assertTrue(expandPaymentMethod.isDisplayed());
        expandPaymentMethod.click();
        
    }
    
    private WebElement selectPaymentMethodType;
    /**
     * Method to select payment method type.
     * @throws IOException 
     */
    public void selectPaymentMethodType() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        WebElement PMTelement = driver.findElement(By.xpath("//select[@name='paymentMethod_0.paymentMethodTypeId']"));
        Select se = new Select(PMTelement);
        se.selectByVisibleText(sp.ExcelRead().get(10));

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_229.value']")
    private WebElement enterCCCardholderName;
    /**
     * Method to Enter CC Cardholder name.
     * @throws IOException 
     */
    public void enterCCCardholderName() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Enter CC Cardholder name");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCCCardholderName);
        Assert.assertTrue(enterCCCardholderName.isDisplayed());
        enterCCCardholderName.sendKeys(sp.ExcelRead().get(11));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_229.value']")
    private WebElement enterCCNumber;
    /**
     * Method to Enter CC Number.
     * @throws IOException 
     */
    public void enterCCNumber() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Enter CC Number");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCCNumber);
        Assert.assertTrue(enterCCNumber.isDisplayed());
        enterCCNumber.sendKeys(sp.ExcelRead().get(12));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='0_metaField_226.value']")
    private WebElement enterCCExpiryDate;
    /**
     * Method to Enter CC Number.
     * @throws IOException 
     */
    public void enterCCExpiryDate() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Enter CC Number");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterCCExpiryDate);
        Assert.assertTrue(enterCCExpiryDate.isDisplayed());
        enterCCExpiryDate.sendKeys(sp.ExcelRead().get(12));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add Instrument']")
    private WebElement clickAddInstrumentButton;
    /**
     * Method to click add instrument button.
     * @throws IOException 
     */
    public void clickAddInstrumentButton() throws IOException{
    	DiscountPage sp=new DiscountPage(driver);
        log.info("Click Add Instrument Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddInstrumentButton);
        Assert.assertTrue(clickAddInstrumentButton.isDisplayed());
        clickAddInstrumentButton.click();
        
    }
    
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}
