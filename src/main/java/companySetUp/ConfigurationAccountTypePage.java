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
import webDataPages.LoginPage;

import org.openqa.selenium.support.ui.Select;

/**
 * @author Ashutosh
 *
 */

public class ConfigurationAccountTypePage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public ConfigurationAccountTypePage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(ConfigurationAccountTypePage.class);
    ConfigurationAccountTypePage configurationAccountTypePage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("ConfigAccType");
		
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
    	ConfigurationAccountTypePage sp=new ConfigurationAccountTypePage(driver);
    	
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
    	ConfigurationAccountTypePage sp=new ConfigurationAccountTypePage(driver);
        log.info("Verifying the First Name is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterPassword);
        Assert.assertTrue(enterPassword.isDisplayed());
        enterPassword.sendKeys(sp.ExcelRead().get(1));

    }

    private WebElement selectCompany;
    /**
     * Method to select Company.
     * @throws IOException 
     */
    public void selectCompany() throws IOException{
    	ConfigurationAccountTypePage sp=new ConfigurationAccountTypePage(driver);
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
    	ConfigurationAccountTypePage sp=new ConfigurationAccountTypePage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//a[.='Account Type']")
    private WebElement clickAccountType;
    /**
     * Method to click on Account Type.
     * @throws IOException 
     */
    public void clickAccountType() throws IOException{
    	ConfigurationAccountTypePage sp=new ConfigurationAccountTypePage(driver);
        log.info("Click on Account Type");
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url2") + "/accountType/list";
        driver.get(url);
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on Account Type.
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	ConfigurationAccountTypePage sp=new ConfigurationAccountTypePage(driver);
        log.info("Click on Add New");
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        
    }
    @FindBy(how=How.XPATH, using="//input[@name='accountType.descriptions[0].content']")
    private WebElement enterAccountName;
    /**
     * Method to Enter Account Name.
     * @throws IOException 
     */
    public void enterAccountName() throws IOException{
    	ConfigurationAccountTypePage sp=new ConfigurationAccountTypePage(driver);
        log.info("Enter Account Name");
        Assert.assertTrue(enterAccountName.isDisplayed());
        enterAccountName.sendKeys(sp.ExcelRead().get(3));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='mainSubscription.nextInvoiceDayOfPeriod']")
    private WebElement enterBillingCycle;
    /**
     * Method to Enter Billing Cycle.
     * @throws IOException 
     */
    public void enterBillingCycle() throws IOException{
    	ConfigurationAccountTypePage sp=new ConfigurationAccountTypePage(driver);
        log.info("Enter Billing Cycle");
        Assert.assertTrue(enterBillingCycle.isDisplayed());
        enterBillingCycle.clear();
        enterBillingCycle.sendKeys(sp.ExcelRead().get(4));
        
    }
    
    private WebElement selectInvoiceDesing;
    /**
     * Method to select Invoice Design.
     * @throws IOException 
     */
    public void selectInvoiceDesing() throws IOException{
    	ConfigurationAccountTypePage sp=new ConfigurationAccountTypePage(driver);
        WebElement InvoiceDesignelement = driver.findElement(By.xpath("//select[@name='invoiceDesign']"));
        Select se = new Select(InvoiceDesignelement);
        se.selectByVisibleText(sp.ExcelRead().get(5));

    }

    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	ConfigurationAccountTypePage sp=new ConfigurationAccountTypePage(driver);
        log.info("Click on Save Changes Button");
        navigateBottom();
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
    	ConfigurationAccountTypePage sp=new ConfigurationAccountTypePage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }

    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        JavaScriptExec.sleep();
    }
}