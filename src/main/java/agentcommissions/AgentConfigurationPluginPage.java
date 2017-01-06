package agentcommissions;

import baseClassPackage.BasePage;
import categoryProducts.AddProductPage;
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

public class AgentConfigurationPluginPage extends BasePage{
    /**
     * This constructor is used to initialize the webdriver in BasePage class, if the user does not want to use page factory
     * then this will take care of initialization of the driver
     *
     * @param webdriver
     */
    public AgentConfigurationPluginPage(WebDriver webdriver) {
        super(webdriver);
    }

    Logger log=Logger.getLogger(AgentConfigurationPluginPage.class);
    AgentConfigurationPluginPage agentConfigurationPluginPage;
    PropertyValExtractors p = new PropertyValExtractors();
  
    public  ArrayList<String> ExcelRead() throws IOException{
    	

		ArrayList<String> rl=new ArrayList<String>();
		File file=new File(System.getProperty("user.dir") +"/Webdata_TestData.xlsx");
		FileInputStream fs=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet("AgentPlugin");
		
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
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
    	
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
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
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
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
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
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
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
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        log.info("Click on Configuration Tab after successful login");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickConfigurationTab);
        Assert.assertTrue(clickConfigurationTab.isDisplayed());
        clickConfigurationTab.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[.='Plug-ins']")
    private WebElement clickPlugin;
    /**
     * Method to click on Plugin after successful login.
     * @throws IOException 
     */
    public void clickPlugin() throws IOException{
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        log.info("Click on Plugin after successful login");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickPlugin);
        Assert.assertTrue(clickPlugin.isDisplayed());
        clickPlugin.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//td[preceding-sibling::td[contains(.,'25')]]")
    private WebElement clickAgentCommissionCalProcess;
    /**
     * Method to click on Agent Commission Calculation Process #25.
     * @throws IOException 
     */
    public void clickAgentCommissionCalProcess() throws IOException{
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        log.info("Click on Agent Commission Calculation Process #25.");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAgentCommissionCalProcess);
        Assert.assertTrue(clickAgentCommissionCalProcess.isDisplayed());
        clickAgentCommissionCalProcess.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit add']//*[text()='Add New']")
    private WebElement clickAddNewButton;
    /**
     * Method to click on add new button".
     * @throws IOException 
     */
    public void clickAddNewButton() throws IOException{
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        log.info("Click on add new button");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAddNewButton);
        Assert.assertTrue(clickAddNewButton.isDisplayed());
        clickAddNewButton.click();
        
    }
   
    
    
    private WebElement selectType;
    /**
     * Method to select type.
     * @throws IOException 
     */
    public void selectType() throws IOException{
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        WebElement Typeelement = driver.findElement(By.xpath("//select[@name='typeId']"));
        Select se = new Select(Typeelement);
        se.selectByVisibleText(sp.ExcelRead().get(3));

    }
    
    @FindBy(how=How.XPATH, using="//input[@name='processingOrder']")
    private WebElement enterOrder;
    /**
     * Method to enter Order.
     * @throws IOException 
     */
    public void enterOrder() throws IOException{
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        log.info("Enter Order");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, enterOrder);
        Assert.assertTrue(enterOrder.isDisplayed());
        enterOrder.sendKeys(sp.ExcelRead().get(4));
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='submit save']//*[text()='Save Plug-in']")
    private WebElement clickSavePluginButton;
    /**
     * Method to click on Save Plugin Button.
     * @throws IOException 
     */
    public void clickSavePluginButton() throws IOException{
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        log.info("Click on Save Plugin Button");
        WaitClass.sleep(2000);
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
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        log.info("Click on Save Changes Button");
        WaitClass.sleep(2000);
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
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        log.info("Verifying if Account Type is created Successfully or not");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyConfirmationMsg);
        Assert.assertTrue(verifyConfirmationMsg.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    @FindBy(how=How.XPATH, using="//a[.='All']")
    private WebElement clickAllLink;
    /**
     * Method to click on All Link.
     * @throws IOException 
     */
    public void clickAllLink() throws IOException{
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        log.info("Click on All Link");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAllLink);
        Assert.assertTrue(clickAllLink.isDisplayed());
        clickAllLink.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//a[@class='cell double']//*[text()='Agent Commission Type']")
    private WebElement clickAgentCommissionType;
    /**
     * Method to click on Agent Commission Type #61.
     * @throws IOException 
     */
    public void clickAgentCommissionType() throws IOException{
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        log.info("Click on Agent Commission Type #61");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, clickAgentCommissionType);
        Assert.assertTrue(clickAgentCommissionType.isDisplayed());
        clickAgentCommissionType.click();
        
    }
    
    @FindBy(how=How.XPATH, using="//input[@name='preference.value']")
    private WebElement verifyInvoice;
    /**
     * Method to verify Invoice Value.
     * @throws IOException 
     */
    public void verifyInvoice() throws IOException{
    	AgentConfigurationPluginPage sp=new AgentConfigurationPluginPage(driver);
        log.info("Verifying if Invoice value is there or not");
        WaitClass.sleep(2000);
        WaitClass.WaitForElementisDisplay(driver, 10, verifyInvoice);
        verifyInvoice.getText();
        Assert.assertTrue(verifyInvoice.isDisplayed(), "Assert Failed as its unable to search text in Logged in Page");
    }
    
    public void navigateBottom(){
        JavaScriptExec.scrolltoBottomofPage(driver);
        WaitClass.sleep(2000);
    }


}

