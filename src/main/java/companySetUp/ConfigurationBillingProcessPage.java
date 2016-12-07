package companySetUp;

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
 * Add Billing Process
 */

public class ConfigurationBillingProcessPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public ConfigurationBillingProcessPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(ConfigurationBillingProcessPage.class);
    ConfigurationBillingProcessPage configurationBillingProcessPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("ConfigBillingProcess");
		
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
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
    	
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
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
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
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
        WebElement Companyelement = driver.findElement(By.xpath("//select[@name='j_client_id']"));
        Select se = new Select(Companyelement);
        se.selectByVisibleText(sp.ExcelRead().get(2));

    }

    @FindBy(how=How.XPATH,using="//a[@class='submit save']")
    private WebElement clickLoginButton;
    /**
     * Method to Click on  Login Button
     */
    public void clickLoginButton(){
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//a[@href='/config/index']//*[text()='Configuration']")
    private WebElement clickConfigurationTab;
    /**
     * Method to click on Configuration tab after successful login.
     * @throws IOException 
     */
    public void clickConfigurationTab() throws IOException{
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
        log.info("Click on Configuration Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationTab);
        Assert.assertTrue(clickConfigurationTab.isDisplayed());
        clickConfigurationTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//li[@class='']//*[text()='Billing Process']")
    private WebElement clickBillingProcess;
    /**
     * Method to click on Billing Process.
     * @throws IOException 
     */
    public void clickBillingProcess() throws IOException{
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
        log.info("Click on Order Periods");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickBillingProcess);
        Assert.assertTrue(clickBillingProcess.isDisplayed());
        clickBillingProcess.click();
        
    }
    
    
    @FindBy(how=How.XPATH,using="//input[@name='nextRunDate']")
    private WebElement enterNextRunDate;
    /**
     * Method to enter Next Run Date.
     * @throws IOException 
     */
    public void enterNextRunDate() throws IOException{
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
        log.info("Verifying the Next Run Date is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterNextRunDate);
        Assert.assertTrue(enterNextRunDate.isDisplayed());
        enterNextRunDate.sendKeys(sp.ExcelRead().get(3));

    }
    
    

    @FindBy(how=How.XPATH,using="//input[@name='generateReport']")
    private WebElement selectGenerateReport;
    /**
     * Method to select Generate Report.
     * @throws IOException 
     */
    public void selectGenerateReport() throws IOException{
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
        log.info("Verifying the Is Recurring is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, selectGenerateReport);
        Assert.assertTrue(selectGenerateReport.isDisplayed());
        selectGenerateReport.clear();
        selectGenerateReport.click();

    }
    
    private WebElement selectBillingPeriod;
    /**
     * Method to select Billing Period.
     * @throws IOException 
     */
    public void selectBillingPeriod() throws IOException{
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
        WebElement Billingelement = driver.findElement(By.xpath("//select[@name='periodUnitId']"));
        Select se = new Select(Billingelement);
        se.selectByVisibleText(sp.ExcelRead().get(4));

    }
    
    
    @FindBy(how=How.XPATH,using="//input[@name='maximumPeriods']")
    private WebElement enterMaxPeriodInvoice;
    /**
     * Method to enter Maximum Order Periods to Invoice.
     * @throws IOException 
     */
    public void enterMaxPeriodInvoice() throws IOException{
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
        log.info("Verifying the Maximum Order Periods to Invoice is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterMaxPeriodInvoice);
        Assert.assertTrue(enterMaxPeriodInvoice.isDisplayed());
        enterMaxPeriodInvoice.sendKeys(sp.ExcelRead().get(5));

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='proratingType']")
    private WebElement selectNeverProrate;
    /**
     * Method to select Never enable prorating.
     * @throws IOException 
     */
    public void selectNeverProrate() throws IOException{
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
        log.info("Verifying the Never enable prorating is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, selectNeverProrate);
        Assert.assertTrue(selectNeverProrate.isDisplayed());
        selectNeverProrate.clear();
        selectNeverProrate.click();

    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSaveChangesButton);
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']//*[text()='Billing configuration saved successfully']")
    private WebElement verifyConfirmationMsg;
    /**
     * Method to verify Billing Period is saved Successfully.
     * @throws IOException 
     */
    public void verifyConfirmationMsg() throws IOException{
    	ConfigurationBillingProcessPage sp=new ConfigurationBillingProcessPage(driver);
        log.info("Verifying if Billing Period is saved Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}

