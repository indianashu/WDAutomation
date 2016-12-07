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
 *Add New Information Type for an Account
 */

public class ConfigurationNewInformationTypePage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public ConfigurationNewInformationTypePage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(ConfigurationNewInformationTypePage.class);
    ConfigurationNewInformationTypePage configurationNewInformationTypePage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("ConfigNewInfoType");
		
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
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
    	
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
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
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
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
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
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
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
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        log.info("Click on Configuration Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationTab);
        Assert.assertTrue(clickConfigurationTab.isDisplayed());
        clickConfigurationTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//li[@class='']//*[text()='Account Type']")
    private WebElement clickAccountType;
    /**
     * Method to click on Account Type.
     * @throws IOException 
     */
    public void clickAccountType() throws IOException{
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        log.info("Click on Account Type");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAccountType);
        Assert.assertTrue(clickAccountType.isDisplayed());
        clickAccountType.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Direct Customer']")
    private WebElement clickAccountTypeCreated;
    /**
     * Method to click on account type created.
     * @throws IOException 
     */
    public void clickAccountTypeCreated() throws IOException{
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        log.info("Click on account type created");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAccountTypeCreated);
        Assert.assertTrue(clickAccountTypeCreated.isDisplayed());
        clickAccountTypeCreated.click();
        
    }
    @FindBy(how=How.XPATH, using="//a[@class='submit edit']//*[text()='Add Information Type']")
    private WebElement clickAddInformationTypeButton;
    /**
     * Method to Add Information Type Button.
     * @throws IOException 
     */
    public void enterAccountName() throws IOException{
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        log.info("Add Information Type Button is available or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddInformationTypeButton);
        Assert.assertTrue(clickAddInformationTypeButton.isDisplayed());
        clickAddInformationTypeButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='name']")
    private WebElement enterName;
    /**
     * Method to Enter Name.
     * @throws IOException 
     */
    public void enterName() throws IOException{
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        log.info("Name is available or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterName);
        Assert.assertTrue(enterName.isDisplayed());
        enterName.sendKeys(sp.ExcelRead().get(3));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Add New Metafield']")
    private WebElement clickAddNewMetafieldButton;
    /**
     * Method to Add New Metafield Button.
     * @throws IOException 
     */
    public void clickAddNewMetafieldButton() throws IOException{
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        log.info("Add Information Type Button is available or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewMetafieldButton);
        Assert.assertTrue(clickAddNewMetafieldButton.isDisplayed());
        clickAddNewMetafieldButton.click();
        
    }  
    
    @FindBy(how=How.XPATH, using="//span[@class='description']")
    private WebElement clickDecription;
    /**
     * Method to Click Description "-".
     * @throws IOException 
     */
    public void clickDecription() throws IOException{
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        log.info("Description - is available or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickDecription);
        Assert.assertTrue(clickDecription.isDisplayed());
        clickDecription.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='metaField0.name']")
    private WebElement enterMetafieldName;
    /**
     * Method to Enter Name.
     * @throws IOException 
     */
    public void enterMetafieldName() throws IOException{
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        log.info("Name is available or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterMetafieldName);
        Assert.assertTrue(enterMetafieldName.isDisplayed());
        enterMetafieldName.sendKeys(sp.ExcelRead().get(4));
        
    }
    
    private WebElement selectMetafieldType;
    /**
     * Method to select Metafield Type.
     * @throws IOException 
     */
    public void selectMetafieldType() throws IOException{
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        WebElement MetafieldTypeelement = driver.findElement(By.xpath("//select[@name='fieldType0']"));
        Select se = new Select(MetafieldTypeelement);
        se.selectByVisibleText(sp.ExcelRead().get(5));

    }

    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Update']")
    private WebElement clickUpdateButton;
    /**
     * Method to click on Update Button.
     * @throws IOException 
     */
    public void clickUpdateButton() throws IOException{
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        log.info("Click on Update Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickUpdateButton);
        Assert.assertTrue(clickUpdateButton.isDisplayed());
        clickUpdateButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSaveChangesButton);
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        
    }
    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']//*[text()='Account Information Type created successfully']")
    private WebElement verifyConfirmationMsg;
    /**
     * Method to verify Account Type is created Successfully.
     * @throws IOException 
     */
    public void verifyConfirmationMsg() throws IOException{
    	ConfigurationNewInformationTypePage sp=new ConfigurationNewInformationTypePage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}
