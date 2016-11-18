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
 * Add Collections
 */

public class ConfigurationCollectionsPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public ConfigurationCollectionsPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(ConfigurationCollectionsPage.class);
    ConfigurationCollectionsPage configurationCollectionsPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("ConfigCollection");
		
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
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
    	
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
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
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
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
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
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
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
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Click on Configuration Tab after successful login");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationTab);
        Assert.assertTrue(clickConfigurationTab.isDisplayed());
        clickConfigurationTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//*[@id='left-column']/div/ul/li[7]/a")
    private WebElement clickCollection;
    /**
     * Method to click on Collection.
     * @throws IOException 
     */
    public void clickCollection() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Click on Collection");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCollection);
        Assert.assertTrue(clickCollection.isDisplayed());
        clickCollection.click();
        
    }
    
    @FindBy(how=How.XPATH,using="//input[@name='obj[0].statusStr']")
    private WebElement enterIDSteps;
    /**
     * Method to enter IDSteps.
     * @throws IOException 
     */
    public void enterIDSteps() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the IDStep is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterIDSteps);
        Assert.assertTrue(enterIDSteps.isDisplayed());
        enterIDSteps.sendKeys(sp.ExcelRead().get(3));

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='obj[0].days']")
    private WebElement enterForDays;
    /**
     * Method to enter For Days.
     * @throws IOException 
     */
    public void enterForDays() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the For Days is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterForDays);
        Assert.assertTrue(enterForDays.isDisplayed());
        enterForDays.sendKeys(sp.ExcelRead().get(4));

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='obj[0].paymentRetry']")
    private WebElement selectPaymentCheckbox;
    /**
     * Method to select Payment Checkbox.
     * @throws IOException 
     */
    public void selectPaymentCheckbox() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the Payment Checkbox is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, selectPaymentCheckbox);
        Assert.assertTrue(selectPaymentCheckbox.isDisplayed());
        selectPaymentCheckbox.click();

    }

    @FindBy(how=How.XPATH,using="//input[@name='obj[1].statusStr']")
    private WebElement enterIDSteps1;
    /**
     * Method to enter IDSteps1.
     * @throws IOException 
     */
    public void enterIDSteps1() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the Description is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterIDSteps1);
        Assert.assertTrue(enterIDSteps1.isDisplayed());
        enterIDSteps1.sendKeys(sp.ExcelRead().get(5));

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='obj[1].days']")
    private WebElement enterForDays1;
    /**
     * Method to enter For Days1.
     * @throws IOException 
     */
    public void enterForDays1() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the For Days is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterForDays1);
        Assert.assertTrue(enterForDays1.isDisplayed());
        enterForDays1.sendKeys(sp.ExcelRead().get(6));

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='obj[1].sendNotification']")
    private WebElement selectNotificationCheckbox;
    /**
     * Method to select Notification Checkbox.
     * @throws IOException 
     */
    public void selectNotificationCheckbox() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the Notification Checkbox is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, selectNotificationCheckbox);
        Assert.assertTrue(selectNotificationCheckbox.isDisplayed());
        selectNotificationCheckbox.click();

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='obj[2].statusStr']")
    private WebElement enterIDSteps2;
    /**
     * Method to enter IDSteps2.
     * @throws IOException 
     */
    public void enterIDSteps2() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the ID Step2 is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterIDSteps2);
        Assert.assertTrue(enterIDSteps2.isDisplayed());
        enterIDSteps2.sendKeys(sp.ExcelRead().get(7));

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='obj[2].days']")
    private WebElement enterForDays2;
    /**
     * Method to enter For Days2.
     * @throws IOException 
     */
    public void enterForDays2() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the For Days is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterForDays2);
        Assert.assertTrue(enterForDays2.isDisplayed());
        enterForDays2.sendKeys(sp.ExcelRead().get(8));

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='obj[2].paymentRetry']")
    private WebElement selectPaymentCheckbox1;
    /**
     * Method to select Payment Checkbox.
     * @throws IOException 
     */
    public void selectPaymentCheckbox1() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the Payment Checkbox is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, selectPaymentCheckbox1);
        Assert.assertTrue(selectPaymentCheckbox1.isDisplayed());
        selectPaymentCheckbox1.click();

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='obj[2].statusStr']")
    private WebElement enterIDSteps3;
    /**
     * Method to enter IDSteps3.
     * @throws IOException 
     */
    public void enterIDSteps3() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the ID Step3 is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterIDSteps3);
        Assert.assertTrue(enterIDSteps3.isDisplayed());
        enterIDSteps3.sendKeys(sp.ExcelRead().get(9));

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='obj[2].days']")
    private WebElement enterForDays3;
    /**
     * Method to enter For Days3.
     * @throws IOException 
     */
    public void enterForDays3() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the For Days is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, enterForDays3);
        Assert.assertTrue(enterForDays3.isDisplayed());
        enterForDays3.sendKeys(sp.ExcelRead().get(10));

    }
    
    @FindBy(how=How.XPATH,using="//input[@name='obj[3].suspended']")
    private WebElement selectSuspendCheckbox1;
    /**
     * Method to select Suspend Checkbox.
     * @throws IOException 
     */
    public void selectSuspendCheckbox1() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying the Suspend Checkbox is available or not");
        WaitClass.WaitForElementisDisplay(driver, 5, selectSuspendCheckbox1);
        Assert.assertTrue(selectSuspendCheckbox1.isDisplayed());
        selectSuspendCheckbox1.click();

    }
    
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSaveChangesButton);
        Assert.assertTrue(clickSaveChangesButton.isDisplayed());
        clickSaveChangesButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//div[@class='msg-box successfully']//*[text()='Done']")
    private WebElement verifyConfirmationMsg;
    /**
     * Method to verify Collections are created/updated Successfully.
     * @throws IOException 
     */
    public void verifyConfirmationMsg() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Verifying if Collections are created/updated Successfully or not");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
  
    
    @FindBy(how=How.XPATH, using="//*[@id='left-column']/div/ul/li[23]/a")
    private WebElement clickPluginsLink;
    /**
     * Method to click on Plugins Link.
     * @throws IOException 
     */
    public void clickPluginsLink() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Click on Plugins Link");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickPluginsLink);
        Assert.assertTrue(clickPluginsLink.isDisplayed());
        clickPluginsLink.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//*[@id='17']/strong")
    private WebElement clickCategory17;
    /**
     * Method to click on category 17 - Generic internal events listener.
     * @throws IOException 
     */
    public void clickCategory17() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("click on category 17 - Generic internal events listener.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickCategory17);
        Assert.assertTrue(clickCategory17.isDisplayed());
        clickCategory17.click();
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on Add New button.
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("click on Add New button.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewButton);
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        
    }

    private WebElement selectTypeID;
    /**
     * Method to select TypeID.
     * @throws IOException 
     */
    public void selectTypeID() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        WebElement TypeIDelement = driver.findElement(By.xpath("//select[@name='typeId']"));
        Select se = new Select(TypeIDelement);
        se.selectByVisibleText(sp.ExcelRead().get(11));

    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='processingOrder']")
    private WebElement enterProcessingOrder;
    /**
     * Method to Enter Processing Order.
     * @throws IOException 
     */
    public void enterProcessingOrder() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Enter Processing Order.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterProcessingOrder);
        Assert.assertTrue(enterProcessingOrder.isDisplayed());
        enterProcessingOrder.sendKeys(sp.ExcelRead().get(12));  
    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='plgDynamic.1.name']")
    private WebElement enterLeftAttribute;
    /**
     * Method to Enter Left Attribute.
     * @throws IOException 
     */
    public void enterLeftAttribute() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Enter Left Attribute.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterLeftAttribute);
        Assert.assertTrue(enterLeftAttribute.isDisplayed());
        enterLeftAttribute.sendKeys(sp.ExcelRead().get(13));  
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='plgDynamic.1.value']")
    private WebElement enterRightAttribute;
    /**
     * Method to Enter Right Attribute.
     * @throws IOException 
     */
    public void enterRightAttribute() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Enter Right Attribute.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterRightAttribute);
        Assert.assertTrue(enterRightAttribute.isDisplayed());
        enterRightAttribute.sendKeys(sp.ExcelRead().get(14));  
    }
    
  
    @FindBy(how=How.XPATH, using="//*[@id='plugin-parameters']/div/div/div[2]/table/tbody/tr/td[3]/a/img")
    private WebElement clickPlusIcon;
    /**
     * Method to click on Plus Icon.
     * @throws IOException 
     */
    public void clickPlusIcon() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Click on Plus Icon.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickPlusIcon);
        Assert.assertTrue(clickPlusIcon.isDisplayed());
        clickPlusIcon.click();  
    }
    
    
  
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Plug-in']")
    private WebElement clickSavePluginButton;
    /**
     * Method to click on Save Plugin Button.
     * @throws IOException 
     */
    public void clickSavePluginButton() throws IOException{
    	ConfigurationCollectionsPage sp=new ConfigurationCollectionsPage(driver);
        log.info("Click on Save Plugin Button.");
        WaitClass.sleep(10000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickSavePluginButton);
        Assert.assertTrue(clickSavePluginButton.isDisplayed());
        clickSavePluginButton.click();  
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(5000);
    }


}
