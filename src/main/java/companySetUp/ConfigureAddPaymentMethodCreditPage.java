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
 * Add Payment Method - Credit Card
 */

public class ConfigureAddPaymentMethodCreditPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public ConfigureAddPaymentMethodCreditPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(ConfigureAddPaymentMethodCreditPage.class);
    ConfigureAddPaymentMethodCreditPage configureAddPaymentMethodCreditPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("ConfigPaymentMethCredit");
		
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
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
    	
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
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
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
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
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
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//a[.='Configuration']")
    private WebElement clickConfigurationTab;
    /**
     * Method to click on Configuration tab after successful login.
     * @throws IOException 
     */
    public void clickConfigurationTab() throws IOException{
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
        log.info("Click on Configuration Tab after successful login");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationTab);
        Assert.assertTrue(clickConfigurationTab.isDisplayed());
        clickConfigurationTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[.='Payment Method']")
    private WebElement clickPaymentMethod;
    /**
     * Method to click on Payment Method.
     * @throws IOException 
     */
    public void clickPaymentMethod() throws IOException{
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
        log.info("Click on Payment Method");
        JavaScriptExec.sleep();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url2") + "/paymentMethodType/list";
        driver.get(url);
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on Add New Button.
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
        log.info("Click on Add New");
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
    	JavaScriptExec.sleep();
        
    }
    
    
    private WebElement selectPaymentMethodTemplate;
    /**
     * Method to select Payment Method Template.
     * @throws IOException 
     */
    public void selectPaymentMethodTemplate() throws IOException{
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
        WebElement Paymentelement = driver.findElement(By.xpath("//select[@name='templateId']"));
        Select se = new Select(Paymentelement);
        se.selectByVisibleText(sp.ExcelRead().get(3));

    }

    @FindBy(how=How.XPATH, using="//a[@class='submit save']")
    private WebElement clickSelectButton;
    /**
     * Method to click on Select Button.
     * @throws IOException 
     */
    public void clickSelectButton() throws IOException{
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
        log.info("Click on Select Button");
        Assert.assertTrue(clickSelectButton.isDisplayed());
        clickSelectButton.click();
    	JavaScriptExec.sleep();
        
    }
    
    @FindBy(how=How.XPATH,using="//input[@name='methodName']")
    private WebElement enterMethodName;
    /**
     * Method to enter Method Name.
     * @throws IOException 
     */
    public void enterMethodName() throws IOException{
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
        log.info("Verifying the Method Name is available or not");
        JavaScriptExec.sleep();
        Assert.assertTrue(enterMethodName.isDisplayed());
        enterMethodName.sendKeys(sp.ExcelRead().get(4));

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='isRecurring']")
    private WebElement selectIsRecurring;
    /**
     * Method to select Is Recurring.
     * @throws IOException 
     */
    public void selectIsRecurring() throws IOException{
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
        log.info("Verifying the Is Recurring is available or not");
        Assert.assertTrue(selectIsRecurring.isDisplayed());
        selectIsRecurring.click();

    }
    
    private WebElement selectAccountType;
    /**
     * Method to select Account Type.
     * @throws IOException 
     */
    public void selectAccountType() throws IOException{
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
        WebElement AccountTypeelement = driver.findElement(By.xpath("//select[@name='accountTypes']"));
        Select se = new Select(AccountTypeelement);
        se.selectByVisibleText(sp.ExcelRead().get(5));

    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
        log.info("Click on Save Changes Button");
        JavaScriptExec.sleep();
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
    	ConfigureAddPaymentMethodCreditPage sp=new ConfigureAddPaymentMethodCreditPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        JavaScriptExec.sleep();
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        JavaScriptExec.sleep();
    }

}