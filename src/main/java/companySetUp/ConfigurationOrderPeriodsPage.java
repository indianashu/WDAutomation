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
 * Add Order Periods - Semi Monthly
 */

public class ConfigurationOrderPeriodsPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public ConfigurationOrderPeriodsPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(ConfigurationOrderPeriodsPage.class);
    ConfigurationOrderPeriodsPage configurationOrderPeriodsPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File("/Users/ashutosh/Documents/Web Data Consulting/WDAutomation/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("ConfigOrderPeriods");
		
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
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
    	
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
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
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
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
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
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//*[@id='navList']/li[7]/a/span")
    private WebElement clickConfigurationTab;
    /**
     * Method to click on Configuration tab after successful login.
     * @throws IOException 
     */
    public void clickConfigurationTab() throws IOException{
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
        log.info("Click on Configuration Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationTab);
        Assert.assertTrue(clickConfigurationTab.isDisplayed());
        clickConfigurationTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='left-column']/div/ul/li[20]/a")
    private WebElement clickOrderPeriods;
    /**
     * Method to click on Payment Method.
     * @throws IOException 
     */
    public void clickOrderPeriods() throws IOException{
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
        log.info("Click on Order Periods");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickOrderPeriods);
        Assert.assertTrue(clickOrderPeriods.isDisplayed());
        clickOrderPeriods.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on Add New Button.
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
        log.info("Click on Add New");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewButton);
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        
    }
    
    
    @FindBy(how=How.XPATH,using="//input[@name='description']")
    private WebElement enterDescription;
    /**
     * Method to enter Description.
     * @throws IOException 
     */
    public void enterDescription() throws IOException{
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
        log.info("Verifying the Description is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterDescription);
        Assert.assertTrue(enterDescription.isDisplayed());
        enterDescription.sendKeys(sp.ExcelRead().get(3));

    }
    
    private WebElement selectUnit;
    /**
     * Method to select Unit.
     * @throws IOException 
     */
    public void selectUnit() throws IOException{
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
        WebElement Unitelement = driver.findElement(By.xpath("//select[@name='periodUnitId']"));
        Select se = new Select(Unitelement);
        se.selectByVisibleText(sp.ExcelRead().get(4));

    }

    @FindBy(how=How.XPATH,using="//input[@name='value']")
    private WebElement enterValue;
    /**
     * Method to enter Value.
     * @throws IOException 
     */
    public void enterValue() throws IOException{
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
        log.info("Verifying the Description is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterValue);
        Assert.assertTrue(enterValue.isDisplayed());
        enterValue.sendKeys(sp.ExcelRead().get(5));

    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSaveChangesButton);
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']//*[text()='Order Period created successfully']")
    private WebElement verifyConfirmationMsg;
    /**
     * Method to verify Order Period is created Successfully.
     * @throws IOException 
     */
    public void verifyConfirmationMsg() throws IOException{
    	ConfigurationOrderPeriodsPage sp=new ConfigurationOrderPeriodsPage(driver);
        log.info("Verifying if Order Period is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}
