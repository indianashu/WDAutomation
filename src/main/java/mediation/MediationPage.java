package mediation;

import baseClassPackage.BasePage;
import customer.CustomerPage;

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

public class MediationPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public MediationPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(MediationPage.class);
    MediationPage orderHierarchiesPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("Mediation");
		
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
    	MediationPage sp=new MediationPage(driver);
    	
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
    	MediationPage sp=new MediationPage(driver);
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
    	MediationPage sp=new MediationPage(driver);
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
    	MediationPage sp=new MediationPage(driver);
        log.info("Verifying the login button is available or not");
		WaitClass.WaitForElementisDisplay(driver, 5, clickLoginButton);
        Assert.assertTrue(clickLoginButton.isDisplayed());
        clickLoginButton.click();
    }

    @FindBy(how=How.XPATH, using="//a[.='Configuration']")
    private WebElement clickConfigurationsTab;
    /**
     * Method to click on Configurations tab after successful login.
     * @throws IOException 
     */
    public void clickConfigurationsTab() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Click on Configurations Tab after successful login");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationsTab);
        Assert.assertTrue(clickConfigurationsTab.isDisplayed());
        clickConfigurationsTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[.='Plug-ins']")
    private WebElement clickPluginsLink;
    /**
     * Method to click on plugins link.
     * @throws IOException 
     */
    public void clickPluginsLink() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Click on plugins link");
        JavaScriptExec.sleep();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1") + "/plugin/list";
        driver.get(url);
    }
    
    @FindBy(how=How.XPATH, using="//td[preceding-sibling::td[contains(.,'15')]]")
    private WebElement clickMediationReader;
    /**
     * Method to click on Mediation Reader link.
     * @throws IOException 
     */
    public void clickMediationReader() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("click on Mediation Reader link.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickMediationReader);
        Assert.assertTrue(clickMediationReader.isDisplayed());
        clickMediationReader.click();
        
    }

    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on Add New Button".
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Click on Add New Button");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewButton);
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        JavaScriptExec.sleep();
    }
    private WebElement selectTypeIdMediationReader;
    /**
     * Method to select type id.
     * @throws IOException 
     */
    public void selectTypeIdMediationReader() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        WebElement PCelement = driver.findElement(By.xpath("//select[@name='typeId']"));
        Select se = new Select(PCelement);
        se.selectByVisibleText(sp.ExcelRead().get(3));

    }

    
    @FindBy(how=How.XPATH, using="//input[@name='processingOrder']")
    private WebElement enterOrderMediationReader;
    /**
     * Method to enter value for Order.
     * @throws IOException 
     */
    public void enterOrderMediationReader() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("enter value for Order.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterOrderMediationReader);
        Assert.assertTrue(enterOrderMediationReader.isDisplayed());
        enterOrderMediationReader.sendKeys(sp.ExcelRead().get(4));
        
    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='plg-parm-format_file']")
    private WebElement enterFormatFile;
    /**
     * Method to enter value for Format File.
     * @throws IOException 
     */
    public void enterFormatFile() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("enter value for Format File.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterFormatFile);
        Assert.assertTrue(enterFormatFile.isDisplayed());
        enterFormatFile.sendKeys(sp.ExcelRead().get(5));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='plg-parm-suffix']")
    private WebElement enterSufix;
    /**
     * Method to enter value for Sufix.
     * @throws IOException 
     */
    public void enterSufix() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("enter value for Sufix.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterSufix);
        Assert.assertTrue(enterSufix.isDisplayed());
        enterSufix.sendKeys(sp.ExcelRead().get(6));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='plg-parm-date_format']")
    private WebElement enterDateFormat;
    /**
     * Method to enter value for Date Format.
     * @throws IOException 
     */
    public void enterDateFormat() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("enter value for Sufix.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterDateFormat);
        Assert.assertTrue(enterDateFormat.isDisplayed());
        enterDateFormat.sendKeys(sp.ExcelRead().get(7));
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='plg-parm-separator']")
    private WebElement enterSeparator;
    /**
     * Method to enter value for Separator.
     * @throws IOException 
     */
    public void enterSeparator() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("enter value for Sufix.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterSeparator);
        Assert.assertTrue(enterSeparator.isDisplayed());
        enterSeparator.sendKeys(sp.ExcelRead().get(8));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Plug-in']")
    private WebElement clickSavePluginButton;
    /**
     * Method to click on Save Plugin Button.
     * @throws IOException 
     */
    public void clickSavePluginButton() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Click on Save Plugin Button");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickSavePluginButton);
        Assert.assertTrue(clickSavePluginButton.isDisplayed());
        clickSavePluginButton.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Changes']")
    private WebElement clickSaveChangesButton;
    /**
     * Method to click on Save Changes Button.
     * @throws IOException 
     */
    public void clickSaveChangesButton() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Click on Save Changes Button");
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
    	MediationPage sp=new MediationPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    
    @FindBy(how=How.XPATH, using="//td[preceding-sibling::td[contains(.,'16')]]")
    private WebElement clickMediationProcessor;
    /**
     * Method to click on Mediation Processor link.
     * @throws IOException 
     */
    public void clickMediationProcessor() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("click on Mediation Processor link.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickMediationProcessor);
        Assert.assertTrue(clickMediationProcessor.isDisplayed());
        clickMediationProcessor.click();
        
    }
    
    private WebElement selectTypeIdMediationProcessor;
    /**
     * Method to select type id.
     * @throws IOException 
     */
    public void selectTypeIdMediationProcessor() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        WebElement PCelement = driver.findElement(By.xpath("//select[@name='typeId']"));
        Select se = new Select(PCelement);
        se.selectByVisibleText(sp.ExcelRead().get(9));

    }
  
    @FindBy(how=How.XPATH, using="//input[@name='processingOrder']")
    private WebElement enterOrderMediationProcessor;
    /**
     * Method to enter value for Order.
     * @throws IOException 
     */
    public void enterOrderMediationProcessor() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("enter value for Order.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterOrderMediationProcessor);
        Assert.assertTrue(enterOrderMediationProcessor.isDisplayed());
        enterOrderMediationProcessor.sendKeys(sp.ExcelRead().get(10));
        
    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='plg-parm-DEFAULT ITEM ID']")
    private WebElement enterDefaultItemIDMediationProcessor;
    /**
     * Method to enter value for Default Item ID.
     * @throws IOException 
     */
    public void enterDefaultItemIDMediationProcessor(String ItemId) throws IOException{
        MediationPage sp=new MediationPage(driver);
        log.info("enter value for Default Item ID.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterDefaultItemIDMediationProcessor);
        Assert.assertTrue(enterDefaultItemIDMediationProcessor.isDisplayed());
        enterDefaultItemIDMediationProcessor.sendKeys(ItemId);
        
    }

    public String fetchDefaultItemID() throws IOException{
        MediationPage sp=new MediationPage(driver);
        driver.findElement(By.xpath("//a[.='Products']")).click();
        String CategoryName = sp.ExcelRead().get(19);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+CategoryName+"']")).click();
        String ItemName = sp.ExcelRead().get(20);
        JavaScriptExec.sleep();
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+ItemName+"']")).click();
        JavaScriptExec.sleep();

        WebElement clickEditProduct = driver.findElement(By.xpath("//a[@class='submit edit']//*[text()='Edit']"));
        JavaScriptExec.scrolltoBottomofPage(driver);
        JavaScriptExec.sleep();
        driver.findElement(By.xpath("//a[@class='submit edit']//*[text()='Edit']")).click();
        JavaScriptExec.sleep();
        String ItemId = driver.findElement(By.xpath("//label[contains(.,'Product ID')]/following::span[1]")).getText();;
        log.info("Item ID." + ItemId);
        return ItemId;
    }
  
    @FindBy(how=How.XPATH, using="//td[preceding-sibling::td[contains(.,'21')]]")
    private WebElement clickMediationErrorHandler;
    /**
     * Method to click on mediation error handler link.
     * @throws IOException 
     */
    public void clickMediationErrorHandler() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Click on Mediation Error Handler Link.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickMediationErrorHandler);
        Assert.assertTrue(clickMediationErrorHandler.isDisplayed());
        clickMediationErrorHandler.click();
        
    }
    
    private WebElement selectTypeIdMediationErrorHandler;
    /**
     * Method to select type id.
     * @throws IOException 
     */
    public void selectTypeIdMediationErrorHandler() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        WebElement PCelement = driver.findElement(By.xpath("//select[@name='typeId']"));
        Select se = new Select(PCelement);
        se.selectByVisibleText(sp.ExcelRead().get(12));

    }
  
    @FindBy(how=How.XPATH, using="//input[@name='processingOrder']")
    private WebElement enterOrderMediationErrorHandler;
    /**
     * Method to enter value for Order.
     * @throws IOException 
     */
    public void enterOrderMediationErrorHandler() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("enter value for Order.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterOrderMediationErrorHandler);
        Assert.assertTrue(enterOrderMediationErrorHandler.isDisplayed());
        enterOrderMediationErrorHandler.sendKeys(sp.ExcelRead().get(13));
        
    }
    
  
    @FindBy(how=How.XPATH, using="//a[.='Customers']")
    private WebElement clickCustomersTab;
    /**
     * Method to click on Customers Tab.
     * @throws IOException 
     */
    public void clickCustomersTab() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Click on Customers Tab");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickCustomersTab);
        Assert.assertTrue(clickCustomersTab.isDisplayed());
        clickCustomersTab.click();
        
    }
    
    
    private WebElement selectUserCompany;
    /**
     * Method to select user company.
     * @throws IOException 
     */
    public void selectUserCompany() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        WebElement Usercompanyelement = driver.findElement(By.xpath("//select[@name='user.entityId']"));
        Select se = new Select(Usercompanyelement);
        se.selectByVisibleText(sp.ExcelRead().get(14));

    }
    
    private WebElement selectAccountType;
    /**
     * Method to select account type.
     * @throws IOException 
     */
    public void selectAccountType() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        WebElement AccountTypeelement = driver.findElement(By.xpath("//select[@name='accountTypeId']"));
        Select se = new Select(AccountTypeelement);
        se.selectByVisibleText(sp.ExcelRead().get(15));

    }    

    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Select']")
    private WebElement clickSelectButton;
    /**
     * Method to click on select Button.
     * @throws IOException 
     */
    public void clickSelectButton() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Click on select Button");
        JavaScriptExec.sleep();
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
    	MediationPage sp=new MediationPage(driver);
        log.info("Enter Login Name");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterLoginName);
        Assert.assertTrue(enterLoginName.isDisplayed());
        enterLoginName.sendKeys(sp.ExcelRead().get(16));
        
    }
    
      
    @FindBy(how=How.XPATH, using="//a[@href='/jbilling/mediationConfig/list']")
    private WebElement clickMediationsLink;
    /**
     * Method to click on Mediations Link.
     * @throws IOException 
     */
    public void clickMediationsLink() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("click on Mediations Link.");
        JavaScriptExec.sleep();
        p.getPropertyFile("test", "configuration.properties");
        String url=p.getVal("url1") + "/mediationConfig/list";
        driver.get(url);
        JavaScriptExec.sleep();
    }
    
  
    @FindBy(how=How.XPATH, using="//input[@name='name']")
    private WebElement enterConfigurationName;
    /**
     * Method to Enter Configuration Name.
     * @throws IOException 
     */
    public void enterConfigurationName() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Enter Configuration Name");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterConfigurationName);
        Assert.assertTrue(enterConfigurationName.isDisplayed());
        enterConfigurationName.sendKeys(sp.ExcelRead().get(17));
        
    }
   
    @FindBy(how=How.XPATH, using="//input[@name='orderValue']")
    private WebElement enterExecutionOrder;
    /**
     * Method to Enter Execution Order.
     * @throws IOException 
     */
    public void enterExecutionOrder() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Enter Execution Order");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, enterExecutionOrder);
        Assert.assertTrue(enterExecutionOrder.isDisplayed());
        enterExecutionOrder.sendKeys(sp.ExcelRead().get(18));
        
    }
  
    //@FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Test Mediation 2.0']")
    private WebElement clickMediation;
    /**
     * Method to Click on Mediation.
     * @throws IOException 
     */
    public void clickMediation() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Click on Mediation");
        JavaScriptExec.sleep();
        String Mediation = sp.ExcelRead().get(17);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+Mediation+"']")).click();
    } 
    
    
    private WebElement uploadMediationCSVFile;
    /**
     * Method to upload Mediation csv file.
     * @throws IOException 
     */
    public void uploadMediationCSVFile() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("upload Mediation csv file");
        JavaScriptExec.sleep();
        WebElement FileUpload = driver.findElement(By.xpath("//input[@name='cdrs']"));
        FileUpload.sendKeys(System.getProperty("user.dir") +"/MediationTest.csv");
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Trigger this Config']")
    private WebElement clickTriggerConfigButton;
    /**
     * Method to click on trigger this config button.
     * @throws IOException 
     */
    public void clickTriggerConfigButton() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("click on trigger this config button");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickTriggerConfigButton);
        Assert.assertTrue(clickTriggerConfigButton.isDisplayed());
        clickTriggerConfigButton.click();
        
    }
   
    @FindBy(how=How.XPATH, using="//a[.='Mediation']")
    private WebElement clickMediationsTab;
    /**
     * Method to click on Mediations Tab.
     * @throws IOException 
     */
    public void clickMediationsTab() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("click on Mediations Tabs");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickMediationsTab);
        Assert.assertTrue(clickMediationsTab.isDisplayed());
        clickMediationsTab.click();        
    }
    
  
    @FindBy(how=How.XPATH, using="//table/tbody/tr[1]/td[6]")
    private WebElement verifyNumberOrders;
    /**
     * Method to Verify Orders created are greater than Zero.
     * @throws IOException 
     */
    public void verifyNumberOrders() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Verify Orders created are greater than Zero.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, verifyNumberOrders);
        Assert.assertTrue(verifyNumberOrders.isDisplayed());
        String OrderNumber = driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).getText();  
        int OrderValue = Integer.parseInt(OrderNumber);
        if (OrderValue > 0) {
        	Assert.assertTrue(true, "Number Orders created are greater than Zero.");
        }else{
        	Assert.assertFalse(false, "Number Orders created are Zero.");
        }
    }
    
    
  
   // @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Test Mediation 2.0']")
    private WebElement clickMediationName;
    /**
     * Method to click on Mediation Created.
     * @throws IOException 
     */
    public void clickMediationName() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("click on Mediation name");
        JavaScriptExec.sleep();
        String MediationName = sp.ExcelRead().get(17);
        driver.findElement(By.xpath("//a[@class='cell double']//*[text()='"+MediationName+"']")).click();
    }
    
  
    @FindBy(how=How.XPATH, using="//*[@id='column2']/div/div[2]/div/table[2]/tbody/tr[3]/td[2]")
    private WebElement verifyDoneBillableValue;
    /**
     * Method to Verify value for Done and Billable.
     * @throws IOException 
     */
    public void verifyDoneBillableValue() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("Verify value for Done and Billable.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, verifyDoneBillableValue);
        Assert.assertTrue(verifyDoneBillableValue.isDisplayed());
        String Number = driver.findElement(By.xpath("//*[@id='column2']/div/div[2]/div/table[2]/tbody/tr[3]/td[2]")).getText();  
        int Value = Integer.parseInt(Number);
        if (Value > 0) {
        	Assert.assertTrue(true, "Done & Billable value is greater than Zero.");
        }else{
        	Assert.assertFalse(false, "Done & Billable value is Zero.");
        }
    }
    
  
    @FindBy(how=How.XPATH, using="//*[@id='column2']/div/div[2]/div/table[2]/tbody/tr[3]/td[3]/a")
    private WebElement clickDoneBillableViewLink;
    /**
     * Method to click on Done Billable View Link.
     * @throws IOException 
     */
    public void clickDoneBillableViewLink() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("click on Done Billable View Link.");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickDoneBillableViewLink);
        Assert.assertTrue(clickDoneBillableViewLink.isDisplayed());
        clickDoneBillableViewLink.click();        
    }
    
    @FindBy(how=How.XPATH, using="//a[.='Orders']")
    private WebElement clickOrdersTab;
    /**
     * Method to click on Orders Tab.
     * @throws IOException 
     */
    public void clickOrdersTab() throws IOException{
    	MediationPage sp=new MediationPage(driver);
        log.info("click on Orders Tabs");
        JavaScriptExec.sleep();
        WaitClass.WaitForElementisDisplay(driver, 10, clickOrdersTab);
        Assert.assertTrue(clickOrdersTab.isDisplayed());
        clickOrdersTab.click();        
    }
    
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        JavaScriptExec.sleep();
    }

}

